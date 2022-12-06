package com.kodilla.good.patterns.challenges.task1;

import com.kodilla.good.patterns.challenges.example1.User;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {
    @Override
    public boolean payment(User user, LocalDateTime dateAddedProduct, Product product) {
        System.out.println(
                "Order was paid by " + user.name() +
                " " + user.surname() +
                ", date: " + dateAddedProduct +
                ", paid: " + product.price()
        );

        return true;
    }
}
