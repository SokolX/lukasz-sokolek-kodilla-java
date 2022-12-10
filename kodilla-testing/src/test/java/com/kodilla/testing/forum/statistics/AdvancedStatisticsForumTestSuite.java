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
        Assertions.assertEquals(0, advancedStatistics.numberOfPosts);
        Assertions.assertEquals(0.0, advancedStatistics.numbersOfPostsPerUser);
        Assertions.assertEquals(0.0, advancedStatistics.numbersOfCommentsPerPost);
    }

    @Test
    void testCalculateAdvStatisticsWhenPostsEquals1000() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(1000, advancedStatistics.numberOfPosts);
        Assertions.assertEquals(0.0, advancedStatistics.numbersOfPostsPerUser);
        Assertions.assertEquals(0.0, advancedStatistics.numbersOfCommentsPerPost);
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsEquals0() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assertions.assertEquals(0, advancedStatistics.numberOfComments);
        Assertions.assertEquals(0.0, advancedStatistics.numbersOfCommentsPerPost);
        Assertions.assertEquals(0.0, advancedStatistics.numbersOfCommentsPerPost);
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
        assertEquals(100, advancedStatistics.numberOfComments);
        assertEquals(10, advancedStatistics.numberOfPosts);
        assertEquals(10.0, advancedStatistics.numbersOfCommentsPerPost);
        assertEquals(10, advancedStatistics.numberOfUsers);
        assertEquals(10.0, advancedStatistics.numbersOfCommentsPerUser);
        assertEquals(1.0, advancedStatistics.numbersOfPostsPerUser);

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
        assertEquals(99, advancedStatistics.numberOfComments);
        assertEquals(30, advancedStatistics.numberOfPosts);
        assertEquals(3.3, advancedStatistics.numbersOfCommentsPerPost);
        assertEquals(10, advancedStatistics.numberOfUsers);
        assertEquals(9.9, advancedStatistics.numbersOfCommentsPerUser);
        assertEquals(3.0, advancedStatistics.numbersOfPostsPerUser);
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
        assertEquals(0, advancedStatistics.numberOfUsers);
        assertEquals(0.0, advancedStatistics.numbersOfPostsPerUser);
        assertEquals(0.0, advancedStatistics.numbersOfCommentsPerUser);
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
        assertEquals(1000, advancedStatistics.numberOfUsers);
        assertEquals(0.0, advancedStatistics.numbersOfPostsPerUser);
        assertEquals(0.0, advancedStatistics.numbersOfCommentsPerUser);
    }
}