package com.example.retail.models.nonvegproducts.repository;

import com.example.retail.models.nonvegproducts.NonVegProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonVegProductsRepository extends JpaRepository<NonVegProducts, Long> {
}
