package com.example.retail.models.edibleproducts;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "edibleproduct_inventory")
@TypeDefs({
    @TypeDef(
        name = "psql-jsonb",
        typeClass = JsonBinaryType.class
    )
})
public class EdibleProductsInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edibleproductinventory_tableid")
    private Long edibleProductInventoryTableId;

    @NotNull
    @Column(name = "edibleproductinventory_costprice")
    private Float edibleProductCostPrice;

    @NotNull
    @Column(name = "edibleproductinventory_fixedcost")
    private Float edibleProductFixedCost;

    // Discounted price is the selling price on which profits will be calculated
    @NotNull
    @Column(name = "edibleproductinventory_sellingprice")
    private Float edibleProductSellingPrice;

    @NotNull
    @Column(name = "edibleproductinventory_expiry")
    @Future
    private LocalDate edibleProductInventoryExpiry;

    @NotNull
    @Column(name = "edibleproductinventory_addedby")
    private String edibleProductInventoryAddedBy;

    @NotNull
    @Column(name = "edibleproductinventory_addedon")
    private LocalDateTime edibleProductInventoryAddedOn;

    @NotNull
    @Column(name = "edibleproductinventory_qtyadded")
    private Float edibleProductInventoryQtyAdded;

    @Column(name = "edibleproductinventory_supplier", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<EdibleProductsSupplier> edibleProductsSupplier;

    @NotNull
    @Column(name = "edible_product_subid")
    private String edibleProductSubId;

    public EdibleProductsInventory() {}

    public EdibleProductsInventory(@NotNull Float edibleProductCostPrice, @NotNull Float edibleProductFixedCost,
                                   @NotNull Float edibleProductSellingPrice, @NotNull @Future LocalDate edibleProductInventoryExpiry,
                                   @NotNull String edibleProductInventoryAddedBy, @NotNull LocalDateTime edibleProductInventoryAddedOn,
                                   @NotNull Float edibleProductInventoryQtyAdded, List<EdibleProductsSupplier> edibleProductsSupplier,
                                   @NotNull String edibleProductSubId) {
        this.edibleProductCostPrice = edibleProductCostPrice;
        this.edibleProductFixedCost = edibleProductFixedCost;
        this.edibleProductSellingPrice = edibleProductSellingPrice;
        this.edibleProductInventoryExpiry = edibleProductInventoryExpiry;
        this.edibleProductInventoryAddedBy = edibleProductInventoryAddedBy;
        this.edibleProductInventoryAddedOn = edibleProductInventoryAddedOn;
        this.edibleProductInventoryQtyAdded = edibleProductInventoryQtyAdded;
        this.edibleProductsSupplier = edibleProductsSupplier;
        this.edibleProductSubId = edibleProductSubId;
    }

    public Long getEdibleProductInventoryTableId() {
        return edibleProductInventoryTableId;
    }

    public void setEdibleProductInventoryTableId(Long edibleProductInventoryTableId) {
        this.edibleProductInventoryTableId = edibleProductInventoryTableId;
    }

    public Float getEdibleProductCostPrice() {
        return edibleProductCostPrice;
    }

    public void setEdibleProductCostPrice(Float edibleProductCostPrice) {
        this.edibleProductCostPrice = edibleProductCostPrice;
    }

    public Float getEdibleProductFixedCost() {
        return edibleProductFixedCost;
    }

    public void setEdibleProductFixedCost(Float edibleProductFixedCost) {
        this.edibleProductFixedCost = edibleProductFixedCost;
    }

    public Float getEdibleProductSellingPrice() {
        return edibleProductSellingPrice;
    }

    public void setEdibleProductSellingPrice(Float edibleProductSellingPrice) {
        this.edibleProductSellingPrice = edibleProductSellingPrice;
    }

    public LocalDate getEdibleProductInventoryExpiry() {
        return edibleProductInventoryExpiry;
    }

    public void setEdibleProductInventoryExpiry(LocalDate edibleProductInventoryExpiry) {
        this.edibleProductInventoryExpiry = edibleProductInventoryExpiry;
    }

    public String getEdibleProductInventoryAddedBy() {
        return edibleProductInventoryAddedBy;
    }

    public void setEdibleProductInventoryAddedBy(String edibleProductInventoryAddedBy) {
        this.edibleProductInventoryAddedBy = edibleProductInventoryAddedBy;
    }

    public LocalDateTime getEdibleProductInventoryAddedOn() {
        return edibleProductInventoryAddedOn;
    }

    public void setEdibleProductInventoryAddedOn(LocalDateTime edibleProductInventoryAddedOn) {
        this.edibleProductInventoryAddedOn = edibleProductInventoryAddedOn;
    }

    public Float getEdibleProductInventoryQtyAdded() {
        return edibleProductInventoryQtyAdded;
    }

    public void setEdibleProductInventoryQtyAdded(Float edibleProductInventoryQtyAdded) {
        this.edibleProductInventoryQtyAdded = edibleProductInventoryQtyAdded;
    }

    public List<EdibleProductsSupplier> getEdibleProductsSupplier() {
        return edibleProductsSupplier;
    }

    public void setEdibleProductsSupplier(List<EdibleProductsSupplier> edibleProductsSupplier) {
        this.edibleProductsSupplier = edibleProductsSupplier;
    }

    public String getEdibleProductSubId() {
        return edibleProductSubId;
    }

    public void setEdibleProductSubId(String edibleProductSubId) {
        this.edibleProductSubId = edibleProductSubId;
    }
}
