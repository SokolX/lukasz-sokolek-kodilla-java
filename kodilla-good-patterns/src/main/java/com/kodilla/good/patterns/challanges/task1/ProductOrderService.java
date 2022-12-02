package com.kodilla.good.patterns.challanges.task1;

import com.kodilla.good.patterns.challanges.example.User;

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
