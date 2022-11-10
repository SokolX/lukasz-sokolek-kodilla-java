package com.kodilla.testing.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @DisplayName("when list number is empty, " +
            "then testOddNumbersExterminatorNormalList should return empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //given
        //List<Integer> emptyList = ;
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //when
        List<Integer> exceptedList = oddNumbersExterminator.exterminate(List.of());
        //then
        Assertions.assertEquals(Collections.EMPTY_LIST, exceptedList);

    }

    @DisplayName("when list contains odd and even numbers, " +
            "then testOddNumbersExterminatorNormalList should return only even numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        //given
        //List<Integer> emptyList = ;
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //when
        List<Integer> exceptedList = oddNumbersExterminator.exterminate(List.of(4, 2, 7, 1, 5, 7, 1, 4, 1));
        //then
        Assertions.assertEquals(List.of(4, 2, 4), exceptedList);

    }
}
