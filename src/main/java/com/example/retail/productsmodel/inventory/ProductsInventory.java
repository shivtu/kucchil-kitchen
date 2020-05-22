package com.example.retail.productsmodel.inventory;

import com.example.retail.productsmodel.vegitables.Vegitables;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProductsInventory {

    @Id
    @GeneratedValue
    private Integer productsInventory_TableId;

    @Column(unique = true)
    private String productsInventory_Id; // this is the productsId (productName+addedBy+expiry ...) from other classes

    private Float productsInventory_CostPrice;

    private Date productsInventory_Expiry;

    private Float productsInventory_MaxDiscount;

    private String productsInventory_AddedBy;

    private String dateTimeAdded;

    private Float incCount;

    private Float fixedCost;

//    @ManyToOne
//    private Vegitables vegitables;

    public ProductsInventory(){}

    public ProductsInventory(String productsInventory_Id, Float productsInventory_CostPrice, Date productsInventory_Expiry, Float productsInventory_MaxDiscount, String productsInventory_AddedBy, String dateTimeAdded, Float incCount, Float fixedCost, Vegitables vegitables) {
        this.productsInventory_Id = productsInventory_Id;
        this.productsInventory_CostPrice = productsInventory_CostPrice;
        this.productsInventory_Expiry = productsInventory_Expiry;
        this.productsInventory_MaxDiscount = productsInventory_MaxDiscount;
        this.productsInventory_AddedBy = productsInventory_AddedBy;
        this.dateTimeAdded = dateTimeAdded;
        this.incCount = incCount;
        this.fixedCost = fixedCost;
//        this.vegitables = vegitables;
    }

    public Integer getProductsInventory_TableId() {
        return productsInventory_TableId;
    }

    public void setProductsInventory_TableId(Integer productsInventory_TableId) {
        this.productsInventory_TableId = productsInventory_TableId;
    }

    public String getProductsInventory_Id() {
        return productsInventory_Id;
    }

    public void setProductsInventory_Id(String productsInventory_Id) {
        this.productsInventory_Id = productsInventory_Id;
    }

    public Float getProductsInventory_CostPrice() {
        return productsInventory_CostPrice;
    }

    public void setProductsInventory_CostPrice(Float productsInventory_CostPrice) {
        this.productsInventory_CostPrice = productsInventory_CostPrice;
    }

    public Date getProductsInventory_Expiry() {
        return productsInventory_Expiry;
    }

    public void setProductsInventory_Expiry(Date productsInventory_Expiry) {
        this.productsInventory_Expiry = productsInventory_Expiry;
    }

    public Float getProductsInventory_MaxDiscount() {
        return productsInventory_MaxDiscount;
    }

    public void setProductsInventory_MaxDiscount(Float productsInventory_MaxDiscount) {
        this.productsInventory_MaxDiscount = productsInventory_MaxDiscount;
    }

    public String getProductsInventory_AddedBy() {
        return productsInventory_AddedBy;
    }

    public void setProductsInventory_AddedBy(String productsInventory_AddedBy) {
        this.productsInventory_AddedBy = productsInventory_AddedBy;
    }

    public String getDateTimeAdded() {
        return dateTimeAdded;
    }

    public void setDateTimeAdded(String dateTimeAdded) {
        this.dateTimeAdded = dateTimeAdded;
    }

    public Float getIncCount() {
        return incCount;
    }

    public void setIncCount(Float incCount) {
        this.incCount = incCount;
    }

    public Float getFixedCost() {
        return fixedCost;
    }

    public void setFixedCost(Float fixedCost) {
        this.fixedCost = fixedCost;
    }

//    public Vegitables getVegitables() {
//        return vegitables;
//    }
//
//    public void setVegitables(Vegitables vegitables) {
//        this.vegitables = vegitables;
//    }
}
