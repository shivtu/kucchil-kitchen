package com.example.retail.controllers.customers.orders_customer;

import com.example.retail.models.customerorders.CustomerOrders;
import com.example.retail.services.customerorders.CustomerOrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/customer/orders")
@CrossOrigin(origins = "*")
public class OrdersCustomerController {

    @Autowired
    CustomerOrderServices customerOrderServices;



    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCustomerOrder(HttpServletRequest request, @RequestBody CustomerOrders customerOrders) {

        return customerOrderServices.createCustomerOrder(request, customerOrders);
    }

}
