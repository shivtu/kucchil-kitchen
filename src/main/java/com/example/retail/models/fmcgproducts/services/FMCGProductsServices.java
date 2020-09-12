package com.example.retail.models.fmcgproducts.services;

import com.example.retail.controllers.retailer.fmcg_retailer.FMCGProductsRequestBody;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.DiscountCalculator;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.models.fmcgproducts.FMCGProducts;
import com.example.retail.models.fmcgproducts.FMCGProductsInventory;
import com.example.retail.models.fmcgproducts.repository.FMCGProductsRepository;
import com.example.retail.models.taxutility.TaxCalculator;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.JWTDetails;
import com.example.retail.util.ValidationResponse;
import com.example.retail.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class FMCGProductsServices {

    @Autowired
    FMCGProductsRepository fmcgProductsRepository;

    @Autowired
    FMCGProductsInventoryServices fmcgProductsInventoryServices;

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

    private String generateSubId (FMCGProductsRequestBody fmcgProductsRequestBody) {
        String subId = fmcgProductsRequestBody.getFmcgProductManufacturer().toLowerCase()
                + fmcgProductsRequestBody.getFmcgProductName().toLowerCase()
                + fmcgProductsRequestBody.getFmcgProductVariant().toLowerCase()
                + fmcgProductsRequestBody.getFmcgProductDenomination().toString().toLowerCase()
                + fmcgProductsRequestBody.getFmcgProductInventoryCostPrice().toString().toLowerCase()
                + fmcgProductsRequestBody.getFmcgProductInventoryFixedCost().toString().toLowerCase();
        return subId;
    }

    public List<FMCGProducts> findAll() {
        return fmcgProductsRepository.findAll();
    }

    private FMCGProducts save (FMCGProducts fmcgProducts) {
        return fmcgProductsRepository.save(fmcgProducts);
    }

    public ResponseEntity<Object> addFmcgProduct(HttpServletRequest request, FMCGProductsRequestBody fmcgProductsRequestBody) {
        /**
         * Create the FMCG product sub-id
         **/
        String subId = generateSubId(fmcgProductsRequestBody);

        /**
         * Perform validations
         **/
        ValidationResponse validationResponse = validations.validateIfTaxesAvailable(fmcgProductsRequestBody.getFmcgProductApplicableTaxes());
        if(validationResponse.getStatusCode() != validations.validationSuccessCode) {
            return ResponseEntity.status(validationResponse.getStatusCode()).body(
                validationResponse
            );
        }

        String fmcgProductAddedBy = jwtDetails.userName(request);
        LocalDate expiryDate = LocalDate.parse(fmcgProductsRequestBody.getFmcgProductInventoryExpiry());

        /**
         * Create FMCGProducts object
         */
        FMCGProducts fmcgProducts = new FMCGProducts();
        fmcgProducts.setFmcgProductManufacturer(fmcgProductsRequestBody.getFmcgProductManufacturer());
        fmcgProducts.setFmcgProductName(fmcgProductsRequestBody.getFmcgProductName());
        fmcgProducts.setFmcgProductVariant(fmcgProductsRequestBody.getFmcgProductVariant());
        fmcgProducts.setFmcgProductDescription(fmcgProductsRequestBody.getFmcgProductDescription());
        fmcgProducts.setFmcgProductGenericName(fmcgProductsRequestBody.getFmcgProductGenericName());
        fmcgProducts.setFmcgProductAlternateName(fmcgProductsRequestBody.getFmcgProductAlternateName());
        fmcgProducts.setItemClassificationName(fmcgProductsRequestBody.getItemClassificationName());
        fmcgProducts.setItemClassificationCode(fmcgProductsRequestBody.getItemClassificationCode());
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

        Map<String, Object> res = new HashMap<>();
        res.put("FMCGProduct", fmcgProducts);
        res.put("FMCGProductInventory", fmcgProductsInventory);

        List<Object> finalRes = new ArrayList<>();
        finalRes.add(res);

        return ResponseEntity.status(201).body(
            createResponse.createSuccessResponse(
                201,
                "FMCG product created",
                finalRes
            )
        );
    }
}
