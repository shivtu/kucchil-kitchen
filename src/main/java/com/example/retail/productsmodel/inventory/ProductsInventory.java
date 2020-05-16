package com.example.retail.productsmodel.inventory;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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


    private HashMap<String, ArrayList> productsInventory_UpdateDetails; // {"InventoryAddition":[{"dateTimeAdded":"12/5/2019"},{"IncCount":10},{"fixedCost":500}]}

    public ProductsInventory(){}

    public ProductsInventory(String productsInventory_Id, Float productsInventory_CostPrice, Date productsInventory_Expiry, Float productsInventory_MaxDiscount, String productsInventory_AddedBy, HashMap<String, ArrayList> productsInventory_UpdateDetails) {
        this.productsInventory_Id = productsInventory_Id;
        this.productsInventory_CostPrice = productsInventory_CostPrice;
        this.productsInventory_Expiry = productsInventory_Expiry;
        this.productsInventory_MaxDiscount = productsInventory_MaxDiscount;
        this.productsInventory_AddedBy = productsInventory_AddedBy;
        this.productsInventory_UpdateDetails = productsInventory_UpdateDetails;
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

    public HashMap<String, ArrayList> getProductsInventory_UpdateDetails() {
        return productsInventory_UpdateDetails;
    }

    public void setProductsInventory_UpdateDetails(HashMap<String, ArrayList> productsInventory_UpdateDetails) {
        this.productsInventory_UpdateDetails = productsInventory_UpdateDetails;
    }
}
