package com.kodilla.good.patterns.challenges.flights;

public interface ScheduleService {

    void findAllDeparaturesFrom(String deparaturesFromCity);
    void findAllArrivalFrom(String arrivalCity);
    void findDeparatureToArrival(String deparaturesFromCity, String arrivalCity);
}
