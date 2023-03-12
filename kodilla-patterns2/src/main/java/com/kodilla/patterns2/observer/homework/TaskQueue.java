package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements ObservableTasks {

    private final List<ObserverTasks> observers;
    private final List<String> taks;
    private final String taskName;

    public TaskQueue(String taskName) {
        observers = new ArrayList<>();
        taks = new ArrayList<>();
        this.taskName = taskName;
    }

    public void addTask(String task) {
        taks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(ObserverTasks observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (ObserverTasks observerTasks : observers) {
            observerTasks.update(this);
        }
    }

    @Override
    public void removeObserver(ObserverTasks observerTasks) {
        observers.remove(observerTasks);
    }

    public String getTaskName() {
        return taskName;
    }

    public List<String> getTaks() {
        return taks;
    }
}
