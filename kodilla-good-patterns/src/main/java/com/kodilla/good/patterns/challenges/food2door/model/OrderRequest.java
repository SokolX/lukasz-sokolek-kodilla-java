package com.kodilla.good.patterns.challenges.food2door.model;

import com.kodilla.good.patterns.challenges.food2door.model.Producer;
import com.kodilla.good.patterns.challenges.food2door.model.Product;

import java.time.LocalDateTime;

public record OrderRequest(Producer producer, LocalDateTime orderDate, Product product, int quantity) {
}
