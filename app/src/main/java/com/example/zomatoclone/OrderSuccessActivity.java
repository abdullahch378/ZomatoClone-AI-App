package com.example.zomatoclone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSuccessActivity extends AppCompatActivity {

    private Button btnGoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        btnGoHome = findViewById(R.id.btnGoHome);
        btnGoHome.setOnClickListener(v -> {
            startActivity(new Intent(OrderSuccessActivity.this, HomeActivity.class));
            finish();
        });
    }
}
