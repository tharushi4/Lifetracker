package com.tharushi.lifetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {
    private CardView todolist;
    private CardView calender;
    private CardView selfcare;
    private CardView expenses;
    private CardView location;
    private CardView mediaGallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        todolist  = findViewById(R.id.todolist);
        calender = findViewById(R.id.calender);
        selfcare  = findViewById(R.id.selfcare);
        expenses  = findViewById(R.id.expenses);
        location  = findViewById(R.id.location);
        mediaGallery  = findViewById(R.id.mediaGallery);


        todolist= (CardView) findViewById(R.id.todolist);
        todolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ToDoActivity.class);
                startActivity(intent);
            }
        });
        calender= (CardView) findViewById(R.id.calender);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, CalenderActicity.class);
                startActivity(intent);
            }
        });
        selfcare= (CardView) findViewById(R.id.selfcare);
        selfcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SelfcareActivity.class);
                startActivity(intent);
            }
        });
        expenses= (CardView) findViewById(R.id.expenses);
        expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,ExpensesActivity.class);
                startActivity(intent);
            }
        });
        location= (CardView) findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });
        mediaGallery= (CardView) findViewById(R.id.mediaGallery);
        mediaGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,MediagalleryActivity.class);
                startActivity(intent);
            }
        });
    }}
