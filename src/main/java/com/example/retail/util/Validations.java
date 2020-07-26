package com.example.retail.util;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import com.example.retail.controllers.retailer.vegitables_retailer.UpdateVegitablesInventoryRequest;
import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.VegitablesInventory;
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

    @Autowired
    VegitableInventoryService vegitableInventoryService;

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
        if (newVegitables.getVegitableInventoryMaxDiscount() < newVegitables.getVegitableOfferedDiscount()) {

            return     createResponse.createValidationResponse(
                    badRequestCode,
                            "Offered discount is set more than the max discount",
                            "Offered discount must always be less than the maximum discount set for an item"
                    );
        }

        // Check if discounts are negative numbers
        if (newVegitables.getVegitableInventoryMaxDiscount() < 0 || newVegitables.getVegitableOfferedDiscount() < 0) {
            return
                    createResponse.createValidationResponse(
                            badRequestCode,
                            "Invalid format for discounts",
                            "Discounts are expressed in %, please provide a positive number"

            );
        }

        // Check if selling price is less than cost price
        if (newVegitables.getVegitableSellingPrice() < newVegitables.getVegitableInventoryCostPrice()) {

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

    public ValidationResponse validateInventory(String vegSubId, UpdateVegitablesInventoryRequest updateVegitablesInventoryRequest) {
        Optional<VegitablesInventory> vegitablesInventory = vegitableInventoryService.findVegitableInventoryBySubId(vegSubId);
        if (!vegitablesInventory.isEmpty()) {
            return
                createResponse.createValidationResponse(
                400,
            "This item with provided details already exists",
            "Try updating the quantity only: /api/v1/retailer/vegitables/update/quantity/<id>/<quantity>"
            );
        }

        if(updateVegitablesInventoryRequest.getVegitableSellingPrice() < updateVegitablesInventoryRequest.getVegitableInventoryCostPrice()) {
            return createResponse.createValidationResponse(
                    badRequestCode,
                    "Selling price of the vegitable is less than the cost price",
                    "Selling price must be more than cost price to make a profit"
            );
        }

        return createResponse.createValidationResponse(validationSuccessCode, "OK", null);
    }
}
