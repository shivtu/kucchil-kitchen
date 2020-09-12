package com.example.retail.models.fmcgproducts.services;

import com.example.retail.models.fmcgproducts.FMCGProductsInventory;
import com.example.retail.models.fmcgproducts.repository.FMCGProductsInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FMCGProductsInventoryServices {

    @Autowired
    FMCGProductsInventoryRepository fmcgProductsInventoryRepository;

    public FMCGProductsInventory save (FMCGProductsInventory fmcgProductsInventory) {
        return fmcgProductsInventoryRepository.save(fmcgProductsInventory);
    }
}
