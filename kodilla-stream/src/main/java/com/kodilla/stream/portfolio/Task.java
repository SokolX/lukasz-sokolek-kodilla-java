package com.kodilla.stream.portfolio;

import java.time.LocalDate;

public record Task(String title,
                   String description,
                   User assignedUser,
                   User creator,
                   LocalDate created,
                   LocalDate deadline) {

    public String getTitle() {
        return title;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignedUser=" + assignedUser +
                ", creator=" + creator +
                ", created=" + created +
                ", deadline=" + deadline +
                '}' + "\n";
    }
}
