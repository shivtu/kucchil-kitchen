package com.example.retail.models.edibleproducts.services;

import com.example.retail.models.edibleproducts.EdibleProducts;
import com.example.retail.models.edibleproducts.repository.EdibleProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdibleProductsService {

    @Autowired
    EdibleProductsRepository productsRepository;

    public List<EdibleProducts> getAllProducts(){
        return  productsRepository.findAll();
    }

    public Optional<EdibleProducts> getProductById(Long productId) {
        return productsRepository.findById(productId);
    }

    public Iterable<EdibleProducts> addProducts(List<EdibleProducts> newProducts) {
        return productsRepository.saveAll(newProducts);
    }

    public EdibleProducts addProduct(EdibleProducts newProduct){
        return productsRepository.save(newProduct);
    }

}
