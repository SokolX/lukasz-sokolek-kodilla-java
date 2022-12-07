package com.kodilla.good.patterns.challenges.food2door.model;

public class Producer {

    private String producerName;
    private Product product;
    private int quantity;

    public Producer(String producerName, Product product, int quantity) {
        this.producerName = producerName;
        this.product = product;
        this.quantity = quantity;
    }

    public String getProducerName() {
        return producerName;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
