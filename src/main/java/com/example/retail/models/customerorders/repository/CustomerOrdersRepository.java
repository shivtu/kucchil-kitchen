package com.example.retail.models.customerorders.repository;

import com.example.retail.models.customerorders.CustomerOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerOrdersRepository extends JpaRepository<CustomerOrders, Long> {

    @Query(value = "SELECT * FROM customer_orders WHERE orders_username= :customerName", nativeQuery = true)
    List<CustomerOrders> findAllOrdersByCustomer(@Param("customerName") String customerName);
}
