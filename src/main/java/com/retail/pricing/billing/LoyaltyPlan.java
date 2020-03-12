package com.retail.pricing.billing;

public class LoyaltyPlan extends BillingPlan {

    @Override
    void getDiscount() {
        discount = 0.05;

    }

}//end of LoyaltyPlan class.
