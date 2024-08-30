// ReminderReceiver.java
package com.tharushi.lifetracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReminderReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Reminder: It's time!", Toast.LENGTH_SHORT).show();
    }
}

