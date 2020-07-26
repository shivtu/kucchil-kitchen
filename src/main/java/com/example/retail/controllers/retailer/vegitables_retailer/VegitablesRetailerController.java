package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.models.vegitables.*;
import com.example.retail.models.vegitables.services.VegitableInventoryService;
import com.example.retail.models.vegitables.services.VegitablesService;
import com.example.retail.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping(value = "/api/v1/retailer/vegitables")
public class VegitablesRetailerController {

    @Autowired
    VegitablesService vegitablesService;

    @Autowired
    VegitableInventoryService vegitableInventoryService;

    @Autowired
    CreateResponse createResponse;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public ResponseEntity<HashMap<Object, Object>> getAllVegitables() {
        List<VegitablesInventory> vi = vegitableInventoryService.findAllVegitableInventory();
        Iterable<Vegitables> v = vegitablesService.getAllVegitables();
        HashMap<Object, Object> response = new HashMap<>();
        response.put("vegitable", v);
        response.put("vegitableInventory", vi);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /** User adds a new item that is not available yet
     The business logic goes as follows
     1. The user introduces a new vegitabble
     2. We create a new row entry in the DB for vegitables table
     3. Additionally we also create a corrosponding entry in the inventory table for the newly created product
     **/
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Object addNewVegitable(HttpServletRequest request,
                                           @ModelAttribute AddVegitablesRequestBody newVegitables,
                                           @RequestParam("images") ArrayList<MultipartFile> images) throws Exception {
        return vegitablesService.addNewVegitable(request, newVegitables, images);
    }


    /* User updates the quantity only for an existing item */
    @RequestMapping(value = "/update/{tableId}/increamentQuantity/{quantity}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateVegitableQty (@PathVariable Long tableId, @PathVariable Float quantity,
                                                      HttpServletRequest request){
        /** Increament quantity of vegitables **/
        if(vegitablesService.updateVegitableQty(tableId, quantity) == 1){;
            /** Update the vegitable_addition_details in vegitable_inventory **/
            return vegitableInventoryService.updateVegitableQty(tableId, quantity, request);
        } else {
            return ResponseEntity.status(400).body(
                    createResponse.createErrorResponse(400, "Vegitable not found",
                            "This item does not exist")
            );
        }
    }


    /** The user will update the inventory only for a vegitable that already exists
     Here we create a new inventory row in the DB for an existing vegitable
     The business logic as follows
     1. Vegitable has already been created
     2. The retailer buys more stock at new cost
     3. We add the quantity provided by the user to the existing quantity in vegitable table
     4. We make new row entry in the DB for the inventory with new cost price, selling price and discount
     5. We add the new subID to vegitables table (this acts as a pointer)
     **/
    @RequestMapping(value = "/add/newInventory/{tableId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  addInventory(@PathVariable Long tableId,
                                                   @RequestBody UpdateVegitablesInventoryRequest updateVegitablesInventoryRequest,
                                                   HttpServletRequest request) {
        return vegitableInventoryService.addInventory(tableId, updateVegitablesInventoryRequest, request);
    }
}
