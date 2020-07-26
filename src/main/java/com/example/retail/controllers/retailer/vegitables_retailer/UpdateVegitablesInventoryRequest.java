package com.example.retail.controllers.retailer.vegitables_retailer;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UpdateVegitablesInventoryRequest {

    private Float vegitablesInventoryCostPrice;

    private Float vegitablesInventoryFixedCost;

    private Float vegitablesInventorySellingPrice;

    private LocalDate vegitablesInventoryExpiry;

    private Float vegitablesInventoryMaxDiscount;

    private Float vegitableQuantity;

    public UpdateVegitablesInventoryRequest(){}

    public UpdateVegitablesInventoryRequest(Float vegitablesInventoryCostPrice,
                                            Float vegitablesInventoryFixedCost,
                                            Float vegitablesInventorySellingPrice,
                                            LocalDate vegitablesInventoryExpiry,
                                            Float vegitablesInventoryMaxDiscount,
                                            Float vegitableQuantity) {
        this.vegitablesInventoryCostPrice = vegitablesInventoryCostPrice;
        this.vegitablesInventoryFixedCost = vegitablesInventoryFixedCost;
        this.vegitablesInventorySellingPrice = vegitablesInventorySellingPrice;
        this.vegitablesInventoryExpiry = vegitablesInventoryExpiry;
        this.vegitablesInventoryMaxDiscount = vegitablesInventoryMaxDiscount;
        this.vegitableQuantity = vegitableQuantity;
    }

    public Float getVegitablesInventoryCostPrice() {
        return vegitablesInventoryCostPrice;
    }

    public void setVegitablesInventoryCostPrice(Float vegitablesInventoryCostPrice) {
        this.vegitablesInventoryCostPrice = vegitablesInventoryCostPrice;
    }

    public Float getVegitablesInventoryFixedCost() {
        return vegitablesInventoryFixedCost;
    }

    public void setVegitablesInventoryFixedCost(Float vegitablesInventoryFixedCost) {
        this.vegitablesInventoryFixedCost = vegitablesInventoryFixedCost;
    }

    public Float getVegitablesInventorySellingPrice() {
        return vegitablesInventorySellingPrice;
    }

    public void setVegitablesInventorySellingPrice(Float vegitablesInventorySellingPrice) {
        this.vegitablesInventorySellingPrice = vegitablesInventorySellingPrice;
    }

    public LocalDate getVegitablesInventoryExpiry() {
        return vegitablesInventoryExpiry;
    }

    public void setVegitablesInventoryExpiry(LocalDate vegitablesInventoryExpiry) {
        this.vegitablesInventoryExpiry = vegitablesInventoryExpiry;
    }

    public Float getVegitablesInventoryMaxDiscount() {
        return vegitablesInventoryMaxDiscount;
    }

    public void setVegitablesInventoryMaxDiscount(Float vegitablesInventoryMaxDiscount) {
        this.vegitablesInventoryMaxDiscount = vegitablesInventoryMaxDiscount;
    }

    public Float getVegitableQuantity() {
        return vegitableQuantity;
    }

    public void setVegitableQuantity(Float vegitableQuantity) {
        this.vegitableQuantity = vegitableQuantity;
    }
}
