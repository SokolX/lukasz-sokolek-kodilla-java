package com.kodilla.stream.world;

import java.math.BigDecimal;

public record Country(String nameCountry, BigDecimal peopleQuantity) {

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    };
}
