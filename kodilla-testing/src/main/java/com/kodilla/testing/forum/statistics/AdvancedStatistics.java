package com.kodilla.testing.forum.statistics;

import java.text.DecimalFormat;

public class AdvancedStatistics {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public int numberOfUsers;
    public int numberOfPosts;
    public int numberOfComments;
    public double numbersOfPostsPerUser;
    public double numbersOfCommentsPerUser;
    public double numbersOfCommentsPerPost;

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getNumbersOfPostsPerUser() {
        return numbersOfPostsPerUser;
    }

    public double getNumbersOfCommentsPerUser() {
        return numbersOfCommentsPerUser;
    }

    public double getNumbersOfCommentsPerPost() {
        return numbersOfCommentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postsCount();
        numberOfComments = statistics.commentsCount();
        numbersOfCommentsPerUser = countAverage(statistics.commentsCount(), statistics.usersNames().size());
        numbersOfPostsPerUser = countAverage(statistics.postsCount(), statistics.usersNames().size());
        numbersOfCommentsPerPost = countAverage(statistics.commentsCount(), statistics.postsCount());
    }

    public void showStatistics() {
        System.out.println(
                "---> Advanced Statistics <---" +
                "\nNumbers of users: " + numberOfUsers +
                "\nNumbers of posts: " + numberOfPosts +
                "\nNumbers of comments: " + numberOfComments +
                "\nNumbers of comments per user: " + numbersOfCommentsPerUser +
                "\nNumbers of comments per post: " + numbersOfCommentsPerPost +
                "\nNumbers of posts per user: " + numbersOfPostsPerUser +
                        "\n-----------------------------"
        );
    }

    public double countAverage(int dividend, int divider) {
        if(isGreaterThanZero(dividend) && isGreaterThanZero(divider)) {
            return Double.parseDouble(DECIMAL_FORMAT.format(Double.valueOf(dividend) / Double.valueOf(divider)));
        } else {
            System.out.println("Impposible operation");
            return 0.0;
        }
    }

    private static boolean isGreaterThanZero(int number) {
        if (number > 0) {
            return true;
        } else {
            return false;
        }
    }
}