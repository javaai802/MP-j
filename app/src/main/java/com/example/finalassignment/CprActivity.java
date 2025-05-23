package com.example.finalassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class CprActivity extends AppCompatActivity {

    LinearLayout cprInfoLayout, aedLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpr);  // 정확히 activity_cpr로 연결

        cprInfoLayout = findViewById(R.id.cprInfoLayout);
        aedLayout = findViewById(R.id.aedLayout);

        // CPR이란? 클릭 시 CprDetailActivity로 이동
        cprInfoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CprActivity.this, CprDetailActivity.class);
                startActivity(intent);
            }
        });

        // AED 클릭 시 AedActivity로 이동 (AedActivity가 준비됐을 때)
        aedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CprActivity.this, AedActivity.class);
                startActivity(intent);
            }
        });
    }
}
