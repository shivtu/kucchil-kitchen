package com.example.retail.models.deliveryutility.services;

import com.example.retail.models.deliveryutility.DeliveryLocations;
import com.example.retail.models.deliveryutility.DeliveryLocationsPage;
import com.example.retail.models.deliveryutility.repository.DeliveryLocationsRepository;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.ValidationResponse;
import com.example.retail.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class DeliveryLocationsServices {

    @Autowired
    CreateResponse createResponse;

    @Autowired
    DeliveryLocationsRepository deliveryLocationsRepository;

    @Autowired
    Validations validations;


    public ResponseEntity<Object> addNewDeliveryLocation (DeliveryLocations deliveryLocations) {
        try {
            String deliveryLocationsSubId = deliveryLocations.getAreaName().toLowerCase() + "--" + deliveryLocations.getAreaPinCode().toLowerCase();
            deliveryLocations.setDeliveryLocationSubId(deliveryLocationsSubId);
            ValidationResponse validationResponse = validations.validateNewDeliveryLocation(deliveryLocationsSubId);

            /***
             * Validate if delivery location with same area name and pin code already exists
             */
            if(validationResponse.getStatusCode() != validations.validationSuccessCode) {
                int validationErrorCode = validationResponse.getStatusCode();
                return ResponseEntity.status(validationErrorCode).body(
                    validationResponse
                );
            }


            DeliveryLocations res = deliveryLocationsRepository.save(deliveryLocations);
            return ResponseEntity.status(201).body(createResponse.createSuccessResponse(201, "Created", res));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(createResponse.createErrorResponse(500, e.getLocalizedMessage(), "NA"));
        }
    }

    public ResponseEntity<Object> findPaginatedDeliveryLocationsPaginated (DeliveryLocationsPage deliveryLocationsPage){
        try{
            Sort sort = Sort.by(deliveryLocationsPage.getSortDirection(), deliveryLocationsPage.getSortBy());
            Pageable pageable = PageRequest.of(deliveryLocationsPage.getPageNo(), deliveryLocationsPage.getPageSize(), sort);
            Page res = deliveryLocationsRepository.findAll(pageable);
            return ResponseEntity.status(200).body(
                createResponse.createSuccessResponse(200, res.getTotalElements() + " items found", res)
            );

        } catch (Exception e) {
            return ResponseEntity.status(500).body("");
        }
    }

}
