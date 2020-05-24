package com.example.retail.productsmodel.vegitables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VegitableInventoryService {
    @Autowired
    VegitableInventoryRepository vegitableInventoryRepository;

    public VegitablesInventory addInventory(VegitablesInventory vegitablesInventory) {
        return vegitableInventoryRepository.save(vegitablesInventory);
    }
}