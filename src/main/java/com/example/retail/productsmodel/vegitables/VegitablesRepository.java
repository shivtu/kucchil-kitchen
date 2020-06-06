package com.example.retail.productsmodel.vegitables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

public interface VegitablesRepository extends JpaRepository<Vegitables, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Vegitables v set v.vegitableQuantity=v.vegitableQuantity + :increamentCount WHERE v.vegitableTableId= :tableId")
    public Integer updateQty(@Param("tableId") Long tableId, @Param("increamentCount") Float increamentCount);
}
