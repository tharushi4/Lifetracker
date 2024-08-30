package com.tharushi.lifetracker;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AddExpenseDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_add_expense, null);

        final EditText titleEditText = view.findViewById(R.id.titleEditText);
        final EditText amountEditText = view.findViewById(R.id.amountEditText);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setTitle("Add Expense")
                .setPositiveButton("Add", (dialog, which) -> {
                    // Get input values and add a new expense
                    String title = titleEditText.getText().toString();
                    double amount = Double.parseDouble(amountEditText.getText().toString());
                    ((ExpensesActivity) requireActivity()).addExpense(title, amount);
                })
                .setNegativeButton("Cancel", null);

        return builder.create();
    }
}

