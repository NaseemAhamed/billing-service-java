package com.retail.pricing.billing;

import com.retail.pricing.enums.ProductType;
import com.retail.pricing.exception.BillingException;
import com.retail.pricing.models.LineItem;
import com.retail.pricing.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class BillingPlanTest {
    @Mock
    User user;

    @Mock
    LineItem lineItem;

    @InjectMocks
    BillingPlanImpl billingPlanImpl;


    @BeforeEach
    public void setUp() throws BillingException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testItemsWithoutGrocery() throws BillingException {
        Mockito.when(lineItem.getPrice()).thenReturn(500);
        billingPlanImpl.generateBill(lineItem, user);

    }

    @Test
    public void testItemsWithGrocery() throws BillingException {
        Mockito.when(lineItem.getPrice()).thenReturn(500);
        Mockito.when(lineItem.getProductType()).thenReturn(ProductType.GROCERIES);
        billingPlanImpl.generateBill(lineItem, user);
    }


}
