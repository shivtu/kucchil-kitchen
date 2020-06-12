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

@Entity
@Table(name = "customer_orders")
@TypeDefs({@TypeDef(name = "psql-jsonb", typeClass = JsonBinaryType.class)})
public class CustomerOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_tableid")
    private Long orderTableId;

    @NotNull
    @NotEmpty
    @Column(name = "orders_usertableid")
    private String userTableId;

    @NotNull
    @NotEmpty
    @Column(name = "orders_username")
    private String userName;

    @NotNull
    @NotEmpty
    @Column(name = "orders_usergivenname")
    private String userGivenName;

    @NotNull
    @NotEmpty
    @Column(name = "orders_userphonennumber")
    private Integer userPhoneNumber;

    @NotNull
    @NotEmpty
    @Column(name = "orders_useraddress")
    private String userAddress;

    @NotNull
    @NotEmpty
    @Column(name = "orders_deliveryaddress")
    private String deliveryAddress;

    @NotNull
    @Min(value = 0)
    @Column(name = "orders_deliverycharges")
    private Float deliveryCharges;

    @Column(name = "orders_applieddiscount")
    private Float appliedDiscount;

    @NotEmpty
    @NotNull
    @Column(name = "orders_itemlist", columnDefinition = "jsonb", updatable = false, nullable = false)
    @Type(type = "psql-jsonb")
    private List<CustomerOrdersItemsList> customerOrdersItemsList;

    @NotNull
    private LocalDate purchaseDate;

    @NotNull
    private LocalTime purchaseTime;

    @NotNull
    @Min(value = 1)
    private Float ordersPaybleamount;

    private String ordersPaymentMode;

    private LocalDateTime paymentDateTime;

    private String paidBy;

    @NotNull
    private Boolean isOrderDelivered;

    public CustomerOrders() {}

    public CustomerOrders(
            @NotNull @NotEmpty String userTableId,
            @NotNull @NotEmpty String userName,
            @NotNull @NotEmpty String userGivenName,
            @NotNull @NotEmpty Integer userPhoneNumber,
            @NotNull @NotEmpty String userAddress,
            @NotNull @NotEmpty String deliveryAddress, @NotNull @Min(value = 0) Float deliveryCharges,
            Float appliedDiscount,
            @NotEmpty @NotNull List<CustomerOrdersItemsList> customerOrdersItemsList,
            @NotNull LocalDate purchaseDate,
            @NotNull LocalTime purchaseTime,
            @NotNull @Min(value = 1) Float ordersPaybleamount,
            String ordersPaymentMode,
            LocalDateTime paymentDateTime,
            String paidBy, @NotNull Boolean isOrderDelivered) {

        this.userTableId = userTableId;
        this.userName = userName;
        this.userGivenName = userGivenName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.deliveryAddress = deliveryAddress;
        this.deliveryCharges = deliveryCharges;
        this.appliedDiscount = appliedDiscount;
        this.customerOrdersItemsList = customerOrdersItemsList;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.ordersPaybleamount = ordersPaybleamount;
        this.ordersPaymentMode = ordersPaymentMode;
        this.paymentDateTime = paymentDateTime;
        this.paidBy = paidBy;
        this.isOrderDelivered = isOrderDelivered;
    }

    public Long getOrderTableId() {
        return orderTableId;
    }

    public void setOrderTableId(Long orderTableId) {
        this.orderTableId = orderTableId;
    }

    public String getUserTableId() {
        return userTableId;
    }

    public void setUserTableId(String userTableId) {
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

    public Integer getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(Integer userPhoneNumber) {
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

    public Float getAppliedDiscount() {
        return appliedDiscount;
    }

    public void setAppliedDiscount(Float appliedDiscount) {
        this.appliedDiscount = appliedDiscount;
    }

    public List<CustomerOrdersItemsList> getCustomerOrdersItemsList() {
        return customerOrdersItemsList;
    }

    public void setCustomerOrdersItemsList(List<CustomerOrdersItemsList> customerOrdersItemsList) {
        this.customerOrdersItemsList = customerOrdersItemsList;
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

    public Boolean getOrderDelivered() {
        return isOrderDelivered;
    }

    public void setOrderDelivered(Boolean orderDelivered) {
        isOrderDelivered = orderDelivered;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }
}
