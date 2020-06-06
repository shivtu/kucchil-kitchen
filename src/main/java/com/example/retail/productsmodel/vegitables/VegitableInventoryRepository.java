package com.example.retail.productsmodel.vegitables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface VegitableInventoryRepository extends JpaRepository<VegitablesInventory, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE VegitablesInventory vi SET vi.vegitablesInventory_AdditionDetails = increamentCount WHERE vi.vegitableInventory_TableId=:tableId")
//    Integer updateVegitableQty(@Param("tableId") Long tableId, @Param("increamentCount") Float increamentCount);

    @Query(value = "SELECT vegitablesInventory_CostPrice FROM VegitablesInventory vi WHERE vi.vegitable_SubId= :subId")
    Optional<VegitablesInventory> getVegitableInventoryBySubId(@Param("subId") String vegitable_SubId);
}
