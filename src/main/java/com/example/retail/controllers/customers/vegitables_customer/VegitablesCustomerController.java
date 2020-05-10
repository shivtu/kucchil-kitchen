package com.example.retail.controllers.customers.vegitables_customer;

import com.example.retail.productsmodel.vegitables.Vegitables;
import com.example.retail.productsmodel.vegitables.VegitablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/vegitables")
public class VegitablesCustomerController {

    @Autowired
    VegitablesService vegitablesService;

    @RequestMapping(value = "/allproducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> getAllVegitables() {
        Iterable<Vegitables> result = vegitablesService.getAllVegitables();
        List<Object> finalResponse = new ArrayList<Object>();
        result.forEach(vegitables -> {
            HashMap<String, Object> perObject = new HashMap<>();
            perObject.put("productName", vegitables.getVegitable_Name());
            finalResponse.add(perObject);
            perObject = null;
        });
        return finalResponse;
    }
}
