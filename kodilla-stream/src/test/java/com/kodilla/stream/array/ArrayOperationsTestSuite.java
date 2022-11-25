package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //given
        int[] numbers = new int[]{ 1, 4, 3, 2, 40, 6, 8, 90, 5, 3, 2, 20, 1, 2, 4, 3, 1, 31, 1, 4 };

        //when
        double average = ArrayOperations.getAverage(numbers);

        //then
        assertEquals(11.55, average);
    }
}