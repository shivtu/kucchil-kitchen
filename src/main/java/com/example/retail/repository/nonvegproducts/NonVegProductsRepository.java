package com.example.retail.repository.nonvegproducts;

import com.example.retail.models.nonvegproducts.NonVegProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonVegProductsRepository extends JpaRepository<NonVegProducts, Long> {
}
