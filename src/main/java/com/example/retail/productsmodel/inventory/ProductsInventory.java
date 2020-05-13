package com.example.retail.productsmodel.inventory;

import com.fasterxml.jackson.annotation.JsonAlias;

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
}
