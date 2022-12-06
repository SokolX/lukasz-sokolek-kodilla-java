package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDateTime;

public interface ProductRepository {

    void createOrder(Producer producer, Product product, LocalDateTime date, int quantity);
}
