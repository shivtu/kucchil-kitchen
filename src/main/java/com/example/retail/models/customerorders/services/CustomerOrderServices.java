package com.example.retail.models.customerorders.services;

import com.example.retail.models.customerorders.CustomerOrders;
import com.example.retail.models.customerorders.repository.CustomerOrdersRepository;
import com.example.retail.users.profiles.UsersProfile;
import com.example.retail.users.profiles.UsersProfileService;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.JWTDetails;
import com.example.retail.util.ValidationResponse;
import com.example.retail.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderServices {

    @Autowired
    CustomerOrdersRepository customerOrdersRepository;

    @Autowired
    JWTDetails jwtDetails;

    @Autowired
    UsersProfileService usersProfileService;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    Validations validations;

    public ResponseEntity<Object> createOrder(CustomerOrders customerOrders, HttpServletRequest request) {
        try {
            // TODO: calculate total amount before and after tax
            ValidationResponse validationRes = validations.validateCustomerOrder(customerOrders);
            int validationResStatusCode = validationRes.getStatusCode();

            if(validationResStatusCode != validations.validationSuccessCode) {
                return ResponseEntity.status(validationResStatusCode).body(
                        createResponse.createErrorResponse(validationResStatusCode, validationRes.getStatusMessage(), validationRes.getAdditionalInfo())
                );
            }

            String orderCreatedBy = jwtDetails.userName(request);
            UsersProfile userDetails = usersProfileService.findByUserName(orderCreatedBy);

            customerOrders.setOrderDelivered(false);
            customerOrders.setSpeacialDiscountName(customerOrders.getSpeacialDiscountName());
            customerOrders.setPurchaseDate(LocalDate.now());
            customerOrders.setPurchaseTime(LocalTime.now());
            customerOrders.setDeliveryCharges(0f);
            customerOrders.setUserAddress(userDetails.getUserProfile_Address());
            customerOrders.setUserPhoneNumber(userDetails.getUserProfile_PhoneNumber());
            customerOrders.setUserName(orderCreatedBy);
            customerOrders.setUserGivenName(userDetails.getUserProfile_GivenName());
            customerOrders.setOrdersPaybleamount(80f);
            customerOrders.setUserTableId(userDetails.getUserProfile_TableId());

            CustomerOrders res = customerOrdersRepository.save(customerOrders);

            List<Object> finalRes = new ArrayList<>();
            finalRes.add(res);
            return ResponseEntity.status(201).body(
                    createResponse.createSuccessResponse(201, "Created", finalRes)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }
    }
}
