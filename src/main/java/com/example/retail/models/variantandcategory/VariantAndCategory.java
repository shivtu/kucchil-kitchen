package com.example.retail.models.variantandcategory;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Maintain a record of all variants for a given category and sub category
 * */
@Entity
@Table(name = "variant_and_category")
@TypeDefs({@TypeDef(name = "psql-jsonb", typeClass = JsonBinaryType.class)})
public class VariantAndCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_and_category_table_id")
    private Long variantAndCategoryTableId;

    @Column(name = "item_category")
    private String itemCategory;

    @Column(name = "item_sub_category", unique = true)
    private String itemSubCategory;

    @Column(name = "item_category_sub_id")
    private String itemCategorySubId;

    @Column(name = "variants", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<String> variantsList;

    public VariantAndCategory() {}

    public VariantAndCategory(Long variantAndCategoryTableId, String itemCategory, String itemSubCategory, String itemCategorySubId, List<String> variantsList) {
        this.variantAndCategoryTableId = variantAndCategoryTableId;
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

    public List<String> getVariantsList() {
        return variantsList;
    }

    public void setVariantsList(List<String> variantsList) {
        this.variantsList = variantsList;
    }
}
