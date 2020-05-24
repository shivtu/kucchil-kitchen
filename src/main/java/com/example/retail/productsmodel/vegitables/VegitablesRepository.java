package com.example.retail.productsmodel.vegitables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;

public interface VegitablesRepository extends JpaRepository<Vegitables, Long> {
    @Query(value = "UPDATE vegitables veg SET veg.vegitable_quantity=? WHERE vegitable_tableid=?", nativeQuery = true)
    public Vegitables updateQty(HashMap requestBody);

    @Query(value = "select * from vegitables where vegitable_tableid=1", nativeQuery = true)
    public Iterable<Vegitables> findAllVegitables();
}
