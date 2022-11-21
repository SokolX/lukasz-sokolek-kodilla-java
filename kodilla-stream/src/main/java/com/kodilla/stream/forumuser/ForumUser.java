package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public record ForumUser(int id, String name, char sex, LocalDate dateOfBirth, int counterOfPublishedPosts) {

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", counterOfPublishedPosts=" + counterOfPublishedPosts +
                '}';
    }
}
