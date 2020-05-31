package com.example.retail.productsmodel.vegitables;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="vegitables")
@TypeDefs({
        @TypeDef(
                name = "psql-jsonb",
                typeClass = JsonBinaryType.class
        )
})
public class Vegitables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vegitable_tableid")
    private Long vegitable_TableId;

    @NotNull
    @NotEmpty
    @Column(name="vagitable_name")
    private String vegitable_Name;

    @Column(name = "vegitable_description")
    private String vegitable_Descp;

    @Column(name = "vegitable_variant")
    private String vegitable_Variant;

    @Column(name = "vegitable_recepie", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<VegitableRecipes> vegitable_Recepie;

    @NotNull
    @Column(name="vegitable_sellingprice")
    private Float vegitable_SellingPrice;

    @Value("0")
    @Column(name = "vegitable_offered_discount")
    private Float vegitable_OfferedDiscount;

    @NotNull(message = "Should discount be available for this item")
    @Column(name = "vegitable_show_discount")
    private Boolean vegitable_ShowDiscount;

    @NotNull
    @Column(name="vegitable_quantity")
    private Float vegitable_Quantity;

    private boolean vegitable_Available;
    @Value("0")
    @Column(name="vegitable_tax")
    private Float vegitable_Tax;

    @NotNull
    @NotEmpty
    @Column(name="vegitable_measurementunit")
    private String vegitable_MeasureMentUnit;

    @Column(name = "vegitable_subid", updatable = false, unique = true)
    private String vegitable_SubId;

    public Vegitables(){
    }

    public Vegitables(@NotNull @NotEmpty String vegitable_Name, String vegitable_Descp, String vegitable_Variant, List<VegitableRecipes> vegitable_Recepie, @NotNull Float vegitable_SellingPrice, Float vegitable_OfferedDiscount, @NotNull(message = "Should discount be available for this item") Boolean vegitable_ShowDiscount, @NotNull Float vegitable_Quantity, boolean vegitable_Available, Float vegitable_Tax, @NotNull @NotEmpty String vegitable_MeasureMentUnit, String vegitable_SubId) {
        this.vegitable_Name = vegitable_Name;
        this.vegitable_Descp = vegitable_Descp;
        this.vegitable_Variant = vegitable_Variant;
        this.vegitable_Recepie = vegitable_Recepie;
        this.vegitable_SellingPrice = vegitable_SellingPrice;
        this.vegitable_OfferedDiscount = vegitable_OfferedDiscount;
        this.vegitable_ShowDiscount = vegitable_ShowDiscount;
        this.vegitable_Quantity = vegitable_Quantity;
        this.vegitable_Available = vegitable_Available;
        this.vegitable_Tax = vegitable_Tax;
        this.vegitable_MeasureMentUnit = vegitable_MeasureMentUnit;
        this.vegitable_SubId = vegitable_SubId;
    }

    public Long getVegitable_TableId() {
        return vegitable_TableId;
    }

    public void setVegitable_TableId(Long vegitable_TableId) {
        this.vegitable_TableId = vegitable_TableId;
    }

    public String getVegitable_Name() {
        return vegitable_Name;
    }

    public void setVegitable_Name(String vegitable_Name) {
        this.vegitable_Name = vegitable_Name;
    }

    public String getVegitable_Descp() {
        return vegitable_Descp;
    }

    public void setVegitable_Descp(String vegitable_Descp) {
        this.vegitable_Descp = vegitable_Descp;
    }

    public String getVegitable_Variant() {
        return vegitable_Variant;
    }

    public void setVegitable_Variant(String vegitable_Variant) {
        this.vegitable_Variant = vegitable_Variant;
    }

    public List<VegitableRecipes> getVegitable_Recepie() {
        return vegitable_Recepie;
    }

    public void setVegitable_Recepie(List<VegitableRecipes> vegitable_Recepie) {
        this.vegitable_Recepie = vegitable_Recepie;
    }

    public Float getVegitable_SellingPrice() {
        return vegitable_SellingPrice;
    }

    public void setVegitable_SellingPrice(Float vegitable_SellingPrice) {
        this.vegitable_SellingPrice = vegitable_SellingPrice;
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

    public boolean isVegitable_Available() {
        return vegitable_Available;
    }

    public void setVegitable_Available(boolean vegitable_Available) {
        this.vegitable_Available = vegitable_Available;
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

    public String getVegitable_SubId() {
        return vegitable_SubId;
    }

    public void setVegitable_SubId(String vegitable_SubId) {
        this.vegitable_SubId = vegitable_SubId;
    }
}
