package com.example.retail.models.vegitables.services;

import com.example.retail.models.vegitables.VegitableAdditionDetails;
import com.example.retail.models.vegitables.VegitablesInventory;
import com.example.retail.models.vegitables.repository.VegitableInventoryRepository;
import com.example.retail.models.vegitables.repository.VegitableInventoryRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegitableInventoryService {
    @Autowired
    VegitableInventoryRepository vegitableInventoryRepository;

    @Autowired
    VegitableInventoryRepositoryImpl vegitableInventoryRepositoryImpl;

    public VegitablesInventory addInventory(VegitablesInventory vegitablesInventory) {
        return vegitableInventoryRepository.save(vegitablesInventory);
    }

    public String findById(Long id) {
        return vegitableInventoryRepository.findById(id).toString();
    }

    public List<VegitablesInventory> findAllVegitableInventory() {
        return vegitableInventoryRepository.findAll();
    }

    public VegitablesInventory getVegitableInventoryBySubId (String subId) {
        return vegitableInventoryRepository.getVegitableInventoryBySubId(subId);
    }

    public int updateVegitablesAdditionDetails (String subId, List<VegitableAdditionDetails> updatedAdditionDetails) {
        return vegitableInventoryRepositoryImpl.updateVegitablesAdditionDetails(subId, updatedAdditionDetails);
    }
}
