package com.kodilla.good.patterns.challenges.food2door.repository;

import com.kodilla.good.patterns.challenges.food2door.model.Producer;
import com.kodilla.good.patterns.challenges.food2door.model.Product;

import java.time.LocalDateTime;

public interface ProductRepository {

    void createOrder(Producer producer, Product product, LocalDateTime date, int quantity);
}
