package com.example.retail.models.vegitables.repository;

import com.example.retail.models.vegitables.VegitablesInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VegitableInventoryRepository extends JpaRepository<VegitablesInventory, Long>, VegitableInventoryRepositoryCustom {

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE VegitablesInventory vi  SET vi.vegitablesInventoryAdditionDetails = to_jsonb(:updatedAdditionDetails) WHERE vegitableSubId = :subId")
//    Integer updateVegitablesAdditionDetails(@Param("subId") String subId, @Param("updatedAdditionDetails") List<VegitableAdditionDetails> updatedAdditionDetails);

    @Transactional
    @Modifying
    @Query(value = "UPDATE vegitables_inventory  SET vegitablesinventory_addtion_details=to_jsonb(:updatedAdditionDetails)", nativeQuery = true)
    int updateVegitablesAdditionDetails(@Param("updatedAdditionDetails") String updatedAdditionDetails);

    @Query(value = "SELECT * FROM vegitables_inventory WHERE vegitable_subid= :subId", nativeQuery = true)
    VegitablesInventory getVegitableInventoryBySubId(@Param("subId") String subId);
}
