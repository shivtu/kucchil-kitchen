package com.example.retail.controllers.customers.vegitables_customer;

import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.services.VegitablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/vegitables")
public class VegitablesCustomerController {

    @Autowired
    VegitablesService vegitablesService;

    @RequestMapping(value = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllVegitables() {
        Iterable<Vegitables> result = vegitablesService.getAllVegitables();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/findall/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAllAvailableVegitables() {
        return vegitablesService.findAllAvailableVegitables();
    }
}
