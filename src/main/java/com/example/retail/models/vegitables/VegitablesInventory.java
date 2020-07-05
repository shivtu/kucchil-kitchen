package com.example.retail.models.vegitables;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
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
    private Float vegitablesInventoryCostPrice;

    @Future
    @Column(name = "vegitablesinventory_expiry")
    private LocalDate vegitablesInventoryExpiry;

    @Column(name = "vegitablesinventory_maxdiscount")
    @Min(value = 0)
    private Float vegitablesInventoryMaxDiscount;

    @Column(name = "vegitablesinventory_fixedcost")
    private Float vegitablesInventoryFixedCost;

    @Column(name = "vegitablesinventory_addtiondetails", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<VegitableAdditionDetails> vegitablesInventoryAdditionDetails;

    @Column(name = "vegitable_subid")
    private String vegitableSubId;

    public VegitablesInventory() {
    }

    public VegitablesInventory(
            @Min(value = 0, message = "Cost price cannot be 0") Float vegitablesInventoryCostPrice,
            LocalDate vegitablesInventoryExpiry,
            @Min(value = 0) Float vegitablesInventoryMaxDiscount,
            Float vegitablesInventoryFixedCost,
            List<VegitableAdditionDetails> vegitablesInventoryAdditionDetails,
            String vegitableSubId) {
        this.vegitablesInventoryCostPrice = vegitablesInventoryCostPrice;
        this.vegitablesInventoryExpiry = vegitablesInventoryExpiry;
        this.vegitablesInventoryMaxDiscount = vegitablesInventoryMaxDiscount;
        this.vegitablesInventoryFixedCost = vegitablesInventoryFixedCost;
        this.vegitablesInventoryAdditionDetails = vegitablesInventoryAdditionDetails;
        this.vegitableSubId = vegitableSubId;
    }

    public Long getVegitableInventoryTableId() {
        return vegitableInventoryTableId;
    }

    public void setVegitableInventoryTableId(Long vegitableInventoryTableId) {
        this.vegitableInventoryTableId = vegitableInventoryTableId;
    }

    public Float getVegitablesInventoryCostPrice() {
        return vegitablesInventoryCostPrice;
    }

    public void setVegitablesInventoryCostPrice(Float vegitablesInventoryCostPrice) {
        this.vegitablesInventoryCostPrice = vegitablesInventoryCostPrice;
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

    public Float getVegitablesInventoryFixedCost() {
        return vegitablesInventoryFixedCost;
    }

    public void setVegitablesInventoryFixedCost(Float vegitablesInventoryFixedCost) {
        this.vegitablesInventoryFixedCost = vegitablesInventoryFixedCost;
    }

    public List<VegitableAdditionDetails> getVegitablesInventoryAdditionDetails() {
        return vegitablesInventoryAdditionDetails;
    }

    public void setVegitablesInventoryAdditionDetails(List<VegitableAdditionDetails> vegitablesInventoryAdditionDetails) {
        this.vegitablesInventoryAdditionDetails = vegitablesInventoryAdditionDetails;
    }

    public String getVegitableSubId() {
        return vegitableSubId;
    }

    public void setVegitableSubId(String vegitableSubId) {
        this.vegitableSubId = vegitableSubId;
    }
}
