package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {

        Product butter = new Product(1, "Butter", 6.0);
        Product oatBran = new Product(2, "Oat bran", 3.5);
        Product watermelon = new Product(3, "Watermelon", 9.0);

        Producer extraFoodShop = new Producer("ExtraFoodShop", butter, 100000);
        Producer healthyShop = new Producer("HealthyShop", watermelon, 100);
        Producer glutenFreeShop = new Producer("GlutenFreeShop", oatBran, 100000);

        OrderRequest orderRequestInExtraFoodShop = new OrderRequest(extraFoodShop, LocalDateTime.now(), butter, 500);
        OrderRequest orderRequestInHealthyShop = new OrderRequest(healthyShop, LocalDateTime.now(), oatBran, 120);
        OrderRequest orderRequestInGlutenFreeShop = new OrderRequest(glutenFreeShop, LocalDateTime.now(), watermelon, 120);

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ProductOrderService(), new OrderProductRepository());
        orderProcessor.process(orderRequestInExtraFoodShop);
        orderProcessor.process(orderRequestInHealthyShop);
        orderProcessor.process(orderRequestInGlutenFreeShop);

    }
}
