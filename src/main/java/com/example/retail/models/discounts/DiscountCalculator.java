package com.example.retail.models.discounts;

import org.springframework.stereotype.Component;

@Component
public class DiscountCalculator {

    public Float calcVegDiscountedPrice(Float sellingPrice, Float discountPercent) {
        return sellingPrice - ((discountPercent * sellingPrice) / 100);
    }
}
