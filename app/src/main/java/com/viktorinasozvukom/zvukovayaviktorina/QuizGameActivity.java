package com.viktorinasozvukom.zvukovayaviktorina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizGameActivity extends AppCompatActivity {
    private RecyclerView recyclerViewQuestions;
    private List<Question_Model> questions = new ArrayList<>();

    static ArrayList<String> list = new ArrayList<String>();

    TextView stop_test;
    static Boolean[] wer = new Boolean[10];
    static Boolean[] wer2 = new Boolean[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);
        stop_test = (TextView) findViewById(R.id.stop_test);
        stop_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizGameActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();
            }
        });
        recyclerViewQuestions = findViewById(R.id.recycler_view);
        prepareQuestions();
        initQuestionsAdapter();
    }

    private void prepareQuestions( ) {
        for (int i = 0; i < 10; i++) {
            wer[i]=false;
            wer2[i]=false;
        }
        Question_Model question1 = new Question_Model();
        question1.optionA = "Рябчик";
        question1.optionB = "Дикуша";
        question1.optionC = "Белая куропатка";
        question1.src_image = "i1";
        question1.music = "p1";
        question1.correctOption = 1;
        questions.add(question1);

        Question_Model question2 = new Question_Model();
        question2.optionA = "Кавказский тетерев";
        question2.optionB = "Тетерев-косач";
        question2.optionC = "Тундряная куропатка";
        question2.src_image = "i2";
        question2.music = "p2";
        question2.correctOption = 3;
        questions.add(question2);

        Question_Model question3 = new Question_Model();
        question3.optionA = "Перепел";
        question3.optionB = "Серая куропатка";
        question3.optionC = "Кеклик";
        question3.src_image = "i3";
        question3.music = "p3";
        question3.correctOption = 3;
        questions.add(question3);

        Question_Model question4 = new Question_Model();
        question4.optionA = "Лебедь-кликун";
        question4.optionB = "Лебедь-трубач";
        question4.optionC = "Лебедь-шипун";
        question4.src_image = "i4";
        question4.music = "p4";
        question4.correctOption = 3;
        questions.add(question4);

        Question_Model question5 = new Question_Model();
        question5.optionA = "Гуменник";
        question5.optionB = "Сухонос";
        question5.optionC = "Американский лебедь";
        question5.src_image = "i5";
        question5.music = "p5";
        question5.correctOption = 1;
        questions.add(question5);

        Question_Model question6 = new Question_Model();
        question6.optionA = "Белощёкая казарка";
        question6.optionB = "Чёрная казарка";
        question6.optionC = "Mалая канадская казарка";
        question6.src_image = "i6";
        question6.music = "p6";
        question6.correctOption = 1;
        questions.add(question6);

        Question_Model question7 = new Question_Model();
        question7.optionA = "Белоспинный альбатрос";
        question7.optionB = "Чернобрового альбатрос";
        question7.optionC = "Темноспинный альбатрос ";
        question7.src_image = "i7";
        question7.music = "p7";
        question7.correctOption = 2;
        questions.add(question7);

        Question_Model question8 = new Question_Model();
        question8.optionA = "Черноголовый ибис";
        question8.optionB = "Большая белая цапля";
        question8.optionC = "Малая колпица ";
        question8.src_image = "i8";
        question8.music = "p8";
        question8.correctOption = 2;
        questions.add(question8);

        Question_Model question9 = new Question_Model();
        question9.optionA = "Чомга, или большая поганка ";
        question9.optionB = "Черношейная поганка";
        question9.optionC = "Чёрный коршун";
        question9.src_image = "i9";
        question9.music = "p9";
        question9.correctOption = 3;
        questions.add(question9);

        Question_Model question10 = new Question_Model();
        question10.optionA = "расавка, или малый журавль";
        question10.optionB = "Стерх, или белый журавль";
        question10.optionC = "Даурский журавль";
        question10.src_image = "i10";
        question10.music = "p10";
        question10.correctOption = 3;
        questions.add(question10);
    }

    private void initQuestionsAdapter() {
        recyclerViewQuestions.setLayoutManager(new LinearLayoutManager(this));
        QuestionAdapter questionAdapter = new QuestionAdapter(this, questions);
        recyclerViewQuestions.setAdapter(questionAdapter);
    }
    // Системная кнопка назад
    @Override
    public void onBackPressed(){
        Intent backintent = new Intent(QuizGameActivity.this, MainActivity.class);
        startActivity(backintent);wer=wer2;finish();
    }

}
