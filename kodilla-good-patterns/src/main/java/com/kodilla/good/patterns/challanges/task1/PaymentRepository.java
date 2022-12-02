package com.kodilla.good.patterns.challanges.task1;

import com.kodilla.good.patterns.challanges.example.User;

import java.time.LocalDateTime;

public interface PaymentRepository {

    void createPayment(User user, LocalDateTime date, double sum);
}
