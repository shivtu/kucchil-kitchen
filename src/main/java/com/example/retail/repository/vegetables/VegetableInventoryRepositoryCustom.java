package com.example.retail.repository.vegetables;
import com.example.retail.models.jsonmodels.InventoryAdditionDetails;

import java.util.List;

public interface VegetableInventoryRepositoryCustom {
    int updateVegetablesAdditionDetails(String subId, List<InventoryAdditionDetails> updatedAdditionDetails);
}
