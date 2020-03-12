package com.retail.pricing.billing;

import com.retail.pricing.enums.ProductType;
import com.retail.pricing.enums.UserType;
import com.retail.pricing.exception.BillingException;
import com.retail.pricing.models.Inputs;
import com.retail.pricing.models.LineItem;
import com.retail.pricing.models.User;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculateBill {
    private static final Logger LOGGER = Logger.getLogger(CalculateBill.class.getName());

    public double clientMethod(final Inputs inputs) throws BillingException {
        GetBillingPlanFactory getBillingPlanFactory = new GetBillingPlanFactory();
        BillingPlan billingPlan = getBillingPlanFactory.getBillingPlan(inputs.getUser());
        LOGGER.log(Level.INFO, "User type: " + inputs.getUser().getType());
        billingPlan.getDiscount();
        return billingPlan.generateBill(inputs.getLineItem(), inputs.getUser());
    }

    //Driver function
    public static void main(String[] args) throws BillingException {
        CalculateBill calculateBill = new CalculateBill();
        Inputs inputs = new Inputs(new User(UserType.EMPLOYEE, LocalDate.now()),
                new LineItem(ProductType.HOUSEWARES, 550));
        calculateBill.clientMethod(inputs);
    }

}// end of CalculateBill class.
