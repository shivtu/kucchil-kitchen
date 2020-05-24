package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.productsmodel.vegitables.VegitableInventoryService;
import com.example.retail.productsmodel.vegitables.Vegitables;
import com.example.retail.productsmodel.vegitables.VegitablesInventory;
import com.example.retail.productsmodel.vegitables.VegitablesService;
import com.example.retail.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping(value = "/api/v1/retailer/vegitables")
public class VegitablesRetailerController {

    @Autowired
    VegitablesService vegitablesService;

    @Autowired
    VegitableInventoryService vegitableInventoryService;

    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public ResponseEntity getAllVegitables() {
        return new ResponseEntity(vegitablesService.getAllVegitables(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addAllVegitables(HttpServletRequest request,
                                           @RequestBody AddVegitablesRequestBody newVegitables) {

                // Get authorization header and find current user
                final String authorizationHeader = request.getHeader("Authorization");
                String jwt = authorizationHeader.substring(7);
                String vegitable_AddedBy = jwtUtil.extractUsername(jwt);
                try {

                    // create new vegitable
                    Vegitables vegitables = new Vegitables();
                    vegitables.setVegitable_Name(newVegitables.getVegitable_Name());
                    vegitables.setVegitable_Descp(newVegitables.getVegitable_Descp());
                    vegitables.setVegitable_Variant(newVegitables.getVegitable_Variant());
                    vegitables.setVegitable_Recepie(newVegitables.getVegitable_Recepie());
                    vegitables.setVegitable_SellingPrice(newVegitables.getVegitable_SellingPrice());
                    vegitables.setVegitable_OfferedDiscount(newVegitables.getVegitable_OfferedDiscount());
                    vegitables.setVegitable_ShowDiscount(newVegitables.getVegitable_ShowDiscount());
                    vegitables.setVegitable_Quantity(newVegitables.getVegitable_Quantity());
                    vegitables.setVegitable_Available(newVegitables.isVegitable_Available());
                    vegitables.setVegitable_Tax(newVegitables.getVegitable_Tax());
                    vegitables.setVegitable_MeasureMentUnit(newVegitables.getVegitable_MeasureMentUnit());
                    // Create a unique subID
                    vegitables.setVegitable_SubId(newVegitables.getVegitable_Name() + newVegitables.getVegitable_Variant()
                            + newVegitables.getVegitablesInventory_CostPrice() + newVegitables.getVegitablesInventory_Expiry()
                            + newVegitables.getVegitablesInventory_FixedCost());

                    // Create vegitable inventory
                    VegitablesInventory vegitablesInventory = new VegitablesInventory();
                    vegitablesInventory.setVegitablesInventory_CostPrice(newVegitables.getVegitablesInventory_CostPrice());
                    vegitablesInventory.setVegitablesInventory_Expiry(newVegitables.getVegitablesInventory_Expiry());
                    vegitablesInventory.setVegitablesInventory_MaxDiscount(newVegitables.getVegitablesInventory_MaxDiscount());
                    vegitablesInventory.setVegitablesInventory_AddedBy(vegitable_AddedBy);
                    vegitablesInventory.setVegitablesInventory_DateTimeAdded(LocalDateTime.now().toString());
                    vegitablesInventory.setVegitablesInventory_IncCount(newVegitables.getVegitable_Quantity()); // Increament quantity = the quantity when adding the product
                    vegitablesInventory.setVegitablesInventory_FixedCost(newVegitables.getVegitablesInventory_FixedCost());
                    // Create a unique subID
                    vegitablesInventory.setVegitable_SubId(newVegitables.getVegitable_Name() + newVegitables.getVegitable_Variant()
                            + newVegitables.getVegitablesInventory_CostPrice() + newVegitables.getVegitablesInventory_Expiry()
                            + newVegitables.getVegitablesInventory_FixedCost());

                    // Persist the vegitable
                    Vegitables createdVeg = vegitablesService.addOneVegitable(vegitables);
                    // Persist the vegitable inventory
                    VegitablesInventory createdVegInventory = vegitableInventoryService.addInventory(vegitablesInventory);

                    HashMap res = new HashMap();
                    res.put("Vegitables", createdVeg);
                    res.put("InventoryUpdate", createdVegInventory);

                    return new ResponseEntity(res, HttpStatus.CREATED);

                }catch (Exception e) {
                    return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
                }

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{vegitable_tableid}")
    public ResponseEntity updateQty(@PathVariable Long vegitable_tableid, @RequestBody HashMap requestBody){
        try{
            requestBody.put("vegitable_tableid", vegitable_tableid);
            vegitablesService.updateQty(requestBody);
           return new ResponseEntity(requestBody, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("fault", HttpStatus.BAD_REQUEST);
        }

    }
}
