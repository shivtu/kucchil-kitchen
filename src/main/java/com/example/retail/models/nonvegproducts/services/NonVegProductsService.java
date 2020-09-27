package com.example.retail.models.nonvegproducts.services;

import com.example.retail.models.nonvegproducts.NonVegProducts;
import com.example.retail.models.nonvegproducts.repository.NonVegProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NonVegProductsService {

    @Autowired
    NonVegProductsRepository nonVegProductsRepository;

    public NonVegProducts save(NonVegProducts nonVegProducts) {
        return nonVegProductsRepository.save(nonVegProducts);
    }
}
