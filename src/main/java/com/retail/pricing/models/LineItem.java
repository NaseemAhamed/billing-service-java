package com.retail.pricing.models;

import com.retail.pricing.enums.ProductType;

public class LineItem {
    private ProductType productType;

    private int price;

    public LineItem(ProductType productType, int price) {
        this.productType = productType;
        this.price = price;
    }


    public ProductType getProductType() {
        return productType;
    }

    public int getPrice() {
        return price;
    }
}
