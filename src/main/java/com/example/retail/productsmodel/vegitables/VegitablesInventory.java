package com.example.retail.productsmodel.vegitables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class VegitablesInventory {

    @Id
    @GeneratedValue
    private Long vegitableInventory_TableId;

    private Float vegitablesInventory_CostPrice;

    private Date vegitablesInventory_Expiry;

    private Float vegitablesInventory_MaxDiscount;

    private String vegitablesInventory_AddedBy;

    private String vegitables_DateTimeAdded;

    private Float vegitables_IncCount;

    private Float vegitables_FixedCost;

    @ManyToOne(targetEntity = Vegitables.class)
    private Vegitables vegitables;

    public VegitablesInventory(){}

    public VegitablesInventory(Float vegitablesInventory_CostPrice, Date vegitablesInventory_Expiry, Float vegitablesInventory_MaxDiscount, String vegitablesInventory_AddedBy, String vegitables_DateTimeAdded, Float vegitables_IncCount, Float vegitables_FixedCost, Vegitables vegitables) {
        this.vegitablesInventory_CostPrice = vegitablesInventory_CostPrice;
        this.vegitablesInventory_Expiry = vegitablesInventory_Expiry;
        this.vegitablesInventory_MaxDiscount = vegitablesInventory_MaxDiscount;
        this.vegitablesInventory_AddedBy = vegitablesInventory_AddedBy;
        this.vegitables_DateTimeAdded = vegitables_DateTimeAdded;
        this.vegitables_IncCount = vegitables_IncCount;
        this.vegitables_FixedCost = vegitables_FixedCost;
        this.vegitables = vegitables;
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

    public Date getVegitablesInventory_Expiry() {
        return vegitablesInventory_Expiry;
    }

    public void setVegitablesInventory_Expiry(Date vegitablesInventory_Expiry) {
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

    public String getVegitables_DateTimeAdded() {
        return vegitables_DateTimeAdded;
    }

    public void setVegitables_DateTimeAdded(String vegitables_DateTimeAdded) {
        this.vegitables_DateTimeAdded = vegitables_DateTimeAdded;
    }

    public Float getVegitables_IncCount() {
        return vegitables_IncCount;
    }

    public void setVegitables_IncCount(Float vegitables_IncCount) {
        this.vegitables_IncCount = vegitables_IncCount;
    }

    public Float getVegitables_FixedCost() {
        return vegitables_FixedCost;
    }

    public void setVegitables_FixedCost(Float vegitables_FixedCost) {
        this.vegitables_FixedCost = vegitables_FixedCost;
    }

    public Vegitables getVegitables() {
        return vegitables;
    }

    public void setVegitables(Vegitables vegitables) {
        this.vegitables = vegitables;
    }
}
