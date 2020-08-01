package com.example.retail.models.discounts.repository;

import com.example.retail.models.discounts.CustomerOrdersDiscount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerOrdersDiscountRepository extends JpaRepository<CustomerOrdersDiscount, Integer> {

    @Query(value = "SELECT * FROM customer_orders_discount WHERE discount_name= :discountName", nativeQuery = true)
    Optional<CustomerOrdersDiscount> findByDiscountName(@Param("discountName") String discountName);

    @Query(value = "SELECT * FROM customer_orders_discount WHERE discount_isactive=true", nativeQuery = true)
    List<CustomerOrdersDiscount> getAllActiveDiscounts();

}
