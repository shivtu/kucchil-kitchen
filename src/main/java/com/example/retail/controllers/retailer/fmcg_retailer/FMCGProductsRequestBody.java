package com.example.retail.controllers.retailer.fmcg_retailer;

import com.example.retail.models.jsonmodels.Suppliers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FMCGProductsRequestBody {

    private String fmcgProductManufacturer;

    private String fmcgProductName;

    private String fmcgProductVariant;

    private String fmcgProductDescription;

    private String fmcgProductGenericName;

    private String fmcgProductAlternateName;

    private String itemCategory;

    private String itemSubCategory;

    private Boolean fmcgProductAvailable;

    private Float fmcgProductSellingPrice;

    private Float fmcgProductOfferedDiscount;

    private String fmcgProductDiscountName;

    private ArrayList<String> fmcgProductApplicableTaxes;

    private Float fmcgProductQuantity;

    private Float fmcgProductMeasurementUnit;

    private Float fmcgProductDenomination;

    private ArrayList<String> fmcgProductImageLocation;

    /** Inventory details **/

    private Float fmcgProductInventoryCostPrice;

    private Float fmcgProductInventoryFixedCost;

    private String fmcgProductInventoryExpiry;

    private Float fmcgProductInventoryAddedQty;

    private List<Suppliers> suppliers;

    public FMCGProductsRequestBody() {}

    public FMCGProductsRequestBody(String fmcgProductManufacturer, String fmcgProductName, String fmcgProductVariant, String fmcgProductDescription,
                                   String fmcgProductGenericName, String fmcgProductAlternateName, String itemCategory, String itemSubCategory,
                                   Boolean fmcgProductAvailable, Float fmcgProductSellingPrice, Float fmcgProductOfferedDiscount,
                                   String fmcgProductDiscountName, ArrayList<String> fmcgProductApplicableTaxes, Float fmcgProductQuantity,
                                   Float fmcgProductMeasurementUnit, Float fmcgProductDenomination, ArrayList<String> fmcgProductImageLocation,
                                   Float fmcgProductInventoryCostPrice, Float fmcgProductInventoryFixedCost, String fmcgProductInventoryExpiry,
                                   Float fmcgProductInventoryAddedQty, List<Suppliers> suppliers) {
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
        this.fmcgProductApplicableTaxes = fmcgProductApplicableTaxes;
        this.fmcgProductQuantity = fmcgProductQuantity;
        this.fmcgProductMeasurementUnit = fmcgProductMeasurementUnit;
        this.fmcgProductDenomination = fmcgProductDenomination;
        this.fmcgProductImageLocation = fmcgProductImageLocation;
        this.fmcgProductInventoryCostPrice = fmcgProductInventoryCostPrice;
        this.fmcgProductInventoryFixedCost = fmcgProductInventoryFixedCost;
        this.fmcgProductInventoryExpiry = fmcgProductInventoryExpiry;
        this.fmcgProductInventoryAddedQty = fmcgProductInventoryAddedQty;
        this.suppliers = suppliers;
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

    public ArrayList<String> getFmcgProductApplicableTaxes() {
        return fmcgProductApplicableTaxes;
    }

    public void setFmcgProductApplicableTaxes(ArrayList<String> fmcgProductApplicableTaxes) {
        this.fmcgProductApplicableTaxes = fmcgProductApplicableTaxes;
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

    public ArrayList<String> getFmcgProductImageLocation() {
        return fmcgProductImageLocation;
    }

    public void setFmcgProductImageLocation(ArrayList<String> fmcgProductImageLocation) {
        this.fmcgProductImageLocation = fmcgProductImageLocation;
    }

    public Float getFmcgProductInventoryCostPrice() {
        return fmcgProductInventoryCostPrice;
    }

    public void setFmcgProductInventoryCostPrice(Float fmcgProductInventoryCostPrice) {
        this.fmcgProductInventoryCostPrice = fmcgProductInventoryCostPrice;
    }

    public Float getFmcgProductInventoryFixedCost() {
        return fmcgProductInventoryFixedCost;
    }

    public void setFmcgProductInventoryFixedCost(Float fmcgProductInventoryFixedCost) {
        this.fmcgProductInventoryFixedCost = fmcgProductInventoryFixedCost;
    }

    public String getFmcgProductInventoryExpiry() {
        return fmcgProductInventoryExpiry;
    }

    public void setFmcgProductInventoryExpiry(String fmcgProductInventoryExpiry) {
        this.fmcgProductInventoryExpiry = fmcgProductInventoryExpiry;
    }

    public Float getFmcgProductInventoryAddedQty() {
        return fmcgProductInventoryAddedQty;
    }

    public void setFmcgProductInventoryAddedQty(Float fmcgProductInventoryAddedQty) {
        this.fmcgProductInventoryAddedQty = fmcgProductInventoryAddedQty;
    }

    public List<Suppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Suppliers> suppliers) {
        this.suppliers = suppliers;
    }
}
