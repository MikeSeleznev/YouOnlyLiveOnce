package com.example.a222;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Random;

public class GamezoneActivity extends AppCompatActivity {

    private ImageView bottle;
    private float last_dir = 0f;
    private int new_dir;
    private Button user1;
    private Button user2;
    private Button user3;
    private Button user4;
    private Button user5;
    private Button user6;
    private Button user7;
    private Button user8;
    private int numberOfPlayers;
    private int selectedUser = 0;
    Players players;
    Game game;
    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Gson gson = new Gson();
        //String json = PreferenceManager.getDefaultSharedPreferences(this).getString("Players", "");
        //final Players players = gson.fromJson(json, Players.class);

        String json = PreferenceManager.getDefaultSharedPreferences(this).getString("game", "");
        game = gson.fromJson(json, Game.class);

        numberOfPlayers = game.numberOfPlayers();

        if (numberOfPlayers == 2){
            setContentView(R.layout.gamezone_two);
            user1 = findViewById(R.id.user1);
            user2 = findViewById(R.id.user2);
        } else if(numberOfPlayers == 3){
            setContentView(R.layout.gamezone_three);
            user1 = findViewById(R.id.user1);
            user2 = findViewById(R.id.user2);
            user3 = findViewById(R.id.user3);
        }else if(numberOfPlayers == 4){
            setContentView(R.layout.gamezone_four);
            user1 = findViewById(R.id.user1);
            user2 = findViewById(R.id.user2);
            user3 = findViewById(R.id.user3);
            user4 = findViewById(R.id.user4);}
        else if(numberOfPlayers == 5){
            setContentView(R.layout.gamezone_five);
            user1 = findViewById(R.id.user1);
            user2 = findViewById(R.id.user2);
            user3 = findViewById(R.id.user3);
            user4 = findViewById(R.id.user4);
            user5 = findViewById(R.id.user5);}
        else if(numberOfPlayers == 6){
            setContentView(R.layout.gamezone_six);
            user1 = findViewById(R.id.user1);
            user2 = findViewById(R.id.user2);
            user3 = findViewById(R.id.user3);
            user4 = findViewById(R.id.user4);
            user5 = findViewById(R.id.user5);
            user6 = findViewById(R.id.user6);}
        else if(numberOfPlayers == 7){
            setContentView(R.layout.gamezone_seven);
            user1 = findViewById(R.id.user1);
            user2 = findViewById(R.id.user2);
            user3 = findViewById(R.id.user3);
            user4 = findViewById(R.id.user4);
            user5 = findViewById(R.id.user5);
            user6 = findViewById(R.id.user6);
            user7 = findViewById(R.id.user7);}
        else{
            setContentView(R.layout.gamezone_eight);
            user1 = findViewById(R.id.user1);
            user2 = findViewById(R.id.user2);
            user3 = findViewById(R.id.user3);
            user4 = findViewById(R.id.user4);
            user5 = findViewById(R.id.user5);
            user6 = findViewById(R.id.user6);
            user7 = findViewById(R.id.user7);
            user8 = findViewById(R.id.user8);}

        bottle = findViewById(R.id.bottle);

