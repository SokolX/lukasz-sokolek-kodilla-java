package com.kodilla.good.patterns.challanges;

import com.kodilla.good.patterns.challanges.example.CarRentalRepository;
import com.kodilla.good.patterns.challanges.example.CarRentalService;
import com.kodilla.good.patterns.challanges.example.MailService;
import com.kodilla.good.patterns.challanges.example.User;
import com.kodilla.good.patterns.challanges.task1.*;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {

        System.out.println("---> EXAMPLE <---");
        User user = new User("Test", "Test", "test@test.pl");

        LocalDateTime rentFrom = LocalDateTime.of(2017, 8, 1, 12, 0);
        LocalDateTime rentTo = LocalDateTime.of(2017, 8, 10, 12, 0);

        CarRentalService carRentalService = new CarRentalService();
        boolean isRented = carRentalService.rent(user, rentFrom, rentTo);

        MailService mailService = new MailService();
        CarRentalRepository carRentalRepository = new CarRentalRepository();

        if (isRented) {
            mailService.inform(user);
            carRentalRepository.createRental(user, rentFrom, rentTo);
        } else {
            System.out.println("Car rent has been rejected!");
        }

        System.out.println("\n---> TASK1 <---");
        Product product = new Product(1, "T-Shirt", 59.99);
        OrderRequest orderRequest = new OrderRequest(user, LocalDateTime.now(), product);

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ProductOrderService(), new OrderPaymentRepository());
        orderProcessor.process(orderRequest);


    }
}
