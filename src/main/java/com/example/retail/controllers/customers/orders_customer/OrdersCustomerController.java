package com.example.retail.controllers.customers.orders_customer;

import com.example.retail.models.customerorders.CustomerOrders;
import com.example.retail.models.customerorders.services.CustomerOrderServices;
import com.example.retail.users.profiles.UsersProfile;
import com.example.retail.users.profiles.UsersProfileService;
import com.example.retail.util.JWTDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer/orders")
public class OrdersCustomerController {

    @Autowired
    CustomerOrderServices customerOrderServices;

    @Autowired
    JWTDetails jwtDetails;

    @Autowired
    UsersProfileService usersProfileService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody CustomerOrders customerOrders, HttpServletRequest request) {
        String orderCreatedBy = jwtDetails.userName(request);
        UsersProfile userDetails = usersProfileService.findByUserName(orderCreatedBy);

        // TODO : perform validation on customerOrdersItemsList

        customerOrders.setOrderDelivered(false);
        customerOrders.setAppliedDiscount(0f);
        customerOrders.setPurchaseDate(LocalDate.now());
        customerOrders.setPurchaseTime(LocalTime.now());
        customerOrders.setDeliveryCharges(0f);
        customerOrders.setUserAddress(userDetails.getUserProfile_Address());
        customerOrders.setUserPhoneNumber(userDetails.getUserProfile_PhoneNumber());
        customerOrders.setUserName(orderCreatedBy);
        customerOrders.setUserGivenName(userDetails.getUserProfile_GivenName());
        customerOrders.setOrdersPaybleamount(80f);
        customerOrders.setUserTableId(userDetails.getUserProfile_TableId());

        return new ResponseEntity(customerOrderServices.save(customerOrders), HttpStatus.CREATED);
    }

}
