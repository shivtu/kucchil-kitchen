package com.example.retail.controllers.retailer.vegetables_retailer;

import com.example.retail.models.jsonmodels.DenominationList;
import com.example.retail.models.jsonmodels.Suppliers;
import com.example.retail.models.vegetables.VegetableRecipes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddVegetablesRequestBody {

    private List<String> vegetableApplicableTaxes = new ArrayList<>();

    private String vegetableName;

    private String vegetableDescp;

    private String vegetableVariant;

    private String itemCategory;

    private String itemSubCategory;

    private VegetableRecipes vegetableRecepie;

    private Float vegetableSellingPrice;

    private Float vegetableOfferedDiscount;

    private String vegetableOfferedDiscountName;

    private Boolean vegetableShowDiscount;

    private Float vegetableQuantity;

    private Boolean vegetableAvailable;

    private String vegetableMeasureMentUnit;

    private List<DenominationList> denominationList;

    private Float vegetableInventoryCostPrice;

    private String vegetableInventoryExpiry;

    private Float vegetableInventoryFixedCost;

    private List<Suppliers> suppliers = new ArrayList<>();

    public AddVegetablesRequestBody(){}

    public AddVegetablesRequestBody(List<String> vegetableApplicableTaxes, String vegetableName, String vegetableDescp, String vegetableVariant, String itemCategory, String itemSubCategory, VegetableRecipes vegetableRecepie, Float vegetableSellingPrice, Float vegetableOfferedDiscount, String vegetableOfferedDiscountName, Boolean vegetableShowDiscount, Float vegetableQuantity, Boolean vegetableAvailable, String vegetableMeasureMentUnit, List<DenominationList> denominationList, Float vegetableInventoryCostPrice, String vegetableInventoryExpiry, Float vegetableInventoryFixedCost, List<Suppliers> suppliers) {
        this.vegetableApplicableTaxes = vegetableApplicableTaxes;
        this.vegetableName = vegetableName;
        this.vegetableDescp = vegetableDescp;
        this.vegetableVariant = vegetableVariant;
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.vegetableRecepie = vegetableRecepie;
        this.vegetableSellingPrice = vegetableSellingPrice;
        this.vegetableOfferedDiscount = vegetableOfferedDiscount;
        this.vegetableOfferedDiscountName = vegetableOfferedDiscountName;
        this.vegetableShowDiscount = vegetableShowDiscount;
        this.vegetableQuantity = vegetableQuantity;
        this.vegetableAvailable = vegetableAvailable;
        this.vegetableMeasureMentUnit = vegetableMeasureMentUnit;
        this.denominationList = denominationList;
        this.vegetableInventoryCostPrice = vegetableInventoryCostPrice;
        this.vegetableInventoryExpiry = vegetableInventoryExpiry;
        this.vegetableInventoryFixedCost = vegetableInventoryFixedCost;
        this.suppliers = suppliers;
    }

    public List<String> getVegetableApplicableTaxes() {
        return vegetableApplicableTaxes;
    }

    public void setVegetableApplicableTaxes(List<String> vegetableApplicableTaxes) {
        this.vegetableApplicableTaxes = vegetableApplicableTaxes;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public String getVegetableDescp() {
        return vegetableDescp;
    }

    public void setVegetableDescp(String vegetableDescp) {
        this.vegetableDescp = vegetableDescp;
    }

    public String getVegetableVariant() {
        return vegetableVariant;
    }

    public void setVegetableVariant(String vegetableVariant) {
        this.vegetableVariant = vegetableVariant;
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

    public VegetableRecipes getVegetableRecepie() {
        return vegetableRecepie;
    }

    public void setVegetableRecepie(VegetableRecipes vegetableRecepie) {
        this.vegetableRecepie = vegetableRecepie;
    }

    public Float getVegetableSellingPrice() {
        return vegetableSellingPrice;
    }

    public void setVegetableSellingPrice(Float vegetableSellingPrice) {
        this.vegetableSellingPrice = vegetableSellingPrice;
    }

    public Float getVegetableOfferedDiscount() {
        return vegetableOfferedDiscount;
    }

    public void setVegetableOfferedDiscount(Float vegetableOfferedDiscount) {
        this.vegetableOfferedDiscount = vegetableOfferedDiscount;
    }

    public String getVegetableOfferedDiscountName() {
        return vegetableOfferedDiscountName;
    }

    public void setVegetableOfferedDiscountName(String vegetableOfferedDiscountName) {
        this.vegetableOfferedDiscountName = vegetableOfferedDiscountName;
    }

    public Boolean getVegetableShowDiscount() {
        return vegetableShowDiscount;
    }

    public void setVegetableShowDiscount(Boolean vegetableShowDiscount) {
        this.vegetableShowDiscount = vegetableShowDiscount;
    }

    public Float getVegetableQuantity() {
        return vegetableQuantity;
    }

    public void setVegetableQuantity(Float vegetableQuantity) {
        this.vegetableQuantity = vegetableQuantity;
    }

    public Boolean getVegetableAvailable() {
        return vegetableAvailable;
    }

    public void setVegetableAvailable(Boolean vegetableAvailable) {
        this.vegetableAvailable = vegetableAvailable;
    }

    public String getVegetableMeasureMentUnit() {
        return vegetableMeasureMentUnit;
    }

    public void setVegetableMeasureMentUnit(String vegetableMeasureMentUnit) {
        this.vegetableMeasureMentUnit = vegetableMeasureMentUnit;
    }

    public List<DenominationList> getDenominationList() {
        return denominationList;
    }

    public void setDenominationList(List<DenominationList> denominationList) {
        this.denominationList = denominationList;
    }

    public Float getVegetableInventoryCostPrice() {
        return vegetableInventoryCostPrice;
    }

    public void setVegetableInventoryCostPrice(Float vegetableInventoryCostPrice) {
        this.vegetableInventoryCostPrice = vegetableInventoryCostPrice;
    }

    public String getVegetableInventoryExpiry() {
        return vegetableInventoryExpiry;
    }

    public void setVegetableInventoryExpiry(String vegetableInventoryExpiry) {
        this.vegetableInventoryExpiry = vegetableInventoryExpiry;
    }

    public Float getVegetableInventoryFixedCost() {
        return vegetableInventoryFixedCost;
    }

    public void setVegetableInventoryFixedCost(Float vegetableInventoryFixedCost) {
        this.vegetableInventoryFixedCost = vegetableInventoryFixedCost;
    }

    public List<Suppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Suppliers> suppliers) {
        this.suppliers = suppliers;
    }
}
