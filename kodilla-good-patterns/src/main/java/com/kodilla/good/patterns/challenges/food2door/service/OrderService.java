package com.kodilla.good.patterns.challenges.food2door.service;

import com.kodilla.good.patterns.challenges.food2door.model.Producer;
import com.kodilla.good.patterns.challenges.food2door.model.Product;

import java.time.LocalDateTime;

public interface OrderService {

    boolean createOrder(Producer producer, LocalDateTime dateOrder, Product product, int quantity);
}
