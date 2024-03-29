package com.example.retail.controllers.retailer.fmcg_retailer;

import com.example.retail.services.fmcgproducts.FMCGProductsServices;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.JWTDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/retailer/fmcg")
@CrossOrigin(origins = "*")
public class FMCGProductsRetailerController {

    @Autowired
    FMCGProductsServices fmcgProductsServices;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    JWTDetails jwtDetails;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> saveFmcgProduct(HttpServletRequest request,
                                                  FMCGProductsRequestBody fmcgProductsRequestBody,
                                                  @RequestParam("FMCGProductImages") List<MultipartFile> FMCGProductImages) throws IOException {
        try {
            return fmcgProductsServices.addFmcgProduct(request, fmcgProductsRequestBody, FMCGProductImages);
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

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllFMCGProductsWithInventory () {
        try {
            List<?> res = fmcgProductsServices.findAllFMCGProductsWithInventory();
            return ResponseEntity.status(200).body(createResponse.createSuccessResponse(
                200, res.size() + " items found",
                res
            ));
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

    /**
     * Update product qty in both products and inventory table simultaneously
     * **/
    @RequestMapping(value = "/update/{subId}/increamentQuantity/{quantity}",
            method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> increamentFMCGProductQuantity(@PathVariable Float quantity, @PathVariable String subId, HttpServletRequest request) {
        if (quantity <= 0) {
            return ResponseEntity.status(400).body(
                createResponse.createErrorResponse(
                    400,
                    "Quantity has to be greater that 0",
                    "NA"
                )
            );
        }
        String addedBy = jwtDetails.userName(request);
        Map<String, ?> finalRes = fmcgProductsServices.increamentFMCGProductQuantity(quantity, addedBy, subId);
        return ResponseEntity.status(201).body(
            createResponse.createSuccessResponse(
                201,
                "Quantity increamented by: " + quantity,
                finalRes
            )
        );
    }


}
