package com.kodilla.good.patterns.challanges.task1;

import com.kodilla.good.patterns.challanges.example.User;

import java.time.LocalDateTime;

public record OrderRequest(User user, LocalDateTime orderDate, Product product) {
}
