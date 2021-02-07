package com.example.retail.models.itemcategories;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_categories")
public class ItemCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_category_tableid")
    private Integer itemCategoryTableId;

    @NotNull
    @NotEmpty
    @Column(name = "item_category")
    private String itemCategory;

    @NotNull
    @NotEmpty
    @Column(name = "item_sub_category")
    private String itemSubCategory;

    @Column(name = "item_category_sub_id", unique = true)
    @NotNull
    @NotEmpty
    private String itemCategorySubId;

    @Column(name = "item_category_info")
    private String itemCategoryInfo;

    @NotEmpty
    @NotNull
    @Column(name = "item_category_last_updated_by")
    private String itemCategoryLastUpdatedBy;

    @NotNull
    @Column(name = "item_category_last_updated_on")
    private LocalDateTime itemCategoryLastUpdatedOn;

    public ItemCategories() {}

    public ItemCategories(@NotNull @NotEmpty String itemCategory, @NotNull @NotEmpty String itemSubCategory, @NotNull @NotEmpty String itemCategorySubId, String itemCategoryInfo, @NotEmpty @NotNull String itemCategoryLastUpdatedBy, @NotNull LocalDateTime itemCategoryLastUpdatedOn) {
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.itemCategorySubId = itemCategorySubId;
        this.itemCategoryInfo = itemCategoryInfo;
        this.itemCategoryLastUpdatedBy = itemCategoryLastUpdatedBy;
        this.itemCategoryLastUpdatedOn = itemCategoryLastUpdatedOn;
    }

    public Integer getItemCategoryTableId() {
        return itemCategoryTableId;
    }

    public void setItemCategoryTableId(Integer itemCategoryTableId) {
        this.itemCategoryTableId = itemCategoryTableId;
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

    public String getItemCategoryInfo() {
        return itemCategoryInfo;
    }

    public void setItemCategoryInfo(String itemCategoryInfo) {
        this.itemCategoryInfo = itemCategoryInfo;
    }

    public String getItemCategoryLastUpdatedBy() {
        return itemCategoryLastUpdatedBy;
    }

    public void setItemCategoryLastUpdatedBy(String itemCategoryLastUpdatedBy) {
        this.itemCategoryLastUpdatedBy = itemCategoryLastUpdatedBy;
    }

    public LocalDateTime getItemCategoryLastUpdatedOn() {
        return itemCategoryLastUpdatedOn;
    }

    public void setItemCategoryLastUpdatedOn(LocalDateTime itemCategoryLastUpdatedOn) {
        this.itemCategoryLastUpdatedOn = itemCategoryLastUpdatedOn;
    }
}
