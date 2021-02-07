package com.example.retail.models.vegetables.repository;

import com.example.retail.models.vegetables.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface VegetablesRepository extends JpaRepository<Vegetables, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Vegetables v set v.vegetableQuantity= v.vegetableQuantity+ :vegetableQuantity WHERE v.vegetableTableId= :tableId")
    public Integer updateVegetableQty(@Param("tableId") Long tableId, @Param("vegetableQuantity") Float vegetableQuantity);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Vegetables v set v.vegetableQuantity= v.vegetableQuantity+ :vegetableQuantity, v.vegetableSubId= :subId, v.vegetableSellingPrice= :newSellingPrice WHERE v.vegetableTableId= :tableId")
    public Integer updateVegetableAsPerInventory(@Param("tableId") Long tableId, @Param("vegetableQuantity") Float vegetableQuantity,
                                              @Param("subId") String subId, @Param("newSellingPrice") Float newSellingPrice);


    @Query(value = "SELECT * FROM vegetables WHERE vegetable_subid = :vegSubId", nativeQuery = true)
    public Optional<Vegetables> findBySubId(@Param("vegSubId") String vegSubId);

    @Query(value = "SELECT * FROM vegetables WHERE vegetable_available=true", nativeQuery = true)
    public List<Vegetables> findAllAvailableVegetables();

    @Query(value = "SELECT * FROM vegetables WHERE vegetable_available=false", nativeQuery = true)
    public List<Vegetables> findAllUnavailableVegetables();

    @Query(value = "SELECT * FROM vegetables WHERE item_classification= :itemClassification", nativeQuery = true)
    public List<Vegetables> findVegetablesByItemCategory(@Param("itemClassification") String itemClassification);
}
