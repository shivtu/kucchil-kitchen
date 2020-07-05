package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.models.vegitables.VegitableRecipes;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AddVegitablesRequestBody {

    private String vegitableName;

    private String vegitableDescp;

    private String vegitableVariant;

    private VegitableRecipes vegitableRecepie;

    private Float vegitableSellingPrice;

    private Float vegitableMaxDiscount;

    private Float vegitableOfferedDiscount;

    private Boolean vegitableShowDiscount;

    private Float vegitableQuantity;

    private boolean vegitableAvailable;

    private Float vegitableTax;

    private String vegitableMeasureMentUnit;

    private Float vegitablesInventoryCostPrice;

    private String vegitablesInventoryExpiry;

    private Float vegitablesInventoryMaxDiscount;

    private Float vegitablesInventoryFixedCost;

    private String vegitableSubId;

    public AddVegitablesRequestBody(){}

    public AddVegitablesRequestBody(
            String vegitableName,
            String vegitableDescp,
            String vegitableVariant,
            VegitableRecipes vegitableRecepie,
            Float vegitableSellingPrice,
            Float vegitableMaxDiscount,
            Float vegitableOfferedDiscount,
            Boolean vegitableShowDiscount,
            Float vegitableQuantity,
            boolean vegitableAvailable,
            Float vegitableTax,
            String vegitableMeasureMentUnit,
            Float vegitablesInventoryCostPrice,
            String vegitablesInventoryExpiry,
            Float vegitablesInventoryMaxDiscount,
            Float vegitablesInventoryFixedCost,
            String vegitableSubId) {

        this.vegitableName = vegitableName;
        this.vegitableDescp = vegitableDescp;
        this.vegitableVariant = vegitableVariant;
        this.vegitableRecepie = vegitableRecepie;
        this.vegitableSellingPrice = vegitableSellingPrice;
        this.vegitableMaxDiscount = vegitableMaxDiscount;
        this.vegitableOfferedDiscount = vegitableOfferedDiscount;
        this.vegitableShowDiscount = vegitableShowDiscount;
        this.vegitableQuantity = vegitableQuantity;
        this.vegitableAvailable = vegitableAvailable;
        this.vegitableTax = vegitableTax;
        this.vegitableMeasureMentUnit = vegitableMeasureMentUnit;
        this.vegitablesInventoryCostPrice = vegitablesInventoryCostPrice;
        this.vegitablesInventoryExpiry = vegitablesInventoryExpiry;
        this.vegitablesInventoryMaxDiscount = vegitablesInventoryMaxDiscount;
        this.vegitablesInventoryFixedCost = vegitablesInventoryFixedCost;
        this.vegitableSubId = vegitableSubId;
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

    public Float getVegitableMaxDiscount() {
        return vegitableMaxDiscount;
    }

    public void setVegitableMaxDiscount(Float vegitableMaxDiscount) {
        this.vegitableMaxDiscount = vegitableMaxDiscount;
    }

    public Float getVegitableOfferedDiscount() {
        return vegitableOfferedDiscount;
    }

    public void setVegitableOfferedDiscount(Float vegitableOfferedDiscount) {
        this.vegitableOfferedDiscount = vegitableOfferedDiscount;
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

    public boolean isVegitableAvailable() {
        return vegitableAvailable;
    }

    public void setVegitableAvailable(boolean vegitableAvailable) {
        this.vegitableAvailable = vegitableAvailable;
    }

    public Float getVegitableTax() {
        return vegitableTax;
    }

    public void setVegitableTax(Float vegitableTax) {
        this.vegitableTax = vegitableTax;
    }

    public String getVegitableMeasureMentUnit() {
        return vegitableMeasureMentUnit;
    }

    public void setVegitableMeasureMentUnit(String vegitableMeasureMentUnit) {
        this.vegitableMeasureMentUnit = vegitableMeasureMentUnit;
    }

    public Float getVegitablesInventoryCostPrice() {
        return vegitablesInventoryCostPrice;
    }

    public void setVegitablesInventoryCostPrice(Float vegitablesInventoryCostPrice) {
        this.vegitablesInventoryCostPrice = vegitablesInventoryCostPrice;
    }

    public String getVegitablesInventoryExpiry() {
        return vegitablesInventoryExpiry;
    }

    public void setVegitablesInventoryExpiry(String vegitablesInventoryExpiry) {
        this.vegitablesInventoryExpiry = vegitablesInventoryExpiry;
    }

    public Float getVegitablesInventoryMaxDiscount() {
        return vegitablesInventoryMaxDiscount;
    }

    public void setVegitablesInventoryMaxDiscount(Float vegitablesInventoryMaxDiscount) {
        this.vegitablesInventoryMaxDiscount = vegitablesInventoryMaxDiscount;
    }

    public Float getVegitablesInventoryFixedCost() {
        return vegitablesInventoryFixedCost;
    }

    public void setVegitablesInventoryFixedCost(Float vegitablesInventoryFixedCost) {
        this.vegitablesInventoryFixedCost = vegitablesInventoryFixedCost;
    }

    public String getVegitableSubId() {
        return vegitableSubId;
    }

    public void setVegitableSubId(String vegitableSubId) {
        this.vegitableSubId = vegitableSubId;
    }
}
