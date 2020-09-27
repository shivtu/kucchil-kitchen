package com.example.retail.models.nonvegproducts;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "non_veg_products")
public class NonVegProducts {

    @Column(name = "non_veg_products_table_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NonVegProductTableId;

    @NotNull
    @Column(name = "non_veg_product_name")
    private String nonVegProductName;

    @Column(name = "non_veg_product_alternate_name")
    private String getNonVegProductAlternateName;

    // with skin or without skin salt water or fresh water... etc
    @Column(name = "non_veg_product_variant")
    private String getNonVegProductVariant;

    @NotEmpty
    @NotNull
    @Column(name = "item_category")
    private String itemCategory;

    @NotEmpty
    @NotNull
    @Column(name = "item_sub_category")
    private String itemSubCategory;

    @Column(name = "non_veg_product_is_frozen")
    private Boolean isFrozen;

    @Column(name = "non_veg_product_is_tinned")
    private Boolean isTinned;

    // raw or processed
    @Column(name = "non_veg_product_type")
    private NonVegProductTypeEnum nonVegProductType;

    @Column(name = "non_veg_product_packaged_by")
    private String nonVegProductPackagedBy;

    @Column(name = "non_veg_product_expiry")
    private String nonVegProductExpiry;

    @Column(name = "non_veg_product_qty")
    private Float nonVegProductQty;

    @Column(name = "non_veg_product_cut_type")
    private String nonVegProductCutType;

    @Column(name = "non_veg_product_is_available")
    private Boolean isAvailable;

    public NonVegProducts() {}

    public NonVegProducts(@NotNull String nonVegProductName, String getNonVegProductAlternateName, String getNonVegProductVariant,
                          @NotEmpty @NotNull String itemCategory, @NotEmpty @NotNull String itemSubCategory, Boolean isFrozen,
                          Boolean isTinned, NonVegProductTypeEnum nonVegProductType, String nonVegProductPackagedBy, String nonVegProductExpiry,
                          Float nonVegProductQty, String nonVegProductCutType, Boolean isAvailable) {
        this.nonVegProductName = nonVegProductName;
        this.getNonVegProductAlternateName = getNonVegProductAlternateName;
        this.getNonVegProductVariant = getNonVegProductVariant;
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.isFrozen = isFrozen;
        this.isTinned = isTinned;
        this.nonVegProductType = nonVegProductType;
        this.nonVegProductPackagedBy = nonVegProductPackagedBy;
        this.nonVegProductExpiry = nonVegProductExpiry;
        this.nonVegProductQty = nonVegProductQty;
        this.nonVegProductCutType = nonVegProductCutType;
        this.isAvailable = isAvailable;
    }

    public Long getNonVegProductTableId() {
        return NonVegProductTableId;
    }

    public void setNonVegProductTableId(Long nonVegProductTableId) {
        NonVegProductTableId = nonVegProductTableId;
    }

    public String getNonVegProductName() {
        return nonVegProductName;
    }

    public void setNonVegProductName(String nonVegProductName) {
        this.nonVegProductName = nonVegProductName;
    }

    public String getGetNonVegProductAlternateName() {
        return getNonVegProductAlternateName;
    }

    public void setGetNonVegProductAlternateName(String getNonVegProductAlternateName) {
        this.getNonVegProductAlternateName = getNonVegProductAlternateName;
    }

    public String getGetNonVegProductVariant() {
        return getNonVegProductVariant;
    }

    public void setGetNonVegProductVariant(String getNonVegProductVariant) {
        this.getNonVegProductVariant = getNonVegProductVariant;
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

    public Boolean getFrozen() {
        return isFrozen;
    }

    public void setFrozen(Boolean frozen) {
        isFrozen = frozen;
    }

    public Boolean getTinned() {
        return isTinned;
    }

    public void setTinned(Boolean tinned) {
        isTinned = tinned;
    }

    public NonVegProductTypeEnum getNonVegProductType() {
        return nonVegProductType;
    }

    public void setNonVegProductType(NonVegProductTypeEnum nonVegProductType) {
        this.nonVegProductType = nonVegProductType;
    }

    public String getNonVegProductPackagedBy() {
        return nonVegProductPackagedBy;
    }

    public void setNonVegProductPackagedBy(String nonVegProductPackagedBy) {
        this.nonVegProductPackagedBy = nonVegProductPackagedBy;
    }

    public String getNonVegProductExpiry() {
        return nonVegProductExpiry;
    }

    public void setNonVegProductExpiry(String nonVegProductExpiry) {
        this.nonVegProductExpiry = nonVegProductExpiry;
    }

    public Float getNonVegProductQty() {
        return nonVegProductQty;
    }

    public void setNonVegProductQty(Float nonVegProductQty) {
        this.nonVegProductQty = nonVegProductQty;
    }

    public String getNonVegProductCutType() {
        return nonVegProductCutType;
    }

    public void setNonVegProductCutType(String nonVegProductCutType) {
        this.nonVegProductCutType = nonVegProductCutType;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
