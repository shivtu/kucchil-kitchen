package com.example.retail.repository.fmcgproducts;

import com.example.retail.models.fmcgproducts.FMCGProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface FMCGProductsRepository extends JpaRepository<FMCGProducts, Long> {

    @Query(value = "UPDATE fmcg_products SET fmcg_product_quantity = fmcg_product_quantity + :fmcgProductQuantity WHERE fmcg_product_subid = :fmcgProductSubId returning *", nativeQuery = true)
    FMCGProducts increamentFMCGProductQty(@Param("fmcgProductQuantity") Float fmcgProductQuantity, @Param("fmcgProductSubId") String fmcgProductSubId);

    @Query(value = "SELECT * FROM fmcg_products WHERE fmcg_product_subid = :fmcgProductSubId", nativeQuery = true)
    Optional<FMCGProducts> findOneBySubId(@Param("fmcgProductSubId") String subId);
}
