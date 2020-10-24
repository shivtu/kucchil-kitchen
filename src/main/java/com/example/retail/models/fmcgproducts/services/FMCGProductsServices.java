package com.example.retail.models.fmcgproducts.services;

import com.example.retail.controllers.retailer.fmcg_retailer.FMCGProductsRequestBody;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.DiscountCalculator;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.models.fmcgproducts.FMCGProducts;
import com.example.retail.models.fmcgproducts.FMCGProductsInventory;
import com.example.retail.models.fmcgproducts.repository.FMCGProductsInventoryRepository;
import com.example.retail.models.fmcgproducts.repository.FMCGProductsRepository;
import com.example.retail.models.taxutility.TaxCalculator;
import com.example.retail.models.variantandcategory.VariantAndCategory;
import com.example.retail.models.variantandcategory.services.VariantAndCategoryService;
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
public class FMCGProductsServices {

    @Autowired
    FMCGProductsRepository fmcgProductsRepository;

   @Autowired
    FMCGProductsInventoryRepository fmcgProductsInventoryRepository;

    @Autowired
    DiscountCalculator discountCalculator;

    @Autowired
    TaxCalculator taxCalculator;

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @Autowired
    JWTDetails jwtDetails;

    @Autowired
    Validations validations;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    Utils utils;

    @Autowired
    VariantAndCategoryService variantAndCategoryService;

    @Autowired
    Constants constants;

