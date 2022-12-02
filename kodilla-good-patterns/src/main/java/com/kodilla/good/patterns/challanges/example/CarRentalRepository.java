package com.kodilla.good.patterns.challanges.example;

import java.time.LocalDateTime;

public class CarRentalRepository implements RentalRepository {

    @Override
    public void createRental(User user, LocalDateTime from, LocalDateTime to) {
        System.out.println(user.name() + " rent something");
    }
}
