package com.example.retail.models.fmcgproducts;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

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
    @NotNull
    @Column(name = "item_category_name")
    private String itemClassificationName;

    @NotEmpty
    @NotNull
    @Column(name = "item_category_code")
    private String itemClassificationCode;

    @NotNull
    @Column(name = "fmcg_product_available")
    private Boolean fmcgProductAvailable;

    @Column(name = "fmcg_product_offered_discount")
    private String fmcgProductOfferedDiscount;

    @Column(name = "fmcg_product_discount_name")
    private String fmcgProductDiscountName;

    @Column(name = "fmcg_product_discounted_price")
    private String fmcgProductDiscountedPrice;

    @NotNull
    @Column(name = "fmcg_product_applicable_taxes")
    private ArrayList<String> fmcgProductApplicableTaxes;

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

    @NotNull
    @Column(name = "fmcg_product_subid")
    private Float fmcgProductSubId;

    @Column(name = "fmcg_product_image_location")
    private ArrayList<String> fmcgProductImageLocation;


    public FMCGProducts() {}

    public FMCGProducts(@NotNull String fmcgProductManufacturer, @NotNull String fmcgProductName, String fmcgProductVariant, @NotNull String fmcgProductDescription, @NotNull String fmcgProductGenericName, String fmcgProductAlternateName, @NotNull String itemClassificationName, @NotEmpty @NotNull String itemClassificationCode, @NotNull Boolean fmcgProductAvailable, String fmcgProductOfferedDiscount, String fmcgProductDiscountName, String fmcgProductDiscountedPrice, @NotNull ArrayList<String> fmcgProductApplicableTaxes, @NotNull Float fmcgProductTaxedPrice, @NotNull Float fmcgProductQuantity, @NotNull Float fmcgProductMeasurementUnit, @NotNull Float fmcgProductDenomination, @NotNull Float fmcgProductSubId, ArrayList<String> fmcgProductImageLocation) {
        this.fmcgProductManufacturer = fmcgProductManufacturer;
        this.fmcgProductName = fmcgProductName;
        this.fmcgProductVariant = fmcgProductVariant;
        this.fmcgProductDescription = fmcgProductDescription;
        this.fmcgProductGenericName = fmcgProductGenericName;
        this.fmcgProductAlternateName = fmcgProductAlternateName;
        this.itemClassificationName = itemClassificationName;
        this.itemClassificationCode = itemClassificationCode;
        this.fmcgProductAvailable = fmcgProductAvailable;
        this.fmcgProductOfferedDiscount = fmcgProductOfferedDiscount;
        this.fmcgProductDiscountName = fmcgProductDiscountName;
        this.fmcgProductDiscountedPrice = fmcgProductDiscountedPrice;
        this.fmcgProductApplicableTaxes = fmcgProductApplicableTaxes;
        this.fmcgProductTaxedPrice = fmcgProductTaxedPrice;
        this.fmcgProductQuantity = fmcgProductQuantity;
        this.fmcgProductMeasurementUnit = fmcgProductMeasurementUnit;
        this.fmcgProductDenomination = fmcgProductDenomination;
        this.fmcgProductSubId = fmcgProductSubId;
        this.fmcgProductImageLocation = fmcgProductImageLocation;
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

    public String getItemClassificationName() {
        return itemClassificationName;
    }

    public void setItemClassificationName(String itemClassificationName) {
        this.itemClassificationName = itemClassificationName;
    }

    public String getItemClassificationCode() {
        return itemClassificationCode;
    }

    public void setItemClassificationCode(String itemClassificationCode) {
        this.itemClassificationCode = itemClassificationCode;
    }

    public Boolean getFmcgProductAvailable() {
        return fmcgProductAvailable;
    }

    public void setFmcgProductAvailable(Boolean fmcgProductAvailable) {
        this.fmcgProductAvailable = fmcgProductAvailable;
    }

    public String getFmcgProductOfferedDiscount() {
        return fmcgProductOfferedDiscount;
    }

    public void setFmcgProductOfferedDiscount(String fmcgProductOfferedDiscount) {
        this.fmcgProductOfferedDiscount = fmcgProductOfferedDiscount;
    }

    public String getFmcgProductDiscountName() {
        return fmcgProductDiscountName;
    }

    public void setFmcgProductDiscountName(String fmcgProductDiscountName) {
        this.fmcgProductDiscountName = fmcgProductDiscountName;
    }

    public String getFmcgProductDiscountedPrice() {
        return fmcgProductDiscountedPrice;
    }

    public void setFmcgProductDiscountedPrice(String fmcgProductDiscountedPrice) {
        this.fmcgProductDiscountedPrice = fmcgProductDiscountedPrice;
    }

    public ArrayList<String> getFmcgProductApplicableTaxes() {
        return fmcgProductApplicableTaxes;
    }

    public void setFmcgProductApplicableTaxes(ArrayList<String> fmcgProductApplicableTaxes) {
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

    public Float getFmcgProductSubId() {
        return fmcgProductSubId;
    }

    public void setFmcgProductSubId(Float fmcgProductSubId) {
        this.fmcgProductSubId = fmcgProductSubId;
    }

    public ArrayList<String> getFmcgProductImageLocation() {
        return fmcgProductImageLocation;
    }

    public void setFmcgProductImageLocation(ArrayList<String> fmcgProductImageLocation) {
        this.fmcgProductImageLocation = fmcgProductImageLocation;
    }
}
