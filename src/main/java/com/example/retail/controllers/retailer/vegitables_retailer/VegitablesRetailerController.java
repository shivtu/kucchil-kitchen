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
    ErrorResponse errorResponse;

    @Autowired
    Utils utils;

    @Autowired
    Validations validations;

    @Autowired
    OpsResponse opsResponse;

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
    public ResponseEntity addAllVegitables(HttpServletRequest request,
                                           @ModelAttribute AddVegitablesRequestBody newVegitables,
                                           @RequestParam("images") ArrayList<MultipartFile> files) {
                try {
                    // Validate vegitables
                    int validationStatus = validations.validateNewVegitables(newVegitables).getResponseCode();
                    if (validationStatus != 200) {
                        return new ResponseEntity(opsResponse, HttpStatus.valueOf(opsResponse.getResponseCode()));
                    }

                    String vegitable_AddedBy = JWTDetails.userName(request);
                    LocalDate vegitableInventoryExpiry = LocalDate.parse(newVegitables.getVegitablesInventoryExpiry());

                    // create new vegitable
                    Vegitables vegitables = new Vegitables();

                    // Create a unique subID
                    String vegSubId = newVegitables.getVegitableName() + newVegitables.getVegitableVariant()
                            + newVegitables.getVegitablesInventoryCostPrice().toString() + newVegitables.getVegitablesInventoryExpiry()
                            + newVegitables.getVegitablesInventoryFixedCost().toString();

                    if (!files.isEmpty()) {
                        // opsResponse = utils.saveFiles(files, "vegitableImages");
                        int errorCheck = utils.saveFiles(files, "vegitableImages").getResponseCode();
                        if(errorCheck != 200){
                            return new ResponseEntity(opsResponse, HttpStatus.valueOf(opsResponse.getResponseCode()));
                        } else {
                            vegitables.setVegitableImagesLocation(opsResponse.getOpsResponseArray());
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
                    ArrayList vegitableRecepieList = new ArrayList<>();
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
                    Vegitables createdVeg = vegitablesService.addOneVegitable(vegitables);
                    // Persist the vegitable inventory
                    VegitablesInventory createdVegInventory = vegitableInventoryService.addInventory(vegitablesInventory);

                    HashMap<String, Object> res = new HashMap<String, Object>();
                    res.put("Vegitables", createdVeg);
                    res.put("InventoryUpdate", createdVegInventory);

                    return new ResponseEntity<>(res, HttpStatus.CREATED);

                }catch (Exception e) {
                    return new ResponseEntity<java.io.Serializable>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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

            errorResponse.setErrorCode(500);
            errorResponse.setErrorMessage("Unable to add inventory");
            errorResponse.setAdditionalInfo("NA");
            ObjectMapper mapper = new ObjectMapper();
            String error = mapper.writeValueAsString(errorResponse);
            return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception ex){
            return new ResponseEntity<Object>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
