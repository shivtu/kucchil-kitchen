package com.example.retail.models.discounts.services;

import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.repository.CustomerOrdersDiscountRepository;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.JWTDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerOrdersDiscountServices {

    @Autowired
    CustomerOrdersDiscountRepository customerOrdersDiscountRepository;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    JWTDetails JWTDetails;

    public ResponseEntity<Object> createSpecialDiscount(HttpServletRequest request, CustomerOrdersDiscount customerOrdersDiscount) {
        try {
            LocalDateTime lastUpdatedOn = LocalDateTime.now();
            customerOrdersDiscount.setDiscountAddedOn(lastUpdatedOn);
            customerOrdersDiscount.setDiscountLastUpdatedBy(JWTDetails.userName(request));
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
            Optional<CustomerOrdersDiscount> customerOrdersDiscount = customerOrdersDiscountRepository.findByDiscountName(discountName);

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

    public List<CustomerOrdersDiscount> findAllDiscounts() {
        List<CustomerOrdersDiscount> res = customerOrdersDiscountRepository.findAll();
        return res;
    }

    public List<CustomerOrdersDiscount> getAllActiveDiscounts() {
        return customerOrdersDiscountRepository.getAllActiveDiscounts();
    }
}
