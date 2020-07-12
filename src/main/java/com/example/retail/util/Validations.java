package com.example.retail.util;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validations {

    @Autowired
    OpsResponse opsResponse;

    public OpsResponse setValidationError (String errorIn) {
        opsResponse.setResponseCode(400);
        opsResponse.setResponseMessage(errorIn);
        return opsResponse;
    }

    public OpsResponse setValidationOk () {
        opsResponse.setResponseCode(200);
        opsResponse.setResponseMessage("Validation ok");
        return opsResponse;
    }

    public OpsResponse validateNewVegitables(AddVegitablesRequestBody newVegitables) {

        // Check if max discount in inventory table is less than offered discount
        if (newVegitables.getVegitablesInventoryMaxDiscount() < newVegitables.getVegitableOfferedDiscount()) {
            return setValidationError("Offered discount is set more than the max discount");
        }

        // Check if selling price is less than cost price
        if (newVegitables.getVegitableSellingPrice() < newVegitables.getVegitablesInventoryCostPrice()) {
            return setValidationError("Selling price of the vegitable is less than the cost price");
        }

        return setValidationOk();

    }
}
