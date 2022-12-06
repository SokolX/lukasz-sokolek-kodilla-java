package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class FlightScheduleService implements ScheduleService {

    FlightsSchedule flightsSchedule = new FlightsSchedule();
    @Override
    public void findAllDeparaturesFrom(String deparaturesFromCity) {
        System.out.println("\nFlights from " + deparaturesFromCity);
        flightsSchedule.getFlights().stream()
                .filter(f -> f.deparatures().equals(deparaturesFromCity))
                .forEach(System.out::println);
    }

    @Override
    public void findAllArrivalFrom(String arrivalCity) {
        System.out.println("\nFlights to " + arrivalCity);
        flightsSchedule.getFlights().stream()
                .filter(f -> f.arrival().equals(arrivalCity))
                .forEach(System.out::println);
    }

    @Override
    public void findDeparatureToArrival(String deparaturesFromCity, String arrivalCity) {
        boolean isDirect = false;

        System.out.println("\nFlights from " + deparaturesFromCity + " to " + arrivalCity);
        List<Flight> directFlightFromDeparaturesToArraial = flightsSchedule.getFlights()
                .stream()
                .filter(isDeparatureEqualsToArrival(deparaturesFromCity, arrivalCity))
                .peek(System.out::println)
                .toList();

        if (directFlightFromDeparaturesToArraial.size() > 0) {
            return;
        }

        isExistsIndirectFlights(deparaturesFromCity, arrivalCity);
    }

    private void isExistsIndirectFlights(String deparaturesFromCity, String arrivalCity) {
        System.out.println("\nIndirect flights from " + deparaturesFromCity + " to " + arrivalCity);
        List<String> flightsFrom = flightsSchedule.getFlights()
                .stream()
                .filter(f -> f.deparatures().equals(deparaturesFromCity))
                .map(Flight::arrival)
                .toList();

        List<String> flightsTo = flightsSchedule.getFlights()
                .stream()
                .filter(f -> f.arrival().equals(arrivalCity))
                .map(Flight::deparatures)
                .toList();

        List<String> flightTo = flightsFrom
                .stream()
                .map(f -> flightsTo
                        .stream()
                        .filter(ft -> ft.equals(f))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .toList();

        System.out.println(flightTo.stream().findFirst().orElse("No indirect  connections available"));
    }

    private Predicate<Flight> isDeparatureEqualsToArrival(String deparaturesFromCity, String arrivalCity) {
        return f -> f.arrival().equals(arrivalCity) && f.deparatures().equals(deparaturesFromCity);
    }
}
