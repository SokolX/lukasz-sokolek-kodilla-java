package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {

        IntStream.of(numbers)
                .forEach(System.out::println);

        return IntStream.of(numbers)
                .average()
                .orElse(0.0);
    }
}