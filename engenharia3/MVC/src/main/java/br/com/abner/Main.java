package br.com.abner;

import br.com.abner.controller.TaskController;
import br.com.abner.model.TaskModel;
import br.com.abner.view.TaskViewGUI;

public class Main {
    public static void main(String[] args) {
        TaskModel model = new TaskModel();

        TaskController controller = new TaskController(model, null);

        TaskViewGUI taskViewGUI = new TaskViewGUI(model, controller);

        model.addObserver(taskViewGUI);

        taskViewGUI.setVisible(true);
    }
}

