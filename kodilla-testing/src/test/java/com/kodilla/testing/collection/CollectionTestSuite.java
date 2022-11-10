package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    private TestInfo testInfo;

    @BeforeEach
    void init(TestInfo testInfo) {
        this.testInfo = testInfo;
    }
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("when list number is empty, " +
            "then testOddNumbersExterminatorNormalList should return empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        System.out.println(testInfo.getDisplayName());
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
        System.out.println(testInfo.getDisplayName());
        //given
        //List<Integer> emptyList = ;
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //when
        List<Integer> exceptedList = oddNumbersExterminator.exterminate(Arrays.asList(4, 2, 7, 1, 5, 7, 1, 4, 1));
        //then
        Assertions.assertEquals(List.of(4, 2, 4), exceptedList);

    }
}
