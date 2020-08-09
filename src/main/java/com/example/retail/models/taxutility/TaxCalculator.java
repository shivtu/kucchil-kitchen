package com.example.retail.models.taxutility;

import com.example.retail.models.taxutility.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class TaxCalculator {

    @Autowired
    TaxRepository taxRepository;

    public Float calcAmountAfterTax(String[] applicableTaxes, Float discountedPrice) {
        int l = applicableTaxes.length;
        Float taxAmount = 0F;
        Float amountAfterTax = 0F;
        for (int i = 0; i < l; i++) {
            Optional<Taxes> taxes = taxRepository.findBytaxName(applicableTaxes[i]);
            if (!taxes.isEmpty()) {
                taxAmount = taxAmount + ((taxes.get().getTaxPercent() * discountedPrice)/100);
            }
        }

        amountAfterTax = discountedPrice + taxAmount;

        return amountAfterTax;
    }

    public Float calcTaxAmount(String itemCategory, Float discountedPrice) {
        return 0F;
    }
}
