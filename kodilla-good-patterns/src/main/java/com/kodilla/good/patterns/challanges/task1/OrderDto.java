package com.kodilla.good.patterns.challanges.task1;

import com.kodilla.good.patterns.challanges.example.User;

public class OrderDto {

    private User user;
    private boolean isPaid;

    public OrderDto(final User user, final boolean isPaid) {
        this.user = user;
        this.isPaid = isPaid;
    }

    public User getUser() { return user; }

    public boolean isPaid() { return isPaid; }
}
