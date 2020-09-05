package com.example.retail.controllers.retailer.edibleproducts_retailer;

import com.example.retail.models.edibleproducts.EdibleProducts;
import com.example.retail.models.edibleproducts.services.EdibleProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/retailer/edibleProducts")
public class EdibleProductsRetailerController {

    @Autowired
    EdibleProductsService productsService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome!";
    }

    @GetMapping(value = "/allproducts")
    public Iterable<EdibleProducts> getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping("/productbyid/{productId}")
    public Optional<EdibleProducts> getProductById(@PathVariable Long productId){
        return productsService.getProductById(productId);
    }

    @RequestMapping(method=RequestMethod.POST, value = "/addproduct",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EdibleProducts addProduct(@RequestBody(required = true) AddEdibleProductsRequestBody newProduct) {
        return productsService.addEdibleProduct(newProduct);
    }

}
