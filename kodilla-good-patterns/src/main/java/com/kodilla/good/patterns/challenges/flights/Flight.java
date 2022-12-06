package com.kodilla.good.patterns.challenges.flights;

public record Flight(String deparatures, String arrival) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (deparatures != null ? !deparatures.equals(flight.deparatures) : flight.deparatures != null) return false;
        return arrival != null ? arrival.equals(flight.arrival) : flight.arrival == null;
    }

    @Override
    public int hashCode() {
        int result = deparatures != null ? deparatures.hashCode() : 0;
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        return result;
    }
}
