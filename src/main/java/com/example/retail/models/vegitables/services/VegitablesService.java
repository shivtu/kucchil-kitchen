package com.example.retail.models.vegitables.services;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import com.example.retail.models.discounts.DiscountCalculator;
import com.example.retail.models.vegitables.*;
import com.example.retail.models.vegitables.repository.VegitablesRepository;
import com.example.retail.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class VegitablesService {

    @Autowired
    private VegitablesRepository vegitablesRepository;

    @Autowired
    JWTDetails JWTDetails;

    @Autowired
    Utils utils;

    @Autowired
    Validations validations;

    @Autowired
    VegitableInventoryService vegitableInventoryService;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    DiscountCalculator discountCalculator;

    @Autowired
    VegitablesHelper vegitablesHelper;

    public List<Object> findAllVegitablesWithInventory() {
        List<Vegitables> vegitables = vegitablesRepository.findAll();
        List<VegitablesInventory> vegitablesInventories = vegitableInventoryService.findAll();

        Map<String, Object> resObject = new HashMap<>();

        List<Object> finalRes = new ArrayList<>();

        vegitables.forEach(vegitable->{
            vegitablesInventories.forEach(vegitablesInventory -> {
                if(vegitable.getVegitableSubId().equals(vegitablesInventory.getVegitableSubId())){
                    resObject.put("vegitable", vegitable);
                    resObject.put("vegitableInventory", vegitablesInventory);
                    finalRes.add(resObject);
                }
            });
        });
        return finalRes;
    }

    public ResponseEntity<Object> addNewVegitable(HttpServletRequest request, AddVegitablesRequestBody newVegitables,
                                                  ArrayList<MultipartFile> images) throws Exception {
        try {
            /* Create a unique subID */
            String vegSubId = (newVegitables.getVegitableName()
                    +newVegitables.getVegitableVariant()
                    +newVegitables.getVegitableInventoryFixedCost()
                    +newVegitables.getVegitableInventoryCostPrice()).toLowerCase();

            /* Validate vegitables */
            ValidationResponse validationStatus = validations.validateNewVegitables(newVegitables, vegSubId);
            if (validationStatus.getStatusCode() != validations.validationSuccessCode) {
                return ResponseEntity.status(validationStatus.getStatusCode()).body(
                        validationStatus
                );
            }

            /* Return error if item category does not exist */
            ValidationResponse itemCategoryValidationStatus = validations.validateItemCategory(newVegitables.getItemCategory());
            if(itemCategoryValidationStatus.getStatusCode() != validations.validationSuccessCode) {
                return ResponseEntity.status(itemCategoryValidationStatus.getStatusCode()).body(
                        itemCategoryValidationStatus
                );
            }

            String vegitable_AddedBy = JWTDetails.userName(request);
            LocalDate vegitableInventoryExpiry = LocalDate.parse(newVegitables.getVegitableInventoryExpiry());

            /* create new vegitable */
            Vegitables vegitables = new Vegitables();

            // Add image for the item
            if (!images.isEmpty()) {
                OpsResponse res = utils.saveFiles(images, "vegitableImages");
                int errorCheck = res.getStatusCode();

                if(errorCheck != utils.opsSuccess){
                    return ResponseEntity.status(errorCheck).body(res);
                } else {
                    vegitables.setVegitableImagesLocation((ArrayList<String>) res.getStatusArray());
                }
            } else {
                ArrayList<String> placeholder = new ArrayList<>();
                // TODO : give correct path to image placeholder
                placeholder.add("src/main/resources/assets/veg-images/veg-image-placeholder.png");
                vegitables.setVegitableImagesLocation(placeholder);
            }

            vegitables.setVegitableApplicableTaxes(newVegitables.getVegitableApplicableTaxes());
            vegitables.setVegitableName(newVegitables.getVegitableName());
            vegitables.setVegitableDescp(newVegitables.getVegitableDescp());
            vegitables.setVegitableVariant(newVegitables.getVegitableVariant());
            vegitables.setItemCategory(newVegitables.getItemCategory());

            /** Create new List and add recepie to the List **/
            ArrayList<VegitableRecipes> vegitableRecepieList = new ArrayList<>();
            vegitableRecepieList.add(newVegitables.getVegitableRecepie());

            vegitables.setVegitableRecepie(vegitableRecepieList);

            Float vegitableSellingPrice = newVegitables.getVegitableSellingPrice();
            vegitables.setVegitableSellingPrice(vegitableSellingPrice);

            vegitables.setVegitableOfferedDiscountName(newVegitables.getVegitableOfferedDiscountName());

            Float vegitableDiscountedPrice = discountCalculator.calcVegDiscountedPrice(vegitableSellingPrice, newVegitables.getVegitableOfferedDiscount());

            vegitables.setVegitableDiscountedPrice(vegitableDiscountedPrice); /* Calculate discounted vegitable price */
            vegitables.setVegitableOfferedDiscount(newVegitables.getVegitableOfferedDiscount());
            vegitables.setVegitableTaxedPrice(vegitablesHelper.calcAmountAfterTax(vegitables.getVegitableApplicableTaxes(), vegitableDiscountedPrice));
//            vegitables.setVegitableShowDiscount(newVegitables.getVegitableShowDiscount());
            vegitables.setVegitableQuantity(newVegitables.getVegitableQuantity());
            vegitables.setVegitableAvailable(newVegitables.getVegitableAvailable());
            vegitables.setVegitableMeasureMentUnit(newVegitables.getVegitableMeasureMentUnit());

            vegitables.setVegitableSubId(vegSubId);

            /** Create vegitable inventory **/
            VegitablesInventory vegitablesInventory = new VegitablesInventory();
            vegitablesInventory.setVegitableInventoryCostPrice(newVegitables.getVegitableInventoryCostPrice());
            vegitablesInventory.setVegitableInventoryFixedCost(newVegitables.getVegitableInventoryFixedCost());
            vegitablesInventory.setVegitableInventorySellingPrice(vegitableDiscountedPrice);
            vegitablesInventory.setVegitableInventoryExpiry(vegitableInventoryExpiry);

            /** Create VegitableAdditionDetails **/
            VegitableAdditionDetails vegitableAdditionDetails = new VegitableAdditionDetails();
            vegitableAdditionDetails.setAddedBy(vegitable_AddedBy);
            vegitableAdditionDetails.setAddedDateTime(LocalDateTime.now());
            vegitableAdditionDetails.setIncreamentCount(newVegitables.getVegitableQuantity());

            List<VegitableAdditionDetails> vegitableDetailsList = new ArrayList<>();
            vegitableDetailsList.add(vegitableAdditionDetails);

            vegitablesInventory.setVegitableInventoryAdditionDetails(vegitableDetailsList);
            vegitablesInventory.setVegitableInventoryFixedCost(newVegitables.getVegitableInventoryFixedCost());

            vegitablesInventory.setVegitableSubId(vegSubId);

            /** Persist the vegitable **/
            Vegitables createdVeg = vegitablesRepository.save(vegitables);
            /** Persist the vegitable inventory **/
            VegitablesInventory createdVegInventory = vegitableInventoryService.addNewInventory(vegitablesInventory);

            HashMap<String, Object> res = new HashMap<String, Object>();
            res.put("vegitable", createdVeg);
            res.put("VegitableInventory", createdVegInventory);

            List<Object> result = new ArrayList<>();
            result.add(res);

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    createResponse.createSuccessResponse(
                            201,
                            "Created",
                            result)
            );

        }catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(
                            500,
                            e.getMessage(),
                            "NA"
                    )
            );
        }
    }

    public List<Vegitables> findAllVegitables() {
        return vegitablesRepository.findAll();
    }

    public Optional<Vegitables> findById(Long id) {
        return vegitablesRepository.findById(id);
    }

    public Optional<Vegitables> getVegitableByTableId(Long vegitableTableId) {
        return vegitablesRepository.findById(vegitableTableId);
    }

    public Optional<Vegitables> findBySubId(String subId) { return vegitablesRepository.findBySubId(subId); }

    public Iterable<Vegitables> addAllVegitables(List<Vegitables> newVegitables) {
        return vegitablesRepository.saveAll(newVegitables);
    }

    public int updateVegitableAsPerInventory(Long tableId, Float increamentCount, String subId, Float newSellingPrice) {
        return vegitablesRepository.updateVegitableAsPerInventory(tableId, increamentCount, subId, newSellingPrice);
    }

    public Integer updateVegitableQty(Long tableId, Float increamentCount) {
        return vegitablesRepository.updateVegitableQty(tableId, increamentCount);
    }

    public List<Vegitables> findAllAvailableVegitables() {
        List<Vegitables> vegitablesList = vegitablesRepository.findAllAvailableVegitables();
        return vegitablesList;
    }

    public List<Vegitables> findAllUnavailableVegitables() {
        List<Vegitables> vegitablesList = vegitablesRepository.findAllUnavailableVegitables();

        return vegitablesList;
    }

    public ResponseEntity<Object> findBySubIdVegitableWithInventory(String vegSubId) {
        try{
            Optional<Vegitables> v= vegitablesRepository.findBySubId(vegSubId);
            Optional<VegitablesInventory> vi =vegitableInventoryService.findVegitableInventoryBySubId(vegSubId);

            List<Object> finalRes = new ArrayList<>();
            Map<String, Object> res = new HashMap<>();
            res.put("vegitables", v);
            res.put("vegitablesInventory", vi);
            finalRes.add(res);

            return ResponseEntity.status(200).body(
                    createResponse.createSuccessResponse(200, "Vegitable and its inventory", finalRes)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }


    }

    public List<Vegitables> findVegitablesByItemCategory(String itemClassification) {
        return vegitablesRepository.findVegitablesByItemCategory(itemClassification);
    }
}
