package com.example.retail.models.vegitables.repository;

import com.example.retail.models.vegitables.Vegitables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface VegitablesRepository extends JpaRepository<Vegitables, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Vegitables v set v.vegitableQuantity= v.vegitableQuantity+ :vegitableQuantity WHERE v.vegitableTableId= :tableId")
    public Integer updateVegitableQty(@Param("tableId") Long tableId, @Param("vegitableQuantity") Float vegitableQuantity);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Vegitables v set v.vegitableQuantity= v.vegitableQuantity+ :vegitableQuantity, v.vegitableSubId= :subId, v.vegitableSellingPrice= :newSellingPrice WHERE v.vegitableTableId= :tableId")
    public Integer updateVegitableAsPerInventory(@Param("tableId") Long tableId, @Param("vegitableQuantity") Float vegitableQuantity,
                                              @Param("subId") String subId, @Param("newSellingPrice") Float newSellingPrice);

    @Query(value = "SELECT * FROM vegitables WHERE vegitable_subid = :vegSubId", nativeQuery = true)
    public Optional<Vegitables> findBySubId(@Param("vegSubId") String vegSubId);
}
