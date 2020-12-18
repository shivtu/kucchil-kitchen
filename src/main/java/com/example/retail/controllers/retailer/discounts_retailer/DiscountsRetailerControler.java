package com.example.retail.controllers.retailer.discounts_retailer;

import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.util.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/retailer/discount")
@CrossOrigin(origins = "*")
public class DiscountsRetailerControler {

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @Autowired
    CreateResponse createResponse;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createSpecialDiscount(HttpServletRequest request, @RequestBody CustomerOrdersDiscount customerOrdersDiscount) {
        return customerOrdersDiscountServices.createSpecialDiscount(request, customerOrdersDiscount);
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAllDiscounts() {
        try {
            List<CustomerOrdersDiscount> result = customerOrdersDiscountServices.findAllDiscounts();
            int resultCount = result.size();
            return ResponseEntity.status(200).body(
                    createResponse.createSuccessResponse(
                            200,
                            resultCount + " item(s) found",
                            result
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(
                            500,
                            e.getMessage(),
                            "NA"
                    )
            );
        }
    }
}
