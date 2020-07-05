package com.example.retail.models.vegitables;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="vegitables")
@TypeDefs({@TypeDef(name = "psql-jsonb", typeClass = JsonBinaryType.class)})
public class Vegitables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vegitable_tableid")
    private Long vegitableTableId;

    @NotNull
    @NotEmpty
    @Column(name="vagitable_name")
    private String vegitableName;

    @Column(name = "vegitable_description")
    @Value("No description available")
    private String vegitableDescp;

    @Value("No information available")
    @Column(name = "vegitable_variant")
    private String vegitableVariant;

    @Column(name = "vegitable_recepie", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<VegitableRecipes> vegitableRecepie;

    @NotNull
    @Column(name="vegitable_sellingprice")
    @Min(value = 1, message = "Selling price cannot be less than 1")
    private Float vegitableSellingPrice;

    @Min(value = 0)
    @Column(name = "vegitable_offereddiscount")
    private Float vegitableOfferedDiscount;

    @NotNull(message = "Should discount be available for this item")
    @Column(name = "vegitable_showdiscount")
    private Boolean vegitableShowDiscount;

    @NotNull
    @Min(value = 0, message = "Quantity cannot be less than 0")
    @Column(name="vegitable_quantity")
    private Float vegitableQuantity;

    private boolean vegitableAvailable;
    @Value("0")
    @Column(name="vegitable_tax")
    private Float vegitableTax;

    @NotNull
    @NotEmpty
    @Column(name="vegitable_measurementunit")
    private String vegitableMeasureMentUnit;

    @Column(name = "vegitable_subid", updatable = false, unique = true)
    private String vegitableSubId;

    @NotNull
    @Column(name = "vegitable_images_location")
    private ArrayList<String> vegitableImagesLocation;

    public Vegitables(){
    }

    public Vegitables(
            @NotNull @NotEmpty String vegitableName,
            String vegitableDescp, String vegitableVariant,
            List<VegitableRecipes> vegitableRecepie,
            @NotNull @Min(value = 1, message = "Selling price cannot be less than 1") Float vegitableSellingPrice,
            Float vegitableOfferedDiscount,
            @NotNull(message = "Should discount be available for this item") Boolean vegitableShowDiscount,
            @NotNull @Min(value = 0, message = "Quantity cannot be less than 0") Float vegitableQuantity,
            boolean vegitableAvailable,
            Float vegitableTax,
            @NotNull @NotEmpty String vegitableMeasureMentUnit,
            String vegitableSubId, ArrayList<String> vegitableImagesLocation) {
        this.vegitableName = vegitableName;
        this.vegitableDescp = vegitableDescp;
        this.vegitableVariant = vegitableVariant;
        this.vegitableRecepie = vegitableRecepie;
        this.vegitableSellingPrice = vegitableSellingPrice;
        this.vegitableOfferedDiscount = vegitableOfferedDiscount;
        this.vegitableShowDiscount = vegitableShowDiscount;
        this.vegitableQuantity = vegitableQuantity;
        this.vegitableAvailable = vegitableAvailable;
        this.vegitableTax = vegitableTax;
        this.vegitableMeasureMentUnit = vegitableMeasureMentUnit;
        this.vegitableSubId = vegitableSubId;
        this.vegitableImagesLocation = vegitableImagesLocation;
    }

    public Long getVegitableTableId() {
        return vegitableTableId;
    }

    public void setVegitableTableId(Long vegitableTableId) {
        this.vegitableTableId = vegitableTableId;
    }

    public String getVegitableName() {
        return vegitableName;
    }

    public void setVegitableName(String vegitableName) {
        this.vegitableName = vegitableName;
    }

    public String getVegitableDescp() {
        return vegitableDescp;
    }

    public void setVegitableDescp(String vegitableDescp) {
        this.vegitableDescp = vegitableDescp;
    }

    public String getVegitableVariant() {
        return vegitableVariant;
    }

    public void setVegitableVariant(String vegitableVariant) {
        this.vegitableVariant = vegitableVariant;
    }

    public List<VegitableRecipes> getVegitableRecepie() {
        return vegitableRecepie;
    }

    public void setVegitableRecepie(List<VegitableRecipes> vegitableRecepie) {
        this.vegitableRecepie = vegitableRecepie;
    }

    public Float getVegitableSellingPrice() {
        return vegitableSellingPrice;
    }

    public void setVegitableSellingPrice(Float vegitableSellingPrice) {
        this.vegitableSellingPrice = vegitableSellingPrice;
    }

    public Float getVegitableOfferedDiscount() {
        return vegitableOfferedDiscount;
    }

    public void setVegitableOfferedDiscount(Float vegitableOfferedDiscount) {
        this.vegitableOfferedDiscount = vegitableOfferedDiscount;
    }

    public Boolean getVegitableShowDiscount() {
        return vegitableShowDiscount;
    }

    public void setVegitableShowDiscount(Boolean vegitableShowDiscount) {
        this.vegitableShowDiscount = vegitableShowDiscount;
    }

    public Float getVegitableQuantity() {
        return vegitableQuantity;
    }

    public void setVegitableQuantity(Float vegitableQuantity) {
        this.vegitableQuantity = vegitableQuantity;
    }

    public boolean isVegitableAvailable() {
        return vegitableAvailable;
    }

    public void setVegitableAvailable(boolean vegitableAvailable) {
        this.vegitableAvailable = vegitableAvailable;
    }

    public Float getVegitableTax() {
        return vegitableTax;
    }

    public void setVegitableTax(Float vegitableTax) {
        this.vegitableTax = vegitableTax;
    }

    public String getVegitableMeasureMentUnit() {
        return vegitableMeasureMentUnit;
    }

    public void setVegitableMeasureMentUnit(String vegitableMeasureMentUnit) {
        this.vegitableMeasureMentUnit = vegitableMeasureMentUnit;
    }

    public String getVegitableSubId() {
        return vegitableSubId;
    }

    public void setVegitableSubId(String vegitableSubId) {
        this.vegitableSubId = vegitableSubId;
    }

    public ArrayList<String> getVegitableImagesLocation() {
        return vegitableImagesLocation;
    }

    public void setVegitableImagesLocation(ArrayList<String> vegitableImagesLocation) {
        this.vegitableImagesLocation = vegitableImagesLocation;
    }
}
