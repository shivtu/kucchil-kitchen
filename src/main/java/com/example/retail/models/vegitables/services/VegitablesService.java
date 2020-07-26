package com.example.retail.models.vegitables.services;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import com.example.retail.models.vegitables.VegitableAdditionDetails;
import com.example.retail.models.vegitables.VegitableRecipes;
import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.VegitablesInventory;
import com.example.retail.models.vegitables.repository.VegitablesRepository;
import com.example.retail.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class VegitablesService {

    @Autowired
    private VegitablesRepository vegitablesRepository;

    @Autowired
    JWTDetails JWTDetails;

    @Autowired
    Utils utils;

    @Autowired
    ValidationResponse validationResponse;

    @Autowired
    Validations validations;

    @Autowired
    VegitableInventoryService vegitableInventoryService;

    @Autowired
    CreateResponse createResponse;

    public Iterable<Vegitables> getAllVegitables() {
        return vegitablesRepository.findAll();
    }

    public Optional<Vegitables> findById(Long id) {
        return vegitablesRepository.findById(id);
    }

    public Optional<Vegitables> getVegitableByTableId(Long vegitableTableId) {
        return vegitablesRepository.findById(vegitableTableId);
    }

    public Optional<Vegitables> findBySubId(String subId) { return vegitablesRepository.findBySubId(subId); }

    public Iterable<Vegitables> addAllVegitables(List<Vegitables> newVegitables) {
        return vegitablesRepository.saveAll(newVegitables);
    }

    public ResponseEntity<Object> addNewVegitable(HttpServletRequest request, AddVegitablesRequestBody newVegitables,
                                               ArrayList<MultipartFile> images) throws Exception {
        try {
            // Create a unique subID
            String vegSubId = newVegitables.getVegitableName()
                    +newVegitables.getVegitableVariant()
                    +newVegitables.getVegitablesInventoryFixedCost()
                    +newVegitables.getVegitablesInventoryCostPrice()
                    .toString().toLowerCase();

            // Validate vegitables
           ValidationResponse validationStatus = validations.validateNewVegitables(newVegitables, vegSubId);
            if (validationStatus.getStatusCode() != validations.validationSuccessCode) {
                return ResponseEntity.status(validationStatus.getStatusCode()).body(
                        validationStatus
                );
            }

            String vegitable_AddedBy = JWTDetails.userName(request);
            LocalDate vegitableInventoryExpiry = LocalDate.parse(newVegitables.getVegitablesInventoryExpiry());

            // create new vegitable
            Vegitables vegitables = new Vegitables();

            if (!images.isEmpty()) {
                OpsResponse res = utils.saveFiles(images, "vegitableImages");
                int errorCheck = res.getStatusCode();

                if(errorCheck != utils.opsSuccess){
                    return ResponseEntity.status(errorCheck).body(res);
                } else {
                    vegitables.setVegitableImagesLocation((ArrayList<String>) res.getStatusArray());
                }
            } else {
                ArrayList<String> placeholder = new ArrayList<>();
                // TODO : give correct path to image placeholder
                placeholder.add("src/main/resources/assets/veg-images/veg-image-placeholder.png");
                vegitables.setVegitableImagesLocation(placeholder);
            }

            vegitables.setVegitableName(newVegitables.getVegitableName());
            vegitables.setVegitableDescp(newVegitables.getVegitableDescp());
            vegitables.setVegitableVariant(newVegitables.getVegitableVariant());

            /** Create new List and add recepie to the List **/
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

            /** Create vegitable inventory **/
            VegitablesInventory vegitablesInventory = new VegitablesInventory();
            vegitablesInventory.setVegitablesInventoryCostPrice(newVegitables.getVegitablesInventoryCostPrice());
            vegitablesInventory.setVegitablesInventoryFixedCost(newVegitables.getVegitablesInventoryFixedCost());
            vegitablesInventory.setVegitableInventorySellingPrice(newVegitables.getVegitableSellingPrice());
            vegitablesInventory.setVegitablesInventoryExpiry(vegitableInventoryExpiry);
            vegitablesInventory.setVegitablesInventoryMaxDiscount(newVegitables.getVegitablesInventoryMaxDiscount());

            /** Create VegitableAdditionDetails **/
            VegitableAdditionDetails vegitableAdditionDetails = new VegitableAdditionDetails();
            vegitableAdditionDetails.setAddedBy(vegitable_AddedBy);
            vegitableAdditionDetails.setAddedDateTime(LocalDateTime.now());
            vegitableAdditionDetails.setIncreamentCount(newVegitables.getVegitableQuantity());

            List<VegitableAdditionDetails> vegitableDetailsList = new ArrayList<>();
            vegitableDetailsList.add(vegitableAdditionDetails);

            vegitablesInventory.setVegitablesInventoryAdditionDetails(vegitableDetailsList);
            vegitablesInventory.setVegitablesInventoryFixedCost(newVegitables.getVegitablesInventoryFixedCost());

            vegitablesInventory.setVegitableSubId(vegSubId);

            /** Persist the vegitable **/
            Vegitables createdVeg = vegitablesRepository.save(vegitables);
            /** Persist the vegitable inventory **/
            VegitablesInventory createdVegInventory = vegitableInventoryService.addNewInventory(vegitablesInventory);

            HashMap<String, Object> res = new HashMap<String, Object>();
            res.put("vegitable", createdVeg);
            res.put("VegitableInventory", createdVegInventory);

            ArrayList<Object> result = new ArrayList<>();
            result.add(res);

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    createResponse.createSuccessResponse(
                            201,
                            "Created",
                            result)
            );

        }catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(
                            400,
                            e.getMessage(),
                            "NA"
                    )
            );
        }
    }

    public Integer updateVegitableQty(Long tableId, Float increamentCount) {
        return vegitablesRepository.updateVegitableQty(tableId, increamentCount);
    }

    public int updateVegitableQtyAndSubID(Long tableId, Float increamentCount, String subId) {
        return vegitablesRepository.updateVegitableQtyAndSubId(tableId, increamentCount, subId);
    }
}
