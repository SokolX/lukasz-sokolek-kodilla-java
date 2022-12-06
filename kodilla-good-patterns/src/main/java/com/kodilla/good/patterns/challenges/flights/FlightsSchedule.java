package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class FlightsSchedule {

    List<Flight> flights = List.of(
            new Flight("Barcelona", "Warsaw"),
            new Flight("Barcelona", "Poznan"),
            new Flight("Poznan", "Warsaw"),
            new Flight("Barcelona", "Rome"),
            new Flight("Barcelona", "London"),
            new Flight("Barcelona", "Berlin"),
            new Flight("Warsaw", "Katowice")
    );

    public FlightsSchedule() {
    }

    public List<Flight> getFlights() {
        return flights;
    }


}
