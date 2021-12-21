package com.viktorinasozvukom.zvukovayaviktorina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView exit_test_Quiz, txt_resultc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int s=0;
        for(int i=0; i<QuizGameActivity.wer.length;i++){
            if (QuizGameActivity.wer!=null)
                if (QuizGameActivity.wer[i])s++;
        }
        txt_resultc = (TextView) findViewById(R.id.txt_resultc);
        txt_resultc.setText("Вы ответили на " + Integer.toString(s) + " из 10");
        exit_test_Quiz = (TextView) findViewById(R.id.exit_test_Quiz);

        exit_test_Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent); QuizGameActivity.wer=QuizGameActivity.wer2;finish();
            }
        });
    }
    // Системная кнопка назад
    @Override
    public void onBackPressed(){
        Intent backintent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(backintent);QuizGameActivity.wer=QuizGameActivity.wer2;finish();
    }
}