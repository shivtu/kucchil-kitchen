package com.example.retail.models.customerorders.services;

import com.example.retail.models.customerorders.CustomerOrders;
import com.example.retail.models.customerorders.repository.CustomerOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderServices {

    @Autowired
    CustomerOrdersRepository customerOrdersRepository;

    public CustomerOrders save(CustomerOrders customerOrders) {
        return customerOrdersRepository.save(customerOrders);
    }
}
