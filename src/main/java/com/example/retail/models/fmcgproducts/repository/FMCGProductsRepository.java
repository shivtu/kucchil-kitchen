package com.example.retail.models.fmcgproducts.repository;

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

//    @Transactional
//    @Modifying
    @Query(value = "UPDATE fmcg_products SET fmcg_product_quantity = fmcg_product_quantity + :fmcgProductQuantity WHERE fmcg_product_subid = :fmcgProductSubId returning *", nativeQuery = true)
    FMCGProducts increamentFMCGProductQty(@Param("fmcgProductQuantity") Float fmcgProductQuantity, @Param("fmcgProductSubId") String fmcgProductSubId);

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE FMCGProducts f SET f.fmcgProductQuantity = f.fmcgProductQuantity + :fmcgProductQuantity WHERE f.fmcgProductSubId = :fmcgProductSubId")
//    int increamentFMCGProductQty (@Param("fmcgProductQuantity") Float fmcgProductQuantity, @Param("fmcgProductSubId") String fmcgProductSubId);
}
