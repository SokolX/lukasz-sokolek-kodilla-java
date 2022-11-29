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
                        () -> scheduleFlights.findFlights(new Flight("Warsaw", "Barcelona"))),
                () -> assertTrue(scheduleFlights.findFlights(new Flight("Berlin", "Warsaw"))),
                () -> assertFalse(scheduleFlights.findFlights(new Flight("Warsaw", "Paris")))
        );
    }
}