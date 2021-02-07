package com.example.retail.models.vegetables.services;

import com.example.retail.controllers.retailer.vegetables_retailer.UpdateVegetablesInventoryRequest;
import com.example.retail.models.jsonmodels.InventoryAdditionDetails;
import com.example.retail.models.vegetables.Vegetables;
import com.example.retail.models.vegetables.VegetablesInventory;
import com.example.retail.models.vegetables.repository.VegetableInventoryRepository;
import com.example.retail.models.vegetables.repository.VegetableInventoryRepositoryImpl;
import com.example.retail.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VegetableInventoryService {
    @Autowired
    VegetableInventoryRepository vegetableInventoryRepository;

    @Autowired
    VegetableInventoryRepositoryImpl vegetableInventoryRepositoryImpl;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    JWTDetails JWTDetails;

    @Autowired
    VegetablesService vegetablesService;

    @Autowired
    Validations validations;

    public VegetablesInventory addNewInventory(VegetablesInventory newVegetablesInventory) {
        return vegetableInventoryRepository.save(newVegetablesInventory);
    }

    public String findById(Long id) {
        return vegetableInventoryRepository.findById(id).toString();
    }

    public List<VegetablesInventory> findAll() {
        return vegetableInventoryRepository.findAll();
    }

    public Optional<VegetablesInventory> findVegetableInventoryBySubId (String subId) {
        return vegetableInventoryRepository.findVegetableInventoryBySubId(subId);
    }

    public ResponseEntity<Object> addInventory(Long tableId, UpdateVegetablesInventoryRequest updateVegetablesInventoryRequest,
                                                      HttpServletRequest request) {
        try {
            String addedBy = JWTDetails.userName(request);
            LocalDateTime dateTimeAdded = LocalDateTime.now();

            /** get the vegetable using tableId **/
            Optional<Vegetables> vegetables = vegetablesService.getVegetableByTableId(tableId);

            String vegSubId = (vegetables.get().getVegetableName()
                    +vegetables.get().getVegetableVariant()
                    + updateVegetablesInventoryRequest.getVegetableInventoryFixedCost()
                    + updateVegetablesInventoryRequest.getVegetableInventoryCostPrice()).toLowerCase();
            ValidationResponse validatedRes = validations.validateInventory(vegSubId, updateVegetablesInventoryRequest);
            if(validatedRes.getStatusCode() != 1) {
                return ResponseEntity.status(validatedRes.getStatusCode()).body(
                        createResponse.createErrorResponse(validatedRes.getStatusCode(),
                        validatedRes.getStatusMessage(),
                        validatedRes.getAdditionalInfo())
                );
            }

            /** update the quantity in vegetables table and set the new subId in the same table **/
            vegetablesService.updateVegetableAsPerInventory(tableId, updateVegetablesInventoryRequest.getVegetableQuantity(), vegSubId, updateVegetablesInventoryRequest.getVegetableSellingPrice());

            /** Create a vegetableInventory object to add new row in the vegetables_inventory table **/
            VegetablesInventory vegetablesInventory = new VegetablesInventory();

            /*
             * Set values for vegetable_inventory
             * New Cost price
             * New Fixed cost
             * New Selling Price
             * New Expiry
             * New Discounts
             */
            vegetablesInventory.setVegetableInventoryCostPrice(updateVegetablesInventoryRequest.getVegetableInventoryCostPrice());
            vegetablesInventory.setVegetableInventoryFixedCost(updateVegetablesInventoryRequest.getVegetableInventoryFixedCost());
            vegetablesInventory.setVegetableInventorySellingPrice(updateVegetablesInventoryRequest.getVegetableSellingPrice());
            vegetablesInventory.setVegetableInventoryExpiry(updateVegetablesInventoryRequest.getVegetableInventoryExpiry());
            vegetablesInventory.setVegetableSubId(vegSubId);

            /*
             * Create vegetable addition details
             * Added by
             * Added date time
             * Quantity added
             */
            InventoryAdditionDetails inventoryAdditionDetails = new InventoryAdditionDetails();
            inventoryAdditionDetails.setAddedBy(addedBy);
            inventoryAdditionDetails.setIncreamentCount(updateVegetablesInventoryRequest.getVegetableQuantity());
            inventoryAdditionDetails.setAddedDateTime(dateTimeAdded);

            /** Wrap additionDetails in list **/
            List<InventoryAdditionDetails> inventoryAdditionDetailsList = new ArrayList<>();
            inventoryAdditionDetailsList.add(inventoryAdditionDetails);

            /** add additionDetails to vegetables_inventory **/
            vegetablesInventory.setVegetableInventoryAdditionDetails(inventoryAdditionDetailsList);

            VegetablesInventory res = vegetableInventoryRepository.save(vegetablesInventory);

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

    public List<Object> updateVegetableQty (Long tableId, Float quantity, HttpServletRequest request) {

        String addedBy = JWTDetails.userName(request);
        LocalDateTime dateTimeAdded = LocalDateTime.now();
        Optional<Vegetables> updatedVegetable = vegetablesService.findById(tableId);

        String vegSubId = updatedVegetable.get().getVegetableSubId().toLowerCase();

        /** Create the vegetable addition details object to update vegetable_inventory **/
        InventoryAdditionDetails inventoryAdditionDetails = new InventoryAdditionDetails();
        inventoryAdditionDetails.setAddedBy(addedBy);
        inventoryAdditionDetails.setAddedDateTime(dateTimeAdded);
        inventoryAdditionDetails.setIncreamentCount(quantity);

        List<InventoryAdditionDetails> inventoryAdditionDetailsList = new ArrayList<>();
        inventoryAdditionDetailsList.add(inventoryAdditionDetails);

        /** update the vegetableinventory_additiondetails column in vegetables_inventory table
         to record who increented quanted and when **/
        vegetableInventoryRepositoryImpl.updateVegetablesAdditionDetails(vegSubId, inventoryAdditionDetailsList);

//        /** Return the response by fetching the vegetables and vegetablesInventory **/
//        List<Object> finalRes = new ArrayList<>();
//        finalRes.add(vegetablesService.findBySubIdVegetableWithInventory(vegSubId));

        return vegetablesService.findBySubIdVegetableWithInventory(vegSubId);
    }
}
