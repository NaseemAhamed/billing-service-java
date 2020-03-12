package com.retail.pricing.billing;

import com.retail.pricing.enums.UserType;
import com.retail.pricing.exception.BillingException;
import com.retail.pricing.models.LineItem;
import com.retail.pricing.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GetBillingPlanFactoryTest {

    @InjectMocks
    GetBillingPlanFactory getBillingPlanFactory;

    @Mock
    User user;

    @Mock
    LineItem lineItem;

    @BeforeEach
    public void setUp() throws BillingException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoyaltyPlanInstance() throws BillingException {
        Mockito.when(user.getType()).thenReturn(UserType.CUSTOMER);
        Mockito.when(user.getSubscribedDate()).thenReturn(LocalDate.now().plusYears(3));
        assertEquals(getBillingPlanFactory.getBillingPlan(user).getClass(), LoyaltyPlan.class);
    }

    @Test
    public void testNormalPlanInstance() throws BillingException {
        Mockito.when(user.getType()).thenReturn(UserType.CUSTOMER);
        Mockito.when(user.getSubscribedDate()).thenReturn(LocalDate.now());
        assertEquals(getBillingPlanFactory.getBillingPlan(user).getClass(), NormalPlan.class);
    }

    @Test
    public void testEmployeePlanInstance() throws BillingException {
        Mockito.when(user.getType()).thenReturn(UserType.EMPLOYEE);
        assertEquals(getBillingPlanFactory.getBillingPlan(user).getClass(), EmployeePlan.class);
    }

    @Test
    public void testAffiliationPlanInstance() throws BillingException {
        Mockito.when(user.getType()).thenReturn(UserType.AFFILIATION);
        assertEquals(getBillingPlanFactory.getBillingPlan(user).getClass(), AffiliationPlan.class);
    }

    @Test
    public void testInvalidUser() throws BillingException {
        user = null;
        assertThrows(BillingException.class, () -> getBillingPlanFactory.getBillingPlan(user));
    }

}
