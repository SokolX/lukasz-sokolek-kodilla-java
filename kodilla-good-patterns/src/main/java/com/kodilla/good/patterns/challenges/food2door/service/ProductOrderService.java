package com.kodilla.good.patterns.challenges.food2door.service;

import com.kodilla.good.patterns.challenges.food2door.model.Producer;
import com.kodilla.good.patterns.challenges.food2door.model.Product;

import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {
    @Override
    public boolean createOrder(Producer producer, LocalDateTime dateAddedProduct, Product product, int quantity) {
        System.out.println(
                "Order in " + producer.getProducerName() +
                ", date: " + dateAddedProduct +
                ", product : " + product.name() +
                ", total cost: " + product.price() * quantity + " $"
        );

        return true;
    }
}
