package com.example.retail.controllers.retailer.deliveryutility_retailer;

import com.example.retail.models.deliveryutility.DeliveryCharges;
import com.example.retail.models.deliveryutility.services.DeliveryChargeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/retailer/deliveryCharges")
@CrossOrigin(origins = "*")
public class DeliveryUtilityRetailerController {

    @Autowired
    DeliveryChargeServices deliveryChargeServices;

    @RequestMapping(value = "/createConstraint", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> createDeliveryChargeConstraint(@RequestBody DeliveryCharges deliveryCharges) {
        return deliveryChargeServices.createDeliveryChargeConstraint(deliveryCharges);
    }

}
