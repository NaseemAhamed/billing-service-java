package com.retail.pricing.predicates;

import com.retail.pricing.enums.UserType;
import com.retail.pricing.models.User;
import com.retail.pricing.util.BillingConstants;
import com.retail.pricing.util.DateUtil;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface UserPredicates {
    default Predicate<User> isValidUser() {
        return user -> user != null && user.getType() != null;
    }

    default Predicate<User> isEmployee() {
        return user -> user.getType() != null && user.getType().equals(UserType.EMPLOYEE);
    }

    default Predicate<User> isAffiliated() {
        return user -> user.getType() != null && user.getType().equals(UserType.AFFILIATION);
    }

    default Predicate<User> isLoyaltyPlanEligible() {
        return user -> user.getType() != null && user.getType().equals(UserType.CUSTOMER) && DateUtil.getDiffYears(LocalDate.now(), user.getSubscribedDate()) > BillingConstants.MIN_LOYALTY_PERIOD_YEARS;
    }
}
