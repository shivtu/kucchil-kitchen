package com.example.retail.models.discounts;

import com.example.retail.models.customerorders.CustomerOrders;
import com.example.retail.models.customerorders.repository.CustomerOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class DiscountCalculator {

    @Autowired
    CustomerOrdersRepository customerOrdersRepository;

    public Float calcVegDiscountedPrice(Float sellingPrice, Float vegitableOfferedDiscount) {
        Float discount = (vegitableOfferedDiscount * sellingPrice) / 100;
        return sellingPrice - discount;
    }

    public Float calcSpecialDiscount (Float totalAmountBeforeDiscountAndTax, Float discountPercent) {
        return (discountPercent * totalAmountBeforeDiscountAndTax)/100;
    }

    public Float calcLoyaltyDiscount (String customerName) {
        List<CustomerOrders> allCustomerOrders = customerOrdersRepository.findAllOrdersByCustomer(customerName);
        AtomicReference<Float> proposedDiscount = new AtomicReference<>(0F);
        AtomicInteger count = new AtomicInteger();
        if(allCustomerOrders.size() > 2) {
            allCustomerOrders.forEach(customerOrders -> {
                proposedDiscount.set(proposedDiscount.get() + customerOrders.getOrdersPaybleamount());
                count.getAndIncrement();
            });
        }

        return (proposedDiscount.get()/count.get())/12;
    }
}
