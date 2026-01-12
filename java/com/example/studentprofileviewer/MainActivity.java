package com.example.studentprofileviewer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText etName, etRoll, etCourse, etEmail;
    Button btnViewProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etRoll = findViewById(R.id.etRoll);
        etCourse = findViewById(R.id.etCourse);
        etEmail = findViewById(R.id.etEmail);
        btnViewProfile = findViewById(R.id.btnViewProfile);
        btnViewProfile.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("NAME", etName.getText().toString());
            intent.putExtra("ROLL", etRoll.getText().toString());
            intent.putExtra("COURSE", etCourse.getText().toString());
            intent.putExtra("EMAIL", etEmail.getText().toString());
            startActivity(intent);
        });
    }
}
