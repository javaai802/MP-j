package com.example.finalassignment;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class HeimlichActivity extends AppCompatActivity {

    private TextView textDescription, symptomText, actionText, noteText;
    private ImageButton ttsButton;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heimlich);

        // View 초기화
        textDescription = findViewById(R.id.textDescription);
        symptomText = findViewById(R.id.symptomText);
        actionText = findViewById(R.id.actionText);
        noteText = findViewById(R.id.noteText);
        ttsButton = findViewById(R.id.ttsButton);

        // 임시 텍스트 설정
        textDescription.setText("환자의 등 뒤에 서서 주먹을 쥔 손의 엄지손가락 방향을 배 윗부분에 대고...");
        symptomText.setText("증상\n- 숨쉬기 힘들어함\n- 심한 호흡곤란 등");
        actionText.setText("응급처치\n- 의식 없으면 심폐소생술\n- 의식 있으면 하임리히법 시행");
        noteText.setText("주의사항\n- 복부에 강한 압력으로 장기 손상 유의\n- 병원 이송 필요");

        // TTS 초기화
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.KOREAN);
            }
        });

        // TTS 버튼 클릭 시 읽어주기
        ttsButton.setOnClickListener(v -> {
            String speakText = textDescription.getText().toString() + "\n"
                    + symptomText.getText().toString() + "\n"
                    + actionText.getText().toString() + "\n"
                    + noteText.getText().toString();
            tts.speak(speakText, TextToSpeech.QUEUE_FLUSH, null, null);
        });
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
