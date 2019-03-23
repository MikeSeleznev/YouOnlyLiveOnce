package com.example.a222;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Random;

public class TaskActivity extends AppCompatActivity {
    TextView theme;
    TextView quest;
    SharedPreferences sPref;
    TextView leftCards;
    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_activity);
        theme = findViewById(R.id.theme);
        quest = findViewById(R.id.quest);
        leftCards = findViewById(R.id.leftCards);

        Gson gson = new Gson();
        String json = PreferenceManager.getDefaultSharedPreferences(this).getString("usuall", "");
        Cards usuall = gson.fromJson(json, Cards.class);

        max = usuall.sizeCards();

        StringBuilder str = new StringBuilder();
        str.append("Осталось карт в колоде ");
        str.append(max-1);
        str.append("/50");

        leftCards.setText(str);

        theme.setText(usuall.getName());

        Random number = new Random();
        int r1 = number.nextInt(max);

        quest.setText(usuall.getQuestion(r1));
        usuall.quests.remove(r1);
    }
}
