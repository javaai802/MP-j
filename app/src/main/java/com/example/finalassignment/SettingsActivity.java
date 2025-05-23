package com.example.finalassignment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private String[] settingsItems = {
            "음향\n소리를 설정합니다",
            "생활안전문자\n안전문자의 빈도 등을 설정합니다",
            "지역 설정\n자신의 지역을 설정합니다",
            "그 외\n생각이안남"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView backButton = findViewById(R.id.backButton);
        ListView listView = findViewById(R.id.settingsListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, android.R.id.text1, settingsItems) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                String[] lines = settingsItems[position].split("\n");
                android.widget.TextView text1 = view.findViewById(android.R.id.text1);
                text1.setText(lines[0]);
                text1.setTextSize(16f);
                android.widget.TextView text2 = view.findViewById(android.R.id.text2);
                if (lines.length > 1) {
                    text2.setText(lines[1]);
                    text2.setTextSize(14f);
                }
                return view;
            }
        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Toast.makeText(this, settingsItems[position].split("\n")[0] + " 클릭됨", Toast.LENGTH_SHORT).show();
            // 향후 액티비티 전환 가능
        });

        backButton.setOnClickListener(v -> finish());
    }
}
