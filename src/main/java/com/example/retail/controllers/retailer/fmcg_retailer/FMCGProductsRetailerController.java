package com.example.retail.controllers.retailer.fmcg_retailer;

import com.example.retail.models.fmcgproducts.services.FMCGProductsServices;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.JWTDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/retailer/fmcg")
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
        return fmcgProductsServices.addFmcgProduct(request, fmcgProductsRequestBody, FMCGProductImages);
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
    @RequestMapping(value = "/update/{subId}/increamentQuantity/{quantity}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateFMCGProductInventory(@PathVariable Float quantity, @PathVariable String subId, HttpServletRequest request) {
        String addedBy = jwtDetails.userName(request);
        return fmcgProductsServices.increamentFMCGProductInventory(quantity, addedBy, subId);
    }


}
