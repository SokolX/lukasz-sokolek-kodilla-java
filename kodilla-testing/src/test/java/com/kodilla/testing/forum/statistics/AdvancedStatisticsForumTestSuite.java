package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DisplayName("testCalculateAdvStatisticsWhen")
@ExtendWith(MockitoExtension.class)
public class AdvancedStatisticsForumTestSuite {

    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    public void before(TestInfo testInfo) {
        System.out.println("Test Case " + testInfo.getDisplayName() + ": begin");
    }

    @AfterEach
    public void after(TestInfo testInfo) {
        System.out.println("Test Case " + testInfo.getDisplayName() + ": end\n");
    }

    private List<String> generateUsersToTest(int quantityUsers) {

        List<String> usersToTest = new ArrayList<>();
        for (int i = 0; i < quantityUsers; i++) {
            usersToTest.add("User" + i);
        }

        return usersToTest;
    }

    @Test
    void testCalculateAdvStatisticsWhenPostsEquals0() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        when(statisticsMock.postsCount()).thenReturn(0);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, advancedStatistics.getNumberOfPosts());
        Assertions.assertEquals(0.0, advancedStatistics.getNumbersOfPostsPerUser());
        Assertions.assertEquals(0.0, advancedStatistics.getNumbersOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenPostsEquals1000() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(1000, advancedStatistics.getNumberOfPosts());
        Assertions.assertEquals(0.0, advancedStatistics.getNumbersOfPostsPerUser());
        Assertions.assertEquals(0.0, advancedStatistics.getNumbersOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsEquals0() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, advancedStatistics.getNumberOfComments());
        Assertions.assertEquals(0.0, advancedStatistics.getNumbersOfCommentsPerUser());
        Assertions.assertEquals(0.0, advancedStatistics.getNumbersOfCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatisticsWhenMoreCommentsThanPosts() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(10);
        List<String> userName = generateUsersToTest(10);
        when(statisticsMock.usersNames()).thenReturn(userName);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, advancedStatistics.getNumberOfComments());
        assertEquals(10, advancedStatistics.getNumberOfPosts());
        assertEquals(10.0, advancedStatistics.getNumbersOfCommentsPerPost());
        assertEquals(10, advancedStatistics.getNumberOfUsers());
        assertEquals(10.0, advancedStatistics.getNumbersOfCommentsPerUser());
        assertEquals(1.0, advancedStatistics.getNumbersOfPostsPerUser());

    }

    @Test
    void testCalculateAdvStatisticsWhenLessCommentsThanPosts() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        when(statisticsMock.commentsCount()).thenReturn(99);
        when(statisticsMock.postsCount()).thenReturn(30);
        List<String> userName = generateUsersToTest(10);
        when(statisticsMock.usersNames()).thenReturn(userName);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(99, advancedStatistics.getNumberOfComments());
        assertEquals(30, advancedStatistics.getNumberOfPosts());
        assertEquals(3.3, advancedStatistics.getNumbersOfCommentsPerPost());
        assertEquals(10, advancedStatistics.getNumberOfUsers());
        assertEquals(9.9, advancedStatistics.getNumbersOfCommentsPerUser());
        assertEquals(3.0, advancedStatistics.getNumbersOfPostsPerUser());
    }


    @Test
    void testCalculateAdvStatisticsWhenUsersEqualTo0() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        List<String> userName = generateUsersToTest(0);
        when(statisticsMock.usersNames()).thenReturn(userName);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, advancedStatistics.getNumberOfUsers());
        assertEquals(0.0, advancedStatistics.getNumbersOfPostsPerUser());
        assertEquals(0.0, advancedStatistics.getNumbersOfCommentsPerUser());
    }

    @Test
    void testCalculateAdvStatisticsWhenUsersEqualTo1000() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        List<String> userName = generateUsersToTest(1000);
        when(statisticsMock.usersNames()).thenReturn(userName);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(1000, advancedStatistics.getNumberOfUsers());
        assertEquals(0.0, advancedStatistics.getNumbersOfPostsPerUser());
        assertEquals(0.0, advancedStatistics.getNumbersOfCommentsPerUser());
    }
}