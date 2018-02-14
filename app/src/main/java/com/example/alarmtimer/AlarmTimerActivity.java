package com.example.alarmtimer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmTimerActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private FloatingActionButton floatingActionButton;

    private final int ALARMTIMER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmtimer);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        timePicker.setIs24HourView(true);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent unIntent = new Intent("com.example.alarmtimer.intentpropio");
                PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmTimerActivity.this,
                        ALARMTIMER, unIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                calendar.set(Calendar.SECOND, 0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                finish();
            }
        });
    }
}
