package com.kodilla.good.patterns.challanges.example;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {

        User user = new User("John", "Wekl", "test@test.pl");

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

    }
}
