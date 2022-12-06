package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDateTime;

public interface OrderService {

    boolean createOrder(Producer producer, LocalDateTime dateOrder, Product product, int quantity);
}
