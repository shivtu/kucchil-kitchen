package com.example.retail.models.jsonmodels;

public class DenominationList {

    private Float fractionalValue;

    private String displayValue;

    public DenominationList() {}

    public DenominationList(Float fractionalValue, String displayValue) {
        this.fractionalValue = fractionalValue;
        this.displayValue = displayValue;
    }

    public Float getFractionalValue() {
        return fractionalValue;
    }

    public void setFractionalValue(Float fractionalValue) {
        this.fractionalValue = fractionalValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
}
