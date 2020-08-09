package com.example.retail.models.vegitables;

import com.example.retail.models.taxutility.TaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VegitablesHelper {

    @Autowired
    TaxCalculator taxCalculator;

    public Float calcAmountAfterTax(String[] applicableTaxes, Float discountedPrice) {

        return taxCalculator.calcAmountAfterTax(applicableTaxes, discountedPrice);
    }

    public Float calcTaxAmount(String itemCategory, Float discountedPrice) {
        return taxCalculator.calcTaxAmount(itemCategory, discountedPrice);
    }
}
