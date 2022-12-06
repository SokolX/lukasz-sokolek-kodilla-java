package com.kodilla.good.patterns.challenges.task1;

import com.kodilla.good.patterns.challenges.example1.User;

import java.time.LocalDateTime;

public record OrderRequest(User user, LocalDateTime orderDate, Product product) {
}
