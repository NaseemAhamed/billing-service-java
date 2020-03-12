package com.retail.pricing.models;

import com.retail.pricing.exception.BillingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputsTest {
    @InjectMocks
    Inputs inputs;

    @Mock
    User user;

    @Mock
    LineItem lineItem;


    @BeforeEach
    public void setUp() throws BillingException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLineItemInstance() throws BillingException {
        assertEquals(inputs.getLineItem().getClass(), lineItem.getClass());
    }

    @Test
    public void testUserInstance() throws BillingException {
        assertEquals(inputs.getUser().getClass(), user.getClass());
    }

}
