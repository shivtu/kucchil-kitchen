package com.example.retail.util;

import com.example.retail.models.deliveryutility.DeliveryCharges;
import com.example.retail.models.deliveryutility.services.DeliveryChargeServices;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.models.itemcategories.ItemCategories;
import com.example.retail.models.itemcategories.service.ItemCategoriesService;
import com.example.retail.models.taxutility.Taxes;
import com.example.retail.models.taxutility.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UtilityServices {

    @Autowired
    TaxService taxService;

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @Autowired
    ItemCategoriesService itemCategoriesService;

    @Autowired
    DeliveryChargeServices deliveryChargeServices;

    @Autowired
    CreateResponse createResponse;

    public ResponseEntity<?> findAllUtilities () {
        List<Taxes> taxes = taxService.forHelperFunctionFindAll();
        List<CustomerOrdersDiscount> customerOrdersDiscounts = customerOrdersDiscountServices.findAllDiscounts();
        List<ItemCategories> itemCategories = itemCategoriesService.findAll();
        List <DeliveryCharges> deliveryCharges = deliveryChargeServices.findAll();

        int count = taxes.size() + customerOrdersDiscounts.size() + itemCategories.size() + deliveryCharges.size();

        Map<String, Object> res = new HashMap<>();

        res.put("taxes", taxes);
        res.put("customerOrdersDiscounts", customerOrdersDiscounts);
        res.put("itemCategories", itemCategories);
        res.put("deliveryCharges", deliveryCharges);

        List<Map<String, Object>> finalRes = new ArrayList<>();
        finalRes.add(res);

        return ResponseEntity.status(200).body(
                createResponse.createSuccessResponse(
                        200,
                        count + " utilities found",
                        finalRes
                )
        );
    }
}
