package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ScheduleFlights {

    public boolean findFilght(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> possiblityFligts = new HashMap<>();
        possiblityFligts.put("Warsaw", true);
        possiblityFligts.put("New York", true);
        possiblityFligts.put("Miami", false);
        possiblityFligts.put("London", true);
        possiblityFligts.put("Paris", false);
        possiblityFligts.put("Berlin", true);

        Optional.ofNullable(possiblityFligts.get(flight.arrivalAirport())).
                orElseThrow(() -> new RouteNotFoundException("Airport doesn't exists"));

        Boolean value = false;
        for(Map.Entry<String, Boolean> entry : possiblityFligts.entrySet()) {
            if (entry.getKey() == flight.arrivalAirport()) {
                value = entry.getValue();
            }
        }
        return value;
    }

    public static void main(String[] args) {
        ScheduleFlights scheduleFlights = new ScheduleFlights();
        Flight flight = new Flight("Warsaw", "Barcelona");

        try {
            System.out.println("Deparature from "
                    + flight.arrivalAirport()
                    + " = "
                    + scheduleFlights.findFilght(flight));
        } catch (RouteNotFoundException e) {
            System.out.println(e);
        } finally {
            System.out.println("Finished");
        }
    }
}
