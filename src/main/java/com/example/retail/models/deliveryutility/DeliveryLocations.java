package com.example.retail.models.deliveryutility;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "delivery_locations")
public class DeliveryLocations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_locations_tableid")
    private Long deliveryLocationsTableId;

    @NotEmpty
    @Column(name = "area_name")
    private String areaName;

    @NotEmpty
    @Column(name = "area_pin_code")
    private String areaPinCode;

    @Column(name = "default_delivery_charge")
    private Float defaultDeliveryCharge = 0F;

    @Column(name = "delivery_location_subid", updatable = false)
    private String deliveryLocationSubId;

    public DeliveryLocations() {}

    public DeliveryLocations(@NotEmpty String areaName, @NotEmpty String areaPinCode, Float defaultDeliveryCharge, String deliveryLocationSubId) {
        this.areaName = areaName;
        this.areaPinCode = areaPinCode;
        this.defaultDeliveryCharge = defaultDeliveryCharge;
        this.deliveryLocationSubId = deliveryLocationSubId;
    }

    public Long getDeliveryLocationsTableId() {
        return deliveryLocationsTableId;
    }

    public void setDeliveryLocationsTableId(Long deliveryLocationsTableId) {
        this.deliveryLocationsTableId = deliveryLocationsTableId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaPinCode() {
        return areaPinCode;
    }

    public void setAreaPinCode(String areaPinCode) {
        this.areaPinCode = areaPinCode;
    }

    public Float getDefaultDeliveryCharge() {
        return defaultDeliveryCharge;
    }

    public void setDefaultDeliveryCharge(Float defaultDeliveryCharge) {
        this.defaultDeliveryCharge = defaultDeliveryCharge;
    }

    public String getDeliveryLocationSubId() {
        return deliveryLocationSubId;
    }

    public void setDeliveryLocationSubId(String deliveryLocationSubId) {
        this.deliveryLocationSubId = deliveryLocationSubId;
    }
}
