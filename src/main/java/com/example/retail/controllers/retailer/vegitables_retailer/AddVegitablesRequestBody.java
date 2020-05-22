package com.example.retail.controllers.retailer.vegitables_retailer;

import com.example.retail.productsmodel.vegitables.VegitableRecipes;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AddVegitablesRequestBody {

    private String vegitable_productId;

    private String vegitable_Name;

    private String vegitable_Descp;

    private String vegitable_variant;

    private List<VegitableRecipes> vegitable_Recepie;

    private Float vegitable_SellingPrice;

    private Float vegitable_MaxDiscount;

    private Float vegitable_OfferedDiscount;

    private Boolean vegitable_ShowDiscount;

    private Float vegitable_Quantity;

    private boolean vegitable_Available;

    private Float vegitable_Tax;

    private String vegitable_MeasureMentUnit;

    private Float vegitableInventory_CostPrice;

    private Date vegitableInventory_Expiry;

    private Float vegitableInventory_MaxDiscount;

    private String vegitableInventory_AddedBy;

    private String vegitableInventory_DateTimeAdded;

    private Float vegitableInventory_IncCount;

    private Float vegitableInventory_FixedCost;

    public AddVegitablesRequestBody(){}

    public AddVegitablesRequestBody(String vegitable_productId, String vegitable_Name, String vegitable_Descp, String vegitable_variant, List<VegitableRecipes> vegitable_Recepie, @NotNull Float vegitable_SellingPrice, Float vegitable_MaxDiscount, Float vegitable_OfferedDiscount, Boolean vegitable_ShowDiscount, Float vegitable_Quantity, boolean vegitable_Available, Float vegitable_Tax, String vegitable_MeasureMentUnit, Float vegitableInventory_CostPrice, Date vegitableInventory_Expiry, Float vegitableInventory_MaxDiscount, String vegitableInventory_AddedBy, String vegitableInventory_DateTimeAdded, Float vegitableInventory_IncCount, Float vegitableInventory_FixedCost) {
        this.vegitable_productId = vegitable_productId;
        this.vegitable_Name = vegitable_Name;
        this.vegitable_Descp = vegitable_Descp;
        this.vegitable_variant = vegitable_variant;
        this.vegitable_Recepie = vegitable_Recepie;
        this.vegitable_SellingPrice = vegitable_SellingPrice;
        this.vegitable_MaxDiscount = vegitable_MaxDiscount;
        this.vegitable_OfferedDiscount = vegitable_OfferedDiscount;
        this.vegitable_ShowDiscount = vegitable_ShowDiscount;
        this.vegitable_Quantity = vegitable_Quantity;
        this.vegitable_Available = vegitable_Available;
        this.vegitable_Tax = vegitable_Tax;
        this.vegitable_MeasureMentUnit = vegitable_MeasureMentUnit;
        this.vegitableInventory_CostPrice = vegitableInventory_CostPrice;
        this.vegitableInventory_Expiry = vegitableInventory_Expiry;
        this.vegitableInventory_MaxDiscount = vegitableInventory_MaxDiscount;
        this.vegitableInventory_AddedBy = vegitableInventory_AddedBy;
        this.vegitableInventory_DateTimeAdded = vegitableInventory_DateTimeAdded;
        this.vegitableInventory_IncCount = vegitableInventory_IncCount;
        this.vegitableInventory_FixedCost = vegitableInventory_FixedCost;
    }

    public String getVegitable_productId() {
        return vegitable_productId;
    }

    public void setVegitable_productId(String vegitable_productId) {
        this.vegitable_productId = vegitable_productId;
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

    public String getVegitable_variant() {
        return vegitable_variant;
    }

    public void setVegitable_variant(String vegitable_variant) {
        this.vegitable_variant = vegitable_variant;
    }

    public List<VegitableRecipes> getVegitable_Recepie() {
        return vegitable_Recepie;
    }

    public void setVegitable_Recepie(List<VegitableRecipes> vegitable_Recepie) {
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

    public Float getVegitableInventory_CostPrice() {
        return vegitableInventory_CostPrice;
    }

    public void setVegitableInventory_CostPrice(Float vegitableInventory_CostPrice) {
        this.vegitableInventory_CostPrice = vegitableInventory_CostPrice;
    }

    public Date getVegitableInventory_Expiry() {
        return vegitableInventory_Expiry;
    }

    public void setVegitableInventory_Expiry(Date vegitableInventory_Expiry) {
        this.vegitableInventory_Expiry = vegitableInventory_Expiry;
    }

    public Float getVegitableInventory_MaxDiscount() {
        return vegitableInventory_MaxDiscount;
    }

    public void setVegitableInventory_MaxDiscount(Float vegitableInventory_MaxDiscount) {
        this.vegitableInventory_MaxDiscount = vegitableInventory_MaxDiscount;
    }

    public String getVegitableInventory_AddedBy() {
        return vegitableInventory_AddedBy;
    }

    public void setVegitableInventory_AddedBy(String vegitableInventory_AddedBy) {
        this.vegitableInventory_AddedBy = vegitableInventory_AddedBy;
    }

    public String getVegitableInventory_DateTimeAdded() {
        return vegitableInventory_DateTimeAdded;
    }

    public void setVegitableInventory_DateTimeAdded(String vegitableInventory_DateTimeAdded) {
        this.vegitableInventory_DateTimeAdded = vegitableInventory_DateTimeAdded;
    }

    public Float getVegitableInventory_IncCount() {
        return vegitableInventory_IncCount;
    }

    public void setVegitableInventory_IncCount(Float vegitableInventory_IncCount) {
        this.vegitableInventory_IncCount = vegitableInventory_IncCount;
    }

    public Float getVegitableInventory_FixedCost() {
        return vegitableInventory_FixedCost;
    }

    public void setVegitableInventory_FixedCost(Float vegitableInventory_FixedCost) {
        this.vegitableInventory_FixedCost = vegitableInventory_FixedCost;
    }
}
