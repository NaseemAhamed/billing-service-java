package com.retail.pricing.predicates;

import com.retail.pricing.enums.ProductType;
import com.retail.pricing.models.LineItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

public class ProductPredicatesTest {
    ProductPredicates productPredicates = spy(ProductPredicates.class);

    @Test
    public void testIsGrocery() {
        assertTrue(productPredicates.isGrocery().test(new LineItem(ProductType.GROCERIES, 7)));
        assertFalse(productPredicates.isGrocery().test(new LineItem(ProductType.HOUSEWARES, 7)));
    }
}
