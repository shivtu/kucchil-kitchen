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
    @Query(value = "UPDATE Vegitables v set v.vegitableQuantity= v.vegitableQuantity+ :vegitableQuantity WHERE v.vegitableSubId= :subId")
    public Integer updateVegitablesQty(@Param("subId") String subId, @Param("vegitableQuantity") Float vegitableQuantity);

    @Query(value = "SELECT * FROM vegitables WHERE vegitable_subid = :subId", nativeQuery = true)
    public Optional<Vegitables> findBySubId(@Param("subId") String vegitable_subid);
}
