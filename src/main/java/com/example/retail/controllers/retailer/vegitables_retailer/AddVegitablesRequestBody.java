package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.models.vegitables.VegitableRecipes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;

@Component
public class AddVegitablesRequestBody {

    private ArrayList<String> vegitableApplicableTaxes;

    private String vegitableName;

    private String vegitableDescp;

    private String vegitableVariant;

    private String itemCategory;

    private VegitableRecipes vegitableRecepie;

    private Float vegitableSellingPrice;

    private Float vegitableOfferedDiscount;

    private String vegitableOfferedDiscountName;

    private Boolean vegitableShowDiscount;

    private Float vegitableQuantity;

    private Boolean vegitableAvailable;

    private String vegitableMeasureMentUnit;

    private Float vegitableInventoryCostPrice;

    private String vegitableInventoryExpiry;

    private Float vegitableInventoryFixedCost;

    public AddVegitablesRequestBody(){}

    public AddVegitablesRequestBody(ArrayList<String> vegitableApplicableTaxes, String vegitableName, String vegitableDescp, String vegitableVariant, String itemCategory, VegitableRecipes vegitableRecepie, Float vegitableSellingPrice, Float vegitableOfferedDiscount, String vegitableOfferedDiscountName, Boolean vegitableShowDiscount, Float vegitableQuantity, Boolean vegitableAvailable, String vegitableMeasureMentUnit, Float vegitableInventoryCostPrice, String vegitableInventoryExpiry, Float vegitableInventoryFixedCost) {
        this.vegitableApplicableTaxes = vegitableApplicableTaxes;
        this.vegitableName = vegitableName;
        this.vegitableDescp = vegitableDescp;
        this.vegitableVariant = vegitableVariant;
        this.itemCategory = itemCategory;
        this.vegitableRecepie = vegitableRecepie;
        this.vegitableSellingPrice = vegitableSellingPrice;
        this.vegitableOfferedDiscount = vegitableOfferedDiscount;
        this.vegitableOfferedDiscountName = vegitableOfferedDiscountName;
        this.vegitableShowDiscount = vegitableShowDiscount;
        this.vegitableQuantity = vegitableQuantity;
        this.vegitableAvailable = vegitableAvailable;
        this.vegitableMeasureMentUnit = vegitableMeasureMentUnit;
        this.vegitableInventoryCostPrice = vegitableInventoryCostPrice;
        this.vegitableInventoryExpiry = vegitableInventoryExpiry;
        this.vegitableInventoryFixedCost = vegitableInventoryFixedCost;
    }

    public ArrayList<String> getVegitableApplicableTaxes() {
        return vegitableApplicableTaxes;
    }

    public void setVegitableApplicableTaxes(ArrayList<String> vegitableApplicableTaxes) {
        this.vegitableApplicableTaxes = vegitableApplicableTaxes;
    }

    public String getVegitableName() {
        return vegitableName;
    }

    public void setVegitableName(String vegitableName) {
        this.vegitableName = vegitableName;
    }

    public String getVegitableDescp() {
        return vegitableDescp;
    }

    public void setVegitableDescp(String vegitableDescp) {
        this.vegitableDescp = vegitableDescp;
    }

    public String getVegitableVariant() {
        return vegitableVariant;
    }

    public void setVegitableVariant(String vegitableVariant) {
        this.vegitableVariant = vegitableVariant;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public VegitableRecipes getVegitableRecepie() {
        return vegitableRecepie;
    }

    public void setVegitableRecepie(VegitableRecipes vegitableRecepie) {
        this.vegitableRecepie = vegitableRecepie;
    }

    public Float getVegitableSellingPrice() {
        return vegitableSellingPrice;
    }

    public void setVegitableSellingPrice(Float vegitableSellingPrice) {
        this.vegitableSellingPrice = vegitableSellingPrice;
    }

    public Float getVegitableOfferedDiscount() {
        return vegitableOfferedDiscount;
    }

    public void setVegitableOfferedDiscount(Float vegitableOfferedDiscount) {
        this.vegitableOfferedDiscount = vegitableOfferedDiscount;
    }

    public String getVegitableOfferedDiscountName() {
        return vegitableOfferedDiscountName;
    }

    public void setVegitableOfferedDiscountName(String vegitableOfferedDiscountName) {
        this.vegitableOfferedDiscountName = vegitableOfferedDiscountName;
    }

    public Boolean getVegitableShowDiscount() {
        return vegitableShowDiscount;
    }

    public void setVegitableShowDiscount(Boolean vegitableShowDiscount) {
        this.vegitableShowDiscount = vegitableShowDiscount;
    }

    public Float getVegitableQuantity() {
        return vegitableQuantity;
    }

    public void setVegitableQuantity(Float vegitableQuantity) {
        this.vegitableQuantity = vegitableQuantity;
    }

    public Boolean getVegitableAvailable() {
        return vegitableAvailable;
    }

    public void setVegitableAvailable(Boolean vegitableAvailable) {
        this.vegitableAvailable = vegitableAvailable;
    }

    public String getVegitableMeasureMentUnit() {
        return vegitableMeasureMentUnit;
    }

    public void setVegitableMeasureMentUnit(String vegitableMeasureMentUnit) {
        this.vegitableMeasureMentUnit = vegitableMeasureMentUnit;
    }

    public Float getVegitableInventoryCostPrice() {
        return vegitableInventoryCostPrice;
    }

    public void setVegitableInventoryCostPrice(Float vegitableInventoryCostPrice) {
        this.vegitableInventoryCostPrice = vegitableInventoryCostPrice;
    }

    public String getVegitableInventoryExpiry() {
        return vegitableInventoryExpiry;
    }

    public void setVegitableInventoryExpiry(String vegitableInventoryExpiry) {
        this.vegitableInventoryExpiry = vegitableInventoryExpiry;
    }

    public Float getVegitableInventoryFixedCost() {
        return vegitableInventoryFixedCost;
    }

    public void setVegitableInventoryFixedCost(Float vegitableInventoryFixedCost) {
        this.vegitableInventoryFixedCost = vegitableInventoryFixedCost;
    }
}
