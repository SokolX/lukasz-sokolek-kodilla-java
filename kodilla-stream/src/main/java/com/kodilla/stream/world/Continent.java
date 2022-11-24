package com.kodilla.stream.world;

import java.util.List;

public record Continent(String continentName, List<Country> countries) {

    public List<Country> getCountries() {
        return countries;
    }
}
