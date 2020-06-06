package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.productsmodel.vegitables.*;
import com.example.retail.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
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

    @Autowired
    EntityManagerFactory emf;

    private String getUserName(HttpServletRequest request) {
        // Get authorization header and find current user
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = authorizationHeader.substring(7);
        String requestingUser = jwtUtil.extractUsername(jwt);
        return requestingUser;
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public ResponseEntity getAllVegitables() {
        return new ResponseEntity(vegitablesService.getAllVegitables(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addAllVegitables(HttpServletRequest request,
                                           @RequestBody AddVegitablesRequestBody newVegitables) {
                String vegitable_AddedBy = getUserName(request);
                try {

                    // create new vegitable
                    Vegitables vegitables = new Vegitables();
                    vegitables.setVegitable_Name(newVegitables.getVegitable_Name());
                    vegitables.setVegitable_Descp(newVegitables.getVegitable_Descp());
                    vegitables.setVegitable_Variant(newVegitables.getVegitable_Variant());
                    List vegitableRecepieList = new ArrayList();
                    vegitableRecepieList.add(newVegitables.getVegitable_Recepie());
                    vegitables.setVegitable_Recepie(vegitableRecepieList);
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

                    // Create VegitableAdditionDetails
                    VegitableAdditionDetails vegitableAdditionDetails = new VegitableAdditionDetails();
                    vegitableAdditionDetails.setAddedBy(vegitable_AddedBy);
                    vegitableAdditionDetails.setAddedDateTime(LocalDateTime.now());
                    vegitableAdditionDetails.setIncreamentCount(newVegitables.getVegitable_Quantity());

                    List vegitableDetailsList = new ArrayList();
                    vegitableDetailsList.add(vegitableAdditionDetails);

                    vegitablesInventory.setVegitablesInventory_AdditionDetails(vegitableDetailsList);
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

    @RequestMapping(value = "/update/{tableId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVegitableQty (@PathVariable Long tableId, @RequestBody AddVegitablesRequestBody requestBody,
                                              HttpServletRequest request){
        try {
//            String addedBy = getUserName(request);
//            Float increamentCount = requestBody.getVegitable_Quantity();
//            LocalDateTime dateTimeAdded = LocalDateTime.now();
//            String subId = requestBody.getVegitable_SubId();
//
//            vegitableInventoryService.getVegitableInventoryBySubId(subId);
//            if(vegitablesService.updateQty(tableId, increamentCount).equals(1)
//                    && vegitableInventoryService.updateVegitableQty(tableId, increamentCount).equals(1)) {
//                return new ResponseEntity("Created", HttpStatus.CREATED);
//            } else {
//                return new ResponseEntity("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
//            }
            return new ResponseEntity("ok", HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
