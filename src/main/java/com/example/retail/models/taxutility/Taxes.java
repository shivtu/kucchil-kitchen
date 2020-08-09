package com.example.retail.models.taxutility;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Taxes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="taxes_tableid")
    private Integer taxesTableId;

    @NotEmpty
    @NotNull
    @Column(name = "tax_name", unique = true, updatable = false)
    private String taxName;

    @Min(0)
    @Column(name = "tax_percent")
    private Float taxPercent;

    @Column(name = "additional_tax_info")
    private String additionalTaxInfo;

    @NotNull
    @Column(name = "should_tax_apply")
    private Boolean shouldTaxApply = true;

    @NotEmpty
    @NotNull
    @Column(name = "last_updated_by")
    private String taxLastUpdatedBy;

    @NotNull
    @Column(name = "last_updated_on")
    private LocalDateTime taxLastUpdatedOn;

    public Taxes() {}

    public Taxes(@NotEmpty @NotNull String taxName, @Min(0) Float taxPercent, String additionalTaxInfo, @NotNull Boolean shouldTaxApply,
                 @NotEmpty @NotNull String taxLastUpdatedBy, @NotNull LocalDateTime taxLastUpdatedOn) {

        this.taxName = taxName;
        this.taxPercent = taxPercent;
        this.additionalTaxInfo = additionalTaxInfo;
        this.shouldTaxApply = shouldTaxApply;
        this.taxLastUpdatedBy = taxLastUpdatedBy;
        this.taxLastUpdatedOn = taxLastUpdatedOn;
    }

    public Integer getTaxesTableId() {
        return taxesTableId;
    }

    public void setTaxesTableId(Integer taxesTableId) {
        this.taxesTableId = taxesTableId;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Float getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(Float taxPercent) {
        this.taxPercent = taxPercent;
    }

    public String getAdditionalTaxInfo() {
        return additionalTaxInfo;
    }

    public void setAdditionalTaxInfo(String additionalTaxInfo) {
        this.additionalTaxInfo = additionalTaxInfo;
    }

    public Boolean getShouldTaxApply() {
        return shouldTaxApply;
    }

    public void setShouldTaxApply(Boolean shouldTaxApply) {
        this.shouldTaxApply = shouldTaxApply;
    }

    public String getTaxLastUpdatedBy() {
        return taxLastUpdatedBy;
    }

    public void setTaxLastUpdatedBy(String taxLastUpdatedBy) {
        this.taxLastUpdatedBy = taxLastUpdatedBy;
    }

    public LocalDateTime getTaxLastUpdatedOn() {
        return taxLastUpdatedOn;
    }

    public void setTaxLastUpdatedOn(LocalDateTime taxLastUpdatedOn) {
        this.taxLastUpdatedOn = taxLastUpdatedOn;
    }
}
