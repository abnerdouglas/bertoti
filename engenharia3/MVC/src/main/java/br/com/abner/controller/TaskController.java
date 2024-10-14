package br.com.abner.controller;

import br.com.abner.model.Task;
import br.com.abner.model.TaskModel;
import br.com.abner.view.TaskViewGUI;

public class TaskController {
    private TaskModel model;
    private TaskViewGUI view;

    public TaskController(TaskModel model, TaskViewGUI view) {
        this.model = model;
        this.view = view;
    }

    public void addTask(String taskName) {
        Task newTask = new Task(taskName);
        model.addTask(newTask);
    }

    public void completeTask(String taskName) {
        model.completeTask(taskName);
    }
}
