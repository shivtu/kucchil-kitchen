package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.models.vegitables.*;
import com.example.retail.models.vegitables.services.VegitableInventoryService;
import com.example.retail.models.vegitables.services.VegitablesService;
import com.example.retail.util.ErrorResponse;
import com.example.retail.util.JWTDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    JWTDetails JWTDetails;

    @Autowired
    ErrorResponse errorResponse;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public ResponseEntity getAllVegitables() {
        List<VegitablesInventory> vi = vegitableInventoryService.findAllVegitableInventory();
        Iterable<Vegitables> v = vegitablesService.getAllVegitables();
        HashMap response = new HashMap<>();
        response.put("vegitable", v);
        response.put("vegitableInventory", vi);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<java.io.Serializable> addAllVegitables(HttpServletRequest request,
                                                                 @RequestBody AddVegitablesRequestBody newVegitables) {
                String vegitable_AddedBy = JWTDetails.userName(request);
                try {

                    // create new vegitable
                    Vegitables vegitables = new Vegitables();
                    vegitables.setVegitableName(newVegitables.getVegitableName());
                    vegitables.setVegitableDescp(newVegitables.getVegitableDescp());
                    vegitables.setVegitableVariant(newVegitables.getVegitableVariant());

                    // Create new List and add recepie to the List
                    List<VegitableRecipes> vegitableRecepieList = new ArrayList<VegitableRecipes>();
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
                            + newVegitables.getVegitablesInventoryCostPrice().toString() + newVegitables.getVegitablesInventoryExpiry().toString()
                            + newVegitables.getVegitablesInventoryFixedCost().toString());

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

                    List<VegitableAdditionDetails> vegitableDetailsList = new ArrayList<>();
                    vegitableDetailsList.add(vegitableAdditionDetails);

                    vegitablesInventory.setVegitablesInventoryAdditionDetails(vegitableDetailsList);
                    vegitablesInventory.setVegitablesInventoryFixedCost(newVegitables.getVegitablesInventoryFixedCost());
                    // Create a unique subID
                    vegitablesInventory.setVegitableSubId(newVegitables.getVegitableName() + newVegitables.getVegitableVariant()
                            + newVegitables.getVegitablesInventoryCostPrice().toString() + newVegitables.getVegitablesInventoryExpiry().toString()
                            + newVegitables.getVegitablesInventoryFixedCost().toString());

                    // Persist the vegitable
                    Vegitables createdVeg = vegitablesService.addOneVegitable(vegitables);
                    // Persist the vegitable inventory
                    VegitablesInventory createdVegInventory = vegitableInventoryService.addInventory(vegitablesInventory);

                    HashMap<String, Object> res = new HashMap<String, Object>();
                    res.put("Vegitables", createdVeg);
                    res.put("InventoryUpdate", createdVegInventory);

                    return new ResponseEntity<>(res, HttpStatus.CREATED);

                }catch (Exception e) {
                    return new ResponseEntity<java.io.Serializable>(e, HttpStatus.INTERNAL_SERVER_ERROR);
                }

    }

    @RequestMapping(value = "/update/{tableId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVegitableQty (@PathVariable Long tableId, @RequestBody AddVegitablesRequestBody requestBody,
                                              HttpServletRequest request){
        try {
            String addedBy = JWTDetails.userName(request);
            Float vegitableQuantity = requestBody.getVegitableQuantity();
            LocalDateTime dateTimeAdded = LocalDateTime.now();
            String subId = requestBody.getVegitableSubId();
            List<VegitableAdditionDetails> updatedAdditionDetails = new ArrayList<>();

            VegitableAdditionDetails newVegitableAdditionDetails = new VegitableAdditionDetails();
            newVegitableAdditionDetails.setIncreamentCount(vegitableQuantity);
            newVegitableAdditionDetails.setAddedDateTime(dateTimeAdded);
            newVegitableAdditionDetails.setAddedBy(addedBy);

            updatedAdditionDetails.add(newVegitableAdditionDetails);
            int resultVegInventory = vegitableInventoryService.updateVegitablesAdditionDetails(subId, updatedAdditionDetails);
            int resultVeg = vegitablesService.updateVegitablesQty(subId, vegitableQuantity);
            if(resultVegInventory == 1 && resultVeg == 1) {
                return new ResponseEntity(vegitablesService.findBySubId(subId), HttpStatus.CREATED);
            }

            errorResponse.setErrorCode(500);
            errorResponse.setErrorMessage("Unable to add inventory");
            errorResponse.setAdditionalInfo("NA");
            ObjectMapper mapper = new ObjectMapper();
            String error = mapper.writeValueAsString(errorResponse);
            return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception ex){
            return new ResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
