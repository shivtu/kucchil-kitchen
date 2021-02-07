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
    @Column(name = "pin_code")
    private String pinCode;

}
