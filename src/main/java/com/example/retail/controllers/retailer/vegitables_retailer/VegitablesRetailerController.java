//package com.example.retail.controllers.retailer.vegitables_retailer;
//
//import com.example.retail.productsmodel.inventory.ProductsInventory;
//import com.example.retail.productsmodel.inventory.ProductsInventoryServices;
//import com.example.retail.productsmodel.vegitables.Vegitables;
//import com.example.retail.productsmodel.vegitables.VegitablesService;
//import com.example.retail.util.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.*;
//
//@RestController
//@RequestMapping(value = "/api/v1/retailer/vegitables")
//public class VegitablesRetailerController {
//
//    @Autowired
//    VegitablesService vegitablesService;
//
//    @Autowired
//    JwtUtil jwtUtil;
//
//    @Autowired
//    ProductsInventoryServices productsInventoryServices;
//
//    @RequestMapping(value = "/findall", method = RequestMethod.GET)
//    public Iterable<Vegitables> getAllVegitables() {
//        return vegitablesService.getAllVegitables();
//    }
//
//    @RequestMapping(value = "/addmultiple", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Vegitables> addAllVegitables(HttpServletRequest request,
//                                              @RequestBody ArrayList<Vegitables> newVegitables) {
//        try {
//                // Get authorization header and find current user
//                final String authorizationHeader = request.getHeader("Authorization");
//                String jwt = authorizationHeader.substring(7);
//                String vegitable_AddedBy = jwtUtil.extractUsername(jwt);
//
//                ArrayList inventoryList = new ArrayList();
//
//                newVegitables.forEach(eachVeg->{
//                    // Create inventory object for "ProductsInventory"
////                    ProductsInventory inventory = new ProductsInventory();
////                    inventory.setProductsInventory_SubId(eachVeg.getVegitable_SubId());
////                    inventory.setProductsInventory_InventoryCount(eachVeg.getVegitable_Quantity());
////                    inventoryList.add(inventory);
//
//
//                    // Add date-time and "AdditionDetails" fields to request body
//                    eachVeg.setVegitable_AddedBy(vegitable_AddedBy);
//                    HashMap hm = new HashMap();
//                    hm.put("dateTimeAdded", new Date());
//                    hm.put("incCount", eachVeg.getVegitable_Quantity());
//
//                eachVeg.setVegitable_AdditionDetails(hm);
//            });
//            // Add inventory count to newly created products
//            List<ProductsInventory> productsInventories = productsInventoryServices.addAllInventory(inventoryList);
//
//            // If inventory gets added add new products - "Vegitables" to repository
//            if(productsInventories.size() > 0) {
//                productsInventories = null;
//                return vegitablesService.addAllVegitables(newVegitables);
//            } else {
//                productsInventories = null;
//                return new ArrayList<>();
//            }
//        } catch (Exception e) {
//            return new ArrayList<>();
//        }
//    }
//
//    @RequestMapping(value = "/addone")
//    public Vegitables addOneVegitable(@RequestBody Vegitables newVegitable){
//        return vegitablesService.addOneVegitable(newVegitable);
//    }
//}