        setVisibleGamers(game.players);
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackgroundColor();
                Random random = new Random();
                new_dir = random.nextInt(2160)+ 1000 + (int) last_dir;
                float pointWidth = bottle.getWidth() / 2;
                float pointHeight = bottle.getHeight() / 2;
                final Animation rotation = new RotateAnimation(last_dir, new_dir, pointWidth, pointHeight);
                rotation.setDuration(2700);
                rotation.setFillAfter(true);
                rotation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        float last_dir_copy = last_dir;
                        float degree = last_dir_copy % 360;
                        if (numberOfPlayers == 2){
                            if (degree > 0 && degree <= 70){paintGamer(user1, 1);}
                            if (degree > 70 && degree <= 250){paintGamer(user2, 2);}
                            if (degree > 250){paintGamer(user1, 1);}

                        } else if(numberOfPlayers == 3){
                            if (degree > 0 && degree <= 30){paintGamer(user1,1);}
                            if (degree > 30 && degree <= 160){paintGamer(user2,2);}
                            if (degree > 160 && degree <= 295){paintGamer(user3,3);}
                            if (degree > 295 ){paintGamer(user1,1);}

                        } else if(numberOfPlayers == 4){
                            if (degree > 0 && degree <= 30){paintGamer(user1,1);}
                            if (degree > 30 && degree <= 125){paintGamer(user2,2);}
                            if (degree > 125 && degree <= 215){paintGamer(user3,3);}
                            if (degree > 215 && degree <= 305){paintGamer(user4,4);}
                            if (degree > 305 ){paintGamer(user1,1);}
                        } else if(numberOfPlayers == 5){
                            if (degree > 0 && degree <= 21){paintGamer(user1,1);}
                            if (degree > 21 && degree <= 93){paintGamer(user2,2);}
                            if (degree > 93 && degree <= 165){paintGamer(user3,3);}
                            if (degree > 165 && degree <= 248){paintGamer(user4,4);}
                            if (degree > 248 && degree <= 325){paintGamer(user5,5);}
                            if (degree > 325 ){paintGamer(user1, 1);}
                        } else if(numberOfPlayers == 6){
                            if (degree > 0 && degree <= 15){paintGamer(user1, 1);}
                            if (degree > 15 && degree <= 75){paintGamer(user2, 2);}
                            if (degree > 75 && degree <= 135){paintGamer(user3, 3);}
                            if (degree > 135 && degree <= 195){paintGamer(user4, 4);}
                            if (degree > 195 && degree <= 255){paintGamer(user5,5);}
                            if (degree > 255 && degree <= 315){paintGamer(user6, 6);}
                            if (degree > 315 ){paintGamer(user1,  1);}
                        } else if(numberOfPlayers == 7){
                            if (degree > 0 && degree <= 10){paintGamer(user1,1);}
                            if (degree > 10 && degree <= 61){paintGamer(user2,2);}
                            if (degree > 61 && degree <= 112){paintGamer(user3,3);}
                            if (degree > 112 && degree <= 163){paintGamer(user4,4);}
                            if (degree > 163 && degree <= 214){paintGamer(user5,5);}
                            if (degree > 214 && degree <= 265){paintGamer(user6,6);}
                            if (degree > 265 && degree <= 317){paintGamer(user7,7);}
                            if (degree > 317 ){paintGamer(user1,1);}
                        } else {
                            if (degree > 0 && degree <= 12){paintGamer(user1,1);}
                            if (degree > 12 && degree <= 57){paintGamer(user2,2);}
                            if (degree > 57 && degree <= 102){paintGamer(user3,3);}
                            if (degree > 102 && degree <= 147){paintGamer(user4,4);}
                            if (degree > 147 && degree <= 192){paintGamer(user5,5);}
                            if (degree > 192 && degree <= 237){paintGamer(user6,6);}
                            if (degree > 237 && degree <= 282){paintGamer(user7,7);}
                            if (degree > 282 && degree <= 327){paintGamer(user8,7);}
                            if (degree > 327 ){paintGamer(user1,1);}
                        }

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                game.setSelectedPlayer(game.players[selectedUser-1]);

                                Gson gson = new Gson();
                                String json = gson.toJson(game);
                                sPref = PreferenceManager.getDefaultSharedPreferences(GamezoneActivity.this);
                                SharedPreferences.Editor ed = sPref.edit();
                                ed.putString("game", json);
                                ed.commit();

                                Intent intent = new Intent(GamezoneActivity.this,SelectActivity.class);

