package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuite {

    private static final String TODO_LIST = "Todo list";
    private static final String LISTNAME = "LISTNAME";
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

    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);
    }
}