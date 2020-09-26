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

    @NotEmpty
    @NotNull
    @Column(name = "item_category")
    private String itemCategory;

    @NotEmpty
    @NotNull
    @Column(name = "item_sub_category")
    private String itemSubCategory;

    @Column(name = "vegitable_recepie", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<VegitableRecipes> vegitableRecepie = new ArrayList<>();

    @NotNull
    @Column(name="vegitable_selling_price")
    @Min(value = 1, message = "Selling price cannot be less than 1")
    private Float vegitableSellingPrice;

    @Min(value = 0, message = "discounts are expressed in %, valid range 0-100")
    @Column(name = "vegitable_offered_discount")
    private Float vegitableOfferedDiscount;

    @NotNull
    @Column(name = "vegitable_offered_discount_name")
    private String vegitableOfferedDiscountName;

    @NotNull
    @Column(name = "vagitable_discounted_price")
    private Float vegitableDiscountedPrice;

    @NotNull
    @Column(name = "vegitable_applicable_taxes")
    @ElementCollection // corrosponding table - vegitables_vegitable_applicable_taxes
    private List<String> vegitableApplicableTaxes = new ArrayList<>();

    @NotNull
    @Column(name = "vagitable_taxed_price")
    private Float vegitableTaxedPrice;

    @NotNull
    @Min(value = 1, message = "Quantity cannot be less than 0")
    @Column(name="vegitable_quantity")
    private Float vegitableQuantity;

    @NotNull(message = "Is this item available")
    @Column(name = "vegitable_available")
    private Boolean vegitableAvailable;

    @NotNull
    @NotEmpty
    @Column(name="vegitable_measurement_unit")
    private String vegitableMeasureMentUnit;

    @Column(name = "vegitable_subid", updatable = false)
    private String vegitableSubId;

    @NotNull
    @Column(name = "vegitable_images_location")
    @ElementCollection // corrosponding table - vegitables_vegitable_images
    private List<String> vegitableImages = new ArrayList<>();

    public Vegitables(){
    }

    public Vegitables(@NotNull @NotEmpty String vegitableName, String vegitableDescp, String vegitableVariant, @NotEmpty @NotNull String itemCategory,
                      @NotEmpty @NotNull String itemSubCategory, List<VegitableRecipes> vegitableRecepie,
                      @NotNull @Min(value = 1, message = "Selling price cannot be less than 1") Float vegitableSellingPrice,
                      @Min(value = 0, message = "discounts are expressed in %, valid range 0-100") Float vegitableOfferedDiscount,
                      @NotNull String vegitableOfferedDiscountName, @NotNull Float vegitableDiscountedPrice,
                      @NotNull List<String> vegitableApplicableTaxes, @NotNull Float vegitableTaxedPrice,
                      @NotNull @Min(value = 1, message = "Quantity cannot be less than 0") Float vegitableQuantity,
                      @NotNull(message = "Is this item available") Boolean vegitableAvailable, @NotNull @NotEmpty String vegitableMeasureMentUnit,
                      String vegitableSubId, @NotNull List<String> vegitableImages) {
        this.vegitableName = vegitableName;
        this.vegitableDescp = vegitableDescp;
        this.vegitableVariant = vegitableVariant;
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.vegitableRecepie = vegitableRecepie;
        this.vegitableSellingPrice = vegitableSellingPrice;
        this.vegitableOfferedDiscount = vegitableOfferedDiscount;
        this.vegitableOfferedDiscountName = vegitableOfferedDiscountName;
        this.vegitableDiscountedPrice = vegitableDiscountedPrice;
        this.vegitableApplicableTaxes = vegitableApplicableTaxes;
        this.vegitableTaxedPrice = vegitableTaxedPrice;
        this.vegitableQuantity = vegitableQuantity;
        this.vegitableAvailable = vegitableAvailable;
        this.vegitableMeasureMentUnit = vegitableMeasureMentUnit;
        this.vegitableSubId = vegitableSubId;
        this.vegitableImages = vegitableImages;
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

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemSubCategory() {
        return itemSubCategory;
    }

    public void setItemSubCategory(String itemSubCategory) {
        this.itemSubCategory = itemSubCategory;
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

    public String getVegitableOfferedDiscountName() {
        return vegitableOfferedDiscountName;
    }

    public void setVegitableOfferedDiscountName(String vegitableOfferedDiscountName) {
        this.vegitableOfferedDiscountName = vegitableOfferedDiscountName;
    }

    public Float getVegitableDiscountedPrice() {
        return vegitableDiscountedPrice;
    }

    public void setVegitableDiscountedPrice(Float vegitableDiscountedPrice) {
        this.vegitableDiscountedPrice = vegitableDiscountedPrice;
    }

    public List<String> getVegitableApplicableTaxes() {
        return vegitableApplicableTaxes;
    }

    public void setVegitableApplicableTaxes(List<String> vegitableApplicableTaxes) {
        this.vegitableApplicableTaxes = vegitableApplicableTaxes;
    }

    public Float getVegitableTaxedPrice() {
        return vegitableTaxedPrice;
    }

    public void setVegitableTaxedPrice(Float vegitableTaxedPrice) {
        this.vegitableTaxedPrice = vegitableTaxedPrice;
    }

    public Float getVegitableQuantity() {
        return vegitableQuantity;
    }

    public void setVegitableQuantity(Float vegitableQuantity) {
        this.vegitableQuantity = vegitableQuantity;
    }

    public Boolean getVegitableAvailable() {
        return vegitableAvailable;
    }

    public void setVegitableAvailable(Boolean vegitableAvailable) {
        this.vegitableAvailable = vegitableAvailable;
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

    public List<String> getVegitableImages() {
        return vegitableImages;
    }

    public void setVegitableImages(List<String> vegitableImages) {
        this.vegitableImages = vegitableImages;
    }
}
