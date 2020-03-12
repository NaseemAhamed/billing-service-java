package com.retail.pricing.models;

public class Inputs {
    User user;
    LineItem lineItem;

    public User getUser() {
        return user;
    }

    public LineItem getLineItem() {
        return lineItem;
    }


    public Inputs(User user, LineItem lineItem) {
        super();
        this.user = user;
        this.lineItem = lineItem;
    }


}
