package com.example.retail.controllers.retailer.vegetables_retailer;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UpdateVegetablesInventoryRequest {

    private Float vegetableInventoryCostPrice;

    private Float vegetableInventoryFixedCost;

    private Float vegetableSellingPrice;

    private LocalDate vegetableInventoryExpiry;

    private Float vegetableInventoryMaxDiscount;

    private Float vegetableQuantity;

    public UpdateVegetablesInventoryRequest(){}

    public UpdateVegetablesInventoryRequest(Float vegetableInventoryCostPrice,
                                            Float vegetableInventoryFixedCost,
                                            Float vegetableSellingPrice,
                                            LocalDate vegetableInventoryExpiry,
                                            Float vegetableInventoryMaxDiscount,
                                            Float vegetableQuantity) {
        this.vegetableInventoryCostPrice = vegetableInventoryCostPrice;
        this.vegetableInventoryFixedCost = vegetableInventoryFixedCost;
        this.vegetableSellingPrice = vegetableSellingPrice;
        this.vegetableInventoryExpiry = vegetableInventoryExpiry;
        this.vegetableInventoryMaxDiscount = vegetableInventoryMaxDiscount;
        this.vegetableQuantity = vegetableQuantity;
    }

    public Float getVegetableInventoryCostPrice() {
        return vegetableInventoryCostPrice;
    }

    public void setVegetableInventoryCostPrice(Float vegetableInventoryCostPrice) {
        this.vegetableInventoryCostPrice = vegetableInventoryCostPrice;
    }

    public Float getVegetableInventoryFixedCost() {
        return vegetableInventoryFixedCost;
    }

    public void setVegetableInventoryFixedCost(Float vegetableInventoryFixedCost) {
        this.vegetableInventoryFixedCost = vegetableInventoryFixedCost;
    }

    public Float getVegetableSellingPrice() {
        return vegetableSellingPrice;
    }

    public void setVegetableSellingPrice(Float vegetableSellingPrice) {
        this.vegetableSellingPrice = vegetableSellingPrice;
    }

    public LocalDate getVegetableInventoryExpiry() {
        return vegetableInventoryExpiry;
    }

    public void setVegetableInventoryExpiry(LocalDate vegetableInventoryExpiry) {
        this.vegetableInventoryExpiry = vegetableInventoryExpiry;
    }

    public Float getVegetableInventoryMaxDiscount() {
        return vegetableInventoryMaxDiscount;
    }

    public void setVegetableInventoryMaxDiscount(Float vegetableInventoryMaxDiscount) {
        this.vegetableInventoryMaxDiscount = vegetableInventoryMaxDiscount;
    }

    public Float getVegetableQuantity() {
        return vegetableQuantity;
    }

    public void setVegetableQuantity(Float vegetableQuantity) {
        this.vegetableQuantity = vegetableQuantity;
    }
}
