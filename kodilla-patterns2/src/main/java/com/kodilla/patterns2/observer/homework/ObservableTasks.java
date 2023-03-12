package com.kodilla.patterns2.observer.homework;

public interface ObservableTasks {

    void registerObserver(ObserverTasks observerTasks);
    void notifyObservers();
    void removeObserver(ObserverTasks observerTasks);

}
