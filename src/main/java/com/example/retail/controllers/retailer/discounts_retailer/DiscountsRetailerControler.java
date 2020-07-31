package com.example.retail.controllers.retailer.discounts_retailer;

import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/retailer/discount")
public class DiscountsRetailerControler {

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createSpecialDiscount(HttpServletRequest request, @RequestBody CustomerOrdersDiscount customerOrdersDiscount) {
        return customerOrdersDiscountServices.createSpecialDiscount(request, customerOrdersDiscount);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAllDiscounts() {
        return customerOrdersDiscountServices.findAllDiscounts();
    }
}