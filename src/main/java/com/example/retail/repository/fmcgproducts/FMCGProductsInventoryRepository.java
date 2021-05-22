package com.example.retail.repository.fmcgproducts;

import com.example.retail.models.fmcgproducts.FMCGProductsInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface FMCGProductsInventoryRepository extends JpaRepository<FMCGProductsInventory, Long> {

    @Query(value = "UPDATE fmcgproduct_inventory SET fmcgproductinventory_addedqty = fmcgproductinventory_addedqty + :fmcgProductInventoryAddedQty, fmcgproductinventory_addedby = :fmcgProductInventoryAddedBy, fmcgproductinventory_addedon = :fmcgProductInventoryAddedOn WHERE fmcg_product_subid = :fmcgProductSubId returning *", nativeQuery = true)
    FMCGProductsInventory increamentFMCGProductsInventoryQty (@Param("fmcgProductInventoryAddedQty") Float fmcgProductInventoryAddedQty, @Param("fmcgProductInventoryAddedBy") String fmcgProductInventoryAddedBy, @Param("fmcgProductInventoryAddedOn") LocalDateTime fmcgProductInventoryAddedOn, @Param("fmcgProductSubId") String fmcgProductSubId);

    @Query(value = "SELECT * FROM fmcgproduct_inventory WHERE WHERE fmcg_product_subid = :fmcgProductSubId LIMIT 1", nativeQuery = true)
    FMCGProductsInventory findOneBySubId (@Param("fmcgProductSubId") String fmcgProductSubId);
}
