package com.example.retail.models.deliveryutility;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class DeliveryCharges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="deliveryCharge_tableid")
    private Integer deliveryChargeTableId;

    @NotNull
    @Column(name = "sales_amount_less_than", unique = true)
    private Float salesAmountLessThan;

    @NotNull
    @Column(name = "sales_amount_greater_than", unique = true)
    private Float salesAmountGreaterThan;

    @NotNull
    @Column(name = "delivery_charge")
    private Float deliveryCharge;

    @Column(name = "override_delivery_constraints")
    private Boolean overrideDeliveryConstraints = false;

    public DeliveryCharges() {}

    public DeliveryCharges(@NotNull Float salesAmountLessThan, @NotNull Float salesAmountGreaterThan,
                           @NotNull Float deliveryCharge, Boolean overrideDeliveryConstraints) {
        this.salesAmountLessThan = salesAmountLessThan;
        this.salesAmountGreaterThan = salesAmountGreaterThan;
        this.deliveryCharge = deliveryCharge;
        this.overrideDeliveryConstraints = overrideDeliveryConstraints;
    }

    public Integer getDeliveryChargeTableId() {
        return deliveryChargeTableId;
    }

    public void setDeliveryChargeTableId(Integer deliveryChargeTableId) {
        this.deliveryChargeTableId = deliveryChargeTableId;
    }

    public Float getSalesAmountLessThan() {
        return salesAmountLessThan;
    }

    public void setSalesAmountLessThan(Float salesAmountLessThan) {
        this.salesAmountLessThan = salesAmountLessThan;
    }

    public Float getSalesAmountGreaterThan() {
        return salesAmountGreaterThan;
    }

    public void setSalesAmountGreaterThan(Float salesAmountGreaterThan) {
        this.salesAmountGreaterThan = salesAmountGreaterThan;
    }

    public Float getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Float deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public Boolean getOverrideDeliveryConstraints() {
        return overrideDeliveryConstraints;
    }

    public void setOverrideDeliveryConstraints(Boolean overrideDeliveryConstraints) {
        this.overrideDeliveryConstraints = overrideDeliveryConstraints;
    }
}
