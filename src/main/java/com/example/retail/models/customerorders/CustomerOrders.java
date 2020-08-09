package com.example.retail.models.customerorders;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "customer_orders")
@TypeDefs({@TypeDef(name = "psql-jsonb", typeClass = JsonBinaryType.class)})
public class CustomerOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_tableid")
    private Long orderTableId;

    @NotNull
    @Column(name = "orders_usertableid")
    private Long userTableId;

    @NotNull
    @NotEmpty
    @Column(name = "orders_username")
    private String userName;

    @NotNull
    @NotEmpty
    @Column(name = "orders_usergivenname")
    private String userGivenName;

    @NotNull
    @Column(name = "orders_userphonennumber")
    private Long userPhoneNumber;

    @NotNull
    @Column(name = "orders_useraddress")
    private String userAddress;

    @Column(name = "orders_deliveryaddress")
    private String deliveryAddress;

    @NotNull
    @Min(value = 0)
    @Column(name = "orders_deliverycharges")
    private Float deliveryCharges = 0F;

    @Column(name = "orders_specialdiscount")
    @Min(value = 0)
    private Float speacialDiscountValue;

    @Column(name = "orders_specialdiscountname")
    private String speacialDiscountName;

    @Column(name = "orders_amountbeforediscount")
    private Float amountBeforeDiscount;

    @Column(name = "orders_amountafterdiscount")
    private Float amountAfterDiscount;

    @Column(name = "orders_amountbeforetax")
    private Float amountBeforeTax;

    @Column(name = "orders_taxcategory")
    private String taxCategory;

    @NotNull
    @Column(name = "orders_paybleamount")
    private Float ordersPaybleamount;

    @Column(name = "orders_paymentmode")
    private String ordersPaymentMode;

    @Column(name = "orders_paymentdatetime")
    private LocalDateTime paymentDateTime;

    @Column(name = "orders_paidby")
    private String paidBy;

    @NotNull
    @Column(name = "orders_isdelivered")
    private Boolean isOrderDelivered;

    @NotNull
    private LocalDate purchaseDate;

    @NotNull
    private LocalTime purchaseTime;

    @NotEmpty
    @NotNull
    @Column(name = "orders_itemlist", columnDefinition = "jsonb", updatable = false, nullable = false)
    @Type(type = "psql-jsonb")
    private List<CustomerOrdersItemsList> customerOrdersItemsList;

    public CustomerOrders() {}

    public CustomerOrders(@NotNull Long userTableId, @NotNull @NotEmpty String userName, @NotNull @NotEmpty String userGivenName, @NotNull Long userPhoneNumber, @NotNull String userAddress, String deliveryAddress, @NotNull @Min(value = 0) Float deliveryCharges, @Min(value = 0) Float speacialDiscountValue, String speacialDiscountName, Float amountBeforeDiscount, Float amountAfterDiscount, Float amountBeforeTax, String taxCategory, @NotNull Float ordersPaybleamount, String ordersPaymentMode, LocalDateTime paymentDateTime, String paidBy, @NotNull Boolean isOrderDelivered, @NotNull LocalDate purchaseDate, @NotNull LocalTime purchaseTime, @NotEmpty @NotNull List<CustomerOrdersItemsList> customerOrdersItemsList) {
        this.userTableId = userTableId;
        this.userName = userName;
        this.userGivenName = userGivenName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.deliveryAddress = deliveryAddress;
        this.deliveryCharges = deliveryCharges;
        this.speacialDiscountValue = speacialDiscountValue;
        this.speacialDiscountName = speacialDiscountName;
        this.amountBeforeDiscount = amountBeforeDiscount;
        this.amountAfterDiscount = amountAfterDiscount;
        this.amountBeforeTax = amountBeforeTax;
        this.taxCategory = taxCategory;
        this.ordersPaybleamount = ordersPaybleamount;
        this.ordersPaymentMode = ordersPaymentMode;
        this.paymentDateTime = paymentDateTime;
        this.paidBy = paidBy;
        this.isOrderDelivered = isOrderDelivered;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.customerOrdersItemsList = customerOrdersItemsList;
    }

    public Long getOrderTableId() {
        return orderTableId;
    }

    public void setOrderTableId(Long orderTableId) {
        this.orderTableId = orderTableId;
    }

    public Long getUserTableId() {
        return userTableId;
    }

    public void setUserTableId(Long userTableId) {
        this.userTableId = userTableId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGivenName() {
        return userGivenName;
    }

    public void setUserGivenName(String userGivenName) {
        this.userGivenName = userGivenName;
    }

    public Long getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(Long userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Float getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Float deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public Float getSpeacialDiscountValue() {
        return speacialDiscountValue;
    }

    public void setSpeacialDiscountValue(Float speacialDiscountValue) {
        this.speacialDiscountValue = speacialDiscountValue;
    }

    public String getSpeacialDiscountName() {
        return speacialDiscountName;
    }

    public void setSpeacialDiscountName(String speacialDiscountName) {
        this.speacialDiscountName = speacialDiscountName;
    }

    public Float getAmountBeforeDiscount() {
        return amountBeforeDiscount;
    }

    public void setAmountBeforeDiscount(Float amountBeforeDiscount) {
        this.amountBeforeDiscount = amountBeforeDiscount;
    }

    public Float getAmountAfterDiscount() {
        return amountAfterDiscount;
    }

    public void setAmountAfterDiscount(Float amountAfterDiscount) {
        this.amountAfterDiscount = amountAfterDiscount;
    }

    public Float getAmountBeforeTax() {
        return amountBeforeTax;
    }

    public void setAmountBeforeTax(Float amountBeforeTax) {
        this.amountBeforeTax = amountBeforeTax;
    }

    public String getTaxCategory() {
        return taxCategory;
    }

    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
    }

    public Float getOrdersPaybleamount() {
        return ordersPaybleamount;
    }

    public void setOrdersPaybleamount(Float ordersPaybleamount) {
        this.ordersPaybleamount = ordersPaybleamount;
    }

    public String getOrdersPaymentMode() {
        return ordersPaymentMode;
    }

    public void setOrdersPaymentMode(String ordersPaymentMode) {
        this.ordersPaymentMode = ordersPaymentMode;
    }

    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public Boolean getOrderDelivered() {
        return isOrderDelivered;
    }

    public void setOrderDelivered(Boolean orderDelivered) {
        isOrderDelivered = orderDelivered;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public List<CustomerOrdersItemsList> getCustomerOrdersItemsList() {
        return customerOrdersItemsList;
    }

    public void setCustomerOrdersItemsList(List<CustomerOrdersItemsList> customerOrdersItemsList) {
        this.customerOrdersItemsList = customerOrdersItemsList;
    }
}
