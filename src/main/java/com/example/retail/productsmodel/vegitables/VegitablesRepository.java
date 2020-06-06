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
    @Query(value = "UPDATE Vegitables v set v.vegitable_Quantity=v.vegitable_Quantity + :increamentCount WHERE v.vegitable_TableId= :tableId")
    public Integer updateQty(@Param("tableId") Long tableId, @Param("increamentCount") Float increamentCount);
}
