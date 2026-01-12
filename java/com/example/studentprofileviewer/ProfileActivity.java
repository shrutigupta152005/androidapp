package com.example.studentprofileviewer;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    TextView tvName, tvRoll, tvCourse, tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // Initialize TextViews
        tvName = findViewById(R.id.tvName);
        tvRoll = findViewById(R.id.tvRoll);
        tvCourse = findViewById(R.id.tvCourse);
        tvEmail = findViewById(R.id.tvEmail);
        // Get data from Intent (sent from MainActivity)
        String name = getIntent().getStringExtra("NAME");
        String roll = getIntent().getStringExtra("ROLL");
        String course = getIntent().getStringExtra("COURSE");
        String email = getIntent().getStringExtra("EMAIL");
        // Set data to TextViews
        tvName.setText("Name: " + name);
        tvRoll.setText("Roll Number: " + roll);
        tvCourse.setText("Course: " + course);
        tvEmail.setText("Email: " + email);
        // Start LoggingService in background
        Intent serviceIntent = new Intent(this, LoggingService.class);
        serviceIntent.putExtra("NAME", name);
        serviceIntent.putExtra("ROLL", roll);
        startService(serviceIntent);
    }
}