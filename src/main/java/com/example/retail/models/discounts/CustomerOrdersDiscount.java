package com.example.retail.models.discounts;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class CustomerOrdersDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discountid")
    private Integer discountId;

    @Column(name = "discount_percentage")
    @NotNull
    private Float discountPercentage = 0f;

    @NotNull
    @NotEmpty
    @Column(name = "discount_name", unique = true)
    private String discountName;

    @Email
    @Column(name = "discount_lastupdatedby")
    private String discountLastUpdatedBy;

    @NotNull
    @Column(name = "discount_addedon")
    private LocalDateTime discountAddedOn;

    @Column(name = "discount_isactive")
    private Boolean isDiscountActive = false;

    public CustomerOrdersDiscount () {}

    public CustomerOrdersDiscount(@Min(value = 0) @NotNull Float discountPercentage,
                                  @NotNull @NotEmpty String discountName, @Email String discountLastUpdatedBy,
                                  @NotNull @NotEmpty LocalDateTime discountAddedOn, Boolean isDiscountActive) {

        this.discountPercentage = discountPercentage;
        this.discountName = discountName;
        this.discountLastUpdatedBy = discountLastUpdatedBy;
        this.discountAddedOn = discountAddedOn;
        this.isDiscountActive = isDiscountActive;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountLastUpdatedBy() {
        return discountLastUpdatedBy;
    }

    public void setDiscountLastUpdatedBy(String discountLastUpdatedBy) {
        this.discountLastUpdatedBy = discountLastUpdatedBy;
    }

    public LocalDateTime getDiscountAddedOn() {
        return discountAddedOn;
    }

    public void setDiscountAddedOn(LocalDateTime discountAddedOn) {
        this.discountAddedOn = discountAddedOn;
    }

    public Boolean getDiscountActive() {
        return isDiscountActive;
    }

    public void setDiscountActive(Boolean discountActive) {
        isDiscountActive = discountActive;
    }
}
