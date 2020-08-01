package com.example.retail.models.customerorders;

import com.example.retail.models.discounts.DiscountCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrdersHelper {

    @Autowired
    DiscountCalculator discountCalculator;

    public Float totalPaybleAfterTax (Float totalAmountAfterSpecialDiscount) {
        return 0F;
    }

    public Float calcVegDiscountedPrice(Float sellingPrice, Float discountPercent) {
        return discountCalculator.calcVegDiscountedPrice(sellingPrice, discountPercent);
    }

    public Float calcSpecialDiscount (Float totalAmountBeforeDiscountAndTax, Float discountPercent) {
        return discountCalculator.calcSpecialDiscount(totalAmountBeforeDiscountAndTax, discountPercent);
    }

    public Float calcLoyaltyDiscount (String customerName) {
        return discountCalculator.calcLoyaltyDiscount(customerName);
    }
}
