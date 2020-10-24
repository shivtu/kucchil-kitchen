package com.example.retail.models.edibleproducts.repository;

import com.example.retail.models.edibleproducts.EdibleProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EdibleProductsRepository extends JpaRepository<EdibleProducts, Long> {

    @Query(value = "SELECT * FROM edible_products WHERE edible_product_subid= :edibleProductSubId", nativeQuery = true)
    public Optional<EdibleProducts> findEdibleProductBySubId (@Param("edibleProductSubId") String edibleProductSubId);

    @Query(value = "UPDATE edible_products SET edible_product_quantity = edible_product_quantity + :edibleProductQuantity WHERE edible_product_subid = :edibleProductSubId returning *", nativeQuery = true)
    EdibleProducts increamentEdibleProductQty(@Param("edibleProductQuantity") Float fmcgProductQuantity, @Param("edibleProductSubId") String fmcgProductSubId);
}
