package com.tharushi.lifetracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity {
    private Button btnSignup;

    protected void onCreate(Bundle savedInstanceState) {

        btnSignup = findViewById(R.id.btnSignup);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        btnSignup= (Button) findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SigninActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
