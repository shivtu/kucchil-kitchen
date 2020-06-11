package com.example.retail.productsmodel.vegitables;
import java.util.List;

public interface VegitableInventoryRepositoryCustom {
    int updateVegitablesAdditionDetails(String subId, List<VegitableAdditionDetails> updatedAdditionDetails);
}
