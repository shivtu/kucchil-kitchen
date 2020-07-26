package com.example.retail.util;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.services.VegitableInventoryService;
import com.example.retail.models.vegitables.services.VegitablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Validations {

    @Autowired
    ErrorResponse errorResponse;

    @Autowired
    Utils utils;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    VegitablesService vegitablesService;

    @Autowired
    ValidationResponse validationResponse;

    public int validationSuccessCode = 1;
    public int uprocessableRequestCode = 422;
    public int badRequestCode = 400;

    public ValidationResponse validateNewVegitables(AddVegitablesRequestBody newVegitables, String vegSubId) {

        Optional<Vegitables> vegitables = vegitablesService.findBySubId(vegSubId);

        // If the item already exists
        if(!vegitables.isEmpty()) {

                return createResponse.createValidationResponse(
                        uprocessableRequestCode,
                            "This item already exists",
                            "Try updating this item instead"
                    );

        }

        // Check if max discount in inventory table is less than offered discount
        if (newVegitables.getVegitablesInventoryMaxDiscount() < newVegitables.getVegitableOfferedDiscount()) {

            return     createResponse.createValidationResponse(
                    badRequestCode,
                            "Offered discount is set more than the max discount",
                            "Offered discount must always be less than the maximum discount set for an item"
                    );
        }

        // Check if discounts are negative numbers
        if (newVegitables.getVegitablesInventoryMaxDiscount() < 0 || newVegitables.getVegitableOfferedDiscount() < 0) {
            return
                    createResponse.createValidationResponse(
                            badRequestCode,
                            "Invalid format for discounts",
                            "Discounts are expressed in %, please provide a positive number"

            );
        }

        // Check if selling price is less than cost price
        if (newVegitables.getVegitableSellingPrice() < newVegitables.getVegitablesInventoryCostPrice()) {

              return createResponse.createValidationResponse(
                      badRequestCode,
                            "Selling price of the vegitable is less than the cost price",
                            "Selling price must be more than cost price to make a profit"
                    );

        }

        return createResponse.createValidationResponse(
                validationSuccessCode,
                "OK",
                "NA"

        );

    }

//    public ResponseEntity<Object> validateNewInventory(String vegSubId) {
//        Optional<VegitablesInventory> vegitablesInventory = vegitableInventoryService.findVegitableInventoryBySubId(vegSubId);
//        if (!vegitablesInventory.isEmpty()) {
//            return ResponseEntity.status(400).body(
//                    createResponse.createErrorResponse(
//                            400,
//                            "This item with provided details already exists",
//                            "Try updating the quantity only: /api/v1/retailer/vegitables/update/quantity/<id>/<quantity>"
//                    )
//
//            );
//        }
//        return ResponseEntity.status(1).body("OK");
//    }
}
