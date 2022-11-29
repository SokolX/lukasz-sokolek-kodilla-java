package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ScheduleFlights {

    public boolean findFlights(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> possibilityFlights = new HashMap<>();
        possibilityFlights.put("Warsaw", true);
        possibilityFlights.put("New York", true);
        possibilityFlights.put("Miami", false);
        possibilityFlights.put("London", true);
        possibilityFlights.put("Paris", false);
        possibilityFlights.put("Berlin", true);

        return Optional.ofNullable(possibilityFlights.get(flight.arrivalAirport())).
                orElseThrow(() -> new RouteNotFoundException("Airport doesn't exists"));
    }

    public static void main(String[] args) {
        ScheduleFlights scheduleFlights = new ScheduleFlights();
        Flight flight = new Flight("Warsaw", "Barcelona");

        try {
            System.out.println("Deparature from "
                    + flight.arrivalAirport()
                    + " = "
                    + scheduleFlights.findFlights(flight));
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        } finally {
            System.out.println("Finished");
        }
    }
}
