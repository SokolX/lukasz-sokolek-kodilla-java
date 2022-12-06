package com.kodilla.good.patterns.challenges.task1;

import com.kodilla.good.patterns.challenges.example1.MailService;
import com.kodilla.good.patterns.challenges.example1.User;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {

        User user = new User("Test", "Test", "test@test.pl");
        Product product = new Product(1, "T-Shirt", 59.99);
        OrderRequest orderRequest = new OrderRequest(user, LocalDateTime.now(), product);

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ProductOrderService(), new OrderPaymentRepository());
        orderProcessor.process(orderRequest);

    }
}
