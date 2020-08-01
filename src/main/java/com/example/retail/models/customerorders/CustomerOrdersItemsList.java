package com.example.retail.models.customerorders;

import org.springframework.stereotype.Component;

@Component
public class CustomerOrdersItemsList {
    private Long productTableId;
    private String productSubId;
    private String productName;
    private String productVariant;
    private Float productQty;
    private String productMeasurementUnit;
    private Float productSellingPrice;
    private Float productDiscountedPrice;
    private Float productTax;

    public CustomerOrdersItemsList() {}

    public CustomerOrdersItemsList(Long productTableId, String productSubId, String productName, String productVariant,
                                   Float productQty, String productMeasurementUnit, Float productSellingPrice,
                                   Float productDiscountedPrice, Float productTax) {

        this.productTableId = productTableId;
        this.productSubId = productSubId;
        this.productName = productName;
        this.productVariant = productVariant;
        this.productQty = productQty;
        this.productMeasurementUnit = productMeasurementUnit;
        this.productSellingPrice = productSellingPrice;
        this.productDiscountedPrice = productDiscountedPrice;
        this.productTax = productTax;
    }

    public Long getProductTableId() {
        return productTableId;
    }

    public void setProductTableId(Long productTableId) {
        this.productTableId = productTableId;
    }

    public String getProductSubId() {
        return productSubId;
    }

    public void setProductSubId(String productSubId) {
        this.productSubId = productSubId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(String productVariant) {
        this.productVariant = productVariant;
    }

    public Float getProductQty() {
        return productQty;
    }

    public void setProductQty(Float productQty) {
        this.productQty = productQty;
    }

    public String getProductMeasurementUnit() {
        return productMeasurementUnit;
    }

    public void setProductMeasurementUnit(String productMeasurementUnit) {
        this.productMeasurementUnit = productMeasurementUnit;
    }

    public Float getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(Float productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public Float getProductDiscountedPrice() {
        return productDiscountedPrice;
    }

    public void setProductDiscountedPrice(Float productDiscountedPrice) {
        this.productDiscountedPrice = productDiscountedPrice;
    }

    public Float getProductTax() {
        return productTax;
    }

    public void setProductTax(Float productTax) {
        this.productTax = productTax;
    }
}
