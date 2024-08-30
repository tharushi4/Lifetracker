package com.tharushi.lifetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ExpenceAdapter extends ArrayAdapter<Expences> {

    public ExpenceAdapter(Context context, List<Expences> expences) {
        super(context, 0, expences);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        Expences expense = getItem(position);

        TextView titleTextView = convertView.findViewById(android.R.id.text1);
        TextView amountTextView = convertView.findViewById(android.R.id.text2);

        titleTextView.setText(expense.getTitle());
        amountTextView.setText(String.valueOf(expense.getAmount()));

        return convertView;
    }
}

