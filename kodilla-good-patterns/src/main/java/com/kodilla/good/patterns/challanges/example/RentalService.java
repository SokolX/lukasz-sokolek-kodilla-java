package com.kodilla.good.patterns.challanges.example;

import java.time.LocalDateTime;

public interface RentalService {

    boolean rent(final User user, final LocalDateTime carRentFrom, final LocalDateTime carRentTo);
}
