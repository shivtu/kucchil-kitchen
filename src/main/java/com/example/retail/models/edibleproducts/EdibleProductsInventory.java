package com.example.retail.models.edibleproducts;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "edibleproduct_inventory")
public class EdibleProductsInventory {

    @Id
    @GeneratedValue
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

    @NotNull
    @Column(name = "edible_product_subid")
    private String edibleProductSubId;

}
