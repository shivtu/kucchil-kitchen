package com.example.retail.models.discounts.services;

import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.repository.CustomerOrdersDiscountRepository;
import com.example.retail.util.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrdersDiscountServices {

    @Autowired
    CustomerOrdersDiscountRepository customerOrdersDiscountRepository;

    @Autowired
    CreateResponse createResponse;

    public ResponseEntity<Object> createSpecialDiscount(CustomerOrdersDiscount customerOrdersDiscount) {
        try {
            CustomerOrdersDiscount res = customerOrdersDiscountRepository.save(customerOrdersDiscount);
            List<Object> finalRes = new ArrayList<>();
            finalRes.add(res);

            return ResponseEntity.status(201).body(
                    createResponse.createSuccessResponse(201, "Discount created", finalRes)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }

    }

    public ResponseEntity<Object> findAllByDiscountName(String discountName) {

        try {
            Optional<CustomerOrdersDiscount> customerOrdersDiscount = customerOrdersDiscountRepository.findAllByDiscountName(discountName);

            List<Object> res = new ArrayList<>();
            String successMessage = "One record found";

            if (customerOrdersDiscount.isEmpty()) {
                successMessage = "query ran successfully but could not find any results found for " + discountName;
            } else {
                res.add(customerOrdersDiscount);
            }

            return ResponseEntity.status(200).body(
                    createResponse.createSuccessResponse(200, successMessage, res)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }

    }

}
