package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskQueueTestSuite {

    @Test
    void testUpdate() {
        //Given
        Mentor mentorBackend = new BackendMentor();
        Mentor mentroFrontend = new FrontEndMentor();

        TaskQueue taskQueueJoe = new TaskQueue("Joe Joe Backend");
        TaskQueue taskQueueMark = new TaskQueue("Mark Mark Backend");
        TaskQueue taskQueuePeter = new TaskQueue("Peter Peter Backend");
        TaskQueue taskQueueJim = new TaskQueue("Jim Jim Frontend");

        taskQueueJoe.registerObserver(mentorBackend);
        taskQueueMark.registerObserver(mentorBackend);
        taskQueuePeter.registerObserver(mentorBackend);
        taskQueueJim.registerObserver(mentroFrontend);

        //When
        taskQueueJoe.addTask("11.1 add impl");
        taskQueueJoe.addTask("11.1 add test");
        taskQueueMark.addTask("17.1 add impl");
        taskQueueMark.addTask("17.1 add test");
        taskQueuePeter.addTask("21.1 add impl");
        taskQueuePeter.addTask("21.1 add test");
        taskQueueJim.addTask("14.1 add impl");
        taskQueueJim.addTask("14.1 add test");

        //Then
        assertEquals(6, mentorBackend.getUpdateCount());
        assertEquals(2, mentroFrontend.getUpdateCount());
    }

}