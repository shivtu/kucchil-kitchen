package com.example.retail.models.vegitables.repository;
import com.example.retail.models.vegitables.VegitableAdditionDetails;

import java.util.List;

public interface VegitableInventoryRepositoryCustom {
    int updateVegitablesAdditionDetails(String subId, List<VegitableAdditionDetails> updatedAdditionDetails);
}
