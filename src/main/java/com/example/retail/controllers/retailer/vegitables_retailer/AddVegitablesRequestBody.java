package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.productsmodel.vegitables.VegitableRecipes;

import java.time.LocalDate;
import java.util.List;

public class AddVegitablesRequestBody {

    private String vegitable_Name;

    private String vegitable_Descp;

    private String vegitable_Variant;

    private VegitableRecipes vegitable_Recepie;

    private Float vegitable_SellingPrice;

    private Float vegitable_MaxDiscount;

    private Float vegitable_OfferedDiscount;

    private Boolean vegitable_ShowDiscount;

    private Float vegitable_Quantity;

    private boolean vegitable_Available;

    private Float vegitable_Tax;

    private String vegitable_MeasureMentUnit;

    private Float vegitablesInventory_CostPrice;

    private LocalDate vegitablesInventory_Expiry;

    private Float vegitablesInventory_MaxDiscount;

    private Float vegitablesInventory_FixedCost;

    private String vegitable_SubId;

    public AddVegitablesRequestBody(){}

    public AddVegitablesRequestBody(
            String vegitable_Name,
            String vegitable_Descp, String vegitable_Variant,
            VegitableRecipes vegitable_Recepie,
            Float vegitable_SellingPrice,
            Float vegitable_MaxDiscount,
            Float vegitable_OfferedDiscount,
            Boolean vegitable_ShowDiscount,
            Float vegitable_Quantity,
            boolean vegitable_Available,
            Float vegitable_Tax,
            String vegitable_MeasureMentUnit,
            Float vegitablesInventory_CostPrice,
            LocalDate vegitablesInventory_Expiry,
            Float vegitablesInventory_MaxDiscount,
            Float vegitablesInventory_FixedCost,
            String vegitable_SubId) {
        this.vegitable_Name = vegitable_Name;
        this.vegitable_Descp = vegitable_Descp;
        this.vegitable_Variant = vegitable_Variant;
        this.vegitable_Recepie = vegitable_Recepie;
        this.vegitable_SellingPrice = vegitable_SellingPrice;
        this.vegitable_MaxDiscount = vegitable_MaxDiscount;
        this.vegitable_OfferedDiscount = vegitable_OfferedDiscount;
        this.vegitable_ShowDiscount = vegitable_ShowDiscount;
        this.vegitable_Quantity = vegitable_Quantity;
        this.vegitable_Available = vegitable_Available;
        this.vegitable_Tax = vegitable_Tax;
        this.vegitable_MeasureMentUnit = vegitable_MeasureMentUnit;
        this.vegitablesInventory_CostPrice = vegitablesInventory_CostPrice;
        this.vegitablesInventory_Expiry = vegitablesInventory_Expiry;
        this.vegitablesInventory_MaxDiscount = vegitablesInventory_MaxDiscount;
        this.vegitablesInventory_FixedCost = vegitablesInventory_FixedCost;
        this.vegitable_SubId = vegitable_SubId;
    }

    public String getVegitable_Name() {
        return vegitable_Name;
    }

    public void setVegitable_Name(String vegitable_Name) {
        this.vegitable_Name = vegitable_Name;
    }

    public String getVegitable_Descp() {
        return vegitable_Descp;
    }

    public void setVegitable_Descp(String vegitable_Descp) {
        this.vegitable_Descp = vegitable_Descp;
    }

    public String getVegitable_Variant() {
        return vegitable_Variant;
    }

    public void setVegitable_Variant(String vegitable_Variant) {
        this.vegitable_Variant = vegitable_Variant;
    }

    public VegitableRecipes getVegitable_Recepie() {
        return vegitable_Recepie;
    }

    public void setVegitable_Recepie(VegitableRecipes vegitable_Recepie) {
        this.vegitable_Recepie = vegitable_Recepie;
    }

    public Float getVegitable_SellingPrice() {
        return vegitable_SellingPrice;
    }

    public void setVegitable_SellingPrice(Float vegitable_SellingPrice) {
        this.vegitable_SellingPrice = vegitable_SellingPrice;
    }

    public Float getVegitable_MaxDiscount() {
        return vegitable_MaxDiscount;
    }

    public void setVegitable_MaxDiscount(Float vegitable_MaxDiscount) {
        this.vegitable_MaxDiscount = vegitable_MaxDiscount;
    }

    public Float getVegitable_OfferedDiscount() {
        return vegitable_OfferedDiscount;
    }

    public void setVegitable_OfferedDiscount(Float vegitable_OfferedDiscount) {
        this.vegitable_OfferedDiscount = vegitable_OfferedDiscount;
    }

    public Boolean getVegitable_ShowDiscount() {
        return vegitable_ShowDiscount;
    }

    public void setVegitable_ShowDiscount(Boolean vegitable_ShowDiscount) {
        this.vegitable_ShowDiscount = vegitable_ShowDiscount;
    }

    public Float getVegitable_Quantity() {
        return vegitable_Quantity;
    }

    public void setVegitable_Quantity(Float vegitable_Quantity) {
        this.vegitable_Quantity = vegitable_Quantity;
    }

    public boolean isVegitable_Available() {
        return vegitable_Available;
    }

    public void setVegitable_Available(boolean vegitable_Available) {
        this.vegitable_Available = vegitable_Available;
    }

    public Float getVegitable_Tax() {
        return vegitable_Tax;
    }

    public void setVegitable_Tax(Float vegitable_Tax) {
        this.vegitable_Tax = vegitable_Tax;
    }

    public String getVegitable_MeasureMentUnit() {
        return vegitable_MeasureMentUnit;
    }

    public void setVegitable_MeasureMentUnit(String vegitable_MeasureMentUnit) {
        this.vegitable_MeasureMentUnit = vegitable_MeasureMentUnit;
    }

    public Float getVegitablesInventory_CostPrice() {
        return vegitablesInventory_CostPrice;
    }

    public void setVegitablesInventory_CostPrice(Float vegitablesInventory_CostPrice) {
        this.vegitablesInventory_CostPrice = vegitablesInventory_CostPrice;
    }

    public LocalDate getVegitablesInventory_Expiry() {
        return vegitablesInventory_Expiry;
    }

    public void setVegitablesInventory_Expiry(LocalDate vegitablesInventory_Expiry) {
        this.vegitablesInventory_Expiry = vegitablesInventory_Expiry;
    }

    public Float getVegitablesInventory_MaxDiscount() {
        return vegitablesInventory_MaxDiscount;
    }

    public void setVegitablesInventory_MaxDiscount(Float vegitablesInventory_MaxDiscount) {
        this.vegitablesInventory_MaxDiscount = vegitablesInventory_MaxDiscount;
    }

    public Float getVegitablesInventory_FixedCost() {
        return vegitablesInventory_FixedCost;
    }

    public void setVegitablesInventory_FixedCost(Float vegitablesInventory_FixedCost) {
        this.vegitablesInventory_FixedCost = vegitablesInventory_FixedCost;
    }

    public String getVegitable_SubId() {
        return vegitable_SubId;
    }

    public void setVegitable_SubId(String vegitable_SubId) {
        this.vegitable_SubId = vegitable_SubId;
    }
}
