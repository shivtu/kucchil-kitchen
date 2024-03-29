package com.example.retail.models.jsonmodels;

import java.time.LocalDateTime;

public class InventoryAdditionDetails {

    private String addedBy;
    private LocalDateTime addedDateTime;
    private Float increamentCount;

    public InventoryAdditionDetails(){}

    public InventoryAdditionDetails(String addedBy, LocalDateTime addedDateTime, Float increamentCount) {
        this.addedBy = addedBy;
        this.addedDateTime = addedDateTime;
        this.increamentCount = increamentCount;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public LocalDateTime getAddedDateTime() {
        return addedDateTime;
    }

    public void setAddedDateTime(LocalDateTime addedDateTime) {
        this.addedDateTime = addedDateTime;
    }

    public Float getIncreamentCount() {
        return increamentCount;
    }

    public void setIncreamentCount(Float increamentCount) {
        this.increamentCount = increamentCount;
    }
}
