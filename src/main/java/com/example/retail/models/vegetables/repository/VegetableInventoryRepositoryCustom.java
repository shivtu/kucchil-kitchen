package com.example.retail.models.vegetables.repository;
import com.example.retail.models.jsonmodels.InventoryAdditionDetails;

import java.util.List;

public interface VegetableInventoryRepositoryCustom {
    int updateVegetablesAdditionDetails(String subId, List<InventoryAdditionDetails> updatedAdditionDetails);
}
