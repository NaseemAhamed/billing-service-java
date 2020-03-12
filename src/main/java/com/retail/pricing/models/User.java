package com.retail.pricing.models;

import com.retail.pricing.enums.UserType;

import java.time.LocalDate;

public class User {
    private UserType type;
    private LocalDate subscribedDate;

    public User(UserType type, LocalDate subscribedDate) {
        this.type = type;
        this.subscribedDate = subscribedDate;
    }

    public LocalDate getSubscribedDate() {
        return subscribedDate;
    }

    public UserType getType() {
        return type;
    }
}
