package com.stradtkt.todoapp;

import com.stradtkt.todoapp.Datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;

    public void initialize() {
        TodoItem todoItem1 = new TodoItem("Walk the dog", "Walk the dog around the park", LocalDate.of(2020, Month.OCTOBER, 4));
        TodoItem todoItem2 = new TodoItem("Doctor Appointment", "Doctor appointment over the phone with doctor", LocalDate.of(2020, Month.OCTOBER, 6));
        TodoItem todoItem3 = new TodoItem("Thanksgiving", "Go to moms for thanksgiving", LocalDate.of(2020, Month.NOVEMBER, 24));
        TodoItem todoItem4 = new TodoItem("Christmas", "Christmas at grandmas", LocalDate.of(2020, Month.DECEMBER, 25));
        TodoItem todoItem5 = new TodoItem("Birthday", "My birthday", LocalDate.of(2020, Month.APRIL, 4));
        todoItems = new ArrayList<TodoItem>();
        todoItems.add(todoItem1);
        todoItems.add(todoItem2);
        todoItems.add(todoItem3);
        todoItems.add(todoItem4);
        todoItems.add(todoItem5);
        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
//        System.out.println("Selected item is " + item);
        StringBuilder stringBuilder = new StringBuilder(item.getDetails());
        stringBuilder.append("\n\n\n\n");
        stringBuilder.append("Due: ");
        stringBuilder.append(item.getDeadline().toString());
        itemDetailsTextArea.setText(stringBuilder.toString());
    }
}
