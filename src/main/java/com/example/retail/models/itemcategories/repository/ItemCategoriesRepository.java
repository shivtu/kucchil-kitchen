package com.example.retail.models.itemcategories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.retail.models.itemcategories.ItemCategories;

import java.util.Optional;

@Repository
public interface ItemCategoriesRepository extends JpaRepository<ItemCategories, Integer> {

    @Query(value = "SELECT * FROM item_categories WHERE item_classification_name= :itemClassificationName", nativeQuery = true)
    Optional<ItemCategories> findItemCategoryByClassification(@Param("itemClassificationName") String itemClassificationName);

    @Query(value = "SELECT * FROM item_categories WHERE item_category_sub_id= :itemCategorySubId", nativeQuery = true)
    Optional<ItemCategories> findByItemCategorySubId(@Param("itemCategorySubId") String itemCategorySubId);
}
