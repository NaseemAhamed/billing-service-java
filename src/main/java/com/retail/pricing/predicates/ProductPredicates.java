package com.retail.pricing.predicates;

import com.retail.pricing.enums.ProductType;
import com.retail.pricing.models.LineItem;

import java.util.function.Predicate;

public interface ProductPredicates {
    default Predicate<LineItem> isGrocery() {
        return lineItem -> lineItem.getProductType() != null && lineItem.getProductType().equals(ProductType.GROCERIES);
    }
}
