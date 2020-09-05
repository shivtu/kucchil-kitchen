package com.example.retail.models.edibleproducts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class EdibleProductsInventory {

    @Id
    @GeneratedValue
    private Long edibleProductInventoryTableId;

    @NotNull
    @Column(name = "")
    private Float edibleProductCostPrice;

    @NotNull
    @Column(name = "")
    private Float edibleProductFixedCost;

    // Discounted price is the selling price on which profits will be calculated
    @NotNull
    @Column(name = "")
    private Float edibleProductSellingPrice;

    @NotNull
    @Column(name = "")
    private LocalDate edibleProductInventoryExpiry;

    @NotNull
    @Column(name = "")
    private String edibleProductInventoryAddedBy;

    @NotNull
    @Column(name = "")
    private LocalDateTime edibleProductInventoryOn;

    @NotNull
    @Column(name = "")
    private Float edibleProductInventoryQtyAdded;

    @NotNull
    @Column(name = "")
    private String edibleProductSubId;

}
