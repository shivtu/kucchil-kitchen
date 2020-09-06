package com.example.retail.models.edibleproducts;

public class EdibleProductsSupplier {

    private String supplierName;
    private String supplierAddress;
    private String supplierContact;

    public EdibleProductsSupplier () {}

    public EdibleProductsSupplier(String supplierName, String supplierAddress, String supplierContact) {
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierContact = supplierContact;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }
}
