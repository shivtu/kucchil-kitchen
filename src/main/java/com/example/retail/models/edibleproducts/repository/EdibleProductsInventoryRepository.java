package com.example.retail.models.edibleproducts.repository;

import com.example.retail.models.edibleproducts.EdibleProductsInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdibleProductsInventoryRepository extends JpaRepository<EdibleProductsInventory, Long> {
}
