package com.example.retail.productsmodel.vegitables;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.HashMap;

public interface VegitablesRepository extends JpaRepository<Vegitables, Long> {
    @Query(value = "UPDATE vegitables set vegitable_Quantity=? WHERE vegitable_tableid=?", nativeQuery = true)
    public Vegitables updateQty(HashMap requestBody);
}
