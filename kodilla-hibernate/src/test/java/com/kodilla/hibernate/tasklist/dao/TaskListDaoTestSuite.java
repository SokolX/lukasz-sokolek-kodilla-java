package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuite {

    private static final String TODO_LIST = "Todo list";
    @Autowired
    TaskListDao taskListDao;


    @AfterEach
    public void cleanupDeleteTaskListAfterTest() {
        taskListDao.deleteAll();
    }

    @Test
    void testFindByListNameWhenListNotExists() {
        //Given
        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(TODO_LIST);

        //Then
        assertEquals(0, readTaskLists.size());
    }

    @Test
    void testFindByListNameWhenOneListExists() {
        //Given
        TaskList taskList = new TaskList(TODO_LIST, "...");
        taskListDao.save(taskList);

        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(TODO_LIST);

        //Then
        assertEquals(1, readTaskLists.size());
    }

    @Test
    void testFindByListNameWhenMoreThanOneListExists() {
        //Given
        TaskList taskList = new TaskList(TODO_LIST, "...");
        taskListDao.save(taskList);
        TaskList secondTaskList = new TaskList(TODO_LIST, "...");
        taskListDao.save(secondTaskList);

        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(TODO_LIST);

        //Then
        assertEquals(2, readTaskLists.size());
    }
}