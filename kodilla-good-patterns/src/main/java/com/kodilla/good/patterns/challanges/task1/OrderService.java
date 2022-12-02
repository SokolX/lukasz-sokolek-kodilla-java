package com.kodilla.good.patterns.challanges.task1;

import com.kodilla.good.patterns.challanges.example.User;

import java.time.LocalDateTime;

public interface OrderService {

    boolean payment(User user, LocalDateTime dateOrder, Product product);
}
