package com.example.a222;


import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GamezoneActivity extends AppCompatActivity {

    private ImageView bottle;
    private Random random = new Random();
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
    private Button lastPaintedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamezone);
        bottle = findViewById(R.id.bottle);
        user1 = findViewById(R.id.user1);
        user2 = findViewById(R.id.user2);
        user3 = findViewById(R.id.user3);
        user4 = findViewById(R.id.user4);
        user5 = findViewById(R.id.user5);
        user6 = findViewById(R.id.user6);
        user7 = findViewById(R.id.user7);
        user8 = findViewById(R.id.user8);


        Intent intent = getIntent();


        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBackgroundColor();
                Random random = new Random();
                new_dir = random.nextInt(2160) + (int) last_dir;
                float pointWidth = bottle.getWidth() / 2;
                float pointHeight = bottle.getHeight() / 2;
                Animation rotation = new RotateAnimation(last_dir, new_dir, pointWidth, pointHeight);
                rotation.setDuration(2700);
                rotation.setFillAfter(true);
                rotation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        float last_dir_copy = last_dir + 80;
                        //new_dir = (int) last_dir_copy - 70;
                        float cyrcles = (last_dir_copy % 360 / 45);
                        cyrcles = (float) Math.round(cyrcles);
                        if (cyrcles < 1) { paintGamer(lastPaintedUser);
                        } else if (cyrcles == 1) {
                            paintGamer(user1);
                        } else if (cyrcles == 2) {
                            paintGamer(user2);
                        } else if (cyrcles == 3) {
                            paintGamer(user3);
                        } else if (cyrcles == 4) {
                            paintGamer(user4);
                        } else if (cyrcles == 5) {
                            paintGamer(user5);
                        } else if (cyrcles == 6) {
                            paintGamer(user6);
                        } else if (cyrcles == 7) {
                            paintGamer(user7);
                        } else if (cyrcles == 8) {
                            paintGamer(user8);
                        }
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

    private void paintGamer(Button user) {
        Drawable image = (Drawable) getResources().getDrawable(R.drawable.circleactive);
        user.setBackground(image);
        user.setTextColor(Color.WHITE);
        lastPaintedUser = user;
    }

    private void setBackgroundColor() {
        Drawable image = (Drawable) getResources().getDrawable(R.drawable.circle);
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
        user8.setTextColor(Color.BLACK);
    }

}