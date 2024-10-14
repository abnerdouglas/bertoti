package br.com.abner.view;

import br.com.abner.controller.TaskController;
import br.com.abner.model.TaskComponent;
import br.com.abner.model.TaskModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskViewGUI extends JFrame implements Observer {
    private TaskModel model;
    private TaskController controller;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private JButton addTaskButton;
    private JButton completeTaskButton;

    public TaskViewGUI(TaskModel model, TaskController controller) {
        this.model = model;
        this.controller = controller;

        setTitle("Gerenciador de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JPanel inputPanel = new JPanel();
        taskInput = new JTextField(20);
        addTaskButton = new JButton("Adicionar Tarefa");

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = taskInput.getText();
                if (!taskName.isEmpty()) {
                    controller.addTask(taskName);
                    taskInput.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Nome da tarefa não pode ser nulo.");
                }
            }
        });

        inputPanel.add(taskInput);
        inputPanel.add(addTaskButton);

        // Botão para marcar uma tarefa como completa
        completeTaskButton = new JButton("Completar Tarefa");
        completeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTask = taskList.getSelectedValue();
                if (selectedTask != null) {
                    controller.completeTask(selectedTask);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione a tarefa para ser cumprida.");
                }
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(completeTaskButton, BorderLayout.SOUTH);
    }

    @Override
    public void update() {
        refreshTaskList();
    }

    private void refreshTaskList() {
        taskListModel.clear();
        for (TaskComponent task : model.getTasks()) {
            taskListModel.addElement(task.getName());
        }
    }
}

