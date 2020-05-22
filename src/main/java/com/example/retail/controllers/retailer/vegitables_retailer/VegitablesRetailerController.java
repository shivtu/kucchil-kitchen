package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.productsmodel.inventory.ProductsInventoryServices;
import com.example.retail.productsmodel.vegitables.Vegitables;
import com.example.retail.productsmodel.vegitables.VegitablesService;
import com.example.retail.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping(value = "/api/v1/retailer/vegitables")
public class VegitablesRetailerController {

    @Autowired
    VegitablesService vegitablesService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    ProductsInventoryServices productsInventoryServices;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public Iterable<Vegitables> getAllVegitables() {
        return vegitablesService.getAllVegitables();
    }

    @RequestMapping(value = "/addmultiple", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addAllVegitables(HttpServletRequest request,
                                           @RequestBody ArrayList<Vegitables> newVegitables) {

                // Get authorization header and find current user
                final String authorizationHeader = request.getHeader("Authorization");
                String jwt = authorizationHeader.substring(7);
                String vegitable_AddedBy = jwtUtil.extractUsername(jwt);
                try {
                    return new ResponseEntity(vegitablesService.addAllVegitables(newVegitables), HttpStatus.CREATED);
                }catch (Exception e) {
                    return new ResponseEntity("Cannot process this request", HttpStatus.INTERNAL_SERVER_ERROR);
                }

    }

    @RequestMapping(value = "/addone")
    public Vegitables addOneVegitable(@RequestBody Vegitables newVegitable){
        return vegitablesService.addOneVegitable(newVegitable);
    }
}
