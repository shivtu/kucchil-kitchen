package com.example.retail.controllers.retailer.helper_retailer;

import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.models.taxutility.services.TaxService;
import com.example.retail.util.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/retailer/helper")
public class HelperRetailerController {

    @Autowired
    CreateResponse createResponse;

    @Autowired
    TaxService taxService;

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @RequestMapping(value = "/findAll/taxes/Discounts/itemCategories", produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public ResponseEntity<Object> findTaxesDiscountsAndItemCategories () {

        HashMap<String, Object> res = new HashMap<String, Object>();
        res.put("discounts", customerOrdersDiscountServices.findAllDiscounts());
        res.put("taxes", taxService.forHelperFunctionFindAll());

        List<Object> finalRes = new ArrayList<>();

        finalRes.add(res);

        return ResponseEntity.status(200).body(
                createResponse.createSuccessResponse(200, "taxes, discounts and item categories", finalRes)
        );
    }
}
