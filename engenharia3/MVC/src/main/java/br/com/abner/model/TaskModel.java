package br.com.abner.model;

import br.com.abner.view.Observer;

import java.util.ArrayList;
import java.util.List;
import br.com.abner.util.Observable;
public class TaskModel implements Observable {
    private List<TaskComponent> tasks = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void addTask(TaskComponent task) {
        tasks.add(task);
        notifyObservers();
    }

    public void completeTask(String taskName) {
        for (TaskComponent task : tasks) {
            if (task.getName().contains(taskName)) {
                task.completeTask();
                notifyObservers();
                break;
            }
        }
    }

    public List<TaskComponent> getTasks() {
        return tasks;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
