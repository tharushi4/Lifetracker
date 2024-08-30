package com.tharushi.lifetracker;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelfcareActivity extends AppCompatActivity implements SensorEventListener{
    private SensorManager sensorManager;
    private TextView stepCountTextView, timeTextView;
    private ProgressBar stepProgressBar;
    private Button resetButton;
    private int stepCount = 0;
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    private long timeInMilliseconds = 0L;
    private long timeSwapBuff = 0L;
    private long updatedTime = 0L;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfcare);

        stepCountTextView = findViewById(R.id.stepCountTextView);
        stepProgressBar = findViewById(R.id.stepProgressBar);
        resetButton = findViewById(R.id.resetButton);
        timeTextView = findViewById(R.id.timeTextView);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetStepCount();
            }
        });
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            // Handle the case where the accelerometer sensor is not available
        }
    }
    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            timeTextView.setText("Time: " + String.format("%02d", mins) + ":"
                    + String.format("%02d", secs));
            customHandler.postDelayed(this, 1000);
        }
    };
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // You can implement a more sophisticated step detection algorithm here
            if (isStep(x, y, z)) {
                stepCount++;
                stepCountTextView.setText("Step Count: " + stepCount);
                updateProgressBar();
            }
        }

    }

    private void updateProgressBar() {
        // Update the progress bar based on the step count
        int maxSteps = 1000; // Set your desired maximum step count
        int progress = (int) (((float) stepCount / maxSteps) * 100);
        stepProgressBar.setProgress(progress);
    }

    private boolean isStep(float x, float y, float z) {
        return Math.sqrt(x * x + y * y + z * z) > 12;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //nothing
    }
        private void resetStepCount() {
        stepCount = 0;
        stepCountTextView.setText("Step Count: 0");
        stepProgressBar.setProgress(0);

        startTime = SystemClock.uptimeMillis();
        timeSwapBuff = 0L;
        customHandler.removeCallbacks(updateTimerThread);
        customHandler.postDelayed(updateTimerThread, 0);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }
}
