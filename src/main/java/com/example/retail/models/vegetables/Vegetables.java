package com.example.retail.models.vegetables;

import com.example.retail.models.jsonmodels.DenominationList;
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
@Table(name="vegetables")
@TypeDefs({@TypeDef(name = "psql-jsonb", typeClass = JsonBinaryType.class)})
public class Vegetables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vegetable_tableid", updatable = false, nullable = false)
    private Long vegetableTableId;

    @NotEmpty
    @Column(name="vagitable_name")
    private String vegetableName;

    @Column(name = "vegetable_description")
    @Value("No description available")
    private String vegetableDescp;

    @Value("No information available")
    @Column(name = "vegetable_variant")
    private String vegetableVariant;

    @NotEmpty
    @Column(name = "item_category")
    private String itemCategory;

    @NotEmpty
    @NotNull
    @Column(name = "item_sub_category")
    private String itemSubCategory;

    @Column(name = "vegetable_recepie", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<VegetableRecipes> vegetableRecepie = new ArrayList<>();

    @NotNull
    @Column(name="vegetable_selling_price")
    @Min(value = 1, message = "Selling price cannot be less than 1")
    private Float vegetableSellingPrice;

    @Min(value = 0, message = "discounts are expressed in %, valid range 0-100")
    @Column(name = "vegetable_offered_discount")
    private Float vegetableOfferedDiscount;

    @NotNull
    @Column(name = "vegetable_offered_discount_name")
    private String vegetableOfferedDiscountName;

    @NotNull
    @Column(name = "vagitable_discounted_price")
    private Float vegetableDiscountedPrice;

    @NotEmpty
    @Column(name = "vegetable_applicable_taxes")
    @ElementCollection // corrosponding table - vegetables_vegetable_applicable_taxes
    private List<String> vegetableApplicableTaxes = new ArrayList<>();

    @NotNull
    @Column(name = "vagitable_taxed_price")
    private Float vegetableTaxedPrice;

    @Min(value = 1)
    @Column(name="vegetable_quantity")
    private Float vegetableQuantity;

    @NotNull
    @Column(name = "vegetable_available")
    private Boolean vegetableAvailable;

    @NotEmpty
    @Column(name="vegetable_measurement_unit")
    private String vegetableMeasureMentUnit;

    @Column(name = "vegetable_denomination_list",columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<DenominationList> denominationList = new ArrayList<>();

    @NotNull
    @Column(name = "vegetable_subid", updatable = false)
    private String vegetableSubId;

    @NotNull
    @Column(name = "vegetable_images_location")
    @ElementCollection // corrosponding table - vegetables_vegetable_images
    private List<String> vegetableImages = new ArrayList<>();

    public Vegetables(){
    }

    public Vegetables(@NotEmpty String vegetableName, String vegetableDescp, String vegetableVariant, @NotEmpty String itemCategory, @NotEmpty @NotNull String itemSubCategory, List<VegetableRecipes> vegetableRecepie, @NotNull @Min(value = 1, message = "Selling price cannot be less than 1") Float vegetableSellingPrice, @Min(value = 0, message = "discounts are expressed in %, valid range 0-100") Float vegetableOfferedDiscount, @NotNull String vegetableOfferedDiscountName, @NotNull Float vegetableDiscountedPrice, @NotEmpty List<String> vegetableApplicableTaxes, @NotNull Float vegetableTaxedPrice, @Min(value = 1) Float vegetableQuantity, @NotNull Boolean vegetableAvailable, @NotEmpty String vegetableMeasureMentUnit, @NotEmpty List<DenominationList> denominationList, @NotNull String vegetableSubId, @NotNull List<String> vegetableImages) {
        this.vegetableName = vegetableName;
        this.vegetableDescp = vegetableDescp;
        this.vegetableVariant = vegetableVariant;
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.vegetableRecepie = vegetableRecepie;
        this.vegetableSellingPrice = vegetableSellingPrice;
        this.vegetableOfferedDiscount = vegetableOfferedDiscount;
        this.vegetableOfferedDiscountName = vegetableOfferedDiscountName;
        this.vegetableDiscountedPrice = vegetableDiscountedPrice;
        this.vegetableApplicableTaxes = vegetableApplicableTaxes;
        this.vegetableTaxedPrice = vegetableTaxedPrice;
        this.vegetableQuantity = vegetableQuantity;
        this.vegetableAvailable = vegetableAvailable;
        this.vegetableMeasureMentUnit = vegetableMeasureMentUnit;
        this.denominationList = denominationList;
        this.vegetableSubId = vegetableSubId;
        this.vegetableImages = vegetableImages;
    }

    public Long getVegetableTableId() {
        return vegetableTableId;
    }

    public void setVegetableTableId(Long vegetableTableId) {
        this.vegetableTableId = vegetableTableId;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public String getVegetableDescp() {
        return vegetableDescp;
    }

    public void setVegetableDescp(String vegetableDescp) {
        this.vegetableDescp = vegetableDescp;
    }

    public String getVegetableVariant() {
        return vegetableVariant;
    }

    public void setVegetableVariant(String vegetableVariant) {
        this.vegetableVariant = vegetableVariant;
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

    public List<VegetableRecipes> getVegetableRecepie() {
        return vegetableRecepie;
    }

    public void setVegetableRecepie(List<VegetableRecipes> vegetableRecepie) {
        this.vegetableRecepie = vegetableRecepie;
    }

    public Float getVegetableSellingPrice() {
        return vegetableSellingPrice;
    }

    public void setVegetableSellingPrice(Float vegetableSellingPrice) {
        this.vegetableSellingPrice = vegetableSellingPrice;
    }

    public Float getVegetableOfferedDiscount() {
        return vegetableOfferedDiscount;
    }

    public void setVegetableOfferedDiscount(Float vegetableOfferedDiscount) {
        this.vegetableOfferedDiscount = vegetableOfferedDiscount;
    }

    public String getVegetableOfferedDiscountName() {
        return vegetableOfferedDiscountName;
    }

    public void setVegetableOfferedDiscountName(String vegetableOfferedDiscountName) {
        this.vegetableOfferedDiscountName = vegetableOfferedDiscountName;
    }

    public Float getVegetableDiscountedPrice() {
        return vegetableDiscountedPrice;
    }

    public void setVegetableDiscountedPrice(Float vegetableDiscountedPrice) {
        this.vegetableDiscountedPrice = vegetableDiscountedPrice;
    }

    public List<String> getVegetableApplicableTaxes() {
        return vegetableApplicableTaxes;
    }

    public void setVegetableApplicableTaxes(List<String> vegetableApplicableTaxes) {
        this.vegetableApplicableTaxes = vegetableApplicableTaxes;
    }

    public Float getVegetableTaxedPrice() {
        return vegetableTaxedPrice;
    }

    public void setVegetableTaxedPrice(Float vegetableTaxedPrice) {
        this.vegetableTaxedPrice = vegetableTaxedPrice;
    }

    public Float getVegetableQuantity() {
        return vegetableQuantity;
    }

    public void setVegetableQuantity(Float vegetableQuantity) {
        this.vegetableQuantity = vegetableQuantity;
    }

    public Boolean getVegetableAvailable() {
        return vegetableAvailable;
    }

    public void setVegetableAvailable(Boolean vegetableAvailable) {
        this.vegetableAvailable = vegetableAvailable;
    }

    public String getVegetableMeasureMentUnit() {
        return vegetableMeasureMentUnit;
    }

    public void setVegetableMeasureMentUnit(String vegetableMeasureMentUnit) {
        this.vegetableMeasureMentUnit = vegetableMeasureMentUnit;
    }

    public List<DenominationList> getDenominationList() {
        return denominationList;
    }

    public void setDenominationList(List<DenominationList> denominationList) {
        this.denominationList = denominationList;
    }

    public String getVegetableSubId() {
        return vegetableSubId;
    }

    public void setVegetableSubId(String vegetableSubId) {
        this.vegetableSubId = vegetableSubId;
    }

    public List<String> getVegetableImages() {
        return vegetableImages;
    }

    public void setVegetableImages(List<String> vegetableImages) {
        this.vegetableImages = vegetableImages;
    }
}
