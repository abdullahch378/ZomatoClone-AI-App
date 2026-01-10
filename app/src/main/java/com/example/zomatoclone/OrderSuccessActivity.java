package com.example.zomatoclone;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class OrderSuccessActivity extends AppCompatActivity {

    Button btnBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        btnBackHome = findViewById(R.id.btnBackHome);

        btnBackHome.setOnClickListener(v -> {
            // Go back to HomeActivity
            Intent intent = new Intent(OrderSuccessActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
