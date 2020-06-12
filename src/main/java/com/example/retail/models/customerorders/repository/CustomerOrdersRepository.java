package com.example.retail.models.customerorders.repository;

import com.example.retail.models.customerorders.CustomerOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrdersRepository extends JpaRepository<CustomerOrders, Long> {
}
