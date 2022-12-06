package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDateTime;

public class OrderProductRepository implements ProductRepository {
    @Override
    public void createOrder(Producer producer, Product product, LocalDateTime date, int quantity) {
        System.out.println("Created order in " + producer.getProducerName() +
                " at " + date +
                ", " + product.name() +
                ", " + quantity + " szt." +
                ", total costs = " + quantity * product.price() +
                " $ \n"
        );
    }
}
