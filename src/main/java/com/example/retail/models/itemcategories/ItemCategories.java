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
    private Integer itemCategoryTableId;

    @NotNull
    @NotEmpty
    @Column(name = "item_classification_code", unique = true,updatable = false)
    private String itemClassificationCode;

    @NotNull
    @NotEmpty
    @Column(name = "item_classification_name")
    private String itemClassificationName;

    @Column(name = "item_classification_info")
    private String itemClassificationInfo;

    @NotEmpty
    @NotNull
    @Column(name = "item_category_last_updated_by")
    private String itemCategoryLastUpdatedBy;

    @NotNull
    @Column(name = "item_category_last_updated_on")
    private LocalDateTime itemCategoryLastUpdatedOn;

    public ItemCategories() {}

    public ItemCategories(@NotNull @NotEmpty String itemClassificationCode, @NotNull @NotEmpty String itemClassificationName,
                          String itemClassificationInfo, @NotEmpty @NotNull String itemCategoryLastUpdatedBy,
                          @NotNull LocalDateTime itemCategoryLastUpdatedOn) {
        this.itemClassificationCode = itemClassificationCode;
        this.itemClassificationName = itemClassificationName;
        this.itemClassificationInfo = itemClassificationInfo;
        this.itemCategoryLastUpdatedBy = itemCategoryLastUpdatedBy;
        this.itemCategoryLastUpdatedOn = itemCategoryLastUpdatedOn;
    }

    public Integer getItemCategoryTableId() {
        return itemCategoryTableId;
    }

    public void setItemCategoryTableId(Integer itemCategoryTableId) {
        this.itemCategoryTableId = itemCategoryTableId;
    }

    public String getItemClassificationCode() {
        return itemClassificationCode;
    }

    public void setItemClassificationCode(String itemClassificationCode) {
        this.itemClassificationCode = itemClassificationCode;
    }

    public String getItemClassificationName() {
        return itemClassificationName;
    }

    public void setItemClassificationName(String itemClassificationName) {
        this.itemClassificationName = itemClassificationName;
    }

    public String getItemClassificationInfo() {
        return itemClassificationInfo;
    }

    public void setItemClassificationInfo(String itemClassificationInfo) {
        this.itemClassificationInfo = itemClassificationInfo;
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
