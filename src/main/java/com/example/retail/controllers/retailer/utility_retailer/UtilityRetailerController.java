package com.example.retail.controllers.retailer.utility_retailer;

import com.example.retail.util.CreateResponse;
import com.example.retail.util.UtilityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/retailer/utility")
public class UtilityRetailerController {

    @Autowired
    UtilityServices utilityServices;

    @Autowired
    CreateResponse createResponse;

    @RequestMapping(value = "/find/allUtilities", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUtilties() {
        try{
            List<?> finalRes = utilityServices.findAllUtilities();
            int count = finalRes.size();
            return ResponseEntity.status(200).body(
                createResponse.createSuccessResponse(
                    200,
                    count + " utilities found",
                    finalRes
                )
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                createResponse.createErrorResponse(
                    500,
                    e.getLocalizedMessage(),
                    "NA"
                )
            );
        }
    }

//    @RequestMapping(value = "/findVariantsBySubId/{subId}")
//    public ResponseEntity<?> findAllVariantsBySubId(@PathVariable String subId) {
//        return utilityServices.findAllVariantsBySubId(subId);
//    }
    @RequestMapping(value = "/find/allProducts", method = RequestMethod.GET)
    public ResponseEntity<?> findAllProducts () {
        try{
            List<?> finalRes = utilityServices.findAllProducts();
            return ResponseEntity.status(200).body(
                createResponse.createSuccessResponse(
                    200,
                    "Products found",
                    finalRes
                )
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                createResponse.createErrorResponse(
                    500,
                    e.getLocalizedMessage(),
                    "NA"
                )
            );
        }
    }

    @RequestMapping(value = "/find/allProducts/allUtilities", method = RequestMethod.GET)
    public ResponseEntity<?> findAllProductsAndUtilities () {
        try {
            List<?> utilities = utilityServices.findAllUtilities();
            List<?> allProducts = utilityServices.findAllProducts();

            Map<String, List<?>> res = new HashMap<>();
            res.put("allProducts", allProducts);
            res.put("utilities", utilities);
            int count = utilities.size() + allProducts.size();
            List<Map<String, List<?>>> finalRes = new ArrayList<>();
            finalRes.add(res);

            return ResponseEntity.status(200).body(
                createResponse.createSuccessResponse(
                    200,
                    count + " items found",
                    finalRes
                )
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                createResponse.createErrorResponse(
                    500,
                    e.getLocalizedMessage(),
                    "NA"
                )
            );
        }
    }
}
