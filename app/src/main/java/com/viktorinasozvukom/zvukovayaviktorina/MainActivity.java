package com.viktorinasozvukom.zvukovayaviktorina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedtimer;
    private Toast backToast;
    TextView btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (TextView) findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizGameActivity.class);
                startActivity(intent);finish();
            }
        });
    }
    // Системная кнопка назад
    @Override
    public void onBackPressed(){
        if (backPressedtimer + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз, чтобы выйти!", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedtimer = System.currentTimeMillis();
    }
}