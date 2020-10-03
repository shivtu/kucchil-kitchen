package com.example.retail.controllers.retailer.nonvegproducts_retailer;

import com.example.retail.models.jsonmodels.Suppliers;
import com.example.retail.models.nonvegproducts.NonVegProductTypeEnum;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NonVegProductsRequestBody {

    private String nonVegProductName;

    private String getNonVegProductAlternateName;

    private String getNonVegProductVariant;

    private String itemCategory;

    private String itemSubCategory;

    private Boolean isFrozen;

    private Boolean isTinned;

    private NonVegProductTypeEnum nonVegProductType;

    private String nonVegProductPackagedBy;

    private Float nonVegProductQty;

    private Float nonVegProductMeasurementUnit;

    private Float nonVegProductOfferedDiscount;

    private String nonVegProductOfferedDiscountName;

    private List<String> nonVegProductApplicableTaxes;

    private String nonVegProductCutType;

    private Boolean isAvailable;

    private Float nonVegProductCostPrice;

    private Float nonVegProductFixedCost;

    private String nonVegProductInventoryExpiry;

    private List<Suppliers> suppliers;

    private String edibleProductSubId;

    public NonVegProductsRequestBody() {}

    public NonVegProductsRequestBody(String nonVegProductName, String getNonVegProductAlternateName, String getNonVegProductVariant,
                                     String itemCategory, String itemSubCategory, Boolean isFrozen, Boolean isTinned,
                                     NonVegProductTypeEnum nonVegProductType, String nonVegProductPackagedBy, Float nonVegProductQty,
                                     Float nonVegProductMeasurementUnit, Float nonVegProductOfferedDiscount,
                                     String nonVegProductOfferedDiscountName, List<String> nonVegProductApplicableTaxes,
                                     String nonVegProductCutType, Boolean isAvailable, Float nonVegProductCostPrice,
                                     Float nonVegProductFixedCost, String nonVegProductInventoryExpiry, List<Suppliers> suppliers,
                                     String edibleProductSubId) {
        this.nonVegProductName = nonVegProductName;
        this.getNonVegProductAlternateName = getNonVegProductAlternateName;
        this.getNonVegProductVariant = getNonVegProductVariant;
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.isFrozen = isFrozen;
        this.isTinned = isTinned;
        this.nonVegProductType = nonVegProductType;
        this.nonVegProductPackagedBy = nonVegProductPackagedBy;
        this.nonVegProductQty = nonVegProductQty;
        this.nonVegProductMeasurementUnit = nonVegProductMeasurementUnit;
        this.nonVegProductOfferedDiscount = nonVegProductOfferedDiscount;
        this.nonVegProductOfferedDiscountName = nonVegProductOfferedDiscountName;
        this.nonVegProductApplicableTaxes = nonVegProductApplicableTaxes;
        this.nonVegProductCutType = nonVegProductCutType;
        this.isAvailable = isAvailable;
        this.nonVegProductCostPrice = nonVegProductCostPrice;
        this.nonVegProductFixedCost = nonVegProductFixedCost;
        this.nonVegProductInventoryExpiry = nonVegProductInventoryExpiry;
        this.suppliers = suppliers;
        this.edibleProductSubId = edibleProductSubId;
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

    public Float getNonVegProductQty() {
        return nonVegProductQty;
    }

    public void setNonVegProductQty(Float nonVegProductQty) {
        this.nonVegProductQty = nonVegProductQty;
    }

    public Float getNonVegProductMeasurementUnit() {
        return nonVegProductMeasurementUnit;
    }

    public void setNonVegProductMeasurementUnit(Float nonVegProductMeasurementUnit) {
        this.nonVegProductMeasurementUnit = nonVegProductMeasurementUnit;
    }

    public Float getNonVegProductOfferedDiscount() {
        return nonVegProductOfferedDiscount;
    }

    public void setNonVegProductOfferedDiscount(Float nonVegProductOfferedDiscount) {
        this.nonVegProductOfferedDiscount = nonVegProductOfferedDiscount;
    }

    public String getNonVegProductOfferedDiscountName() {
        return nonVegProductOfferedDiscountName;
    }

    public void setNonVegProductOfferedDiscountName(String nonVegProductOfferedDiscountName) {
        this.nonVegProductOfferedDiscountName = nonVegProductOfferedDiscountName;
    }

    public List<String> getNonVegProductApplicableTaxes() {
        return nonVegProductApplicableTaxes;
    }

    public void setNonVegProductApplicableTaxes(List<String> nonVegProductApplicableTaxes) {
        this.nonVegProductApplicableTaxes = nonVegProductApplicableTaxes;
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

    public Float getNonVegProductCostPrice() {
        return nonVegProductCostPrice;
    }

    public void setNonVegProductCostPrice(Float nonVegProductCostPrice) {
        this.nonVegProductCostPrice = nonVegProductCostPrice;
    }

    public Float getNonVegProductFixedCost() {
        return nonVegProductFixedCost;
    }

    public void setNonVegProductFixedCost(Float nonVegProductFixedCost) {
        this.nonVegProductFixedCost = nonVegProductFixedCost;
    }

    public String getNonVegProductInventoryExpiry() {
        return nonVegProductInventoryExpiry;
    }

    public void setNonVegProductInventoryExpiry(String nonVegProductInventoryExpiry) {
        this.nonVegProductInventoryExpiry = nonVegProductInventoryExpiry;
    }

    public List<Suppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Suppliers> suppliers) {
        this.suppliers = suppliers;
    }

    public String getEdibleProductSubId() {
        return edibleProductSubId;
    }

    public void setEdibleProductSubId(String edibleProductSubId) {
        this.edibleProductSubId = edibleProductSubId;
    }
}


