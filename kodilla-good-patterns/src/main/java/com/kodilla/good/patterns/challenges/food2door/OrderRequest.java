package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDateTime;

public record OrderRequest(Producer producer, LocalDateTime orderDate, Product product, int quantity) {
}
