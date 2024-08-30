package com.tharushi.lifetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ToDoActivity extends AppCompatActivity {

    private List<Task> tasks;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolist);

        tasks = new ArrayList<>();
        adapter = new TaskAdapter(this, tasks);

        ListView tasksListView = findViewById(R.id.todoListView);
        tasksListView.setAdapter(adapter);

        Button addTaskButton = findViewById(R.id.addButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddTaskDialog();
            }
        });

        // Sample data for testing
        tasks.add(new Task("Task 1"));
        tasks.add(new Task("Task 2"));
        adapter.notifyDataSetChanged();
    }

    private void showAddTaskDialog() {
        final EditText taskEditText = new EditText(this);
        taskEditText.setHint("Task");

        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Add Task")
                .setView(taskEditText)
                .setPositiveButton("Add", (dialog, which) -> {
                    String taskTitle = taskEditText.getText().toString();
                    addTask(taskTitle);
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
    protected void addTask(String title) {
        Task newTask = new Task(title);
        tasks.add(newTask);
        adapter.notifyDataSetChanged();
    }
    private void deleteTask(int position) {
        tasks.remove(position);
        adapter.notifyDataSetChanged();
    }
    public void onTaskLongClick(int position) {
        deleteTask(position);
    }
}
