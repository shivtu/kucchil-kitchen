package com.example.retail.models.variantandcategory;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "variant_and_category")
public class VariantAndCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "variant_and_category_table_id")
    private Long variantAndCategoryTableId;

    private String itemCategory;

    @Column(name = "item_sub_category", unique = true)
    private String itemSubCategory;

    @Column(name = "item_category_sub_id")
    private String itemCategorySubId;

    @Column(name = "variants")
    @ElementCollection
    private Set<String> variantsList = new HashSet<>();

    public VariantAndCategory() {}

    public VariantAndCategory(String itemCategory, String itemSubCategory, String itemCategorySubId, Set<String> variantsList) {
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.itemCategorySubId = itemCategorySubId;
        this.variantsList = variantsList;
    }

    public Long getVariantAndCategoryTableId() {
        return variantAndCategoryTableId;
    }

    public void setVariantAndCategoryTableId(Long variantAndCategoryTableId) {
        this.variantAndCategoryTableId = variantAndCategoryTableId;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemSubCategory() {
        return itemSubCategory;
    }

    public void setItemSubCategory(String itemSubCategory) {
        this.itemSubCategory = itemSubCategory;
    }

    public String getItemCategorySubId() {
        return itemCategorySubId;
    }

    public void setItemCategorySubId(String itemCategorySubId) {
        this.itemCategorySubId = itemCategorySubId;
    }

    public Set<String> getVariantsList() {
        return variantsList;
    }

    public void setVariantsList(Set<String> variantsList) {
        this.variantsList = variantsList;
    }
}
