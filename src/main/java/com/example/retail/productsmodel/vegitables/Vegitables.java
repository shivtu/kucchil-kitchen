package com.example.retail.productsmodel.vegitables;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;

@Entity
@Table(name="vegitables")
public class Vegitables {

    @Id
    @GeneratedValue
    @Column(name="vegitable_tableid")
    private Long vegitable_TableId;

    @NotNull
    @NotEmpty
    @Column(name="vagitable_name")
    private String vegitable_Name;

    @Column(name = "vegitable_description")
    private String vegitable_Descp;

    @Column(name = "vegitable_variant")
    private String vegitable_variant;

    @Column(name = "vegitable_recepie")
    private String vegitable_Recepie;

    @Column(name="vegitable_sellingprice")
    private Float vegitable_SellingPrice;

    @Column(name="vegitable_maxdiscount")
    private Float vegitable_MaxDiscount;

    @Column(name = "vegitable_offered_discount")
    private Float vegitable_OfferedDiscount;

    @Column(name = "vegitable_show_discount")
    private Boolean vegitable_ShowDiscount;

    @Column(name="vegitable_quantity")
    private Float vegitable_Quantity;

    private boolean vegitable_Available;

    @Column(name="vegitable_tax")
    private Float vegitable_Tax;

    @Column(name="vegitable_measurementunit")
    private String vegitable_MeasureMentUnit;

    public Vegitables(){
    }


}
