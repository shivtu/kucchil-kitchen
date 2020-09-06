package com.example.retail.models.vegitables.repository;
import com.example.retail.models.jsonmodels.InventoryAdditionDetails;

import java.util.List;

public interface VegitableInventoryRepositoryCustom {
    int updateVegitablesAdditionDetails(String subId, List<InventoryAdditionDetails> updatedAdditionDetails);
}
