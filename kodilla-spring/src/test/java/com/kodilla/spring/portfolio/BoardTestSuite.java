package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        TaskList toDo = board.toDoList();
        toDo.getTasks().add("To Do");

        TaskList inProgress = board.inProgressList();
        inProgress.getTasks().add("In Progress");

        TaskList done = board.doneList();
        done.getTasks().add("Done");

        //Then
        assertEquals(1, toDo.getTasks().size());
        assertEquals("To Do", toDo.getTasks().get(0));
        assertEquals(1, inProgress.getTasks().size());
        assertEquals("In Progress", inProgress.getTasks().get(0));
        assertEquals(1, done.getTasks().size());
        assertEquals("Done", done.getTasks().get(0));
    }

}