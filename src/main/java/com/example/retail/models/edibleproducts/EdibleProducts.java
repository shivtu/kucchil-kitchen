package com.example.retail.models.edibleproducts;

import com.example.retail.models.jsonmodels.DenominationList;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "edible_products")
@TypeDefs({@TypeDef(name = "psql-jsonb", typeClass = JsonBinaryType.class)})
public class EdibleProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="edible_product_tableid")
    private Long edibleProductsTableId;

    // Manufacturer of the product
    @NotNull
    @Column(name = "edible_product_manufacturer")
    private String edibleProductManufacturer;

    // Name given to the product by the manufacturer
    @NotNull
    @Column(name = "edible_product_name")
    private String edibleProductName;

    // Variant of the product : Usually the base content of the product : Example - fibre, fruits, vitamin etc
    @NotNull
    @Column(name = "edible_product_variant")
    private String edibleProductVariant;

    // Flavour of the product
    @Column(name = "edible_product_flavor")
    private String edibleProductFlavor;

    // How was the product made : Example - manufactured, processed, raw etc
    @Column(name = "edible_product_type")
    private String edibleProductType;

    // General description of the product
    @NotNull
    @Column(name = "edible_product_description")
    private String edibleProductDescription;

    @Column(name = "edible_product_image_location")
    @ElementCollection
    private List<String> edibleProductImageLocation = new ArrayList<>();

    // Generic item name
    @NotNull
    @Column(name = "edible_product_generic_name")
    private String edibleProductGenericName;

    // An alternate name to the generic item name
    @Column(name = "edible_product_alternate_name")
    private String edibleProductAlternaleName;

    // Product category : Example - confectionary, dairy, spices etc
    @NotNull
    @Column(name = "item_category")
    private String itemCategory;

    @NotEmpty
    @NotNull
    @Column(name = "item_sub_category")
    private String itemSubCategory;

    // Can be safely consumed by minors ?
    @Column(name = "edible_product_for_minors")
    private Boolean edibleProductForMinors;

    @NotNull
    @Column(name = "edible_product_available")
    private Boolean edibleProductAvailable;

    // MRP set by govt/manufacturer
    @NotNull
    @Column(name = "edible_product_mrp")
    private Float edibleProductMrp;

    // offered discount
    @NotNull
    @Column(name = "edible_product_offered_discount")
    private Float edibleProductOfferedDiscount;

    @NotNull
    @Column(name = "edible_product_discount_name")
    private String edibleProductsDiscountName;

    @NotNull
    @Column(name = "edible_product_discounted_price")
   private Float edibleProductDiscountedPrice;

    @NotNull
    @Column(name = "edible_product_applicable_taxes")
    @ElementCollection
    private List<String> edibleProductApplicableTaxes = new ArrayList<>();

    @NotNull
    @Column(name = "edible_product_taxed_price")
    private Float edibleProductTaxedPrice;

    // Inventory count
    @NotNull
    @Column(name = "edible_product_quantity")
    private Float edibleProductQuantity;

    // Measurement unit of the product : weight, volume etc
    @NotNull
    @Column(name = "edible_product_measurement_unit")
    private String edibleProductsMeasureMentUnit;

    // Denomination of the product as per measurement unit
    @NotNull
    @Column(name = "edible_product_denomination")
    private Float edibleProductDenomination;

    // edibleProducts_Name + edibleProducts_productName + edibleProducts_Manufacturer + edibleProducts_Variant
    // + edibleProducts_Flavor + edibleProducts_Expiry + edibleProducts_Denomination
    @NotNull
    @Column(name = "edible_product_subid")
    private String edibleProductSubId;

    public EdibleProducts(){}

    public EdibleProducts(@NotNull String edibleProductManufacturer, @NotNull String edibleProductName,
                          @NotNull String edibleProductVariant, String edibleProductFlavor, String edibleProductType,
                          @NotNull String edibleProductDescription, List<String> edibleProductImageLocation,
                          @NotNull String edibleProductGenericName, String edibleProductAlternaleName, @NotNull String itemCategory,
                          @NotEmpty @NotNull String itemSubCategory, Boolean edibleProductForMinors,
                          @NotNull Boolean edibleProductAvailable, @NotNull Float edibleProductMrp,
                          @NotNull Float edibleProductOfferedDiscount, @NotNull String edibleProductsDiscountName,
                          @NotNull Float edibleProductDiscountedPrice, @NotNull List<String> edibleProductApplicableTaxes,
                          @NotNull Float edibleProductTaxedPrice, @NotNull Float edibleProductQuantity,
                          @NotNull String edibleProductsMeasureMentUnit, @NotNull Float edibleProductDenomination,
                          @NotNull String edibleProductSubId) {
        this.edibleProductManufacturer = edibleProductManufacturer;
        this.edibleProductName = edibleProductName;
        this.edibleProductVariant = edibleProductVariant;
        this.edibleProductFlavor = edibleProductFlavor;
        this.edibleProductType = edibleProductType;
        this.edibleProductDescription = edibleProductDescription;
        this.edibleProductImageLocation = edibleProductImageLocation;
        this.edibleProductGenericName = edibleProductGenericName;
        this.edibleProductAlternaleName = edibleProductAlternaleName;
        this.itemCategory = itemCategory;
        this.itemSubCategory = itemSubCategory;
        this.edibleProductForMinors = edibleProductForMinors;
        this.edibleProductAvailable = edibleProductAvailable;
        this.edibleProductMrp = edibleProductMrp;
        this.edibleProductOfferedDiscount = edibleProductOfferedDiscount;
        this.edibleProductsDiscountName = edibleProductsDiscountName;
        this.edibleProductDiscountedPrice = edibleProductDiscountedPrice;
        this.edibleProductApplicableTaxes = edibleProductApplicableTaxes;
        this.edibleProductTaxedPrice = edibleProductTaxedPrice;
        this.edibleProductQuantity = edibleProductQuantity;
        this.edibleProductsMeasureMentUnit = edibleProductsMeasureMentUnit;
        this.edibleProductDenomination = edibleProductDenomination;
        this.edibleProductSubId = edibleProductSubId;
    }

    public Long getEdibleProductsTableId() {
        return edibleProductsTableId;
    }

    public void setEdibleProductsTableId(Long edibleProductsTableId) {
        this.edibleProductsTableId = edibleProductsTableId;
    }

    public String getEdibleProductManufacturer() {
        return edibleProductManufacturer;
    }

    public void setEdibleProductManufacturer(String edibleProductManufacturer) {
        this.edibleProductManufacturer = edibleProductManufacturer;
    }

    public String getEdibleProductName() {
        return edibleProductName;
    }

    public void setEdibleProductName(String edibleProductName) {
        this.edibleProductName = edibleProductName;
    }

    public String getEdibleProductVariant() {
        return edibleProductVariant;
    }

    public void setEdibleProductVariant(String edibleProductVariant) {
        this.edibleProductVariant = edibleProductVariant;
    }

    public String getEdibleProductFlavor() {
        return edibleProductFlavor;
    }

    public void setEdibleProductFlavor(String edibleProductFlavor) {
        this.edibleProductFlavor = edibleProductFlavor;
    }

    public String getEdibleProductType() {
        return edibleProductType;
    }

    public void setEdibleProductType(String edibleProductType) {
        this.edibleProductType = edibleProductType;
    }

    public String getEdibleProductDescription() {
        return edibleProductDescription;
    }

    public void setEdibleProductDescription(String edibleProductDescription) {
        this.edibleProductDescription = edibleProductDescription;
    }

    public List<String> getEdibleProductImageLocation() {
        return edibleProductImageLocation;
    }

    public void setEdibleProductImageLocation(List<String> edibleProductImageLocation) {
        this.edibleProductImageLocation = edibleProductImageLocation;
    }

    public String getEdibleProductGenericName() {
        return edibleProductGenericName;
    }

    public void setEdibleProductGenericName(String edibleProductGenericName) {
        this.edibleProductGenericName = edibleProductGenericName;
    }

    public String getEdibleProductAlternaleName() {
        return edibleProductAlternaleName;
    }

    public void setEdibleProductAlternaleName(String edibleProductAlternaleName) {
        this.edibleProductAlternaleName = edibleProductAlternaleName;
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

    public Boolean getEdibleProductForMinors() {
        return edibleProductForMinors;
    }

    public void setEdibleProductForMinors(Boolean edibleProductForMinors) {
        this.edibleProductForMinors = edibleProductForMinors;
    }

    public Boolean getEdibleProductAvailable() {
        return edibleProductAvailable;
    }

    public void setEdibleProductAvailable(Boolean edibleProductAvailable) {
        this.edibleProductAvailable = edibleProductAvailable;
    }

    public Float getEdibleProductMrp() {
        return edibleProductMrp;
    }

    public void setEdibleProductMrp(Float edibleProductMrp) {
        this.edibleProductMrp = edibleProductMrp;
    }

    public Float getEdibleProductOfferedDiscount() {
        return edibleProductOfferedDiscount;
    }

    public void setEdibleProductOfferedDiscount(Float edibleProductOfferedDiscount) {
        this.edibleProductOfferedDiscount = edibleProductOfferedDiscount;
    }

    public String getEdibleProductsDiscountName() {
        return edibleProductsDiscountName;
    }

    public void setEdibleProductsDiscountName(String edibleProductsDiscountName) {
        this.edibleProductsDiscountName = edibleProductsDiscountName;
    }

    public Float getEdibleProductDiscountedPrice() {
        return edibleProductDiscountedPrice;
    }

    public void setEdibleProductDiscountedPrice(Float edibleProductDiscountedPrice) {
        this.edibleProductDiscountedPrice = edibleProductDiscountedPrice;
    }

    public List<String> getEdibleProductApplicableTaxes() {
        return edibleProductApplicableTaxes;
    }

    public void setEdibleProductApplicableTaxes(List<String> edibleProductApplicableTaxes) {
        this.edibleProductApplicableTaxes = edibleProductApplicableTaxes;
    }

    public Float getEdibleProductTaxedPrice() {
        return edibleProductTaxedPrice;
    }

    public void setEdibleProductTaxedPrice(Float edibleProductTaxedPrice) {
        this.edibleProductTaxedPrice = edibleProductTaxedPrice;
    }

    public Float getEdibleProductQuantity() {
        return edibleProductQuantity;
    }

    public void setEdibleProductQuantity(Float edibleProductQuantity) {
        this.edibleProductQuantity = edibleProductQuantity;
    }

    public String getEdibleProductsMeasureMentUnit() {
        return edibleProductsMeasureMentUnit;
    }

    public void setEdibleProductsMeasureMentUnit(String edibleProductsMeasureMentUnit) {
        this.edibleProductsMeasureMentUnit = edibleProductsMeasureMentUnit;
    }

    public Float getEdibleProductDenomination() {
        return edibleProductDenomination;
    }

    public void setEdibleProductDenomination(Float edibleProductDenomination) {
        this.edibleProductDenomination = edibleProductDenomination;
    }

    public String getEdibleProductSubId() {
        return edibleProductSubId;
    }

    public void setEdibleProductSubId(String edibleProductSubId) {
        this.edibleProductSubId = edibleProductSubId;
    }
}
