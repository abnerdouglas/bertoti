package br.com.abner.model;

import br.com.abner.model.TaskComponent;

import java.util.ArrayList;
import java.util.List;

public class TaskComposite extends TaskComponent {
    private List<TaskComponent> tasks = new ArrayList<>();
    private String name;

    public TaskComposite(String name) {
        this.name = name;
    }

    public void addTask(TaskComponent task) {
        tasks.add(task);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void completeTask() {
        for (TaskComponent task : tasks) {
            task.completeTask();
        }
    }

    public List<TaskComponent> getTasks() {
        return tasks;
    }
}
