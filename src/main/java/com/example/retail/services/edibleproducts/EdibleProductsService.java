package com.example.retail.services.edibleproducts;

import com.example.retail.controllers.retailer.edibleproducts_retailer.AddEdibleProductsRequestBody;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.DiscountCalculator;
import com.example.retail.services.discounts.CustomerOrdersDiscountServices;
import com.example.retail.models.edibleproducts.EdibleProducts;
import com.example.retail.models.edibleproducts.EdibleProductsInventory;
import com.example.retail.repository.edibleproducts.EdibleProductsInventoryRepository;
import com.example.retail.repository.edibleproducts.EdibleProductsRepository;
import com.example.retail.models.taxutility.TaxCalculator;
import com.example.retail.models.variantandcategory.VariantAndCategory;
import com.example.retail.services.variantandcategory.VariantAndCategoryService;
import com.example.retail.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class EdibleProductsService {

    @Autowired
    EdibleProductsRepository edibleProductsRepository;

    @Autowired
    EdibleProductsInventoryRepository edibleProductsInventoryRepository;

    @Autowired
    Validations validations;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    DiscountCalculator discountCalculator;

    @Autowired
    TaxCalculator taxCalculator;

    @Autowired
    JWTDetails jwtDetails;

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @Autowired
    Utils utils;

    @Autowired
    VariantAndCategoryService variantAndCategoryService;

    @Autowired
    Constants constants;

    public List<?> findAllEdibleProductsWithInventory(){
        List<EdibleProducts> edibleProducts = edibleProductsRepository.findAll();
        List<EdibleProductsInventory> edibleProductsInventories = edibleProductsInventoryRepository.findAll();

        List<Map<String, ?>> finalRes = new ArrayList<>();

        edibleProducts.forEach((edibleProduct) -> {
            edibleProductsInventories.forEach((edibleProductInventory) -> {
                if(edibleProduct.getEdibleProductSubId().equals(edibleProductInventory.getEdibleProductSubId())) {
                    Map<String, Object> resObject = new HashMap<>();
                    resObject.put(constants.edibleProduct, edibleProduct);
                    resObject.put(constants.edibleProductInventory, edibleProductInventory);
                    finalRes.add(resObject);
                }
            });
        });

        return finalRes;
    }

    public List<EdibleProducts> findAll() {
        return edibleProductsRepository.findAll();
    }

    public Iterable<EdibleProducts> addAllEdibleProducts(List<EdibleProducts> newProducts) {
        return edibleProductsRepository.saveAll(newProducts);
    }

    public ResponseEntity<Object> addEdibleProduct(HttpServletRequest request, ArrayList<MultipartFile> edibleProductImages,
                                                   AddEdibleProductsRequestBody newEdibleProduct) throws IOException {

        LocalDate expiryDate = LocalDate.parse(newEdibleProduct.getEdibleProductInventoryExpiry());
        String edibleProductAddedBy = jwtDetails.userName(request);

        // Get the Sub ID
        String subid = utils.createEdibleProductSubId(
            newEdibleProduct.getEdibleProductManufacturer(),
            newEdibleProduct.getEdibleProductName(),
            newEdibleProduct.getEdibleProductVariant(),
            newEdibleProduct.getEdibleProductFlavor(),
            newEdibleProduct.getEdibleProductDenomination(),
            expiryDate
        );

        /**
         * Validate if product already exists
         * Return Error response from validation if validation fails
         * */
        ValidationResponse validateIfProductExists = validations.validateNewEdibleProductExits(subid);

        if(validateIfProductExists.getStatusCode() != validations.validationSuccessCode) {
            return ResponseEntity.status(validateIfProductExists.getStatusCode()).body(
               validateIfProductExists
            );
        }


        /**
         * Create the edible products model
         * */
        EdibleProducts edibleProducts = new EdibleProducts();

        /**
         * Save the product image
         * */
        if (!edibleProductImages.isEmpty()) {
            OpsResponse res = utils.saveFiles(edibleProductImages, constants.saveImageSwitchCaseEdibleProducts);
            int errorCheck = res.getStatusCode();

            if(errorCheck != utils.opsSuccess){
                return ResponseEntity.status(errorCheck).body(res);
            } else {
                edibleProducts.setEdibleProductImageLocation((ArrayList<String>) res.getStatusArray());
            }
        } else {
            ArrayList<String> imagePlaceHolder = new ArrayList<>();
            // TODO : give correct path to image placeholder
            imagePlaceHolder.add("src/main/resources/assets/veg-images/veg-image-placeholder.png");
            edibleProducts.setEdibleProductImageLocation(imagePlaceHolder);
        }

        /**
         * Add variants to variant & category list
         * **/
        String itemCategorySubId = utils.createItemCategorySubId(newEdibleProduct.getItemCategory(), newEdibleProduct.getItemSubCategory());
        /* Return error if item category does not exist */
        ValidationResponse itemCategoryValidationStatus = validations.validateItemCategory(itemCategorySubId);
        if(itemCategoryValidationStatus.getStatusCode() != validations.validationSuccessCode) {
            return ResponseEntity.status(itemCategoryValidationStatus.getStatusCode()).body(
                    itemCategoryValidationStatus
            );
        }

        /**Create new VariandAndCategory**/
        VariantAndCategory variantAndCategory = new VariantAndCategory();
        variantAndCategory.setItemCategory(newEdibleProduct.getItemCategory());
        variantAndCategory.setItemSubCategory(newEdibleProduct.getItemSubCategory());
        variantAndCategory.setItemCategorySubId(itemCategorySubId);

        Optional<VariantAndCategory> optionalVariantAndCategory = variantAndCategoryService.findBySubId(itemCategorySubId);
        if(optionalVariantAndCategory.isPresent()) {
            /** If itemCategory and itemSubCategory (itemCategorySubId) is present add variant to existing variant list **/
            List<String> variantList =  new ArrayList<>();
            variantList.add(newEdibleProduct.getEdibleProductVariant());
            variantAndCategoryService.addVariants(itemCategorySubId, variantList);
        } else {
            List<String> variantList = new ArrayList<>();
            /**Persist new variant and category**/
            variantList.add(newEdibleProduct.getEdibleProductVariant());
            variantAndCategory.setVariantsList(variantList);
            variantAndCategoryService.save(variantAndCategory);
        }

        edibleProducts.setEdibleProductManufacturer(newEdibleProduct.getEdibleProductManufacturer());
        edibleProducts.setEdibleProductName(newEdibleProduct.getEdibleProductName());
        edibleProducts.setEdibleProductVariant(newEdibleProduct.getEdibleProductVariant());
        edibleProducts.setEdibleProductFlavor(newEdibleProduct.getEdibleProductFlavor());
        edibleProducts.setEdibleProductType(newEdibleProduct.getEdibleProductType());
        edibleProducts.setEdibleProductDescription(newEdibleProduct.getEdibleProductDescription());
        edibleProducts.setEdibleProductGenericName(newEdibleProduct.getEdibleProductGenericName());
        edibleProducts.setEdibleProductAlternaleName(newEdibleProduct.getEdibleProductAlternaleName());
        edibleProducts.setItemCategory(newEdibleProduct.getItemCategory());
        edibleProducts.setItemSubCategory(newEdibleProduct.getItemSubCategory());
        edibleProducts.setEdibleProductForMinors(newEdibleProduct.getEdibleProductForMinors());
        edibleProducts.setEdibleProductAvailable(newEdibleProduct.getEdibleProductAvailable());
        edibleProducts.setEdibleProductMrp(newEdibleProduct.getEdibleProductMrp());
        edibleProducts.setEdibleProductOfferedDiscount(newEdibleProduct.getEdibleProductOfferedDiscount());
        edibleProducts.setEdibleProductsDiscountName(newEdibleProduct.getEdibleProductsDiscountName());

        /**
         * Check if discount exists
         **/
        Optional<CustomerOrdersDiscount> proposedDiscount =
                customerOrdersDiscountServices.findByDiscountName(newEdibleProduct.getEdibleProductsDiscountName());

        /**
         * If discount does not exist, set the discount proposed in the payload
         **/
        Float discountedPrice = 0F;
        if(proposedDiscount.isEmpty()) {
            /**
             * Calculate the discounted price from the payload
             **/
            discountedPrice  = discountCalculator.calcDiscountedPrice(
                newEdibleProduct.getEdibleProductMrp(), newEdibleProduct.getEdibleProductOfferedDiscount()
            );
        }  else {
            /**
             * Calculate the discounted price from the DB record
             **/
            discountedPrice = discountCalculator.calcDiscountedPrice(
                newEdibleProduct.getEdibleProductMrp(), proposedDiscount.get().getDiscountPercentage()
            );
        }

        /**
         * Finally set the discounted price
         **/
        edibleProducts.setEdibleProductDiscountedPrice(discountedPrice);
        edibleProducts.setEdibleProductApplicableTaxes(newEdibleProduct.getEdibleProductApplicableTaxes());

        /**
         * Validate the taxes in request body
         **/
        ValidationResponse taxValidation = validations.validateIfTaxesAvailable(newEdibleProduct.getEdibleProductApplicableTaxes());

        if(taxValidation.getStatusCode() != validations.validationSuccessCode) {
            return ResponseEntity.status(taxValidation.getStatusCode()).body(
                taxValidation
            );
        }

        /**
         * Calculate taxed price after discount
         **/
        edibleProducts.setEdibleProductTaxedPrice(taxCalculator.calcAmountAfterTax(newEdibleProduct.getEdibleProductApplicableTaxes(), discountedPrice));
        edibleProducts.setEdibleProductQuantity(newEdibleProduct.getEdibleProductQuantity());
        edibleProducts.setEdibleProductsMeasureMentUnit(newEdibleProduct.getEdibleProductsMeasureMentUnit());
        edibleProducts.setEdibleProductDenomination(newEdibleProduct.getEdibleProductDenomination());
        edibleProducts.setEdibleProductSubId(subid);

        edibleProductsRepository.save(edibleProducts);

        /**
         * Create the edible products inventory model
         * */
        EdibleProductsInventory edibleProductsInventory = new EdibleProductsInventory();

        edibleProductsInventory.setEdibleProductCostPrice(newEdibleProduct.getEdibleProductCostPrice());
        edibleProductsInventory.setEdibleProductFixedCost(newEdibleProduct.getEdibleProductFixedCost());
        edibleProductsInventory.setEdibleProductSellingPrice(discountedPrice);
        edibleProductsInventory.setEdibleProductInventoryExpiry(expiryDate);
        edibleProductsInventory.setEdibleProductInventoryAddedBy(edibleProductAddedBy);
        edibleProductsInventory.setEdibleProductInventoryAddedOn(LocalDateTime.now());
        edibleProductsInventory.setEdibleProductInventoryQtyAdded(newEdibleProduct.getEdibleProductQuantity());
        edibleProductsInventory.setEdibleProductSubId(subid);

        edibleProductsInventoryRepository.save(edibleProductsInventory);

        Map<String, Object> res = new HashMap<String, Object>();

        res.put("edibleProduct", edibleProducts);
        res.put("edibleProductInventory", edibleProductsInventory);

        List<Object> finalRes = new ArrayList<>();

        finalRes.add(res);

        return ResponseEntity.status(201).body(
            createResponse.createSuccessResponse(
                201,
                "Product created",
                finalRes
                )
        );
    }

    public Map<String, Object> increamentEdibleProductsQuantity (Float quantity, String subId, String addedBy) {
        LocalDateTime addedOn = LocalDateTime.now();
        EdibleProducts edibleProducts = edibleProductsRepository.increamentEdibleProductQty(quantity, subId);
        EdibleProductsInventory edibleProductsInventory = edibleProductsInventoryRepository.increamentEdibleProductInventoryQuantity(quantity, addedBy, subId, addedOn);

        Map<String, Object> res = new HashMap<>();
        res.put(constants.edibleProduct, edibleProducts);
        res.put(constants.edibleProductInventory, edibleProductsInventory);

        return res;
    }

}
