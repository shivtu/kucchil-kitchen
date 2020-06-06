package com.example.retail.productsmodel.vegitables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class VegitableInventoryService {
    @Autowired
    VegitableInventoryRepository vegitableInventoryRepository;

    public VegitablesInventory addInventory(VegitablesInventory vegitablesInventory) {
        return vegitableInventoryRepository.save(vegitablesInventory);
    }

//    public Integer updateVegitableQty(Long tableId, Float increamentCount){
//        return vegitableInventoryRepository.updateVegitableQty(tableId, increamentCount);
//    }

    public Optional<VegitablesInventory> findById(Long id) {
        return vegitableInventoryRepository.findById(id);
    }

    public VegitablesInventory findByvegitableSubId(String vegitableSubId) {
        return vegitableInventoryRepository.findByVegitableSubId(vegitableSubId);
    }
}
