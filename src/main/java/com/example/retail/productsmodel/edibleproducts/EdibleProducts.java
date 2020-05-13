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


}
