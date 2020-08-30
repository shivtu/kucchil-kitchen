package com.example.retail.controllers.retailer.utility_retailer;

import com.example.retail.util.UtilityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/retailer/utility")
public class UtilityRetailerController {

    @Autowired
    UtilityServices utilityServices;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUtilties() {
        return utilityServices.findAllUtilities();
    }
}
