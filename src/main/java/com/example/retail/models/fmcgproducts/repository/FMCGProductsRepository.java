package com.example.retail.models.fmcgproducts.repository;

import com.example.retail.models.fmcgproducts.FMCGProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FMCGProductsRepository extends JpaRepository<FMCGProducts, Long> {
}
