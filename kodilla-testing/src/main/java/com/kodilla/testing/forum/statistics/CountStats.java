package com.kodilla.testing.forum.statistics;

import java.util.List;

public class CountStats {

    public int numberOfUsers = 0;
    public int numberOfPosts = 0;
    public int numberOfComments = 0;

    public double averagePostsPerUsers = 0;
    public double averageCommentsPerUsers = 0;
    public double averageCommentsPerPosts = 0;

    public void calculateAdvStatistics(Statistics statistics) {
        numberOfUsers = usersCount(statistics);
        numberOfPosts = postsCount(statistics);
        numberOfComments = commentsCount(statistics);
        averageCommentsPerUsers = countAverageCommentsPerUser(statistics);
        averagePostsPerUsers = countAveragePostsPerUser(statistics);
        averageCommentsPerPosts = countAverageCommentsPerPost(statistics);
    }

    public void showStatistics() {
        System.out.println(
                numberOfUsers +
        numberOfPosts +
        numberOfComments +
        averageCommentsPerUsers +
        averagePostsPerUsers +
        averageCommentsPerPosts
        );
    }

    public int postsCount(Statistics statistics) {
        return statistics.postsCount();
    }

    public int commentsCount(Statistics statistics) {
        return statistics.commentsCount();
    }

    public int usersCount(Statistics statistics) {
        return statistics.usersNames().size();
    }

    public double countAveragePostsPerUser(Statistics statistics) {
        return statistics.postsCount() / usersCount(Statistics statistics);
    }

    public double countAverageCommentsPerUser(Statistics statistics) {
        return statistics.commentsCount()/ usersCount(Statistics statistics);
    }

    public double countAverageCommentsPerPost(Statistics statistics) {
        return statistics.postsCount() / statistics.commentsCount();
    }
}
