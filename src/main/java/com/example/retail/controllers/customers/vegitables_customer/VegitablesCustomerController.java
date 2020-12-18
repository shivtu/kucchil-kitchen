package com.example.retail.controllers.customers.vegitables_customer;

import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.services.VegitablesService;
import com.example.retail.util.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/vegitables")
@CrossOrigin(origins = "*")
public class VegitablesCustomerController {

    @Autowired
    VegitablesService vegitablesService;

    @Autowired
    CreateResponse createResponse;

    @RequestMapping(value = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllVegitables() {
        List<Vegitables> result = vegitablesService.findAllVegitables();
        int resultCount = result.size();
        return ResponseEntity.status(200).body(
                createResponse.createSuccessResponse(
                        200,
                        resultCount + " items(s) found",
                        result
                )
        );
    }

    @RequestMapping(value = "/findall/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAllAvailableVegitables() {
        try {
            List<Vegitables> result = vegitablesService.findAllAvailableVegitables();
            int resultCount = result.size();
            return ResponseEntity.status(200).body(
                    createResponse.createSuccessResponse(
                            200,
                            resultCount + " items(s) found",
                            result
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(
                            500,
                            e.getMessage(),
                            "NA"
                    )
            );
        }
    }
}
