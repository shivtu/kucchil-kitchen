package com.example.retail.models.vegetables;

import com.example.retail.models.jsonmodels.InventoryAdditionDetails;
import com.example.retail.models.jsonmodels.Suppliers;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vegetables_inventory")
@TypeDefs({
    @TypeDef(
        name = "psql-jsonb",
        typeClass = JsonBinaryType.class
    )
})
public class VegetablesInventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vegetablesinventory_tableid", nullable = false, updatable = false)
    private Long vegetableInventoryTableId;

    @Column(name = "vegetablesinventory_costprice")
    @Min(value = 0, message = "Cost price cannot be 0")
    @NotNull
    private Float vegetableInventoryCostPrice;

    @Column(name = "vegetablesinventory_fixedcost")
    @Min(value = 0, message = "Fixed costs cannot be less than 0")
    @NotNull
    private Float vegetableInventoryFixedCost;

    // Discounted price is the selling price on which profits will be calculated
    @Column(name = "vegetablesinventory_sellingprice")
    @Min(value = 0, message = "Selling price cannot be less than 0")
    @NotNull(message = "Selling price is required")
    private Float vegetableInventorySellingPrice;

    @Future
    @Column(name = "vegetablesinventory_expiry")
    @NotNull
    private LocalDate vegetableInventoryExpiry;

//    @Column(name = "vegetablesinventory_maxdiscount")
//    @Min(value = 0, message = "discounts are expressed in %, valid range 0-100")
//    @NotNull
//    private Float vegetableInventoryMaxDiscount;

    @Column(name = "vegetablesinventory_addtiondetails", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<InventoryAdditionDetails> vegetableInventoryAdditionDetails = new ArrayList<>();

    @Column(name = "vegetablesinventory__supplier", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<Suppliers> suppliers = new ArrayList<>();

    @Column(name = "vegetable_subid", updatable = false, unique = true)
    private String vegetableSubId;

    public VegetablesInventory() {}

    public VegetablesInventory(@Min(value = 0, message = "Cost price cannot be 0") @NotNull Float vegetableInventoryCostPrice,
                               @Min(value = 0, message = "Fixed costs cannot be less than 0") @NotNull Float vegetableInventoryFixedCost,
                               @Min(value = 0, message = "Selling price cannot be less than 0") @NotNull(message = "Selling price is required") Float vegetableInventorySellingPrice,
                               @Future @NotNull LocalDate vegetableInventoryExpiry, List<InventoryAdditionDetails> vegetableInventoryAdditionDetails,
                               List<Suppliers> suppliers, String vegetableSubId) {
        this.vegetableInventoryCostPrice = vegetableInventoryCostPrice;
        this.vegetableInventoryFixedCost = vegetableInventoryFixedCost;
        this.vegetableInventorySellingPrice = vegetableInventorySellingPrice;
        this.vegetableInventoryExpiry = vegetableInventoryExpiry;
        this.vegetableInventoryAdditionDetails = vegetableInventoryAdditionDetails;
        this.suppliers = suppliers;
        this.vegetableSubId = vegetableSubId;
    }

    public Long getVegetableInventoryTableId() {
        return vegetableInventoryTableId;
    }

    public void setVegetableInventoryTableId(Long vegetableInventoryTableId) {
        this.vegetableInventoryTableId = vegetableInventoryTableId;
    }

    public Float getVegetableInventoryCostPrice() {
        return vegetableInventoryCostPrice;
    }

    public void setVegetableInventoryCostPrice(Float vegetableInventoryCostPrice) {
        this.vegetableInventoryCostPrice = vegetableInventoryCostPrice;
    }

    public Float getVegetableInventoryFixedCost() {
        return vegetableInventoryFixedCost;
    }

    public void setVegetableInventoryFixedCost(Float vegetableInventoryFixedCost) {
        this.vegetableInventoryFixedCost = vegetableInventoryFixedCost;
    }

    public Float getVegetableInventorySellingPrice() {
        return vegetableInventorySellingPrice;
    }

    public void setVegetableInventorySellingPrice(Float vegetableInventorySellingPrice) {
        this.vegetableInventorySellingPrice = vegetableInventorySellingPrice;
    }

    public LocalDate getVegetableInventoryExpiry() {
        return vegetableInventoryExpiry;
    }

    public void setVegetableInventoryExpiry(LocalDate vegetableInventoryExpiry) {
        this.vegetableInventoryExpiry = vegetableInventoryExpiry;
    }

    public List<InventoryAdditionDetails> getVegetableInventoryAdditionDetails() {
        return vegetableInventoryAdditionDetails;
    }

    public void setVegetableInventoryAdditionDetails(List<InventoryAdditionDetails> vegetableInventoryAdditionDetails) {
        this.vegetableInventoryAdditionDetails = vegetableInventoryAdditionDetails;
    }

    public List<Suppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Suppliers> suppliers) {
        this.suppliers = suppliers;
    }

    public String getVegetableSubId() {
        return vegetableSubId;
    }

    public void setVegetableSubId(String vegetableSubId) {
        this.vegetableSubId = vegetableSubId;
    }
}
