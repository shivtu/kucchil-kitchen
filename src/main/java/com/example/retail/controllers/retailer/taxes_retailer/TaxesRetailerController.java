package com.example.retail.controllers.retailer.taxes_retailer;

import com.example.retail.models.taxutility.Taxes;
import com.example.retail.models.taxutility.services.TaxService;
import com.example.retail.util.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/retailer/taxes")
@CrossOrigin(origins = "*")
public class TaxesRetailerController {

    @Autowired
    TaxService taxService;

    @Autowired
    CreateResponse createResponse;

    @RequestMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,
    method = RequestMethod.POST)
    public ResponseEntity<Object> addTax(HttpServletRequest request, @RequestBody Taxes newTax) {
        return taxService.addTax(request, newTax);
    }
}
