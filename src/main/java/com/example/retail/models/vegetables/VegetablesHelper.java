package com.example.retail.models.vegetables;

import com.example.retail.models.taxutility.TaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VegetablesHelper {

    @Autowired
    TaxCalculator taxCalculator;

    public Float calcAmountAfterTax(List<String> applicableTaxes, Float discountedPrice) {

        return taxCalculator.calcAmountAfterTax(applicableTaxes, discountedPrice);
    }

    public Float calcTaxAmount(String itemCategory, Float discountedPrice) {
        return taxCalculator.calcTaxAmount(itemCategory, discountedPrice);
    }
}
