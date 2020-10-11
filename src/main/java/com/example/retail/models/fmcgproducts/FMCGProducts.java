package com.example.retail.models.fmcgproducts;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fmcg_products")
public class FMCGProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fmcg_product_tableid")
    private Long fmcgProductTableId;

    @NotNull
    @Column(name = "fmcg_product_manufacturer")
    private String fmcgProductManufacturer;

    @NotNull
    @Column(name = "fmcg_product_name")
    private String fmcgProductName;

    @Column(name = "fmcg_product_variant")
    private String fmcgProductVariant;

    @NotNull
    @Column(name = "fmcg_product_description")
    private String fmcgProductDescription;

    @NotNull
    @Column(name = "fmcg_product_generic_name")
    private String fmcgProductGenericName;

    @Column(name = "fmcg_product_alternate_name")
    private String fmcgProductAlternateName;

    // Product category : Example - confectionary, dairy, spices etc
    @NotEmpty
    @NotNull
    @Column(name = "item_category")
    private String itemCategory;

    @NotEmpty
    @NotNull
    @Column(name = "item_sub_category")
    private String itemSubCategory;

    @NotNull
    @Column(name = "fmcg_product_available")
    private Boolean fmcgProductAvailable;

    // This price is exclusive of applicable taxes
    @Column(name = "fmcg_product_selling_price")
    private Float fmcgProductSellingPrice;

    // Discount percentage
    @Column(name = "fmcg_product_offered_discount")
    private Float fmcgProductOfferedDiscount;

    @Column(name = "fmcg_product_discount_name")
    private String fmcgProductDiscountName;

    @Column(name = "fmcg_product_discounted_price")
    private Float fmcgProductDiscountedPrice;

    @NotNull
    @Column(name = "fmcg_product_applicable_taxes")
    @ElementCollection
    private List<String> fmcgProductApplicableTaxes = new ArrayList<>();

    @NotNull
    @Column(name = "fmcg_product_taxed_price")
    private Float fmcgProductTaxedPrice;

    @NotNull
    @Column(name = "fmcg_product_quantity")
    private Float fmcgProductQuantity;

    @NotNull
    @Column(name = "fmcg_product_measurement_unit")
    private Float fmcgProductMeasurementUnit;

    @NotNull
    @Column(name = "fmcg_product_denomination")
    private Float fmcgProductDenomination;

    /**
     * fmcgProductManufacturer + fmcgProductName + fmcgProductVariant + fmcgProductDenomination + fmcgProductInventoryCostPrice + fmcgProductInventoryFixedCost
     */
    @NotNull
    @Column(name = "fmcg_product_subid")
    private String fmcgProductSubId;

    @Column(name = "fmcg_product_image_location")
    @ElementCollection
    private List<String> FMCGProductImages = new ArrayList<>();


    public FMCGProducts() {}

    public FMCGProducts(@NotNull String fmcgProductManufacturer, @NotNull String fmcgProductName, String fmcgProductVariant, @NotNull String fmcgProductDescription, @NotNull String fmcgProductGenericName, String fmcgProductAlternateName, @NotEmpty @NotNull String itemCategory, @NotEmpty @NotNull String itemSubCategory, @NotNull Boolean fmcgProductAvailable, Float fmcgProductSellingPrice, Float fmcgProductOfferedDiscount, String fmcgProductDiscountName, Float fmcgProductDiscountedPrice, @NotNull List<String> fmcgProductApplicableTaxes, @NotNull Float fmcgProductTaxedPrice, @NotNull Float fmcgProductQuantity, @NotNull Float fmcgProductMeasurementUnit, @NotNull Float fmcgProductDenomination, @NotNull String fmcgProductSubId, List<String> FMCGProductImages) {
        this.fmcgProductManufacturer = fmcgProductManufacturer;
        this.fmcgProductName = fmcgProductName;
        this.fmcgProductVariant = fmcgProductVariant;
        this.fmcgProductDescription = fmcgProductDescription;
        this.fmcgProductGenericName = fmcgProductGenericName;
        this.fmcgProductAlternateName = fmcgProductAlternateName;
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.fmcgProductAvailable = fmcgProductAvailable;
        this.fmcgProductSellingPrice = fmcgProductSellingPrice;
        this.fmcgProductOfferedDiscount = fmcgProductOfferedDiscount;
        this.fmcgProductDiscountName = fmcgProductDiscountName;
        this.fmcgProductDiscountedPrice = fmcgProductDiscountedPrice;
        this.fmcgProductApplicableTaxes = fmcgProductApplicableTaxes;
        this.fmcgProductTaxedPrice = fmcgProductTaxedPrice;
        this.fmcgProductQuantity = fmcgProductQuantity;
        this.fmcgProductMeasurementUnit = fmcgProductMeasurementUnit;
        this.fmcgProductDenomination = fmcgProductDenomination;
        this.fmcgProductSubId = fmcgProductSubId;
        this.FMCGProductImages = FMCGProductImages;
    }

    public Long getFmcgProductTableId() {
        return fmcgProductTableId;
    }

    public void setFmcgProductTableId(Long fmcgProductTableId) {
        this.fmcgProductTableId = fmcgProductTableId;
    }

    public String getFmcgProductManufacturer() {
        return fmcgProductManufacturer;
    }

    public void setFmcgProductManufacturer(String fmcgProductManufacturer) {
        this.fmcgProductManufacturer = fmcgProductManufacturer;
    }

    public String getFmcgProductName() {
        return fmcgProductName;
    }

    public void setFmcgProductName(String fmcgProductName) {
        this.fmcgProductName = fmcgProductName;
    }

    public String getFmcgProductVariant() {
        return fmcgProductVariant;
    }

    public void setFmcgProductVariant(String fmcgProductVariant) {
        this.fmcgProductVariant = fmcgProductVariant;
    }

    public String getFmcgProductDescription() {
        return fmcgProductDescription;
    }

    public void setFmcgProductDescription(String fmcgProductDescription) {
        this.fmcgProductDescription = fmcgProductDescription;
    }

    public String getFmcgProductGenericName() {
        return fmcgProductGenericName;
    }

    public void setFmcgProductGenericName(String fmcgProductGenericName) {
        this.fmcgProductGenericName = fmcgProductGenericName;
    }

    public String getFmcgProductAlternateName() {
        return fmcgProductAlternateName;
    }

    public void setFmcgProductAlternateName(String fmcgProductAlternateName) {
        this.fmcgProductAlternateName = fmcgProductAlternateName;
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

    public Boolean getFmcgProductAvailable() {
        return fmcgProductAvailable;
    }

    public void setFmcgProductAvailable(Boolean fmcgProductAvailable) {
        this.fmcgProductAvailable = fmcgProductAvailable;
    }

    public Float getFmcgProductSellingPrice() {
        return fmcgProductSellingPrice;
    }

    public void setFmcgProductSellingPrice(Float fmcgProductSellingPrice) {
        this.fmcgProductSellingPrice = fmcgProductSellingPrice;
    }

    public Float getFmcgProductOfferedDiscount() {
        return fmcgProductOfferedDiscount;
    }

    public void setFmcgProductOfferedDiscount(Float fmcgProductOfferedDiscount) {
        this.fmcgProductOfferedDiscount = fmcgProductOfferedDiscount;
    }

    public String getFmcgProductDiscountName() {
        return fmcgProductDiscountName;
    }

    public void setFmcgProductDiscountName(String fmcgProductDiscountName) {
        this.fmcgProductDiscountName = fmcgProductDiscountName;
    }

    public Float getFmcgProductDiscountedPrice() {
        return fmcgProductDiscountedPrice;
    }

    public void setFmcgProductDiscountedPrice(Float fmcgProductDiscountedPrice) {
        this.fmcgProductDiscountedPrice = fmcgProductDiscountedPrice;
    }

    public List<String> getFmcgProductApplicableTaxes() {
        return fmcgProductApplicableTaxes;
    }

    public void setFmcgProductApplicableTaxes(List<String> fmcgProductApplicableTaxes) {
        this.fmcgProductApplicableTaxes = fmcgProductApplicableTaxes;
    }

    public Float getFmcgProductTaxedPrice() {
        return fmcgProductTaxedPrice;
    }

    public void setFmcgProductTaxedPrice(Float fmcgProductTaxedPrice) {
        this.fmcgProductTaxedPrice = fmcgProductTaxedPrice;
    }

    public Float getFmcgProductQuantity() {
        return fmcgProductQuantity;
    }

    public void setFmcgProductQuantity(Float fmcgProductQuantity) {
        this.fmcgProductQuantity = fmcgProductQuantity;
    }

    public Float getFmcgProductMeasurementUnit() {
        return fmcgProductMeasurementUnit;
    }

    public void setFmcgProductMeasurementUnit(Float fmcgProductMeasurementUnit) {
        this.fmcgProductMeasurementUnit = fmcgProductMeasurementUnit;
    }

    public Float getFmcgProductDenomination() {
        return fmcgProductDenomination;
    }

    public void setFmcgProductDenomination(Float fmcgProductDenomination) {
        this.fmcgProductDenomination = fmcgProductDenomination;
    }

    public String getFmcgProductSubId() {
        return fmcgProductSubId;
    }

    public void setFmcgProductSubId(String fmcgProductSubId) {
        this.fmcgProductSubId = fmcgProductSubId;
    }

    public List<String> getFMCGProductImages() {
        return FMCGProductImages;
    }

    public void setFMCGProductImages(List<String> FMCGProductImages) {
        this.FMCGProductImages = FMCGProductImages;
    }
}