    /**
     * Create a new FMCG product
     * @param request
     * @param fmcgProductsRequestBody
     * @param FMCGProductImages
     * @return FMCGProduct
     * @throws IOException
     */
    public ResponseEntity<Object> addFmcgProduct(HttpServletRequest request,
                                                 FMCGProductsRequestBody fmcgProductsRequestBody,
                                                 List<MultipartFile> FMCGProductImages) throws IOException {
        /**
         * Create the FMCG product sub-id
         **/
        String subId = utils.createFMCGProductSubId(
            fmcgProductsRequestBody.getFmcgProductManufacturer(),
            fmcgProductsRequestBody.getFmcgProductName(),
            fmcgProductsRequestBody.getFmcgProductVariant(),
            fmcgProductsRequestBody.getFmcgProductDenomination(),
            fmcgProductsRequestBody.getFmcgProductInventoryCostPrice(),
            fmcgProductsRequestBody.getFmcgProductInventoryFixedCost()
        );

        /**
         * Perform validations
         **/
        ValidationResponse validationResponse = validations.validateIfTaxesAvailable(fmcgProductsRequestBody.getFmcgProductApplicableTaxes());
        if(validationResponse.getStatusCode() != validations.validationSuccessCode) {
            return ResponseEntity.status(validationResponse.getStatusCode()).body(
                validationResponse
            );
        }

        /**
         * If subId already exists return error
         * **/
        ValidationResponse productExists = validations.validateNewFMCGProductExists(subId);
        if(productExists.getStatusCode() != validations.validationSuccessCode) {
            return ResponseEntity.status(productExists.getStatusCode()).body(
                productExists
            );
        }

        String fmcgProductAddedBy = jwtDetails.userName(request);
        LocalDate expiryDate = LocalDate.parse(fmcgProductsRequestBody.getFmcgProductInventoryExpiry());

        /**
         * Create FMCGProducts object
         */
        FMCGProducts fmcgProducts = new FMCGProducts();

        // Add image for the item before saving to DB
        if (!FMCGProductImages.isEmpty()) {
            OpsResponse res = utils.saveFiles(FMCGProductImages, constants.saveImageSwitchCaseFMCGProducts);
            int errorCheck = res.getStatusCode();

            if(errorCheck != utils.opsSuccess){
                return ResponseEntity.status(errorCheck).body(res);
            } else {
                fmcgProducts.setFMCGProductImages(res.getStatusArray());
            }
        } else {
            List<String> imagePlaceHolder = new ArrayList<>();
            // TODO : give correct path to image placeholder
            imagePlaceHolder.add("src/main/resources/assets/veg-images/veg-image-placeholder.png");
            fmcgProducts.setFMCGProductImages(imagePlaceHolder);
        }

        String itemCategorySubId = utils.getItemCategorySubId(fmcgProductsRequestBody.getItemCategory(), fmcgProductsRequestBody.getItemSubCategory());
        /* Return error if item category does not exist */
        ValidationResponse itemCategoryValidationStatus = validations.validateItemCategory(itemCategorySubId);
        if(itemCategoryValidationStatus.getStatusCode() != validations.validationSuccessCode) {
            return ResponseEntity.status(itemCategoryValidationStatus.getStatusCode()).body(
                itemCategoryValidationStatus
            );
        }

        /**Create new VariandAndCategory**/
        VariantAndCategory variantAndCategory = new VariantAndCategory();
        variantAndCategory.setItemCategory(fmcgProductsRequestBody.getItemCategory());
        variantAndCategory.setItemSubCategory(fmcgProductsRequestBody.getItemSubCategory());
        variantAndCategory.setItemCategorySubId(itemCategorySubId);

        Optional<VariantAndCategory> optionalVariantAndCategory = variantAndCategoryService.findBySubId(itemCategorySubId);
        if(optionalVariantAndCategory.isPresent()) {
            /** If itemCategory and itemSubCategory (itemCategorySubId) is present add variant to existing variant list **/
            List<String> variantList =  new ArrayList<>();
            variantList.add(fmcgProductsRequestBody.getFmcgProductVariant());
            variantAndCategoryService.addVariants(itemCategorySubId, variantList);
        } else {
            List<String> variantList = new ArrayList<>();
            /**Persist new variant and category**/
            variantList.add(fmcgProductsRequestBody.getFmcgProductVariant());
            variantAndCategory.setVariantsList(variantList);
            variantAndCategoryService.save(variantAndCategory);
        }

        fmcgProducts.setFmcgProductManufacturer(fmcgProductsRequestBody.getFmcgProductManufacturer());
        fmcgProducts.setFmcgProductName(fmcgProductsRequestBody.getFmcgProductName());
        fmcgProducts.setFmcgProductVariant(fmcgProductsRequestBody.getFmcgProductVariant());
        fmcgProducts.setFmcgProductDescription(fmcgProductsRequestBody.getFmcgProductDescription());
        fmcgProducts.setFmcgProductGenericName(fmcgProductsRequestBody.getFmcgProductGenericName());
        fmcgProducts.setFmcgProductAlternateName(fmcgProductsRequestBody.getFmcgProductAlternateName());
        fmcgProducts.setItemCategory(fmcgProductsRequestBody.getItemCategory());
        fmcgProducts.setItemSubCategory(fmcgProductsRequestBody.getItemSubCategory());
        fmcgProducts.setFmcgProductAvailable(fmcgProductsRequestBody.getFmcgProductAvailable());
        fmcgProducts.setFmcgProductSellingPrice(fmcgProductsRequestBody.getFmcgProductSellingPrice());
        fmcgProducts.setFmcgProductOfferedDiscount(fmcgProductsRequestBody.getFmcgProductOfferedDiscount());
        fmcgProducts.setFmcgProductDiscountName(fmcgProductsRequestBody.getFmcgProductDiscountName());

        /**
         * Check if discount exists
         **/
        Optional<CustomerOrdersDiscount> proposedDiscount =
                customerOrdersDiscountServices.findByDiscountName(fmcgProductsRequestBody.getFmcgProductDiscountName());
        /**
         * If discount does not exist, set the discount proposed in the payload
         **/
        Float discountedPrice = 0F;

        if(proposedDiscount.isEmpty()) {
            discountedPrice = discountCalculator.calcDiscountedPrice(
                    fmcgProductsRequestBody.getFmcgProductSellingPrice(), fmcgProductsRequestBody.getFmcgProductOfferedDiscount()
            );
        } else {
            /**
             * Calculate the discounted price from the DB record
             **/
            discountedPrice = discountCalculator.calcDiscountedPrice(
                    fmcgProductsRequestBody.getFmcgProductSellingPrice(), proposedDiscount.get().getDiscountPercentage()
            );
        }

        fmcgProducts.setFmcgProductDiscountedPrice(discountedPrice);
        fmcgProducts.setFmcgProductApplicableTaxes(fmcgProductsRequestBody.getFmcgProductApplicableTaxes());
        fmcgProducts.setFmcgProductTaxedPrice(taxCalculator.calcAmountAfterTax(fmcgProductsRequestBody.getFmcgProductApplicableTaxes(), discountedPrice));
        fmcgProducts.setFmcgProductQuantity(fmcgProductsRequestBody.getFmcgProductQuantity());
        fmcgProducts.setFmcgProductMeasurementUnit(fmcgProductsRequestBody.getFmcgProductMeasurementUnit());
        fmcgProducts.setFmcgProductDenomination(fmcgProductsRequestBody.getFmcgProductDenomination());
        fmcgProducts.setFmcgProductSubId(subId);



        /**
         * Create FMCG products inventory object
         **/
        FMCGProductsInventory fmcgProductsInventory = new FMCGProductsInventory();
        fmcgProductsInventory.setFmcgProductInventoryCostPrice(fmcgProductsRequestBody.getFmcgProductInventoryCostPrice());
        fmcgProductsInventory.setFmcgProductInventoryFixedCost(fmcgProductsRequestBody.getFmcgProductInventoryFixedCost());
        /*
        * We set the selling price in the inventory excluding the tax and including the discounts to calculate the absolute profits
         */
        fmcgProductsInventory.setFmcgProductInventorySellingPrice(discountedPrice);
        fmcgProductsInventory.setFmcgProductInventoryExpiry(expiryDate);
        fmcgProductsInventory.setFmcgProductInventoryAddedBy(fmcgProductAddedBy);
        fmcgProductsInventory.setFmcgProductInventoryAddedOn(LocalDateTime.now());
        fmcgProductsInventory.setFmcgProductInventoryAddedQty(fmcgProductsRequestBody.getFmcgProductInventoryAddedQty());
        fmcgProductsInventory.setSuppliers(fmcgProductsRequestBody.getSuppliers());
        fmcgProductsInventory.setFmcgProductSubId(subId);
        fmcgProductsInventory.setFmcgProductInventoryAddedQty(fmcgProductsRequestBody.getFmcgProductQuantity());

        fmcgProductsRepository.save(fmcgProducts);
        fmcgProductsInventoryRepository.save(fmcgProductsInventory);

        Map<String, Object> res = new HashMap<>();
        res.put("FMCGProduct", fmcgProducts);
        res.put("FMCGProductInventory", fmcgProductsInventory);

        List< Map<String, ?>> finalRes = new ArrayList<>();
        finalRes.add(res);

        return ResponseEntity.status(201).body(
            createResponse.createSuccessResponse(
                201,
                "FMCG product created",
                finalRes
            )
        );
    }

