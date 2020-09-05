package com.example.retail.models.edibleproducts.repository;

import com.example.retail.models.edibleproducts.EdibleProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdibleProductsRepository extends JpaRepository<EdibleProducts, Long> {
}
