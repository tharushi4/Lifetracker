package com.tharushi.lifetracker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;

public class ExpensesActivity extends AppCompatActivity {
    private List<Expences> expenses;
    private ExpenceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        expenses = new ArrayList<>();
        adapter = new ExpenceAdapter(this, expenses);

        ListView expensesListView = findViewById(R.id.expensesListView);
        expensesListView.setAdapter(adapter);

        expensesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click (you can implement update logic here)
            }
        });

        expensesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle long press (you can implement delete logic here)
                deleteExpense(position);
                return true;
            }
        });

        Button addExpenseButton = findViewById(R.id.addExpenseButton);
        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddExpenseDialog();
            }
        });
    }

    private void showAddExpenseDialog() {
        // Implement a dialog or a new activity to get user input for adding a new expense
        // For simplicity, using a simple AlertDialog in this example
        // You can replace this with your preferred UI for adding expenses
        AddExpenseDialogFragment dialog = new AddExpenseDialogFragment();
        dialog.show(getSupportFragmentManager(), "AddExpenseDialog");
    }

    public void addExpense(String title, double amount) {
        Expences newExpense = new Expences(title, amount);
        adapter.add(newExpense);
    }

    private void updateExpense(int position, String title, double amount) {
        Expences expences = adapter.getItem(position);
        expences.setTitle(title);
        expences.setAmount(amount);
        adapter.notifyDataSetChanged();
    }

    private void deleteExpense(int position) {
        adapter.remove(adapter.getItem(position));
    }
}
