package com.example.retail.controllers.retailer.deliveryutility_retailer;

import com.example.retail.models.deliveryutility.DeliveryCharges;
import com.example.retail.models.deliveryutility.DeliveryLocations;
import com.example.retail.models.deliveryutility.DeliveryLocationsPage;
import com.example.retail.models.deliveryutility.services.DeliveryChargeServices;
import com.example.retail.models.deliveryutility.services.DeliveryLocationsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/retailer/deliveryUtility")
@CrossOrigin(origins = "*")
public class DeliveryUtilityRetailerController {

    @Autowired
    DeliveryChargeServices deliveryChargeServices;

    @Autowired
    DeliveryLocationsServices deliveryLocationsServices;

    @RequestMapping(value = "/createConstraint", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> createDeliveryChargeConstraint(@RequestBody DeliveryCharges deliveryCharges) {
        return deliveryChargeServices.createDeliveryChargeConstraint(deliveryCharges);
    }

    @RequestMapping(value = "/addNewDeliveryLocation", method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> addNewDeliveryLocation(@RequestBody DeliveryLocations deliveryLocations) {
        return deliveryLocationsServices.addNewDeliveryLocation(deliveryLocations);
    }

    @RequestMapping(value = "/findAllDeliveryLocations/paginated", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> findPaginatedDeliveryLocationsPaginated(DeliveryLocationsPage deliveryLocationsPage){
        return deliveryLocationsServices.findPaginatedDeliveryLocationsPaginated(deliveryLocationsPage);
    }

}