    public List<?> findAllFMCGProductsWithInventory() {
        List<FMCGProducts> FMCGProducts = fmcgProductsRepository.findAll();
        List<FMCGProductsInventory> FMCGProductsInventories = fmcgProductsInventoryRepository.findAll();


        List<Map<String, ?>> finalRes = new ArrayList<>();

        FMCGProducts.forEach((FMCGProduct) -> {
            FMCGProductsInventories.forEach((FMCGProductsInventory) -> {
                if(FMCGProduct.getFmcgProductSubId().equals(FMCGProductsInventory.getFmcgProductSubId())) {
                    Map<String, Object> resObject = new HashMap<>();
                    resObject.put(constants.FMCGProduct, FMCGProduct);
                    resObject.put(constants.FMCGProductInventory, FMCGProductsInventory);
                    finalRes.add(resObject);
                }
            });
        });

        return finalRes;
    }

    public List<FMCGProducts> findAll () {
        return fmcgProductsRepository.findAll();
    }

    /**
     * Update qty in FMCGProducts table and FMCGProductsInventory table
     * For MVP we update the id of the user who last updates the inventory and do not maintain each update record with
     * relation to which user and what time
     */
    public Map<String, ?> increamentFMCGProductQuantity (Float fmcgProductQuantity, String fmcgProductInventoryAddedBy, String fmcgProductSubId) {

            LocalDateTime localDateTime = LocalDateTime.now();
            FMCGProducts fmcgProducts = fmcgProductsRepository.increamentFMCGProductQty(fmcgProductQuantity, fmcgProductSubId);
            FMCGProductsInventory fmcgProductsInventory =
                fmcgProductsInventoryRepository.increamentFMCGProductsInventoryQty(
                    fmcgProductQuantity, fmcgProductInventoryAddedBy, localDateTime, fmcgProductSubId
                );

            Map<String, Object> res = new HashMap<>();
            res.put(constants.FMCGProduct, fmcgProducts);
            res.put(constants.FMCGProductInventory, fmcgProductsInventory);

           return res;

    }
}
