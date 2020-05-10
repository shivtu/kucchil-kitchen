package com.example.retail.productsmodel.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductsInventory {

    @Id
    @GeneratedValue
    private Integer productsInventory_TableId;

    private String productsInventory_SubId;

    private Float productsInventory_InventoryCount;

    public ProductsInventory(){}

    public ProductsInventory(Integer productsInventory_TableId, String productsInventory_SubId, Float productsInventory_InventoryCount) {
        this.productsInventory_TableId = productsInventory_TableId;
        this.productsInventory_SubId = productsInventory_SubId;
        this.productsInventory_InventoryCount = productsInventory_InventoryCount;
    }

    public Integer getProductsInventory_TableId() {
        return productsInventory_TableId;
    }

    public void setProductsInventory_TableId(Integer productsInventory_TableId) {
        this.productsInventory_TableId = productsInventory_TableId;
    }

    public String getProductsInventory_SubId() {
        return productsInventory_SubId;
    }

    public void setProductsInventory_SubId(String productsInventory_SubId) {
        this.productsInventory_SubId = productsInventory_SubId;
    }

    public Float getProductsInventory_InventoryCount() {
        return productsInventory_InventoryCount;
    }

    public void setProductsInventory_InventoryCount(Float productsInventory_InventoryCount) {
        this.productsInventory_InventoryCount = productsInventory_InventoryCount;
    }
}
