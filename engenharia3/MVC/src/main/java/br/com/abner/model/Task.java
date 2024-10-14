package br.com.abner.model;

public class Task extends TaskComponent {
    private String name;
    private boolean isCompleted;

    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }

    @Override
    public String getName() {
        return name + (isCompleted ? " (Tarefa Completa)" : "");
    }

    @Override
    public void completeTask() {
        this.isCompleted = true;
    }
}

