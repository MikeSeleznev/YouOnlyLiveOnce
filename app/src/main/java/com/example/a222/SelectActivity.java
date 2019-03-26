package com.example.a222;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;



public class SelectActivity extends AppCompatActivity {

    TextView user;
    ImageButton usual;
    CheckedTextView kolodanumcards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_activity);

        final Intent intent = getIntent();
        String selectedUser = (String) intent.getSerializableExtra("user");

        Gson gson = new Gson();
        String json = PreferenceManager.getDefaultSharedPreferences(this).getString("game", "");
        Game game = gson.fromJson(json, Game.class);

        kolodanumcards = (CheckedTextView) findViewById(R.id.kolodanumcards);
        kolodanumcards.setText(game.cards[0].leftCardsInt());

        user = (TextView)findViewById(R.id.selectedUser);
        user.setText(game.getSelectedPlayer().getFullName());

        usual = (ImageButton) findViewById(R.id.usual);
        usual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent taskIntent = new Intent(SelectActivity.this, TaskActivity.class);
                taskIntent.putExtra("pack", Const.USUAL);
                startActivity(taskIntent);
                finish();
            }
        });
    }
}
