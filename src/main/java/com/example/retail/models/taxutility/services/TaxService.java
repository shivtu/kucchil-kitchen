package com.example.retail.models.taxutility.services;

import com.example.retail.models.taxutility.Taxes;
import com.example.retail.models.taxutility.repository.TaxRepository;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.JWTDetails;
import com.example.retail.util.ValidationResponse;
import com.example.retail.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaxService {

    @Autowired
    TaxRepository taxRepository;

    @Autowired
    JWTDetails JWTDetails;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    Validations validations;

    public ResponseEntity<Object> addTax(HttpServletRequest request, Taxes newTax) {
        try {
            ValidationResponse res = validations.validateNewTax(newTax);
            if(res.getStatusCode() != validations.validationSuccessCode) {
                return ResponseEntity.status(res.getStatusCode()).body(res);
            }
            String lastUpdatedBy = JWTDetails.userName(request);

            newTax.setTaxLastUpdatedBy(lastUpdatedBy);
            newTax.setTaxLastUpdatedOn(LocalDateTime.now());


            List<Object> finalRes = new ArrayList<>();
            finalRes.add(taxRepository.save(newTax));

            return ResponseEntity.status(201).body(
                    createResponse.createSuccessResponse(201, "New tax created", finalRes)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }
    }

    public List<Taxes> forHelperFunctionFindAll() {
        return taxRepository.findAll();
    }
}
