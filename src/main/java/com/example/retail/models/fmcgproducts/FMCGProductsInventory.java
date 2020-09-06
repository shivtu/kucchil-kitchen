package com.example.retail.models.fmcgproducts;

import com.example.retail.models.jsonmodels.Suppliers;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fmcgproduct_inventory")
@TypeDefs({
    @TypeDef(
        name = "psql-jsonb",
        typeClass = JsonBinaryType.class
    )
})
public class FMCGProductsInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fmcgproductinventory_tableid")
    private Long fmcgProductTableId;

    private Float fmcgProductInventoryCostPrice;

    private Float fmcgProductInventoryFixedCost;

    private Float fmcgProductInventorySellingPrice;

    private LocalDate fmcgProductInventoryExpiry;

    private String fmcgProductInventoryAddedBy;

    private LocalDateTime fmcgProductInventoryAddedOn;

    private Float fmcgProductInventoryAddedQty;

    @Type(type = "psql-jsonb")
    private List<Suppliers> suppliers;

    @NotNull
    @Column(name = "fmcg_product_subid")
    private Float fmcgProductSubId;


    public FMCGProductsInventory() {}

    public FMCGProductsInventory(Float fmcgProductInventoryCostPrice, Float fmcgProductInventoryFixedCost,
                                 Float fmcgProductInventorySellingPrice, LocalDate fmcgProductInventoryExpiry,
                                 String fmcgProductInventoryAddedBy, LocalDateTime fmcgProductInventoryAddedOn,
                                 Float fmcgProductInventoryAddedQty, List<Suppliers> suppliers, @NotNull Float fmcgProductSubId) {
        this.fmcgProductInventoryCostPrice = fmcgProductInventoryCostPrice;
        this.fmcgProductInventoryFixedCost = fmcgProductInventoryFixedCost;
        this.fmcgProductInventorySellingPrice = fmcgProductInventorySellingPrice;
        this.fmcgProductInventoryExpiry = fmcgProductInventoryExpiry;
        this.fmcgProductInventoryAddedBy = fmcgProductInventoryAddedBy;
        this.fmcgProductInventoryAddedOn = fmcgProductInventoryAddedOn;
        this.fmcgProductInventoryAddedQty = fmcgProductInventoryAddedQty;
        this.suppliers = suppliers;
        this.fmcgProductSubId = fmcgProductSubId;
    }

    public Long getFmcgProductTableId() {
        return fmcgProductTableId;
    }

    public void setFmcgProductTableId(Long fmcgProductTableId) {
        this.fmcgProductTableId = fmcgProductTableId;
    }

    public Float getFmcgProductInventoryCostPrice() {
        return fmcgProductInventoryCostPrice;
    }

    public void setFmcgProductInventoryCostPrice(Float fmcgProductInventoryCostPrice) {
        this.fmcgProductInventoryCostPrice = fmcgProductInventoryCostPrice;
    }

    public Float getFmcgProductInventoryFixedCost() {
        return fmcgProductInventoryFixedCost;
    }

    public void setFmcgProductInventoryFixedCost(Float fmcgProductInventoryFixedCost) {
        this.fmcgProductInventoryFixedCost = fmcgProductInventoryFixedCost;
    }

    public Float getFmcgProductInventorySellingPrice() {
        return fmcgProductInventorySellingPrice;
    }

    public void setFmcgProductInventorySellingPrice(Float fmcgProductInventorySellingPrice) {
        this.fmcgProductInventorySellingPrice = fmcgProductInventorySellingPrice;
    }

    public LocalDate getFmcgProductInventoryExpiry() {
        return fmcgProductInventoryExpiry;
    }

    public void setFmcgProductInventoryExpiry(LocalDate fmcgProductInventoryExpiry) {
        this.fmcgProductInventoryExpiry = fmcgProductInventoryExpiry;
    }

    public String getFmcgProductInventoryAddedBy() {
        return fmcgProductInventoryAddedBy;
    }

    public void setFmcgProductInventoryAddedBy(String fmcgProductInventoryAddedBy) {
        this.fmcgProductInventoryAddedBy = fmcgProductInventoryAddedBy;
    }

    public LocalDateTime getFmcgProductInventoryAddedOn() {
        return fmcgProductInventoryAddedOn;
    }

    public void setFmcgProductInventoryAddedOn(LocalDateTime fmcgProductInventoryAddedOn) {
        this.fmcgProductInventoryAddedOn = fmcgProductInventoryAddedOn;
    }

    public Float getFmcgProductInventoryAddedQty() {
        return fmcgProductInventoryAddedQty;
    }

    public void setFmcgProductInventoryAddedQty(Float fmcgProductInventoryAddedQty) {
        this.fmcgProductInventoryAddedQty = fmcgProductInventoryAddedQty;
    }

    public List<Suppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Suppliers> suppliers) {
        this.suppliers = suppliers;
    }

    public Float getFmcgProductSubId() {
        return fmcgProductSubId;
    }

    public void setFmcgProductSubId(Float fmcgProductSubId) {
        this.fmcgProductSubId = fmcgProductSubId;
    }
}
