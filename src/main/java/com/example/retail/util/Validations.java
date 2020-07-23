package com.example.retail.util;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Validations {

    @Autowired
    ErrorResponse errorResponse;

    @Autowired
    Utils utils;

    @Autowired
    CreateResponse createResponse;

    public ResponseEntity<Object> validateNewVegitables(AddVegitablesRequestBody newVegitables) {

        // Check if max discount in inventory table is less than offered discount
        if (newVegitables.getVegitablesInventoryMaxDiscount() < newVegitables.getVegitableOfferedDiscount()) {
            return ResponseEntity.badRequest().body(
                    createResponse.createErrorResponse(
                            400,
                            "Offered discount is set more than the max discount",
                            "Offered discount must always be less than the maximum discount set for an item"
                    )
            );
        }

        // Check if discounts are negative numbers
        if (newVegitables.getVegitablesInventoryMaxDiscount() < 0 || newVegitables.getVegitableOfferedDiscount() < 0) {
            return ResponseEntity.badRequest().body(
                    createResponse.createErrorResponse(
                            400,
                            "Invalid format for discounts",
                            "Discounts are expressed in %, please provide a positive number"
                    )
            );
        }

        // Check if selling price is less than cost price
        if (newVegitables.getVegitableSellingPrice() < newVegitables.getVegitablesInventoryCostPrice()) {
            return ResponseEntity.badRequest().body(
                    createResponse.createErrorResponse(
                            400,
                            "Selling price of the vegitable is less than the cost price",
                            "Selling price must be more than cost price to make a profit"
                    )
            );
        }



        // Check if cost price and/or cost price is negative

        return ResponseEntity.status(1).body("OK");

    }
}
