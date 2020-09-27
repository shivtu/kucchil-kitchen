package com.example.retail.models.variantandcategory.repository;

import com.example.retail.models.variantandcategory.VariantAndCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VariantAndCategoryRepository extends JpaRepository<VariantAndCategory, Long> {

    @Query(value = "SELECT * FROM variant_and_category WHERE item_category_sub_id = :itemCategorySubId", nativeQuery = true)
    public Optional<VariantAndCategory> findBySubId(@Param("itemCategorySubId") String itemCategorySubId);
}
