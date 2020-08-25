package com.example.retail.controllers.customers.edibleproducts_customer;

import com.example.retail.models.edibleproducts.EdibleProducts;
import com.example.retail.models.edibleproducts.services.EdibleProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/edibleProducts")
public class EdibleProductsCustomerController {

    @Autowired
    EdibleProductsService productsService;

    @Autowired
    EdibleProductsService edibleProductsService;

    @RequestMapping(value = "/allproducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Object> getAllProducts(){
        Iterable<EdibleProducts> result = edibleProductsService.getAllProducts();
        List<Object> finalResponse = new ArrayList<Object>();

        result.forEach(edibleProducts -> {
            HashMap<String, Object> perObject = new HashMap();
            perObject.put("productName", edibleProducts.getEdibleProducts_productName());
            perObject.put("productDesc", edibleProducts.getEdibleProducts_Desc());
            finalResponse.add(perObject);
            perObject = null;
        });
        return finalResponse;
    }
}
