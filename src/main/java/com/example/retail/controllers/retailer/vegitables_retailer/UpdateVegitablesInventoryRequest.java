package com.example.retail.controllers.retailer.vegitables_retailer;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UpdateVegitablesInventoryRequest {

    private Float vegitableInventoryCostPrice;

    private Float vegitableInventoryFixedCost;

    private Float vegitableSellingPrice;

    private LocalDate vegitableInventoryExpiry;

    private Float vegitableInventoryMaxDiscount;

    private Float vegitableQuantity;

    public UpdateVegitablesInventoryRequest(){}

    public UpdateVegitablesInventoryRequest(Float vegitableInventoryCostPrice,
                                            Float vegitableInventoryFixedCost,
                                            Float vegitableSellingPrice,
                                            LocalDate vegitableInventoryExpiry,
                                            Float vegitableInventoryMaxDiscount,
                                            Float vegitableQuantity) {
        this.vegitableInventoryCostPrice = vegitableInventoryCostPrice;
        this.vegitableInventoryFixedCost = vegitableInventoryFixedCost;
        this.vegitableSellingPrice = vegitableSellingPrice;
        this.vegitableInventoryExpiry = vegitableInventoryExpiry;
        this.vegitableInventoryMaxDiscount = vegitableInventoryMaxDiscount;
        this.vegitableQuantity = vegitableQuantity;
    }

    public Float getVegitableInventoryCostPrice() {
        return vegitableInventoryCostPrice;
    }

    public void setVegitableInventoryCostPrice(Float vegitableInventoryCostPrice) {
        this.vegitableInventoryCostPrice = vegitableInventoryCostPrice;
    }

    public Float getVegitableInventoryFixedCost() {
        return vegitableInventoryFixedCost;
    }

    public void setVegitableInventoryFixedCost(Float vegitableInventoryFixedCost) {
        this.vegitableInventoryFixedCost = vegitableInventoryFixedCost;
    }

    public Float getVegitableSellingPrice() {
        return vegitableSellingPrice;
    }

    public void setVegitableSellingPrice(Float vegitableSellingPrice) {
        this.vegitableSellingPrice = vegitableSellingPrice;
    }

    public LocalDate getVegitableInventoryExpiry() {
        return vegitableInventoryExpiry;
    }

    public void setVegitableInventoryExpiry(LocalDate vegitableInventoryExpiry) {
        this.vegitableInventoryExpiry = vegitableInventoryExpiry;
    }

    public Float getVegitableInventoryMaxDiscount() {
        return vegitableInventoryMaxDiscount;
    }

    public void setVegitableInventoryMaxDiscount(Float vegitableInventoryMaxDiscount) {
        this.vegitableInventoryMaxDiscount = vegitableInventoryMaxDiscount;
    }

    public Float getVegitableQuantity() {
        return vegitableQuantity;
    }

    public void setVegitableQuantity(Float vegitableQuantity) {
        this.vegitableQuantity = vegitableQuantity;
    }
}
