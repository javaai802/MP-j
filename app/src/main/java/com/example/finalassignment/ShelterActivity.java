package com.example.finalassignment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShelterActivity extends AppCompatActivity {

    private Spinner spinnerCity, spinnerDistrict;
    private EditText etSearch;
    private CardView shelterCard;
    private TextView shelterTitle, shelterDistance;
    private Button btnSelect;

    private Map<String, List<String>> districtMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter);

        // View 연결
        spinnerCity = findViewById(R.id.spinner_city);
        spinnerDistrict = findViewById(R.id.spinner_district);
        etSearch = findViewById(R.id.et_search);
        shelterCard = findViewById(R.id.shelter_card);
        shelterTitle = findViewById(R.id.shelter_title);
        shelterDistance = findViewById(R.id.shelter_distance);
        btnSelect = findViewById(R.id.btn_select);

        // 동 데이터 설정
        setupDistrictMap();
        setupCitySpinner();
        setupSearchBar();
    }

    private void setupDistrictMap() {
        districtMap = new HashMap<>();
        districtMap.put("서울", Arrays.asList("강남구", "서초구", "중구"));
        districtMap.put("부산", Arrays.asList("해운대구", "사하구", "수영구"));
        districtMap.put("대구", Arrays.asList("중구", "남구", "수성구"));
    }

    private void setupCitySpinner() {
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getItemAtPosition(position).toString();
                List<String> districts = districtMap.get(selectedCity);
                if (districts != null) {
                    ArrayAdapter<String> districtAdapter = new ArrayAdapter<>(
                            ShelterActivity.this,
                            android.R.layout.simple_spinner_item,
                            districts
                    );
                    districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerDistrict.setAdapter(districtAdapter);
                }
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
    }

    private void setupSearchBar() {
        etSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                    (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

                String keyword = etSearch.getText().toString().trim();
                String selectedCity = spinnerCity.getSelectedItem().toString();
                String selectedDistrict = spinnerDistrict.getSelectedItem().toString();

                if (!keyword.isEmpty()) {
                    showMockShelterInfo(selectedCity, selectedDistrict, keyword);
                }
                return true;
            }
            return false;
        });
    }

    private void showMockShelterInfo(String city, String district, String keyword) {
        // 실제 API 연동 시 교체할 부분
        shelterCard.setVisibility(View.VISIBLE);
        shelterTitle.setText(city + " " + district + " - 대피소 예시 (" + keyword + ")");
        shelterDistance.setText("약 1.2km 거리");

        btnSelect.setOnClickListener(v ->
                // 버튼 클릭 시 로직 (예: 상세 정보 화면 이동 등)
                shelterCard.setVisibility(View.GONE)
        );
    }
}
