package com.example.retail.controllers.retailer.edibleproducts_retailer;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import com.example.retail.models.edibleproducts.EdibleProducts;
import com.example.retail.models.edibleproducts.services.EdibleProductsService;
import com.example.retail.util.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/retailer/edibleProducts")
public class EdibleProductsRetailerController {

    @Autowired
    EdibleProductsService edibleProductsService;

    @Autowired
    CreateResponse createResponse;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome!";
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        try {
            List<?> finalRes = edibleProductsService.findAllEdibleProductsWithInventory();
            return ResponseEntity.status(200).body(createResponse.createSuccessResponse(
                200,
                finalRes.size() + " items found",
                finalRes
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

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> addEdibleProduct(
            HttpServletRequest request,
            @ModelAttribute AddEdibleProductsRequestBody newProduct,
            @RequestParam("edibleProductImages") ArrayList<MultipartFile> edibleProductImages) {

        try {
            return edibleProductsService.addEdibleProduct(request, edibleProductImages, newProduct);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                createResponse.createErrorResponse(
                    500,
                    e.getMessage(),
                    e.toString()
                )
            );
        }
    }

}
