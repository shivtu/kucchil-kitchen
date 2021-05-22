package com.example.retail.services.nonvegproducts;

import com.example.retail.models.nonvegproducts.NonVegProducts;
import com.example.retail.repository.nonvegproducts.NonVegProductsRepository;
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
