package com.kodilla.good.patterns.challenges.task1;

import com.kodilla.good.patterns.challenges.example1.User;

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
