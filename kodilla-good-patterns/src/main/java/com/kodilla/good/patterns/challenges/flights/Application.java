package com.kodilla.good.patterns.challenges.flights;

public class Application {

    public static void main(String[] args) {
        ScheduleService scheduleService = new FlightScheduleService();
        scheduleService.findAllDeparaturesFrom("Barcelona");
        scheduleService.findAllArrivalFrom("Warsaw");
        scheduleService.findDeparatureToArrival("Barcelona","Katowice");
    }
}
