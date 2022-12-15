package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void initLogger() {
        logger = Logger.INSTANCE;
    }

    @Test
    void testGetLastLogWhenLastLogHas1Log() {
        //Given
        logger.log("writing to log");

        //When
        String logFromLogger = logger.getLastLog();

        //Then
        assertEquals("writing to log", logFromLogger);
    }

    @Test
    void testGetLastLogWhenLastLogWasOverwriteBy2Log() {
        //Given
        logger.log("writing to log");
        logger.log("writing to log2");

        //When
        String logFromLogger = logger.getLastLog();

        //Then
        assertEquals("writing to log2", logFromLogger);
    }
}