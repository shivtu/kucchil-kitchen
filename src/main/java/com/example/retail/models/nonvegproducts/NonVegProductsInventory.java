package com.example.retail.models.nonvegproducts;

import com.example.retail.models.jsonmodels.Suppliers;
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
@Table(name = "non-veg_products_inventory")
@TypeDefs({
    @TypeDef(
        name = "psql-jsonb",
        typeClass = JsonBinaryType.class
    )
})
public class NonVegProductsInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nonvegproductinventory_tableid")
    private Long nonVegProductInventoryTableId;

    @NotNull
    @Column(name = "edibleproductinventory_costprice")
    private Float nonVegProductCostPrice;

    @NotNull
    @Column(name = "edibleproductinventory_fixedcost")
    private Float nonVegProductFixedCost;

    // Discounted price is the selling price on which profits will be calculated
    @NotNull
    @Column(name = "edibleproductinventory_sellingprice")
    private Float nonVegProductSellingPrice;

    @NotNull
    @Column(name = "edibleproductinventory_expiry")
    @Future
    private LocalDate nonVegProductInventoryExpiry;

    @NotNull
    @Column(name = "edibleproductinventory_addedby")
    private String edibleProductInventoryAddedBy;

    @NotNull
    @Column(name = "edibleproductinventory_addedon")
    private LocalDateTime nonVegProductInventoryAddedOn;

    @NotNull
    @Column(name = "edibleproductinventory_qtyadded")
    private Float nonVegProductInventoryQtyAdded;

    @Column(name = "edibleproductinventory_supplier", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<Suppliers> suppliers;

    @NotNull
    @Column(name = "edible_product_subid")
    private String edibleProductSubId;

    public NonVegProductsInventory() {}

    public NonVegProductsInventory(@NotNull Float nonVegProductCostPrice, @NotNull Float nonVegProductFixedCost,
                                   @NotNull Float nonVegProductSellingPrice, @NotNull @Future LocalDate nonVegProductInventoryExpiry,
                                   @NotNull String edibleProductInventoryAddedBy, @NotNull LocalDateTime nonVegProductInventoryAddedOn,
                                   @NotNull Float nonVegProductInventoryQtyAdded, List<Suppliers> suppliers, @NotNull String edibleProductSubId) {
        this.nonVegProductCostPrice = nonVegProductCostPrice;
        this.nonVegProductFixedCost = nonVegProductFixedCost;
        this.nonVegProductSellingPrice = nonVegProductSellingPrice;
        this.nonVegProductInventoryExpiry = nonVegProductInventoryExpiry;
        this.edibleProductInventoryAddedBy = edibleProductInventoryAddedBy;
        this.nonVegProductInventoryAddedOn = nonVegProductInventoryAddedOn;
        this.nonVegProductInventoryQtyAdded = nonVegProductInventoryQtyAdded;
        this.suppliers = suppliers;
        this.edibleProductSubId = edibleProductSubId;
    }

    public Long getNonVegProductInventoryTableId() {
        return nonVegProductInventoryTableId;
    }

    public void setNonVegProductInventoryTableId(Long nonVegProductInventoryTableId) {
        this.nonVegProductInventoryTableId = nonVegProductInventoryTableId;
    }

    public Float getNonVegProductCostPrice() {
        return nonVegProductCostPrice;
    }

    public void setNonVegProductCostPrice(Float nonVegProductCostPrice) {
        this.nonVegProductCostPrice = nonVegProductCostPrice;
    }

    public Float getNonVegProductFixedCost() {
        return nonVegProductFixedCost;
    }

    public void setNonVegProductFixedCost(Float nonVegProductFixedCost) {
        this.nonVegProductFixedCost = nonVegProductFixedCost;
    }

    public Float getNonVegProductSellingPrice() {
        return nonVegProductSellingPrice;
    }

    public void setNonVegProductSellingPrice(Float nonVegProductSellingPrice) {
        this.nonVegProductSellingPrice = nonVegProductSellingPrice;
    }

    public LocalDate getNonVegProductInventoryExpiry() {
        return nonVegProductInventoryExpiry;
    }

    public void setNonVegProductInventoryExpiry(LocalDate nonVegProductInventoryExpiry) {
        this.nonVegProductInventoryExpiry = nonVegProductInventoryExpiry;
    }

    public String getEdibleProductInventoryAddedBy() {
        return edibleProductInventoryAddedBy;
    }

    public void setEdibleProductInventoryAddedBy(String edibleProductInventoryAddedBy) {
        this.edibleProductInventoryAddedBy = edibleProductInventoryAddedBy;
    }

    public LocalDateTime getNonVegProductInventoryAddedOn() {
        return nonVegProductInventoryAddedOn;
    }

    public void setNonVegProductInventoryAddedOn(LocalDateTime nonVegProductInventoryAddedOn) {
        this.nonVegProductInventoryAddedOn = nonVegProductInventoryAddedOn;
    }

    public Float getNonVegProductInventoryQtyAdded() {
        return nonVegProductInventoryQtyAdded;
    }

    public void setNonVegProductInventoryQtyAdded(Float nonVegProductInventoryQtyAdded) {
        this.nonVegProductInventoryQtyAdded = nonVegProductInventoryQtyAdded;
    }

    public List<Suppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Suppliers> suppliers) {
        this.suppliers = suppliers;
    }

    public String getEdibleProductSubId() {
        return edibleProductSubId;
    }

    public void setEdibleProductSubId(String edibleProductSubId) {
        this.edibleProductSubId = edibleProductSubId;
    }
}
