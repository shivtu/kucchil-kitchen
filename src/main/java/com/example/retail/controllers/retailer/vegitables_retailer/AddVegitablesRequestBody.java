package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.models.vegitables.VegitableRecipes;
import org.springframework.stereotype.Component;

@Component
public class AddVegitablesRequestBody {

    private String vegitableName;

    private String vegitableDescp;

    private String vegitableVariant;

    private VegitableRecipes vegitableRecepie;

    private Float vegitableSellingPrice;

    private Float vegitableOfferedDiscount;

    private Boolean vegitableShowDiscount;

    private Float vegitableQuantity;

    private boolean vegitableAvailable;

    private String vegitableMeasureMentUnit;

    private Float vegitableInventoryCostPrice;

    private String vegitableInventoryExpiry;

    private Float vegitableInventoryMaxDiscount;

    private Float vegitableInventoryFixedCost;

    public AddVegitablesRequestBody(){}

    public AddVegitablesRequestBody(String vegitableName,
                                    String vegitableDescp,
                                    String vegitableVariant,
                                    VegitableRecipes vegitableRecepie,
                                    Float vegitableSellingPrice,
                                    Float vegitableOfferedDiscount,
                                    Boolean vegitableShowDiscount,
                                    Float vegitableQuantity,
                                    boolean vegitableAvailable,
                                    String vegitableMeasureMentUnit,
                                    Float vegitableInventoryCostPrice,
                                    String vegitableInventoryExpiry,
                                    Float vegitableInventoryMaxDiscount,
                                    Float vegitableInventoryFixedCost) {
        this.vegitableName = vegitableName;
        this.vegitableDescp = vegitableDescp;
        this.vegitableVariant = vegitableVariant;
        this.vegitableRecepie = vegitableRecepie;
        this.vegitableSellingPrice = vegitableSellingPrice;
        this.vegitableOfferedDiscount = vegitableOfferedDiscount;
        this.vegitableShowDiscount = vegitableShowDiscount;
        this.vegitableQuantity = vegitableQuantity;
        this.vegitableAvailable = vegitableAvailable;
        this.vegitableMeasureMentUnit = vegitableMeasureMentUnit;
        this.vegitableInventoryCostPrice = vegitableInventoryCostPrice;
        this.vegitableInventoryExpiry = vegitableInventoryExpiry;
        this.vegitableInventoryMaxDiscount = vegitableInventoryMaxDiscount;
        this.vegitableInventoryFixedCost = vegitableInventoryFixedCost;
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

    public Float getVegitableInventoryMaxDiscount() {
        return vegitableInventoryMaxDiscount;
    }

    public void setVegitableInventoryMaxDiscount(Float vegitableInventoryMaxDiscount) {
        this.vegitableInventoryMaxDiscount = vegitableInventoryMaxDiscount;
    }

    public Float getVegitableInventoryFixedCost() {
        return vegitableInventoryFixedCost;
    }

    public void setVegitableInventoryFixedCost(Float vegitableInventoryFixedCost) {
        this.vegitableInventoryFixedCost = vegitableInventoryFixedCost;
    }
}
