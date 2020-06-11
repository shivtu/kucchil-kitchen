package com.example.retail.productsmodel.vegitables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegitableInventoryService {
    @Autowired
    VegitableInventoryRepository vegitableInventoryRepository;

    public VegitablesInventory addInventory(VegitablesInventory vegitablesInventory) {
        return vegitableInventoryRepository.save(vegitablesInventory);
    }

    public int updateVegitablesAdditionDetails(String updatedAdditionDetails){
        return vegitableInventoryRepository.updateVegitablesAdditionDetails(updatedAdditionDetails);
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
}
