package com.tharushi.lifetracker;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class CalenderActicity extends AppCompatActivity {
    EditText title;
    EditText location;
    EditText Description;
    Button addevent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
title = findViewById(R.id.title);
location = findViewById(R.id.location);
Description = findViewById(R.id.description);
addevent = findViewById(R.id.addevent);

addevent.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (!title.getText().toString().isEmpty() && !location.getText().toString().isEmpty() && !Description.getText().toString().isEmpty() ){
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setData(CalendarContract.Events.CONTENT_URI);
            intent.putExtra(CalendarContract.Events.TITLE,title.getText().toString());
            intent.putExtra(CalendarContract.Events.EVENT_LOCATION,location.getText().toString());
            intent.putExtra(CalendarContract.Events.DESCRIPTION,Description.getText().toString());
            intent.putExtra(CalendarContract.Events.ALL_DAY,"true");
            intent.putExtra(Intent.EXTRA_EMAIL,"tharushi@gmail.com");

            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity((intent));
            }else {
                Toast.makeText(CalenderActicity.this,"No support" ,Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(CalenderActicity.this,"please fill all the fields",Toast.LENGTH_SHORT).show();
        }
    }
});
}}