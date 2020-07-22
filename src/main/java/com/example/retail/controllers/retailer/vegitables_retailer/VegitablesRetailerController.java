package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.models.vegitables.*;
import com.example.retail.models.vegitables.services.VegitableInventoryService;
import com.example.retail.models.vegitables.services.VegitablesService;
import com.example.retail.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
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
    Utils utils;

    @Autowired
    Validations validations;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public ResponseEntity<HashMap<Object, Object>> getAllVegitables() {
        List<VegitablesInventory> vi = vegitableInventoryService.findAllVegitableInventory();
        Iterable<Vegitables> v = vegitablesService.getAllVegitables();
        HashMap<Object, Object> response = new HashMap<>();
        response.put("vegitable", v);
        response.put("vegitableInventory", vi);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object>addVegitable(HttpServletRequest request,
                                           @ModelAttribute AddVegitablesRequestBody newVegitables,
                                           @RequestParam("images") ArrayList<MultipartFile> files) {
                try {
                    // Validate vegitables
                    ResponseEntity<Object> validationStatus = validations.validateNewVegitables(newVegitables);
                    if (validationStatus.getStatusCodeValue() != 1) {
                       return validationStatus;
                    }

                    String vegitable_AddedBy = JWTDetails.userName(request);
                    LocalDate vegitableInventoryExpiry = LocalDate.parse(newVegitables.getVegitablesInventoryExpiry());

                    // create new vegitable
                    Vegitables vegitables = new Vegitables();

                    // Create a unique subID
                    String vegSubId = newVegitables.getVegitableName()+newVegitables.getVegitableVariant()+
                            newVegitables.getVegitablesInventoryExpiry()+newVegitables.getVegitablesInventoryFixedCost().toString();

                    if (!files.isEmpty()) {
                         ResponseEntity<Object> res = utils.saveFiles(files, "vegitableImages");
                        int errorCheck = res.getStatusCodeValue();
                        if(errorCheck != 1){
                            return res;
                        } else {
                            vegitables.setVegitableImagesLocation((ArrayList<String>) res.getBody());
                        }
                    } else {
                        ArrayList<String> placeholder = new ArrayList<String>();
                        // TODO : give correct path to image placeholder
                        placeholder.add("src/main/resources/assets/veg-images/veg-image-placeholder.png");
                        vegitables.setVegitableImagesLocation(placeholder);
                    }

                    vegitables.setVegitableName(newVegitables.getVegitableName());
                    vegitables.setVegitableDescp(newVegitables.getVegitableDescp());
                    vegitables.setVegitableVariant(newVegitables.getVegitableVariant());

                    // Create new List and add recepie to the List
                    ArrayList<VegitableRecipes> vegitableRecepieList = new ArrayList<>();
                    vegitableRecepieList.add(newVegitables.getVegitableRecepie());

                    vegitables.setVegitableRecepie(vegitableRecepieList);
                    vegitables.setVegitableSellingPrice(newVegitables.getVegitableSellingPrice());
                    vegitables.setVegitableOfferedDiscount(newVegitables.getVegitableOfferedDiscount());
                    vegitables.setVegitableShowDiscount(newVegitables.getVegitableShowDiscount());
                    vegitables.setVegitableQuantity(newVegitables.getVegitableQuantity());
                    vegitables.setVegitableAvailable(newVegitables.isVegitableAvailable());
                    vegitables.setVegitableMeasureMentUnit(newVegitables.getVegitableMeasureMentUnit());

                    vegitables.setVegitableSubId(vegSubId);

                    // Create vegitable inventory
                    VegitablesInventory vegitablesInventory = new VegitablesInventory();
                    vegitablesInventory.setVegitablesInventoryCostPrice(newVegitables.getVegitablesInventoryCostPrice());
                    vegitablesInventory.setVegitablesInventoryExpiry(vegitableInventoryExpiry);
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

                    vegitablesInventory.setVegitableSubId(vegSubId);

                    // Persist the vegitable
                    Vegitables createdVeg = vegitablesService.addVegitable(vegitables);
                    // Persist the vegitable inventory
                    VegitablesInventory createdVegInventory = vegitableInventoryService.addInventory(vegitablesInventory);

                    HashMap<String, Object> res = new HashMap<String, Object>();
                    res.put("vegitable", createdVeg);
                    res.put("VegitableInventory", createdVegInventory);

                    ArrayList<Object> result = new ArrayList<>();
                    result.add(res);

                    return ResponseEntity.status(HttpStatus.CREATED).body(
                            utils.createSuccessResponse(
                                    201,
                                    "Created",
                                    result)
                    );

                }catch (Exception e) {
                    return ResponseEntity.status(500).body(
                            utils.createErrorResponse(
                                    400,
                                    e.getMessage(),
                                    "NA"
                            )
                    );
                }
    }

    @RequestMapping(value = "/update/{tableId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateVegitableQty (@PathVariable Long tableId, @RequestBody AddVegitablesRequestBody requestBody,
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
                return new ResponseEntity<Object>(vegitablesService.findBySubId(subId), HttpStatus.CREATED);
            }
            return new ResponseEntity<Object>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception ex){
            return new ResponseEntity<Object>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
