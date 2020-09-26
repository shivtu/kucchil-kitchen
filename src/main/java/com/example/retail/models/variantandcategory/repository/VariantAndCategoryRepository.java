package com.example.retail.models.variantandcategory.repository;

import com.example.retail.models.variantandcategory.VariantAndCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface VariantAndCategoryRepository extends JpaRepository<VariantAndCategory, Long> {

    @Query(value = "SELECT * FROM variant_and_category WHERE item_category_sub_id = :itemCategorySubId", nativeQuery = true)
    public Optional<VariantAndCategory> findBySubId(@Param("itemCategorySubId") String itemCategorySubId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE VariantAndCategory v set v.variantsList= :variantList WHERE v.itemCategorySubId= :itemCategorySubId")
    public Integer updateVariantList(@Param("variantList") List<String> variantList, @Param("itemCategorySubId") String itemCategorySubId);
}
