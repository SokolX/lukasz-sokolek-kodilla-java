package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //given
        int[] numbers = new int[20];

        //when
        double average = ArrayOperations.getAverage(numbers);

        //then
        assertEquals(9.5, average);
    }
}