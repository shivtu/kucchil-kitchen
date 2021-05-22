package com.example.retail.services.deliveryutility;

import com.example.retail.models.deliveryutility.DeliveryCharges;
import com.example.retail.repository.deliveryutility.DeliveryChargesRepository;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.ValidationResponse;
import com.example.retail.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryChargeServices {

    @Autowired
    DeliveryChargesRepository deliveryChargesRepository;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    Validations validations;

    public ResponseEntity<Object> createDeliveryChargeConstraint(DeliveryCharges deliveryCharges) {

        try {
            ValidationResponse validationRes = validations.validateDeliveryChargeConstraint(deliveryCharges);
            if(validationRes.getStatusCode() != validations.validationSuccessCode) {
                return ResponseEntity.status(validationRes.getStatusCode()).body(
                        validationRes
                );
            }
            DeliveryCharges res = deliveryChargesRepository.save(deliveryCharges);
            List<Object> finalRes = new ArrayList<>();
            finalRes.add(res);
            return ResponseEntity.status(201).body(
                    createResponse.createSuccessResponse(201, "Delivery constraint created", finalRes)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }
    }

    public List<DeliveryCharges> findAll() {
        return deliveryChargesRepository.findAll();
    }
}
