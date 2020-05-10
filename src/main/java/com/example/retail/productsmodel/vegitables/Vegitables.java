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

    @Column(name = "vegitable_sub_id", unique = true)
    private String vegitable_SubId;

    @NotNull
    @NotEmpty
    @Column(name="vagitable_name")
    private String vegitable_Name;

    @Column(name="vegitable_productid")
    private String vegitable_id;

    @Column(name = "vegitable_description")
    private String vegitable_Descp;

    @Column(name = "vegitable_variant")
    private String vegitable_variant;

    @Column(name = "vegitable_consume_before")
    private Date vegitable_ConsumeBefore;

    @Column(name = "vegitable_recepie")
    private String vegitable_Recepie;

    @Column(name="vegitable_costprice")
    private Float vegitable_CostPrice;

    @Column(name = "vegitable_transportation_cost")
    private Float vegitable_TransportationCost;

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

    @Column(name="vegitable_tax")
    private Float vegitable_Tax;

    @Column(name="vegitable_measurementunit")
    private String vegitable_MeasureMentUnit;

    @Column(name = "vegitable_added_by")
    private String vegitable_AddedBy;

    @Column(name = "veitable_addition_details")
    private HashMap vegitable_AdditionDetails;

    public Vegitables(){
    }

    public Vegitables(Long vegitable_TableId, String vegitable_SubId, @NotNull @NotEmpty String vegitable_Name, String vegitable_id, String vegitable_Descp, String vegitable_variant, Date vegitable_ConsumeBefore, String vegitable_Recepie, Float vegitable_CostPrice, Float vegitable_TransportationCost, Float vegitable_SellingPrice, Float vegitable_MaxDiscount, Float vegitable_OfferedDiscount, Boolean vegitable_ShowDiscount, Float vegitable_Quantity, Float vegitable_Tax, String vegitable_MeasureMentUnit, String vegitable_AddedBy, HashMap vegitable_AdditionDetails) {
        this.vegitable_TableId = vegitable_TableId;
        this.vegitable_SubId = vegitable_SubId;
        this.vegitable_Name = vegitable_Name;
        this.vegitable_id = vegitable_id;
        this.vegitable_Descp = vegitable_Descp;
        this.vegitable_variant = vegitable_variant;
        this.vegitable_ConsumeBefore = vegitable_ConsumeBefore;
        this.vegitable_Recepie = vegitable_Recepie;
        this.vegitable_CostPrice = vegitable_CostPrice;
        this.vegitable_TransportationCost = vegitable_TransportationCost;
        this.vegitable_SellingPrice = vegitable_SellingPrice;
        this.vegitable_MaxDiscount = vegitable_MaxDiscount;
        this.vegitable_OfferedDiscount = vegitable_OfferedDiscount;
        this.vegitable_ShowDiscount = vegitable_ShowDiscount;
        this.vegitable_Quantity = vegitable_Quantity;
        this.vegitable_Tax = vegitable_Tax;
        this.vegitable_MeasureMentUnit = vegitable_MeasureMentUnit;
        this.vegitable_AddedBy = vegitable_AddedBy;
        this.vegitable_AdditionDetails = vegitable_AdditionDetails;
    }

    public Long getVegitable_TableId() {
        return vegitable_TableId;
    }

    public void setVegitable_TableId(Long vegitable_TableId) {
        this.vegitable_TableId = vegitable_TableId;
    }

    public String getVegitable_SubId() {
        return vegitable_SubId;
    }

    public void setVegitable_SubId(String vegitable_SubId) {
        this.vegitable_SubId = vegitable_SubId;
    }

    public String getVegitable_Name() {
        return vegitable_Name;
    }

    public void setVegitable_Name(String vegitable_Name) {
        this.vegitable_Name = vegitable_Name;
    }

    public String getVegitable_id() {
        return vegitable_id;
    }

    public void setVegitable_id(String vegitable_id) {
        this.vegitable_id = vegitable_id;
    }

    public String getVegitable_Descp() {
        return vegitable_Descp;
    }

    public void setVegitable_Descp(String vegitable_Descp) {
        this.vegitable_Descp = vegitable_Descp;
    }

    public String getVegitable_variant() {
        return vegitable_variant;
    }

    public void setVegitable_variant(String vegitable_variant) {
        this.vegitable_variant = vegitable_variant;
    }

    public Date getVegitable_ConsumeBefore() {
        return vegitable_ConsumeBefore;
    }

    public void setVegitable_ConsumeBefore(Date vegitable_ConsumeBefore) {
        this.vegitable_ConsumeBefore = vegitable_ConsumeBefore;
    }

    public String getVegitable_Recepie() {
        return vegitable_Recepie;
    }

    public void setVegitable_Recepie(String vegitable_Recepie) {
        this.vegitable_Recepie = vegitable_Recepie;
    }

    public Float getVegitable_CostPrice() {
        return vegitable_CostPrice;
    }

    public void setVegitable_CostPrice(Float vegitable_CostPrice) {
        this.vegitable_CostPrice = vegitable_CostPrice;
    }

    public Float getVegitable_TransportationCost() {
        return vegitable_TransportationCost;
    }

    public void setVegitable_TransportationCost(Float vegitable_TransportationCost) {
        this.vegitable_TransportationCost = vegitable_TransportationCost;
    }

    public Float getVegitable_SellingPrice() {
        return vegitable_SellingPrice;
    }

    public void setVegitable_SellingPrice(Float vegitable_SellingPrice) {
        this.vegitable_SellingPrice = vegitable_SellingPrice;
    }

    public Float getVegitable_MaxDiscount() {
        return vegitable_MaxDiscount;
    }

    public void setVegitable_MaxDiscount(Float vegitable_MaxDiscount) {
        this.vegitable_MaxDiscount = vegitable_MaxDiscount;
    }

    public Float getVegitable_OfferedDiscount() {
        return vegitable_OfferedDiscount;
    }

    public void setVegitable_OfferedDiscount(Float vegitable_OfferedDiscount) {
        this.vegitable_OfferedDiscount = vegitable_OfferedDiscount;
    }

    public Boolean getVegitable_ShowDiscount() {
        return vegitable_ShowDiscount;
    }

    public void setVegitable_ShowDiscount(Boolean vegitable_ShowDiscount) {
        this.vegitable_ShowDiscount = vegitable_ShowDiscount;
    }

    public Float getVegitable_Quantity() {
        return vegitable_Quantity;
    }

    public void setVegitable_Quantity(Float vegitable_Quantity) {
        this.vegitable_Quantity = vegitable_Quantity;
    }

    public Float getVegitable_Tax() {
        return vegitable_Tax;
    }

    public void setVegitable_Tax(Float vegitable_Tax) {
        this.vegitable_Tax = vegitable_Tax;
    }

    public String getVegitable_MeasureMentUnit() {
        return vegitable_MeasureMentUnit;
    }

    public void setVegitable_MeasureMentUnit(String vegitable_MeasureMentUnit) {
        this.vegitable_MeasureMentUnit = vegitable_MeasureMentUnit;
    }

    public String getVegitable_AddedBy() {
        return vegitable_AddedBy;
    }

    public void setVegitable_AddedBy(String vegitable_AddedBy) {
        this.vegitable_AddedBy = vegitable_AddedBy;
    }

    public HashMap getVegitable_AdditionDetails() {
        return vegitable_AdditionDetails;
    }

    public void setVegitable_AdditionDetails(HashMap vegitable_AdditionDetails) {
        this.vegitable_AdditionDetails = vegitable_AdditionDetails;
    }
}
