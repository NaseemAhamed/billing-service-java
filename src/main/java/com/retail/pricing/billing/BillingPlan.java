package com.retail.pricing.billing;

import com.retail.pricing.models.LineItem;
import com.retail.pricing.models.User;
import com.retail.pricing.predicates.ProductPredicates;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BillingPlan implements ProductPredicates {
    private static final Logger LOGGER = Logger.getLogger(CalculateBill.class.getName());
    protected double discount;

    abstract void getDiscount();

    public double generateBill(final LineItem lineItem, final User user) {
        double price = lineItem.getPrice();
        LOGGER.log(Level.INFO, "Maximum Retail Price : {0} dollars", price);

        if (isGrocery().negate().test(lineItem)) {
            price = price * (1.0 - discount); // discounts based on user
            LOGGER.log(Level.INFO, "Discount to be applied based on user type: {0} percent ", discount * 100);
            LOGGER.log(Level.INFO, "Discounted price based on user type: {0}", price);
        }

        double hundreds = Math.floor(((int) lineItem.getPrice() % 1000) / (double) 100);
        double priceToDiscount = (hundreds * 5);
        price = price - priceToDiscount; // discounts based on item price
        LOGGER.log(Level.INFO, "Discount to be applied based on item price: {0} dollars", priceToDiscount);
        LOGGER.log(Level.INFO, "NET AMOUNT: {0}", price);

        return price;
    }
}//end of BillingPlan class.
