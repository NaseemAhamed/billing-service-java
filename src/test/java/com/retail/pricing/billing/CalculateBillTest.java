package com.retail.pricing.billing;

import com.retail.pricing.enums.ProductType;
import com.retail.pricing.enums.UserType;
import com.retail.pricing.exception.BillingException;
import com.retail.pricing.models.Inputs;
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

public class CalculateBillTest {
    @InjectMocks
    CalculateBill calculateBill;

    @Mock
    User user;

    @Mock
    LineItem lineItem;

    @Mock
    Inputs inputs;

    @BeforeEach
    public void setUp() throws BillingException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEmployeePlan() throws BillingException {
        user = new User(UserType.EMPLOYEE, LocalDate.now());
        Mockito.when(inputs.getUser()).thenReturn(user);
        lineItem = new LineItem(ProductType.HOUSEWARES, 500);
        Mockito.when(inputs.getLineItem()).thenReturn(lineItem);
        assertEquals(325.0, calculateBill.clientMethod(inputs), 0.01);
        ;

    }

    @Test
    public void testAffiliationPlan() throws BillingException {
        user = new User(UserType.AFFILIATION, LocalDate.now());
        Mockito.when(inputs.getUser()).thenReturn(user);
        lineItem = new LineItem(ProductType.HOUSEWARES, 500);
        Mockito.when(inputs.getLineItem()).thenReturn(lineItem);
        assertEquals(425.0, calculateBill.clientMethod(inputs), 0.01);
    }

    @Test
    public void testLoyaltyPlan() throws BillingException {
        user = new User(UserType.CUSTOMER, LocalDate.now().plusYears(3));
        Mockito.when(inputs.getUser()).thenReturn(user);
        lineItem = new LineItem(ProductType.STATIONERY, 500);
        Mockito.when(inputs.getLineItem()).thenReturn(lineItem);
        assertEquals(450.0, calculateBill.clientMethod(inputs), 0.01);
    }

    @Test
    public void testEmployeePlanWithGroceries() throws BillingException { //Only Single discount should be applied
        user = new User(UserType.EMPLOYEE, LocalDate.now());
        Mockito.when(inputs.getUser()).thenReturn(user);
        lineItem = new LineItem(ProductType.GROCERIES, 500);
        Mockito.when(inputs.getLineItem()).thenReturn(lineItem);
        assertEquals(475.0, calculateBill.clientMethod(inputs), 0.01);
    }

    @Test
    public void testBillingException() throws BillingException {
        user = new User(null, LocalDate.now());
        Mockito.when(inputs.getUser()).thenReturn(user);
        lineItem = new LineItem(ProductType.STATIONERY, 500);
        Mockito.when(inputs.getLineItem()).thenReturn(lineItem);
        assertThrows(BillingException.class, () -> calculateBill.clientMethod(inputs));
    }

    @Test
    public void testNormalPlan() throws BillingException {
        user = new User(UserType.CUSTOMER, LocalDate.now());
        Mockito.when(inputs.getUser()).thenReturn(user);
        lineItem = new LineItem(ProductType.STATIONERY, 500);
        Mockito.when(inputs.getLineItem()).thenReturn(lineItem);
        assertEquals(475, calculateBill.clientMethod(inputs), 0.01);
    }

    @Test
    public void testDriverFunctionIT() throws BillingException {
        String[] args = {"a", "b"};

        CalculateBill.main(args);
    }

}
