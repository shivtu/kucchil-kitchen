package com.example.retail.models.vegitables.services;

import com.example.retail.controllers.retailer.vegitables_retailer.UpdateVegitablesInventoryRequest;
import com.example.retail.models.vegitables.VegitableAdditionDetails;
import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.VegitablesInventory;
import com.example.retail.models.vegitables.repository.VegitableInventoryRepository;
import com.example.retail.models.vegitables.repository.VegitableInventoryRepositoryImpl;
import com.example.retail.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VegitableInventoryService {
    @Autowired
    VegitableInventoryRepository vegitableInventoryRepository;

    @Autowired
    VegitableInventoryRepositoryImpl vegitableInventoryRepositoryImpl;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    JWTDetails JWTDetails;

    @Autowired
    VegitablesService vegitablesService;

    @Autowired
    VegitableInventoryService vegitableInventoryService;

    @Autowired
    Validations validations;

    public VegitablesInventory addNewInventory(VegitablesInventory newVegitablesInventory) {
        return vegitableInventoryRepository.save(newVegitablesInventory);
    }

    public String findById(Long id) {
        return vegitableInventoryRepository.findById(id).toString();
    }

    public List<VegitablesInventory> findAll() {
        return vegitableInventoryRepository.findAll();
    }

    public Optional<VegitablesInventory> findVegitableInventoryBySubId (String subId) {
        return vegitableInventoryRepository.findVegitableInventoryBySubId(subId);
    }

    public ResponseEntity<Object> addInventory(Long tableId, UpdateVegitablesInventoryRequest updateVegitablesInventoryRequest,
                                                      HttpServletRequest request) {
        try {
            String addedBy = JWTDetails.userName(request);
            LocalDateTime dateTimeAdded = LocalDateTime.now();

            /** get the vegitable using tableId **/
            Optional<Vegitables> vegitables = vegitablesService.getVegitableByTableId(tableId);

            String vegSubId = (vegitables.get().getVegitableName()
                    +vegitables.get().getVegitableVariant()
                    +updateVegitablesInventoryRequest.getVegitableInventoryFixedCost()
                    +updateVegitablesInventoryRequest.getVegitableInventoryCostPrice()).toLowerCase();
            ValidationResponse validatedRes = validations.validateInventory(vegSubId, updateVegitablesInventoryRequest);
            if(validatedRes.getStatusCode() != 1) {
                return ResponseEntity.status(validatedRes.getStatusCode()).body(
                        createResponse.createErrorResponse(validatedRes.getStatusCode(),
                        validatedRes.getStatusMessage(),
                        validatedRes.getAdditionalInfo())
                );
            }

            /** update the quantity in vegitables table and set the new subId in the same table **/
            vegitablesService.updateVegitableAsPerInventory(tableId, updateVegitablesInventoryRequest.getVegitableQuantity(), vegSubId, updateVegitablesInventoryRequest.getVegitableSellingPrice());

            /** Create a vegitableInventory object to add new row in the vegitables_inventory table **/
            VegitablesInventory vegitablesInventory = new VegitablesInventory();

            /*
             * Set values for vegitable_inventory
             * New Cost price
             * New Fixed cost
             * New Selling Price
             * New Expiry
             * New Discounts
             */
            vegitablesInventory.setVegitableInventoryCostPrice(updateVegitablesInventoryRequest.getVegitableInventoryCostPrice());
            vegitablesInventory.setVegitableInventoryFixedCost(updateVegitablesInventoryRequest.getVegitableInventoryFixedCost());
            vegitablesInventory.setVegitableInventorySellingPrice(updateVegitablesInventoryRequest.getVegitableSellingPrice());
            vegitablesInventory.setVegitableInventoryExpiry(updateVegitablesInventoryRequest.getVegitableInventoryExpiry());
            vegitablesInventory.setVegitableSubId(vegSubId);

            /*
             * Create vegitable addition details
             * Added by
             * Added date time
             * Quantity added
             */
            VegitableAdditionDetails vegitableAdditionDetails = new VegitableAdditionDetails();
            vegitableAdditionDetails.setAddedBy(addedBy);
            vegitableAdditionDetails.setIncreamentCount(updateVegitablesInventoryRequest.getVegitableQuantity());
            vegitableAdditionDetails.setAddedDateTime(dateTimeAdded);

            /** Wrap additionDetails in list **/
            List<VegitableAdditionDetails> vegitableAdditionDetailsList = new ArrayList<>();
            vegitableAdditionDetailsList.add(vegitableAdditionDetails);

            /** add additionDetails to vegitables_inventory **/
            vegitablesInventory.setVegitableInventoryAdditionDetails(vegitableAdditionDetailsList);

            VegitablesInventory res = vegitableInventoryRepository.save(vegitablesInventory);

            List<Object> resArray = new ArrayList<>();
            resArray.add(res);

            return ResponseEntity.status(201).body(
                    createResponse.createSuccessResponse(201, "Created", resArray)
            );

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }

    }

    public List<Object> updateVegitableQty (Long tableId, Float quantity, HttpServletRequest request) {

        String addedBy = JWTDetails.userName(request);
        LocalDateTime dateTimeAdded = LocalDateTime.now();
        Optional<Vegitables> updatedVegitable = vegitablesService.findById(tableId);

        String vegSubId = updatedVegitable.get().getVegitableSubId().toLowerCase();

        /** Create the vegitable addition details object to update vegitable_inventory **/
        VegitableAdditionDetails vegitableAdditionDetails = new VegitableAdditionDetails();
        vegitableAdditionDetails.setAddedBy(addedBy);
        vegitableAdditionDetails.setAddedDateTime(dateTimeAdded);
        vegitableAdditionDetails.setIncreamentCount(quantity);

        List<VegitableAdditionDetails> vegitableAdditionDetailsList = new ArrayList<>();
        vegitableAdditionDetailsList.add(vegitableAdditionDetails);

        vegitableInventoryRepositoryImpl.updateVegitablesAdditionDetails(vegSubId, vegitableAdditionDetailsList);

        /** Return the response by fetching the vegitables and vegitablesInventory **/
        List<Object> finalRes = new ArrayList<>();
        finalRes.add(vegitablesService.findBySubIdVegitableWithInventory(vegSubId));

        return finalRes;
    }
}
