package com.example.retail.models.taxutility;

import com.example.retail.repository.taxutility.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class TaxCalculator {

    @Autowired
    TaxRepository taxRepository;

    public Float calcAmountAfterTax(List<String> applicableTaxes, Float discountedPrice) {

        AtomicReference<Float> taxAmount = new AtomicReference<>(0F);
        Float amountAfterTax = 0F;
        applicableTaxes.forEach(applicableTax -> {
            Optional<Taxes> taxes = taxRepository.findBytaxName(applicableTax);
            if (!taxes.isEmpty()) {
                taxAmount.set(taxAmount.get() + ((taxes.get().getTaxPercent() * discountedPrice) / 100));
            }
        });

        amountAfterTax = discountedPrice + taxAmount.get();

        return amountAfterTax;
    }

    public Float calcTaxAmount(String itemCategory, Float discountedPrice) {
        return 0F;
    }
}
