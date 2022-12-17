package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING_TASK -> new ShoppingTask("ShoppingTask", "Butter", 2);
            case PAINTING_TASK -> new PaintingTask("PaintingTask", "Red", "Car");
            case DRIVING_TASK -> new DrivingTask("DrivingTask", "New York", "Airplane");
            default -> null;
        };
    }
}
