package com.example.retail.productsmodel.vegitables;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vegitables_inventory")
@TypeDefs({
        @TypeDef(
                name = "psql-jsonb",
                typeClass = JsonBinaryType.class
        )
})
public class VegitablesInventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vegitablesinventory_tableid", nullable = false, updatable = false)
    private Long vegitableInventory_TableId;

    @Column(name = "vegitablesinventory_costprice")
    @Min(value = 0, message = "Cost price cannot be 0")
    private Float vegitablesInventory_CostPrice;

    @Column(name = "vegitablesinventory_expiry")
    private LocalDate vegitablesInventory_Expiry;

    @Column(name = "vegitablesinventory_maxdiscount")
    @Min(value = 0)
    private Float vegitablesInventory_MaxDiscount;

    @Column(name = "vegitablesinventory_fixedcost")
    private Float vegitablesInventory_FixedCost;

    @Column(name = "vegitablesinventory_addtion_details", columnDefinition = "jsonb")
    @Type(type = "psql-jsonb")
    private List<VegitableAdditionDetails> vegitablesInventory_AdditionDetails;


    @Column(name = "vegitable_subid")
    private String vegitable_SubId;

    public VegitablesInventory(){}

    public VegitablesInventory(
            @Min(value = 0, message = "Cost price cannot be 0") Float vegitablesInventory_CostPrice,
            LocalDate vegitablesInventory_Expiry,
            @Min(value = 0) Float vegitablesInventory_MaxDiscount,
            Float vegitablesInventory_FixedCost,
            List<VegitableAdditionDetails> vegitablesInventory_AdditionDetails,
            String vegitable_SubId) {
        this.vegitablesInventory_CostPrice = vegitablesInventory_CostPrice;
        this.vegitablesInventory_Expiry = vegitablesInventory_Expiry;
        this.vegitablesInventory_MaxDiscount = vegitablesInventory_MaxDiscount;
        this.vegitablesInventory_FixedCost = vegitablesInventory_FixedCost;
        this.vegitablesInventory_AdditionDetails = vegitablesInventory_AdditionDetails;
        this.vegitable_SubId = vegitable_SubId;
    }

    public Long getVegitableInventory_TableId() {
        return vegitableInventory_TableId;
    }

    public void setVegitableInventory_TableId(Long vegitableInventory_TableId) {
        this.vegitableInventory_TableId = vegitableInventory_TableId;
    }

    public Float getVegitablesInventory_CostPrice() {
        return vegitablesInventory_CostPrice;
    }

    public void setVegitablesInventory_CostPrice(Float vegitablesInventory_CostPrice) {
        this.vegitablesInventory_CostPrice = vegitablesInventory_CostPrice;
    }

    public LocalDate getVegitablesInventory_Expiry() {
        return vegitablesInventory_Expiry;
    }

    public void setVegitablesInventory_Expiry(LocalDate vegitablesInventory_Expiry) {
        this.vegitablesInventory_Expiry = vegitablesInventory_Expiry;
    }

    public Float getVegitablesInventory_MaxDiscount() {
        return vegitablesInventory_MaxDiscount;
    }

    public void setVegitablesInventory_MaxDiscount(Float vegitablesInventory_MaxDiscount) {
        this.vegitablesInventory_MaxDiscount = vegitablesInventory_MaxDiscount;
    }

    public Float getVegitablesInventory_FixedCost() {
        return vegitablesInventory_FixedCost;
    }

    public void setVegitablesInventory_FixedCost(Float vegitablesInventory_FixedCost) {
        this.vegitablesInventory_FixedCost = vegitablesInventory_FixedCost;
    }

    public List<VegitableAdditionDetails> getVegitablesInventory_AdditionDetails() {
        return vegitablesInventory_AdditionDetails;
    }

    public void setVegitablesInventory_AdditionDetails(List<VegitableAdditionDetails> vegitablesInventory_AdditionDetails) {
        this.vegitablesInventory_AdditionDetails = vegitablesInventory_AdditionDetails;
    }

    public String getVegitable_SubId() {
        return vegitable_SubId;
    }

    public void setVegitable_SubId(String vegitable_SubId) {
        this.vegitable_SubId = vegitable_SubId;
    }
}
