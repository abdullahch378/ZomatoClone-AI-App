package com.example.zomatoclone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            finish();
        });
    }
}
