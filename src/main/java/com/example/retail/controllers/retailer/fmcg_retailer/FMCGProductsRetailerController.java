package com.example.retail.controllers.retailer.fmcg_retailer;

import com.example.retail.models.fmcgproducts.services.FMCGProductsServices;
import com.example.retail.util.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/retailer/fmcg")
public class FMCGProductsRetailerController {

    @Autowired
    FMCGProductsServices fmcgProductsServices;

    @Autowired
    CreateResponse createResponse;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveFmcgProduct(HttpServletRequest request, FMCGProductsRequestBody fmcgProductsRequestBody) {
        return fmcgProductsServices.addFmcgProduct(request, fmcgProductsRequestBody);
    }

}
