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

    @RequestMapping(value = "/find/subid/{vegitableSubId}")
    public VegitablesInventory findBySubId(@PathVariable String vegitableSubId) {
        return vegitableInventoryService.findByvegitableSubId(vegitableSubId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addAllVegitables(HttpServletRequest request,
                                           @RequestBody AddVegitablesRequestBody newVegitables) {
                String vegitable_AddedBy = getUserName(request);
                try {

                    // create new vegitable
                    Vegitables vegitables = new Vegitables();
                    vegitables.setVegitableName(newVegitables.getVegitableName());
                    vegitables.setVegitableDescp(newVegitables.getVegitableDescp());
                    vegitables.setVegitableVariant(newVegitables.getVegitableVariant());

                    // Create new List and add recepie to the List
                    List vegitableRecepieList = new ArrayList();
                    vegitableRecepieList.add(newVegitables.getVegitableRecepie());

                    vegitables.setVegitableRecepie(vegitableRecepieList);
                    vegitables.setVegitableSellingPrice(newVegitables.getVegitableSellingPrice());
                    vegitables.setVegitableOfferedDiscount(newVegitables.getVegitableOfferedDiscount());
                    vegitables.setVegitableShowDiscount(newVegitables.getVegitableShowDiscount());
                    vegitables.setVegitableQuantity(newVegitables.getVegitableQuantity());
                    vegitables.setVegitableAvailable(newVegitables.isVegitableAvailable());
                    vegitables.setVegitableTax(newVegitables.getVegitableTax());
                    vegitables.setVegitableMeasureMentUnit(newVegitables.getVegitableMeasureMentUnit());
                    // Create a unique subID
                    vegitables.setVegitableSubId(newVegitables.getVegitableName() + newVegitables.getVegitableVariant()
                            + newVegitables.getVegitablesInventoryCostPrice() + newVegitables.getVegitablesInventoryExpiry()
                            + newVegitables.getVegitablesInventoryFixedCost());

                    // Create vegitable inventory
                    VegitablesInventory vegitablesInventory = new VegitablesInventory();
                    vegitablesInventory.setVegitablesInventoryCostPrice(newVegitables.getVegitablesInventoryCostPrice());
                    vegitablesInventory.setVegitablesInventoryExpiry(newVegitables.getVegitablesInventoryExpiry());
                    vegitablesInventory.setVegitablesInventoryMaxDiscount(newVegitables.getVegitablesInventoryMaxDiscount());

                    // Create VegitableAdditionDetails
                    VegitableAdditionDetails vegitableAdditionDetails = new VegitableAdditionDetails();
                    vegitableAdditionDetails.setAddedBy(vegitable_AddedBy);
                    vegitableAdditionDetails.setAddedDateTime(LocalDateTime.now());
                    vegitableAdditionDetails.setIncreamentCount(newVegitables.getVegitableQuantity());

                    List vegitableDetailsList = new ArrayList();
                    vegitableDetailsList.add(vegitableAdditionDetails);

                    vegitablesInventory.setVegitablesInventoryAdditionDetails(vegitableDetailsList);
                    vegitablesInventory.setVegitablesInventoryFixedCost(newVegitables.getVegitablesInventoryFixedCost());
                    // Create a unique subID
                    vegitablesInventory.setVegitableSubId(newVegitables.getVegitableName() + newVegitables.getVegitableVariant()
                            + newVegitables.getVegitablesInventoryCostPrice() + newVegitables.getVegitablesInventoryExpiry()
                            + newVegitables.getVegitablesInventoryFixedCost());

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
