package com.kodilla.good.patterns.challanges.task1;

import com.kodilla.good.patterns.challanges.example.User;

import java.time.LocalDateTime;

public class OrderPaymentRepository implements PaymentRepository {
    @Override
    public void createPayment(User user, LocalDateTime date, double sum) {
        System.out.println("Created payment of user: " + user.name() +
                " at " + date +
                ", sum = " + sum + " zł"
        );
    }
}
