package com.example.alarmtimer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent newActivity = new Intent(context, AlarmTimerActivity.class);
        newActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newActivity);
    }
}
