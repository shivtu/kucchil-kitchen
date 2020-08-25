package com.example.retail.models.customerorders.services;

import com.example.retail.models.customerorders.CustomerOrders;
import com.example.retail.models.customerorders.CustomerOrdersHelper;
import com.example.retail.models.customerorders.repository.CustomerOrdersRepository;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.DiscountCalculator;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.users.profiles.UsersProfile;
import com.example.retail.users.profiles.UsersProfileService;
import com.example.retail.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

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

    @Autowired
    Utils utils;

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @Autowired
    CustomerOrdersHelper customerOrdersHelper;

    public ResponseEntity<Object> createCustomerOrder(HttpServletRequest request, CustomerOrders customerOrders) {
        try {
            /* Validate the order */
            ValidationResponse validationRes = validations.validateCustomerOrder(customerOrders);
            int validationResStatusCode = validationRes.getStatusCode();

            if(validationResStatusCode != validations.validationSuccessCode) {
                return ResponseEntity.status(validationResStatusCode).body(
                        createResponse.createErrorResponse(validationResStatusCode, validationRes.getStatusMessage(),
                                validationRes.getAdditionalInfo())
                );
            }

            String orderCreatedBy = jwtDetails.userName(request);
            Optional<UsersProfile> userDetails = usersProfileService.findByUserName(orderCreatedBy);
            AtomicReference<Float> totalAmountBeforeDiscountAndTax = new AtomicReference<>(0F);
            Float totalAmountAfterSpecialDiscount = 0F;

            Optional<CustomerOrdersDiscount> customerOrdersDiscount = Optional.empty();

            /* If returned Object from validation is not null cast returned object to CustomerOrdersDiscount */
            if (!validationRes.getAdditionalObjectsReturned().equals(Optional.empty())) {
                customerOrdersDiscount = (Optional<CustomerOrdersDiscount>) validationRes.getAdditionalObjectsReturned();
            }

            customerOrders.getCustomerOrdersItemsList().forEach(eachItem -> {
                /*
                Calculate the total amount before discount and taxes
                *  */
                totalAmountBeforeDiscountAndTax.set(totalAmountBeforeDiscountAndTax.get() + eachItem.getProductDiscountedPrice());
            });

            if(!customerOrdersDiscount.equals(Optional.empty())) {
                /* calculate the price after discount */
                totalAmountAfterSpecialDiscount = totalAmountBeforeDiscountAndTax.get() - customerOrdersHelper.calcSpecialDiscount(totalAmountBeforeDiscountAndTax.get(), customerOrdersDiscount.get().getDiscountPercentage());
            }

            /* If loyalty discount is requested calculate the loayalty discount */
            // TODO: check if special discount and loyalty discount ( && customerOrders.getSpeacialDiscountName().equals("loyaltyDiscount")) both can be applied together
            if (customerOrders.getSpeacialDiscountName() != null && customerOrders.getSpeacialDiscountName().equals("loyaltyDiscount")) {
                totalAmountAfterSpecialDiscount = totalAmountBeforeDiscountAndTax.get() - customerOrdersHelper.calcLoyaltyDiscount(orderCreatedBy);
            }

            Float deliveryCharges = 0F;

            Float paybleAmountAfterTax = totalAmountBeforeDiscountAndTax.get() - customerOrdersHelper.calcTax(totalAmountAfterSpecialDiscount, customerOrders.getTaxCategory());

            customerOrders.setUserTableId(userDetails.get().getUserProfile_TableId());
            customerOrders.setUserName(userDetails.get().getUserName());
            customerOrders.setUserGivenName(userDetails.get().getUserProfile_GivenName());
            customerOrders.setUserPhoneNumber(userDetails.get().getUserProfile_PhoneNumber());
            customerOrders.setUserAddress(userDetails.get().getUserProfile_Address());
            if (customerOrders.getDeliveryAddress() != null) {
                customerOrders.setDeliveryAddress(customerOrders.getDeliveryAddress());
            } else {
                customerOrders.setDeliveryAddress(userDetails.get().getUserProfile_Address());
            }
            customerOrders.setDeliveryCharges(deliveryCharges);
            customerOrders.setSpeacialDiscountValue(totalAmountBeforeDiscountAndTax.get() - totalAmountAfterSpecialDiscount);
            customerOrders.setAmountBeforeDiscount(totalAmountBeforeDiscountAndTax.get());
            customerOrders.setAmountAfterDiscount(totalAmountAfterSpecialDiscount);
            customerOrders.setAmountBeforeTax(totalAmountAfterSpecialDiscount + deliveryCharges);
            customerOrders.setOrdersPaybleamount(paybleAmountAfterTax);
            customerOrders.setOrderDelivered(false);
            customerOrders.setPurchaseDate(LocalDate.now());
            customerOrders.setPurchaseTime(LocalTime.now());

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
