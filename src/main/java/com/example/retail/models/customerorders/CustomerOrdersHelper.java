package com.example.retail.models.customerorders;

import com.example.retail.models.discounts.DiscountCalculator;
import com.example.retail.repository.taxutility.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrdersHelper {

    @Autowired
    DiscountCalculator discountCalculator;

    @Autowired
    TaxRepository taxRepository;

    public Float calcTax (Float totalAmountAfterSpecialDiscount, String itemCategory) {
        return totalAmountAfterSpecialDiscount;
    }

    public Float calcVegDiscountedPrice(Float sellingPrice, Float discountPercent) {
        return discountCalculator.calcDiscountedPrice(sellingPrice, discountPercent);
    }

    public Float calcSpecialDiscount (Float totalAmountBeforeDiscountAndTax, Float discountPercent) {
        return discountCalculator.calcSpecialDiscount(totalAmountBeforeDiscountAndTax, discountPercent);
    }

    public Float calcLoyaltyDiscount (String customerName) {
        return discountCalculator.calcLoyaltyDiscount(customerName);
    }
}
