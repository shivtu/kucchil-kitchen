package com.example.retail.productsmodel.edibleproducts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class EdibleProducts {

    @Id
    @GeneratedValue
    private Long edibleProducts_TableId;

    @NotNull
    // edibleProducts_Name + edibleProducts_productName + edibleProducts_Manufacturer + edibleProducts_Variant
    // + edibleProducts_Flavor + edibleProducts_Expiry + edibleProducts_Denomination + edibleProducts_CostPrice
    // + edibleProducts_Mrp
    private String edibleProducts_Id;

    // Name given to the product by the manufacturer
    private String edibleProducts_productName;

    // Generic item name
    private String edibleProducts_Name;

    // An alternate name to the generic item name
    private String edibleProducts_AlternaleName;

    // Product category : Example - confectionary, dairy, spices etc
    private String edibleProducts_Category;

    // Manufacturer of the product
    private String edibleProducts_Manufacturer;

    // Variant of the product : Usually the base content of the product : Example - fibre, fruits, vitamin etc
    private String edibleProducts_Variant;

    // How was the product made : Example - manufactured, processed, raw etc
    private String edibleProducts_Type;

    // Flavour of the product
    private String edibleProducts_Flavor;

    // General description of the product
    private String edibleProducts_Desc;

    // Can be safely consumed by minors ?
    private Boolean edibleProducts_ForMinors;

    // Measurement unit of the product : weight, volume etc
    private String edibleProducts_MeasureMentUnit;

    // Denomination of the product as per measurement unit
    private Float edibleProducts_Denomination;

    // Inventory count
    private Integer edibleProducts_InventoryCount;

    // MRP set by govt/manufacturer
    private Float edibleProducts_Mrp;

    // Maximum discount allowed
    private Float edibleProducts_MaxDiscount;

    // Should customer view the discount
    private Float edibleProducts_ShowDiscount;

    // Currently offered discount
    private Float edibleProducts_OfferedDiscount;

    // Tax on the product
    private Float edibleProducts_Tax;

    public EdibleProducts(){}

    public EdibleProducts(@NotNull String edibleProducts_Id, String edibleProducts_productName, String edibleProducts_Name, String edibleProducts_AlternaleName, String edibleProducts_Category, String edibleProducts_Manufacturer, String edibleProducts_Variant, String edibleProducts_Type, String edibleProducts_Flavor, String edibleProducts_Desc, Boolean edibleProducts_ForMinors, String edibleProducts_MeasureMentUnit, Float edibleProducts_Denomination, Integer edibleProducts_InventoryCount, Float edibleProducts_Mrp, Float edibleProducts_MaxDiscount, Float edibleProducts_ShowDiscount, Float edibleProducts_OfferedDiscount, Float edibleProducts_Tax) {
        this.edibleProducts_Id = edibleProducts_Id;
        this.edibleProducts_productName = edibleProducts_productName;
        this.edibleProducts_Name = edibleProducts_Name;
        this.edibleProducts_AlternaleName = edibleProducts_AlternaleName;
        this.edibleProducts_Category = edibleProducts_Category;
        this.edibleProducts_Manufacturer = edibleProducts_Manufacturer;
        this.edibleProducts_Variant = edibleProducts_Variant;
        this.edibleProducts_Type = edibleProducts_Type;
        this.edibleProducts_Flavor = edibleProducts_Flavor;
        this.edibleProducts_Desc = edibleProducts_Desc;
        this.edibleProducts_ForMinors = edibleProducts_ForMinors;
        this.edibleProducts_MeasureMentUnit = edibleProducts_MeasureMentUnit;
        this.edibleProducts_Denomination = edibleProducts_Denomination;
        this.edibleProducts_InventoryCount = edibleProducts_InventoryCount;
        this.edibleProducts_Mrp = edibleProducts_Mrp;
        this.edibleProducts_MaxDiscount = edibleProducts_MaxDiscount;
        this.edibleProducts_ShowDiscount = edibleProducts_ShowDiscount;
        this.edibleProducts_OfferedDiscount = edibleProducts_OfferedDiscount;
        this.edibleProducts_Tax = edibleProducts_Tax;
    }

    public Long getEdibleProducts_TableId() {
        return edibleProducts_TableId;
    }

    public void setEdibleProducts_TableId(Long edibleProducts_TableId) {
        this.edibleProducts_TableId = edibleProducts_TableId;
    }

    public String getEdibleProducts_Id() {
        return edibleProducts_Id;
    }

    public void setEdibleProducts_Id(String edibleProducts_Id) {
        this.edibleProducts_Id = edibleProducts_Id;
    }

    public String getEdibleProducts_productName() {
        return edibleProducts_productName;
    }

    public void setEdibleProducts_productName(String edibleProducts_productName) {
        this.edibleProducts_productName = edibleProducts_productName;
    }

    public String getEdibleProducts_Name() {
        return edibleProducts_Name;
    }

    public void setEdibleProducts_Name(String edibleProducts_Name) {
        this.edibleProducts_Name = edibleProducts_Name;
    }

    public String getEdibleProducts_AlternaleName() {
        return edibleProducts_AlternaleName;
    }

    public void setEdibleProducts_AlternaleName(String edibleProducts_AlternaleName) {
        this.edibleProducts_AlternaleName = edibleProducts_AlternaleName;
    }

    public String getEdibleProducts_Category() {
        return edibleProducts_Category;
    }

    public void setEdibleProducts_Category(String edibleProducts_Category) {
        this.edibleProducts_Category = edibleProducts_Category;
    }

    public String getEdibleProducts_Manufacturer() {
        return edibleProducts_Manufacturer;
    }

    public void setEdibleProducts_Manufacturer(String edibleProducts_Manufacturer) {
        this.edibleProducts_Manufacturer = edibleProducts_Manufacturer;
    }

    public String getEdibleProducts_Variant() {
        return edibleProducts_Variant;
    }

    public void setEdibleProducts_Variant(String edibleProducts_Variant) {
        this.edibleProducts_Variant = edibleProducts_Variant;
    }

    public String getEdibleProducts_Type() {
        return edibleProducts_Type;
    }

    public void setEdibleProducts_Type(String edibleProducts_Type) {
        this.edibleProducts_Type = edibleProducts_Type;
    }

    public String getEdibleProducts_Flavor() {
        return edibleProducts_Flavor;
    }

    public void setEdibleProducts_Flavor(String edibleProducts_Flavor) {
        this.edibleProducts_Flavor = edibleProducts_Flavor;
    }

    public String getEdibleProducts_Desc() {
        return edibleProducts_Desc;
    }

    public void setEdibleProducts_Desc(String edibleProducts_Desc) {
        this.edibleProducts_Desc = edibleProducts_Desc;
    }

    public Boolean getEdibleProducts_ForMinors() {
        return edibleProducts_ForMinors;
    }

    public void setEdibleProducts_ForMinors(Boolean edibleProducts_ForMinors) {
        this.edibleProducts_ForMinors = edibleProducts_ForMinors;
    }

    public String getEdibleProducts_MeasureMentUnit() {
        return edibleProducts_MeasureMentUnit;
    }

    public void setEdibleProducts_MeasureMentUnit(String edibleProducts_MeasureMentUnit) {
        this.edibleProducts_MeasureMentUnit = edibleProducts_MeasureMentUnit;
    }

    public Float getEdibleProducts_Denomination() {
        return edibleProducts_Denomination;
    }

    public void setEdibleProducts_Denomination(Float edibleProducts_Denomination) {
        this.edibleProducts_Denomination = edibleProducts_Denomination;
    }

    public Integer getEdibleProducts_InventoryCount() {
        return edibleProducts_InventoryCount;
    }

    public void setEdibleProducts_InventoryCount(Integer edibleProducts_InventoryCount) {
        this.edibleProducts_InventoryCount = edibleProducts_InventoryCount;
    }

    public Float getEdibleProducts_Mrp() {
        return edibleProducts_Mrp;
    }

    public void setEdibleProducts_Mrp(Float edibleProducts_Mrp) {
        this.edibleProducts_Mrp = edibleProducts_Mrp;
    }

    public Float getEdibleProducts_MaxDiscount() {
        return edibleProducts_MaxDiscount;
    }

    public void setEdibleProducts_MaxDiscount(Float edibleProducts_MaxDiscount) {
        this.edibleProducts_MaxDiscount = edibleProducts_MaxDiscount;
    }

    public Float getEdibleProducts_ShowDiscount() {
        return edibleProducts_ShowDiscount;
    }

    public void setEdibleProducts_ShowDiscount(Float edibleProducts_ShowDiscount) {
        this.edibleProducts_ShowDiscount = edibleProducts_ShowDiscount;
    }

    public Float getEdibleProducts_OfferedDiscount() {
        return edibleProducts_OfferedDiscount;
    }

    public void setEdibleProducts_OfferedDiscount(Float edibleProducts_OfferedDiscount) {
        this.edibleProducts_OfferedDiscount = edibleProducts_OfferedDiscount;
    }

    public Float getEdibleProducts_Tax() {
        return edibleProducts_Tax;
    }

    public void setEdibleProducts_Tax(Float edibleProducts_Tax) {
        this.edibleProducts_Tax = edibleProducts_Tax;
    }
}
