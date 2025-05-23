package com.example.finalassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnShelter, btnWarning, btnSettings, btnHeimlich, btnCpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShelter = findViewById(R.id.btn_shelter);
        btnWarning = findViewById(R.id.btn_warning);
        btnSettings = findViewById(R.id.btn_settings);
        btnHeimlich = findViewById(R.id.btn_heimlich);
        btnCpr = findViewById(R.id.btn_cpr);

        btnShelter.setOnClickListener(v -> {
            Toast.makeText(this, "대피소 클릭", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ShelterActivity.class));
        });

        btnWarning.setOnClickListener(v -> {
            Toast.makeText(this, "경고 클릭", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, WarningActivity.class));
        });

        btnSettings.setOnClickListener(v -> {
            Toast.makeText(this, "설정 클릭", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SettingsActivity.class));
        });

        btnHeimlich.setOnClickListener(v -> {
            Toast.makeText(this, "하임리히 클릭", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HeimlichActivity.class));
        });

        btnCpr.setOnClickListener(v -> {
            Toast.makeText(this, "CPR 클릭", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, CprActivity.class));
        });
    }
}
