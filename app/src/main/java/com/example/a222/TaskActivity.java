package com.example.a222;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Random;

public class TaskActivity extends AppCompatActivity {
    TextView theme;
    TextView quest;
    SharedPreferences sPref;
    TextView leftCards;
    Button doneButton;
    int max;
    String question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_activity);
        theme = findViewById(R.id.theme);
        quest = findViewById(R.id.quest);
        leftCards = findViewById(R.id.leftCards);
        doneButton = findViewById(R.id.doneButton);

        Gson gson = new Gson();
        String json = PreferenceManager.getDefaultSharedPreferences(this).getString("usuall", "");
        final Cards usuall = gson.fromJson(json, Cards.class);
        usuall.minusOneCard();
        max = usuall.sizeCards();

        leftCards.setText(usuall.leftCardsText());
        theme.setText(usuall.getName());
        question = usuall.getRandomQuestion();
        quest.setText(question);
        usuall.cards.remove(question);


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Gson gson = new Gson();
                String json = gson.toJson(usuall);
                sPref = PreferenceManager.getDefaultSharedPreferences(TaskActivity.this);
                SharedPreferences.Editor ed = sPref.edit();
                ed.putString("usuall", json);
                ed.commit();

                Intent intent = new Intent(TaskActivity.this, GamezoneActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
