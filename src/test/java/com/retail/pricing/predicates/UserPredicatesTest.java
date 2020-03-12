package com.retail.pricing.predicates;

import com.retail.pricing.enums.UserType;
import com.retail.pricing.models.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;


public class UserPredicatesTest {

    UserPredicates userPredicates = spy(UserPredicates.class);

    @Test
    public void testIsEmployee() {
        assertTrue(userPredicates.isEmployee().test(new User(UserType.EMPLOYEE, LocalDate.now())));
        assertFalse(userPredicates.isEmployee().test(new User(UserType.CUSTOMER, LocalDate.now())));
    }

    @Test
    public void testAffiliatedUser() {
        assertTrue(userPredicates.isAffiliated().test(new User(UserType.AFFILIATION, LocalDate.now())));
        assertFalse(userPredicates.isAffiliated().test(new User(UserType.CUSTOMER, LocalDate.now())));
    }

    @Test
    public void testLoyaltyUser() {
        assertTrue(userPredicates.isLoyaltyPlanEligible().test(new User(UserType.CUSTOMER, LocalDate.now().plusYears(3))));
        assertFalse(userPredicates.isLoyaltyPlanEligible().test(new User(UserType.EMPLOYEE, LocalDate.now())));
    }

    @Test
    public void testValidUser() {
        assertTrue(userPredicates.isValidUser().test(new User(UserType.CUSTOMER, LocalDate.now())));
        assertFalse(userPredicates.isValidUser().test(new User(null, LocalDate.now())));
    }
}
