package com.example.finalassignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WarningActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private Button btnAll, btnNatural, btnLife;
    private RecyclerView recyclerWarnings;
    private WarningAdapter adapter;
    private ArrayList<WarningItem> warningList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);

        // 1. UI 요소 연결
        btnBack = findViewById(R.id.btn_back);
        btnAll = findViewById(R.id.btn_all);
        btnNatural = findViewById(R.id.btn_natural);
        btnLife = findViewById(R.id.btn_life);
        recyclerWarnings = findViewById(R.id.recycler_warnings);

        // 2. 리사이클러뷰 설정
        recyclerWarnings.setLayoutManager(new LinearLayoutManager(this));
        warningList = new ArrayList<>();

        adapter = new WarningAdapter(warningList);
        recyclerWarnings.setAdapter(adapter);

        // 3. 버튼 클릭 리스너
        btnBack.setOnClickListener(view -> finish());

        btnAll.setOnClickListener(view -> {
            Toast.makeText(this, "지역 알림 필터 선택됨", Toast.LENGTH_SHORT).show();
            // 실제 필터링 로직은 추후 구현
        });

        btnNatural.setOnClickListener(view -> {
            Toast.makeText(this, "자연 재해 필터 선택됨", Toast.LENGTH_SHORT).show();
        });

        btnLife.setOnClickListener(view -> {
            Toast.makeText(this, "생활 안전 필터 선택됨", Toast.LENGTH_SHORT).show();
        });
    }
}
