package com.example.retail.controllers.customers.orders_customer;

import com.example.retail.models.customerorders.CustomerOrders;
import com.example.retail.models.customerorders.services.CustomerOrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/v1/customer/orders")
public class OrdersCustomerController {

    @Autowired
    CustomerOrderServices customerOrderServices;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody CustomerOrders customerOrders) {
        customerOrders.setOrderDelivered(false);
        customerOrders.setAppliedDiscount(0f);
        customerOrders.setDeliveryAddress("Bangalore-560006");
        customerOrders.setOrdersPaymentMode("CASH");
        customerOrders.setPurchaseDate(LocalDate.now());
        customerOrders.setPurchaseTime(LocalTime.now());
        customerOrders.setDeliveryCharges(0f);
        customerOrders.setUserAddress("Bangalore");
        customerOrders.setUserPhoneNumber(9964123546L);
        customerOrders.setUserName("spiderman@gmail.com");
        customerOrders.setUserGivenName("spiderman");
        customerOrders.setOrdersPaybleamount(80f);
        customerOrders.setUserTableId(1L);
        customerOrders.setUserTableId(1L);
        return new ResponseEntity(customerOrderServices.save(customerOrders), HttpStatus.CREATED);
    }

}
