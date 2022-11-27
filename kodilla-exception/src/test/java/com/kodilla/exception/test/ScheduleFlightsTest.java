package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleFlightsTest {

    @Test
    void testFindFlight() {
        // given
        ScheduleFlights scheduleFlights = new ScheduleFlights();

        // when & then
        assertAll(
                () -> assertThrows(Exception.class,
                        () -> scheduleFlights.findFilght(new Flight("Warsaw", "Barcelona"))),
                () -> assertEquals(true,
                        scheduleFlights.findFilght(new Flight("Berlin", "Warsaw"))),
                () -> assertEquals(false,
                        scheduleFlights.findFilght(new Flight("Warsaw", "Paris")))
        );
    }
}