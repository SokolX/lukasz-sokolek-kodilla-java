package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //given
        TaskFactory taskFactory = new TaskFactory();

        //when
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPING_TASK);
        shoppingTask.executeTask();

        //then
        assertEquals(true, shoppingTask.isTaskExecuted());
        assertEquals("ShoppingTask", shoppingTask.getTaskName());
    }

    @Test
    void testFactoryDrivingTask() {
        //given
        TaskFactory taskFactory = new TaskFactory();

        //when
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVING_TASK);
        drivingTask.executeTask();

        //then
        assertEquals(true, drivingTask.isTaskExecuted());
        assertEquals("DrivingTask", drivingTask.getTaskName());
    }

    @Test
    void testFactoryPaintingTask() {
        //given
        TaskFactory taskFactory = new TaskFactory();

        //when
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTING_TASK);
        paintingTask.executeTask();

        //then
        assertEquals(true, paintingTask.isTaskExecuted());
        assertEquals("PaintingTask", paintingTask.getTaskName());
    }
}