                                //intent.putExtra("user", players.names.get(selectedUser - 1));
                                startActivity(intent);
                                finish();
                            }
                        }, 500);


                        }


                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                last_dir = new_dir;
                bottle.startAnimation(rotation);
            }
        });

    }



    private void setVisibleGamers(Players[] players) {

            user1.setText(players[0].getShortName());
            user2.setText(players[1].getShortName());
        if (numberOfPlayers == 3) {
            user3.setText(players[2].getShortName());
        } else if (numberOfPlayers == 4) {
            user3.setText(players[2].getShortName());
            user4.setText(players[3].getShortName());
        } else if (numberOfPlayers == 5) {
            user3.setText(players[2].getShortName());
            user4.setText(players[3].getShortName());
            user5.setText(players[4].getShortName());
        } else if (numberOfPlayers == 6) {
            user3.setText(players[2].getShortName());
            user4.setText(players[3].getShortName());
            user5.setText(players[4].getShortName());
            user6.setText(players[5].getShortName());
        } else if (numberOfPlayers == 7) {
            user3.setText(players[2].getShortName());
            user4.setText(players[3].getShortName());
            user5.setText(players[4].getShortName());
            user6.setText(players[5].getShortName());
            user7.setText(players[6].getShortName());
        } else if (numberOfPlayers == 8){
            user3.setText(players[2].getShortName());
            user4.setText(players[3].getShortName());
            user5.setText(players[4].getShortName());
            user6.setText(players[5].getShortName());
            user7.setText(players[6].getShortName());
            user8.setText(players[7].getShortName());
        }
    }

    private void paintGamer(Button user, int selectUser) {
        if (!(user == null)){
        Drawable image = (Drawable) getResources().getDrawable(R.drawable.circleactive);
        user.setBackground(image);
        user.setTextColor(Color.WHITE);
        }
        selectedUser = selectUser;
    }

    private void setBackgroundColor() {

        Drawable image = (Drawable) getResources().getDrawable(R.drawable.circle);
        if (numberOfPlayers == 2){
            user1.setBackground(image);
            user1.setTextColor(Color.BLACK);

            user2.setBackground(image);
            user2.setTextColor(Color.BLACK);
        } else if(numberOfPlayers == 3){
            user1.setBackground(image);
            user1.setTextColor(Color.BLACK);

            user2.setBackground(image);
            user2.setTextColor(Color.BLACK);

            user3.setBackground(image);
            user3.setTextColor(Color.BLACK);
        }else if(numberOfPlayers == 4){
            user1.setBackground(image);
            user1.setTextColor(Color.BLACK);

            user2.setBackground(image);
            user2.setTextColor(Color.BLACK);

            user3.setBackground(image);
            user3.setTextColor(Color.BLACK);

            user4.setBackground(image);
            user4.setTextColor(Color.BLACK);
        }else if(numberOfPlayers == 5){
            user1.setBackground(image);
            user1.setTextColor(Color.BLACK);

            user2.setBackground(image);
            user2.setTextColor(Color.BLACK);

            user3.setBackground(image);
            user3.setTextColor(Color.BLACK);

            user4.setBackground(image);
            user4.setTextColor(Color.BLACK);

            user5.setBackground(image);
            user5.setTextColor(Color.BLACK);
        }else if(numberOfPlayers == 6){
            user1.setBackground(image);
            user1.setTextColor(Color.BLACK);

            user2.setBackground(image);
            user2.setTextColor(Color.BLACK);

            user3.setBackground(image);
            user3.setTextColor(Color.BLACK);

            user4.setBackground(image);
            user4.setTextColor(Color.BLACK);

            user5.setBackground(image);
            user5.setTextColor(Color.BLACK);

            user6.setBackground(image);
            user6.setTextColor(Color.BLACK);}
        else if(numberOfPlayers == 7){
            user1.setBackground(image);
            user1.setTextColor(Color.BLACK);

            user2.setBackground(image);
            user2.setTextColor(Color.BLACK);

            user3.setBackground(image);
            user3.setTextColor(Color.BLACK);

            user4.setBackground(image);
            user4.setTextColor(Color.BLACK);

            user5.setBackground(image);
            user5.setTextColor(Color.BLACK);

            user6.setBackground(image);
            user6.setTextColor(Color.BLACK);

            user7.setBackground(image);
            user7.setTextColor(Color.BLACK);}
        else{

        user1.setBackground(image);
        user1.setTextColor(Color.BLACK);

        user2.setBackground(image);
        user2.setTextColor(Color.BLACK);

        user3.setBackground(image);
        user3.setTextColor(Color.BLACK);

        user4.setBackground(image);
        user4.setTextColor(Color.BLACK);

        user5.setBackground(image);
        user5.setTextColor(Color.BLACK);

        user6.setBackground(image);
        user6.setTextColor(Color.BLACK);

        user7.setBackground(image);
        user7.setTextColor(Color.BLACK);

        user8.setBackground(image);
        user8.setTextColor(Color.BLACK);}
    }

}