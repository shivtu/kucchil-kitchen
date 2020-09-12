package com.example.retail.models.fmcgproducts.repository;

import com.example.retail.models.fmcgproducts.FMCGProductsInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FMCGProductsInventoryRepository extends JpaRepository<FMCGProductsInventory, Long> {
}
