package com.example.retail.productsmodel.vegitables;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "vegitables_inventory")
public class VegitablesInventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vegitablesinventory_tableid", nullable = false, updatable = false)
    private Long vegitableInventory_TableId;

    @Column(name = "vegitablesinventory_costprice")
    private Float vegitablesInventory_CostPrice;

    @Column(name = "vegitablesinventory_expiry")
    private LocalDate vegitablesInventory_Expiry;

    @Column(name = "vegitablesinventory_maxdiscount")
    private Float vegitablesInventory_MaxDiscount;

    @Column(name = "vegitablesinventory_addedby")
    private String vegitablesInventory_AddedBy;

    @Column(name = "vegitablesinventory_datetime_added")
    private String vegitablesInventory_DateTimeAdded;

    @Column(name = "vegitablesinventory_inccount")
    private Float vegitablesInventory_IncCount;

    @Column(name = "vegitablesinventory_fixedcost")
    private Float vegitablesInventory_FixedCost;

    private String vegitable_SubId;

    public VegitablesInventory(){}

    public VegitablesInventory(Float vegitablesInventory_CostPrice, LocalDate vegitablesInventory_Expiry, Float vegitablesInventory_MaxDiscount, String vegitablesInventory_AddedBy, String vegitablesInventory_DateTimeAdded, Float vegitablesInventory_IncCount, Float vegitablesInventory_FixedCost, String vegitable_SubId) {
        this.vegitablesInventory_CostPrice = vegitablesInventory_CostPrice;
        this.vegitablesInventory_Expiry = vegitablesInventory_Expiry;
        this.vegitablesInventory_MaxDiscount = vegitablesInventory_MaxDiscount;
        this.vegitablesInventory_AddedBy = vegitablesInventory_AddedBy;
        this.vegitablesInventory_DateTimeAdded = vegitablesInventory_DateTimeAdded;
        this.vegitablesInventory_IncCount = vegitablesInventory_IncCount;
        this.vegitablesInventory_FixedCost = vegitablesInventory_FixedCost;
        this.vegitable_SubId = vegitable_SubId;
    }

    public Long getVegitableInventory_TableId() {
        return vegitableInventory_TableId;
    }

    public void setVegitableInventory_TableId(Long vegitableInventory_TableId) {
        this.vegitableInventory_TableId = vegitableInventory_TableId;
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

    public String getVegitablesInventory_AddedBy() {
        return vegitablesInventory_AddedBy;
    }

    public void setVegitablesInventory_AddedBy(String vegitablesInventory_AddedBy) {
        this.vegitablesInventory_AddedBy = vegitablesInventory_AddedBy;
    }

    public String getVegitablesInventory_DateTimeAdded() {
        return vegitablesInventory_DateTimeAdded;
    }

    public void setVegitablesInventory_DateTimeAdded(String vegitablesInventory_DateTimeAdded) {
        this.vegitablesInventory_DateTimeAdded = vegitablesInventory_DateTimeAdded;
    }

    public Float getVegitablesInventory_IncCount() {
        return vegitablesInventory_IncCount;
    }

    public void setVegitablesInventory_IncCount(Float vegitablesInventory_IncCount) {
        this.vegitablesInventory_IncCount = vegitablesInventory_IncCount;
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
