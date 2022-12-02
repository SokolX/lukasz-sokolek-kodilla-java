package com.kodilla.good.patterns.challanges.example;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService{

    public boolean rent(final User user, final LocalDateTime carRentFrom, final LocalDateTime carRentTo) {
        System.out.println("Renting Car for: " + user.name() + user.surname()
                + " from: " + carRentFrom.toString() + " to: " + carRentTo.toString());

        return true;
    }
}
