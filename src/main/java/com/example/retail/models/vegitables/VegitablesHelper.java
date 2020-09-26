package com.example.retail.models.vegitables;

import com.example.retail.models.taxutility.TaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class VegitablesHelper {

    @Autowired
    TaxCalculator taxCalculator;

    public Float calcAmountAfterTax(List<String> applicableTaxes, Float discountedPrice) {

        return taxCalculator.calcAmountAfterTax(applicableTaxes, discountedPrice);
    }

    public Float calcTaxAmount(String itemCategory, Float discountedPrice) {
        return taxCalculator.calcTaxAmount(itemCategory, discountedPrice);
    }
}
