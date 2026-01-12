package com.example.studentprofileviewer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class LoggingService extends Service {

    private static final String TAG = "LoggingService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Get data passed from ProfileActivity
        String name = intent.getStringExtra("NAME");
        String roll = intent.getStringExtra("ROLL");

        Log.d(TAG, "Profile Viewed: " + name + " (Roll: " + roll + ")");

        // Service runs once and stops (not sticky)
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service Destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Not using bound service here
        return null;
    }
}