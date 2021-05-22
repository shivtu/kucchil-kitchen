package com.example.retail.repository.vegetables;

import com.example.retail.models.vegetables.VegetablesInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VegetableInventoryRepository extends JpaRepository<VegetablesInventory, Long>, VegetableInventoryRepositoryCustom {

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE VegetablesInventory vi  SET vi.vegetablesInventoryAdditionDetails = to_jsonb(:updatedAdditionDetails) WHERE vegetableSubId = :subId")
//    Integer updateVegetablesAdditionDetails(@Param("subId") String subId, @Param("updatedAdditionDetails") List<VegetableAdditionDetails> updatedAdditionDetails);

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE vegetables_inventory  SET vegetablesinventory_addtion_details=to_jsonb(:updatedAdditionDetails)", nativeQuery = true)
//    int updateVegetablesAdditionDetails(@Param("updatedAdditionDetails") String updatedAdditionDetails);

    @Query(value = "SELECT * FROM vegetables_inventory WHERE vegetable_subid= :subId", nativeQuery = true)
    Optional<VegetablesInventory> findVegetableInventoryBySubId(@Param("subId") String subId);
}
