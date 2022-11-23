package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {

    private final String nameCountry;
    private final BigDecimal peopleQuantity;

    public Country(final String nameCountry, final BigDecimal peopleQuantity) {
        this.nameCountry = nameCountry;
        this.peopleQuantity = peopleQuantity;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    };
}
