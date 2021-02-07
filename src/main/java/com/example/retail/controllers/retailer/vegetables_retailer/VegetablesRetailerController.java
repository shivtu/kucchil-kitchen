package com.example.retail.controllers.retailer.vegetables_retailer;

import com.example.retail.models.vegetables.Vegetables;
import com.example.retail.models.vegetables.VegetablesPage;
import com.example.retail.models.vegetables.services.VegetableInventoryService;
import com.example.retail.models.vegetables.services.VegetablesService;
import com.example.retail.util.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/retailer/vegetables")
@CrossOrigin(origins = "*")
public class VegetablesRetailerController {

    @Autowired
    CreateResponse createResponse;

    @Autowired
    VegetablesService vegetablesService;

    @Autowired
    VegetableInventoryService vegetableInventoryService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<?> findAllVegetablesWithInventory() {
        try {
            List<?> result = vegetablesService.findAllVegetablesWithInventory();
            int resultCount = result.size();
            return ResponseEntity.status(200).body(
                    createResponse.createSuccessResponse(
                            200,
                            resultCount + " item(s) found",
                            result
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(
                            500,
                            e.toString(),
                            "NA"
                    )
            );
        }

    }


    /**
     * User adds a new item that is not available yet
     * The business logic goes as follows
     * 1. The user introduces a new vegetabble
     * 2. We create a new row entry in the DB for vegetables table
     * 3. Additionally we also create a corrosponding entry in the inventory table for the newly created product
     **/
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Object addNewVegetable(HttpServletRequest request,
                                  @ModelAttribute AddVegetablesRequestBody newVegetables,
                                  @RequestParam("vegetableImages") ArrayList<MultipartFile> vegetableImages) throws Exception {
        return vegetablesService.addNewVegetable(request, newVegetables, vegetableImages);
    }


    /* User updates the quantity only for an existing item */
    @RequestMapping(value = "/update/{tableId}/increamentQuantity/{quantity}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateVegetableQty(@PathVariable Long tableId, @PathVariable Float quantity,
                                                     HttpServletRequest request) {
        try {
            /** Increament quantity of vegetables **/
            if (vegetablesService.updateVegetableQty(tableId, quantity) == 1) {
                /** Update the vegetable_addition_details in vegetable_inventory **/
                List<Object> result = vegetableInventoryService.updateVegetableQty(tableId, quantity, request);

                return ResponseEntity.status(201).body(
                        createResponse.createSuccessResponse(
                                201,
                                "Quantity updated!!",
                                result
                        )
                );
            } else {
                return ResponseEntity.status(400).body(
                        createResponse.createErrorResponse(400, "Vegetable not found",
                                "This item does not exist")
                );
            }
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


    /**
     * The user will update the inventory only for a vegetable that already exists
     * Here we create a new inventory row in the DB for an existing vegetable
     * The business logic as follows
     * 1. Vegetable has already been created
     * 2. The retailer buys more stock at new cost
     * 3. We add the quantity provided by the user to the existing quantity in vegetable table
     * 4. We make new row entry in the DB for the inventory with new cost price, selling price and discount
     * 5. We add the new subID to vegetables table (this acts as a pointer)
     **/
    @RequestMapping(value = "/add/inventory/{tableId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addInventory(@PathVariable Long tableId,
                                               @RequestBody UpdateVegetablesInventoryRequest updateVegetablesInventoryRequest,
                                               HttpServletRequest request) {
        return vegetableInventoryService.addInventory(tableId, updateVegetablesInventoryRequest, request);
    }

    @RequestMapping(value = "/findAll/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAllAvailableVegetables() {
        try {
            List<Vegetables> result = vegetablesService.findAllAvailableVegetables();
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

    @RequestMapping(method = RequestMethod.GET, value = "/findAll/unavailable", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAllUnavailableVegetables() {
        try {
            List<Vegetables> result = vegetablesService.findAllUnavailableVegetables();
            int resultCount = result.size();
            return ResponseEntity.status(200).body(
                    createResponse.createSuccessResponse(
                            200,
                            resultCount + " item(s) found",
                            result
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }
    }

    @RequestMapping(value = "/findAll/paginated", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAllVegetablesWithPagination(VegetablesPage vegetablesPage) {
        Page<Vegetables> result = vegetablesService.findPaginatedVegetables(vegetablesPage);

        return ResponseEntity.status(200).body(
                createResponse.createSuccessResponse(
                        200,
                        "",
                        result
                )
        );
    }
}
