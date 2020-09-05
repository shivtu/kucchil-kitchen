package com.example.retail.controllers.retailer.edibleproducts_retailer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AddEdibleProductsRequestBody {

    private String edibleProductManufacturer;

    private String edibleProductName;

    private String edibleProductVariant;

    private String edibleProductFlavor;

    private String edibleProductType;

    private String edibleProductDescription;

    private String edibleProductGenericName;

    private String edibleProductAlternaleName;

    private String itemClassificationName;

    private String itemClassificationCode;

    private Boolean edibleProductForMinors;

    private Boolean edibleProductAvailable;

    private Float edibleProductMrp;

    private Float edibleProductOfferedDiscount;

    private String edibleProductsDiscountName;

    private ArrayList<String> edibleProductApplicableTaxes;

    private Float edibleProductQuantity;

    private String edibleProductsMeasureMentUnit;

    private Float edibleProductDenomination;

    public AddEdibleProductsRequestBody() {}

    public AddEdibleProductsRequestBody(String edibleProductManufacturer, String edibleProductName, String edibleProductVariant,
                                        String edibleProductFlavor, String edibleProductType, String edibleProductDescription,
                                        String edibleProductGenericName, String edibleProductAlternaleName,
                                        String itemClassificationName, String itemClassificationCode, Boolean edibleProductForMinors,
                                        Boolean edibleProductAvailable, Float edibleProductMrp, Float edibleProductOfferedDiscount,
                                        String edibleProductsDiscountName, ArrayList<String> edibleProductApplicableTaxes,
                                        Float edibleProductQuantity, String edibleProductsMeasureMentUnit,
                                        Float edibleProductDenomination) {
        this.edibleProductManufacturer = edibleProductManufacturer;
        this.edibleProductName = edibleProductName;
        this.edibleProductVariant = edibleProductVariant;
        this.edibleProductFlavor = edibleProductFlavor;
        this.edibleProductType = edibleProductType;
        this.edibleProductDescription = edibleProductDescription;
        this.edibleProductGenericName = edibleProductGenericName;
        this.edibleProductAlternaleName = edibleProductAlternaleName;
        this.itemClassificationName = itemClassificationName;
        this.itemClassificationCode = itemClassificationCode;
        this.edibleProductForMinors = edibleProductForMinors;
        this.edibleProductAvailable = edibleProductAvailable;
        this.edibleProductMrp = edibleProductMrp;
        this.edibleProductOfferedDiscount = edibleProductOfferedDiscount;
        this.edibleProductsDiscountName = edibleProductsDiscountName;
        this.edibleProductApplicableTaxes = edibleProductApplicableTaxes;
        this.edibleProductQuantity = edibleProductQuantity;
        this.edibleProductsMeasureMentUnit = edibleProductsMeasureMentUnit;
        this.edibleProductDenomination = edibleProductDenomination;
    }

    public String getEdibleProductManufacturer() {
        return edibleProductManufacturer;
    }

    public void setEdibleProductManufacturer(String edibleProductManufacturer) {
        this.edibleProductManufacturer = edibleProductManufacturer;
    }

    public String getEdibleProductName() {
        return edibleProductName;
    }

    public void setEdibleProductName(String edibleProductName) {
        this.edibleProductName = edibleProductName;
    }

    public String getEdibleProductVariant() {
        return edibleProductVariant;
    }

    public void setEdibleProductVariant(String edibleProductVariant) {
        this.edibleProductVariant = edibleProductVariant;
    }

    public String getEdibleProductFlavor() {
        return edibleProductFlavor;
    }

    public void setEdibleProductFlavor(String edibleProductFlavor) {
        this.edibleProductFlavor = edibleProductFlavor;
    }

    public String getEdibleProductType() {
        return edibleProductType;
    }

    public void setEdibleProductType(String edibleProductType) {
        this.edibleProductType = edibleProductType;
    }

    public String getEdibleProductDescription() {
        return edibleProductDescription;
    }

    public void setEdibleProductDescription(String edibleProductDescription) {
        this.edibleProductDescription = edibleProductDescription;
    }

    public String getEdibleProductGenericName() {
        return edibleProductGenericName;
    }

    public void setEdibleProductGenericName(String edibleProductGenericName) {
        this.edibleProductGenericName = edibleProductGenericName;
    }

    public String getEdibleProductAlternaleName() {
        return edibleProductAlternaleName;
    }

    public void setEdibleProductAlternaleName(String edibleProductAlternaleName) {
        this.edibleProductAlternaleName = edibleProductAlternaleName;
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

    public Boolean getEdibleProductForMinors() {
        return edibleProductForMinors;
    }

    public void setEdibleProductForMinors(Boolean edibleProductForMinors) {
        this.edibleProductForMinors = edibleProductForMinors;
    }

    public Boolean getEdibleProductAvailable() {
        return edibleProductAvailable;
    }

    public void setEdibleProductAvailable(Boolean edibleProductAvailable) {
        this.edibleProductAvailable = edibleProductAvailable;
    }

    public Float getEdibleProductMrp() {
        return edibleProductMrp;
    }

    public void setEdibleProductMrp(Float edibleProductMrp) {
        this.edibleProductMrp = edibleProductMrp;
    }

    public Float getEdibleProductOfferedDiscount() {
        return edibleProductOfferedDiscount;
    }

    public void setEdibleProductOfferedDiscount(Float edibleProductOfferedDiscount) {
        this.edibleProductOfferedDiscount = edibleProductOfferedDiscount;
    }

    public String getEdibleProductsDiscountName() {
        return edibleProductsDiscountName;
    }

    public void setEdibleProductsDiscountName(String edibleProductsDiscountName) {
        this.edibleProductsDiscountName = edibleProductsDiscountName;
    }

    public ArrayList<String> getEdibleProductApplicableTaxes() {
        return edibleProductApplicableTaxes;
    }

    public void setEdibleProductApplicableTaxes(ArrayList<String> edibleProductApplicableTaxes) {
        this.edibleProductApplicableTaxes = edibleProductApplicableTaxes;
    }

    public Float getEdibleProductQuantity() {
        return edibleProductQuantity;
    }

    public void setEdibleProductQuantity(Float edibleProductQuantity) {
        this.edibleProductQuantity = edibleProductQuantity;
    }

    public String getEdibleProductsMeasureMentUnit() {
        return edibleProductsMeasureMentUnit;
    }

    public void setEdibleProductsMeasureMentUnit(String edibleProductsMeasureMentUnit) {
        this.edibleProductsMeasureMentUnit = edibleProductsMeasureMentUnit;
    }

    public Float getEdibleProductDenomination() {
        return edibleProductDenomination;
    }

    public void setEdibleProductDenomination(Float edibleProductDenomination) {
        this.edibleProductDenomination = edibleProductDenomination;
    }
}
