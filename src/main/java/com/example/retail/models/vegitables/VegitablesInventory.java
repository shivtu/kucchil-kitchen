package com.example.retail.models.vegitables;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vegitables_inventory")
@TypeDefs({
        @TypeDef(
                name = "psql-jsonb",
                typeClass = JsonBinaryType.class
        )
})
public class VegitablesInventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vegitablesinventory_tableid", nullable = false, updatable = false)
    private Long vegitableInventoryTableId;

    @Column(name = "vegitablesinventory_costprice")
    @Min(value = 0, message = "Cost price cannot be 0")
    @NotNull
    private Float vegitableInventoryCostPrice;

    @Column(name = "vegitablesinventory_fixedcost")
    @Min(value = 0, message = "Fixed costs cannot be less than 0")
    @NotNull
    private Float vegitableInventoryFixedCost;

    @Column(name = "vegitablesinventory_sellingprice")
    @Min(value = 0, message = "Selling price cannot be less than 0")
    @NotNull(message = "Selling price is required")
    private Float vegitableInventorySellingPrice;

    @Future
    @Column(name = "vegitablesinventory_expiry")
    @NotNull
    private LocalDate vegitableInventoryExpiry;

    @Column(name = "vegitablesinventory_maxdiscount")
    @Min(value = 0, message = "discounts are expressed in %, valid range 0-100")
    @NotNull
    private Float vegitableInventoryMaxDiscount;

    @Column(name = "vegitablesinventory_addtiondetails", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<VegitableAdditionDetails> vegitableInventoryAdditionDetails;

    @Column(name = "vegitable_subid", updatable = false, unique = true)
    private String vegitableSubId;

    public VegitablesInventory() {}

    public VegitablesInventory(Long vegitableInventoryTableId,
                               @Min(value = 0, message = "Cost price cannot be 0") @NotNull Float vegitableInventoryCostPrice,
                               @Min(value = 0, message = "Fixed costs cannot be less than 0") @NotNull Float vegitableInventoryFixedCost,
                               @Min(value = 0, message = "Selling price cannot be less than 0") @NotNull(message = "Selling price is required") Float vegitableInventorySellingPrice,
                               @Future @NotNull LocalDate vegitableInventoryExpiry,
                               @Min(value = 0, message = "discounts are expressed in %, valid range 0-100") @NotNull Float vegitableInventoryMaxDiscount,
                               List<VegitableAdditionDetails> vegitableInventoryAdditionDetails,
                               String vegitableSubId) {
        this.vegitableInventoryTableId = vegitableInventoryTableId;
        this.vegitableInventoryCostPrice = vegitableInventoryCostPrice;
        this.vegitableInventoryFixedCost = vegitableInventoryFixedCost;
        this.vegitableInventorySellingPrice = vegitableInventorySellingPrice;
        this.vegitableInventoryExpiry = vegitableInventoryExpiry;
        this.vegitableInventoryMaxDiscount = vegitableInventoryMaxDiscount;
        this.vegitableInventoryAdditionDetails = vegitableInventoryAdditionDetails;
        this.vegitableSubId = vegitableSubId;
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

    public Float getVegitableInventorySellingPrice() {
        return vegitableInventorySellingPrice;
    }

    public void setVegitableInventorySellingPrice(Float vegitableInventorySellingPrice) {
        this.vegitableInventorySellingPrice = vegitableInventorySellingPrice;
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

    public List<VegitableAdditionDetails> getVegitableInventoryAdditionDetails() {
        return vegitableInventoryAdditionDetails;
    }

    public void setVegitableInventoryAdditionDetails(List<VegitableAdditionDetails> vegitableInventoryAdditionDetails) {
        this.vegitableInventoryAdditionDetails = vegitableInventoryAdditionDetails;
    }

    public String getVegitableSubId() {
        return vegitableSubId;
    }

    public void setVegitableSubId(String vegitableSubId) {
        this.vegitableSubId = vegitableSubId;
    }
}
