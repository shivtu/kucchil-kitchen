package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.productsmodel.vegitables.Vegitables;
import com.example.retail.productsmodel.vegitables.VegitablesInventory;
import com.example.retail.productsmodel.vegitables.VegitablesService;
import com.example.retail.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    JwtUtil jwtUtil;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public Iterable<Vegitables> getAllVegitables() {
        return vegitablesService.getAllVegitables();
    }

    @RequestMapping(value = "/addmultiple", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addAllVegitables(HttpServletRequest request,
                                           HttpEntity<AddVegitablesRequestBody> newVegitables) {

                // Get authorization header and find current user
                final String authorizationHeader = request.getHeader("Authorization");
                String jwt = authorizationHeader.substring(7);
                String vegitable_AddedBy = jwtUtil.extractUsername(jwt);
                try {

                    Vegitables vegitables = new Vegitables();
                    AddVegitablesRequestBody newVegitablesBody = newVegitables.getBody();

                    vegitables.setVegitable_productId(newVegitablesBody.getVegitable_Name()
                            + newVegitablesBody.getVegitable_variant()
                            + newVegitablesBody.getVegitableInventory_Expiry()
                            +newVegitablesBody.getVegitableInventory_AddedBy()
                            + newVegitablesBody.getVegitableInventory_CostPrice());

                    vegitables.setVegitable_Name(newVegitablesBody.getVegitable_Name());
                    vegitables.setVegitable_Descp(newVegitablesBody.getVegitable_Descp());
                    vegitables.setVegitable_variant(newVegitablesBody.getVegitable_variant());
                    vegitables.setVegitable_Recepie(newVegitablesBody.getVegitable_Recepie());
                    vegitables.setVegitable_SellingPrice(newVegitablesBody.getVegitable_SellingPrice());
                    vegitables.setVegitable_MaxDiscount(newVegitablesBody.getVegitable_MaxDiscount());
                    vegitables.setVegitable_OfferedDiscount(newVegitablesBody.getVegitable_OfferedDiscount());
                    vegitables.setVegitable_ShowDiscount(newVegitablesBody.getVegitable_ShowDiscount());
                    vegitables.setVegitable_Quantity(newVegitablesBody.getVegitable_Quantity());
                    vegitables.setVegitable_Tax(newVegitablesBody.getVegitable_Tax());
                    vegitables.setVegitable_MeasureMentUnit(newVegitablesBody.getVegitable_MeasureMentUnit());

                    VegitablesInventory vegitablesInventory = new VegitablesInventory();
                    vegitablesInventory.setVegitablesInventory_CostPrice(newVegitablesBody.getVegitableInventory_CostPrice());
                    vegitablesInventory.setVegitablesInventory_Expiry(newVegitablesBody.getVegitableInventory_Expiry());
                    vegitablesInventory.setVegitablesInventory_MaxDiscount(newVegitablesBody.getVegitableInventory_MaxDiscount());
                    vegitablesInventory.setVegitablesInventory_AddedBy(newVegitablesBody.getVegitableInventory_AddedBy());
                    vegitablesInventory.setVegitables_DateTimeAdded(LocalDateTime.now().toString());
                    vegitablesInventory.setVegitables_IncCount(newVegitablesBody.getVegitableInventory_IncCount());
                    vegitablesInventory.setVegitables_FixedCost(newVegitablesBody.getVegitableInventory_FixedCost());

                    List vegitableInventoryList = new ArrayList();
                    vegitableInventoryList.add(vegitablesInventory);

                    vegitables.setVegitablesInventoryList(vegitableInventoryList);

                    return new ResponseEntity(vegitablesService.addOneVegitable(vegitables), HttpStatus.CREATED);

                }catch (Exception e) {
                    return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
                }

    }

    @RequestMapping(value = "/addone")
    public Vegitables addOneVegitable(@RequestBody Vegitables newVegitable){
        return vegitablesService.addOneVegitable(newVegitable);
    }
}
