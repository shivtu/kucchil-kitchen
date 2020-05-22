package com.example.retail.productsmodel.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    public ProductsInventory(){}


}
