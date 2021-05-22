package com.example.retail.services.vegetables;

import com.example.retail.controllers.retailer.vegetables_retailer.AddVegetablesRequestBody;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.DiscountCalculator;
import com.example.retail.services.discounts.CustomerOrdersDiscountServices;
import com.example.retail.models.jsonmodels.InventoryAdditionDetails;
import com.example.retail.models.variantandcategory.VariantAndCategory;
import com.example.retail.services.variantandcategory.VariantAndCategoryService;
import com.example.retail.models.vegetables.*;
import com.example.retail.repository.vegetables.VegetablesRepository;
import com.example.retail.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class VegetablesService {

    @Autowired
    VegetablesRepository vegetablesRepository;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    JWTDetails JWTDetails;

    @Autowired
    Utils utils;

    @Autowired
    Validations validations;

    @Autowired
    VegetableInventoryService vegetableInventoryService;

    @Autowired
    DiscountCalculator discountCalculator;

    @Autowired
    VegetablesHelper vegetablesHelper;

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @Autowired
    VariantAndCategoryService variantAndCategoryService;

    @Autowired
    Constants constants;


    public List<?> findAllVegetablesWithInventory() {
        List<Vegetables> vegetables = vegetablesRepository.findAll();
        List<VegetablesInventory> vegetablesInventories = vegetableInventoryService.findAll();

        List<Map<String, ?>> finalRes = new ArrayList<>();

        vegetables.forEach(vegetable->
            vegetablesInventories.forEach(vegetablesInventory -> {
                if(vegetable.getVegetableSubId().equals(vegetablesInventory.getVegetableSubId())){
                    Map<String, Object> resObject = new HashMap<>();
                    resObject.put(constants.vegetable, vegetable);
                    resObject.put(constants.vegetableInventory, vegetablesInventory);
                    finalRes.add(resObject);
                }
            }
        ));
        return finalRes;
    }

    public ResponseEntity<Object> addNewVegetable(HttpServletRequest request, AddVegetablesRequestBody newVegetables,
                                                  List<MultipartFile> vegetableImages) {
        try {
            /* Create a unique subID */
            String vegSubId = utils.createVegetableSubId(newVegetables.getVegetableName()
                    ,newVegetables.getVegetableVariant()
                    ,newVegetables.getVegetableInventoryFixedCost()
                    ,newVegetables.getVegetableInventoryCostPrice());

            /* aate vegetables */
            ValidationResponse validationStatus = validations.validateNewVegetables(newVegetables, vegSubId);
            if (validationStatus.getStatusCode() != validations.validationSuccessCode) {
                return ResponseEntity.status(validationStatus.getStatusCode()).body(
                        validationStatus
                );
            }

            String itemCategorySubId = utils.createItemCategorySubId(newVegetables.getItemCategory(), newVegetables.getItemSubCategory());
            /* Return error if item category does not exist */
            ValidationResponse itemCategoryValidationStatus = validations.validateItemCategory(itemCategorySubId);
            if(itemCategoryValidationStatus.getStatusCode() != validations.validationSuccessCode) {
                return ResponseEntity.status(itemCategoryValidationStatus.getStatusCode()).body(
                        itemCategoryValidationStatus
                );
            }

            String vegetable_AddedBy = JWTDetails.userName(request);
            LocalDate vegetableInventoryExpiry = LocalDate.parse(newVegetables.getVegetableInventoryExpiry());

            if(vegetableInventoryExpiry.isBefore(LocalDate.now())) {
                return ResponseEntity.status(422).body(
                        createResponse.createErrorResponse(
                            422,
                            "Expiry date needs to be anytime later than today's date",
                            "Expiry date is earlier than current date"
                        )
                );
            }

            /* create new vegetable */
            Vegetables vegetables = new Vegetables();

            // Add image for the item
            if (!vegetableImages.isEmpty()) {
                OpsResponse res = utils.saveFiles(vegetableImages, constants.saveImageSwitchCaseVegetables);
                int errorCheck = res.getStatusCode();

                if(errorCheck != utils.opsSuccess){
                    return ResponseEntity.status(errorCheck).body(res);
                } else {
                    vegetables.setVegetableImages(res.getStatusArray());
                }
            } else {
                List<String> imagePlaceHolder = new ArrayList<>();
                // TODO : give correct path to image placeholder
                imagePlaceHolder.add("src/main/resources/assets/veg-images/veg-image-placeholder.png");
                vegetables.setVegetableImages(imagePlaceHolder);
            }

            vegetables.setVegetableApplicableTaxes(newVegetables.getVegetableApplicableTaxes());
            vegetables.setVegetableName(newVegetables.getVegetableName());
            vegetables.setVegetableDescp(newVegetables.getVegetableDescp());
            vegetables.setVegetableVariant(newVegetables.getVegetableVariant());
            vegetables.setItemCategory(newVegetables.getItemCategory());
            vegetables.setItemSubCategory(newVegetables.getItemSubCategory());


            /** Create new List and add recepie to the List **/
            ArrayList<VegetableRecipes> vegetableRecepieList = new ArrayList<>();
            vegetableRecepieList.add(newVegetables.getVegetableRecepie());

            vegetables.setVegetableRecepie(vegetableRecepieList);

            Float vegetableSellingPrice = newVegetables.getVegetableSellingPrice();
            vegetables.setVegetableSellingPrice(vegetableSellingPrice);

            // Check if discount is available
            Optional<CustomerOrdersDiscount> customerOrdersDiscount = customerOrdersDiscountServices.findByDiscountName(newVegetables.getVegetableOfferedDiscountName());
            Float vegetableDiscountedPrice;
            if(customerOrdersDiscount.isEmpty()){
                vegetables.setVegetableOfferedDiscountName(newVegetables.getVegetableOfferedDiscountName());
                vegetableDiscountedPrice = discountCalculator.calcDiscountedPrice(vegetableSellingPrice, newVegetables.getVegetableOfferedDiscount());
                vegetables.setVegetableDiscountedPrice(vegetableDiscountedPrice); /* Calculate discounted vegetable price */
                vegetables.setVegetableOfferedDiscount(newVegetables.getVegetableOfferedDiscount());
                vegetables.setVegetableTaxedPrice(vegetablesHelper.calcAmountAfterTax(newVegetables.getVegetableApplicableTaxes(), vegetableDiscountedPrice));
            } else {
                vegetables.setVegetableOfferedDiscountName(customerOrdersDiscount.get().getDiscountName());
                vegetableDiscountedPrice = discountCalculator.calcDiscountedPrice(vegetableSellingPrice, customerOrdersDiscount.get().getDiscountPercentage());
                vegetables.setVegetableDiscountedPrice(vegetableDiscountedPrice);
                vegetables.setVegetableOfferedDiscount(customerOrdersDiscount.get().getDiscountPercentage());
                vegetables.setVegetableTaxedPrice(vegetablesHelper.calcAmountAfterTax(newVegetables.getVegetableApplicableTaxes(), vegetableDiscountedPrice));
            }

            vegetables.setVegetableQuantity(newVegetables.getVegetableQuantity());
            vegetables.setVegetableAvailable(newVegetables.getVegetableAvailable());
            vegetables.setVegetableMeasureMentUnit(newVegetables.getVegetableMeasureMentUnit());

            vegetables.setVegetableSubId(vegSubId);

            /** Create vegetable inventory **/
            VegetablesInventory vegetablesInventory = new VegetablesInventory();
            vegetablesInventory.setVegetableInventoryCostPrice(newVegetables.getVegetableInventoryCostPrice());
            vegetablesInventory.setVegetableInventoryFixedCost(newVegetables.getVegetableInventoryFixedCost());
            vegetablesInventory.setVegetableInventorySellingPrice(vegetableDiscountedPrice);
            vegetablesInventory.setVegetableInventoryExpiry(vegetableInventoryExpiry);
            vegetablesInventory.setSuppliers(newVegetables.getSuppliers());

            /** Create VegetableAdditionDetails **/
            InventoryAdditionDetails inventoryAdditionDetails = new InventoryAdditionDetails();
            inventoryAdditionDetails.setAddedBy(vegetable_AddedBy);
            inventoryAdditionDetails.setAddedDateTime(LocalDateTime.now());
            inventoryAdditionDetails.setIncreamentCount(newVegetables.getVegetableQuantity());

            List<InventoryAdditionDetails> vegetableDetailsList = new ArrayList<>();
            vegetableDetailsList.add(inventoryAdditionDetails);

            vegetablesInventory.setVegetableInventoryAdditionDetails(vegetableDetailsList);
            vegetablesInventory.setVegetableInventoryFixedCost(newVegetables.getVegetableInventoryFixedCost());

            vegetablesInventory.setVegetableSubId(vegSubId);

            /**Create new VariandAndCategory**/
            VariantAndCategory variantAndCategory = new VariantAndCategory();
            variantAndCategory.setItemCategory(newVegetables.getItemCategory());
            variantAndCategory.setItemSubCategory(newVegetables.getItemSubCategory());
            variantAndCategory.setItemCategorySubId(itemCategorySubId);

            Optional<VariantAndCategory> optionalVariantAndCategory = variantAndCategoryService.findBySubId(itemCategorySubId);
            if(optionalVariantAndCategory.isPresent()) {
                /** If itemCategory and itemSubCategory (itemCategorySubId) is present add variant to existing variant list **/
                List<String> variantList =  new ArrayList<>();
                variantList.add(newVegetables.getVegetableVariant());
                variantAndCategoryService.addVariants(itemCategorySubId, variantList);
            } else {
                List<String> variantList = new ArrayList<>();
                /**Persist new variant and category**/
                variantList.add(newVegetables.getVegetableVariant());
                variantAndCategory.setVariantsList(variantList);
                variantAndCategoryService.save(variantAndCategory);
            }

            vegetables.setDenominationList(newVegetables.getDenominationList());

            /** Persist the vegetable **/
            Vegetables createdVeg = vegetablesRepository.save(vegetables);
            /** Persist the vegetable inventory **/
            VegetablesInventory createdVegInventory = vegetableInventoryService.addNewInventory(vegetablesInventory);


            Map<String, Object> res = new HashMap<>();
            res.put(constants.vegetable, createdVeg);
            res.put(constants.vegetableInventory, createdVegInventory);


            List<Object> result = new ArrayList<>();
            result.add(res);

            return ResponseEntity.status(HttpStatus.CREATED).body(
                createResponse.createSuccessResponse(
                    201,
                    "Created",
                    result
                )
            );

        }catch (Exception e) {
            return ResponseEntity.status(500).body(
                createResponse.createErrorResponse(
                    500,
                    e.getLocalizedMessage(),
                    "NA"
                )
            );
        }
    }

    public List<Vegetables> findAllVegetables() {
        return vegetablesRepository.findAll();
    }

    public Optional<Vegetables> findById(Long id) {
        return vegetablesRepository.findById(id);
    }

    public Optional<Vegetables> getVegetableByTableId(Long vegetableTableId) {
        return vegetablesRepository.findById(vegetableTableId);
    }

    public Optional<Vegetables> findBySubId(String subId) { return vegetablesRepository.findBySubId(subId); }

    public Iterable<Vegetables> addAllVegetables(List<Vegetables> newVegetables) {
        return vegetablesRepository.saveAll(newVegetables);
    }

    public int updateVegetableAsPerInventory(Long tableId, Float increamentCount, String subId, Float newSellingPrice) {
        return vegetablesRepository.updateVegetableAsPerInventory(tableId, increamentCount, subId, newSellingPrice);
    }

    public Integer updateVegetableQty(Long tableId, Float increamentCount) {
        return vegetablesRepository.updateVegetableQty(tableId, increamentCount);
    }

    public List<Vegetables> findAllAvailableVegetables() {
        return vegetablesRepository.findAllAvailableVegetables();
    }

    public List<Vegetables> findAllUnavailableVegetables() {
        return vegetablesRepository.findAllUnavailableVegetables();
    }

    public List<Object> findBySubIdVegetableWithInventory(String vegSubId) {

        Optional<Vegetables> v= vegetablesRepository.findBySubId(vegSubId);
        Optional<VegetablesInventory> vi = vegetableInventoryService.findVegetableInventoryBySubId(vegSubId);

        List<Object> finalRes = new ArrayList<>();
        Map<String, Object> res = new HashMap<>();
        res.put("vegetables", v);
        res.put("vegetablesInventory", vi);
        finalRes.add(res);
        return finalRes;
    }

    public List<Vegetables> findVegetablesByItemCategory(String itemCategory) {
        return vegetablesRepository.findVegetablesByItemCategory(itemCategory);
    }

    public ResponseEntity<Object> findPaginatedVegetables(VegetablesPage vegetablesPage) {
        try {
            Sort sort = Sort.by(vegetablesPage.getSortDirection(), vegetablesPage.getSortBy());
            Pageable pageable = PageRequest.of(vegetablesPage.getPageNo(), vegetablesPage.getPageSize(), sort);
            Page<Vegetables> res =  vegetablesRepository.findAll(pageable);
            return ResponseEntity.status(200).body(
                createResponse.createSuccessResponse(201, res.getTotalElements() + " itesms found", res)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(createResponse.createErrorResponse(500, e.getLocalizedMessage(), "NA"));
        }
    }
}
