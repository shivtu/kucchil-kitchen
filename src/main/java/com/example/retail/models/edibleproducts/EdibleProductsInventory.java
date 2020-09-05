package com.example.retail.models.edibleproducts;

import com.example.retail.util.InventoryAdditionDetails;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class EdibleProductsInventory {

    @Id
    @GeneratedValue
    private Long edibleProductInventoryTableId;

    private Float edibleProductCostPrice;

    private Float edibleProductFixedCost;

    // Discounted price is the selling price on which profits will be calculated
    private Float edibleProductSellingPrice;

    private LocalDate edibleProductInventoryExpiry;

    @Type(type = "psql-jsonb")
    private List<InventoryAdditionDetails> vegitableInventoryAdditionDetails;

    private String edibleProductSubId;

}
