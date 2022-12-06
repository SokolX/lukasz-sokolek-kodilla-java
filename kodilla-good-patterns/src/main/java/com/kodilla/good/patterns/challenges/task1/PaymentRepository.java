package com.kodilla.good.patterns.challenges.task1;

import com.kodilla.good.patterns.challenges.example1.User;

import java.time.LocalDateTime;

public interface PaymentRepository {

    void createPayment(User user, LocalDateTime date, double sum);
}
