package com.example.retail.models.edibleproducts.repository;

import com.example.retail.models.edibleproducts.EdibleProductsInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EdibleProductsInventoryRepository extends JpaRepository<EdibleProductsInventory, Long> {

    @Query(value = "UPDATE edibleproduct_inventory SET edibleproductinventory_qtyadded = edibleproductinventory_qtyadded + :edibleProductInventoryQtyAdded, " +
            "edibleproductinventory_addedby = :edibleProductInventoryAddedBy, " +
            "edibleproductinventory_addedon = :edibleProductInventoryAddedOn WHERE edible_product_subid = :edibleProductSubId returning *", nativeQuery = true)
    EdibleProductsInventory increamentEdibleProductInventoryQuantity (@Param("edibleProductInventoryQtyAdded") Float quantity,
                                                                      @Param("edibleProductInventoryAddedBy") String addedBy,
                                                                      @Param("edibleProductSubId") String subId,
                                                                      @Param("edibleProductInventoryAddedOn")LocalDateTime addedOn);
}
