package com.retail.pricing.billing;

import com.retail.pricing.exception.BillingException;
import com.retail.pricing.models.User;
import com.retail.pricing.predicates.UserPredicates;
import com.retail.pricing.util.BillingConstants;

public class GetBillingPlanFactory implements UserPredicates {
    /**
     * @param user
     * @return BillingPlan
     * @throws BillingException
     */
    public BillingPlan getBillingPlan(final User user) throws BillingException {
        if (isValidUser().negate().test(user)) {
            throw new BillingException(BillingConstants.INVALID_USER);
        }

        if (isEmployee().test(user)) {
            return new EmployeePlan();
        } else if (isAffiliated().test(user)) {
            return new AffiliationPlan();
        } else if (isLoyaltyPlanEligible().test(user)) {
            return new LoyaltyPlan();
        } else {
            return new NormalPlan();
        }
    }
}// end of GetBillingPlanFactory class.
