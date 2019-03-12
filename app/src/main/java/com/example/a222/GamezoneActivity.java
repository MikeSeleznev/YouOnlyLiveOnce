package com.example.a222;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.lukedeighton.wheelview.Circle;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;
import com.lukedeighton.wheelview.adapter.WheelArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GamezoneActivity extends AppCompatActivity {

    private float x;
    private float y;

    private float xX = 0f;
    private float yY = 0f;

    private float xXX;
    private float yYY;

    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;
    float angle;
    float angle2;

    private boolean start = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamezone);
        bottle = findViewById(R.id.bottle);

        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bottle.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(start){
                x = event.getX();
                y = event.getY();
                start = false;}
                else{
                    xX = event.getX();
                    yY = event.getY();
                }

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        System.out.println(x);
                        System.out.println(y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        System.out.println(x);
                        System.out.println(y);
                        angle = (float) Math.atan2((yY - y), (xX - x));
                        Double angle1 = (double) angle;
                        angle2 = ((float)Math.toDegrees(angle1)) % 360;
                        if (angle < -180.f) angle += 360.0f;
                        if (angle > 180.f) angle -= 360.0f;
                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println(x);
                        System.out.println(y);
                        break;
                }
                //float angle1 = (float) Math.atan2( (fY - sY), (fX - sX) );
                //float angle2 = (float) Math.atan2( (nfY - nsY), (nfX - nsX) );
                //float angle = ((float)Math.toDegrees(angle1 - angle2)) % 360;


                RotateAnimation rotateAnimation = new RotateAnimation(0f, angle2,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(1000);
                rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                bottle.startAnimation(rotateAnimation);

                return true;
            }

        });

    }
        private View.OnTouchListener handleTouch = new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                x = event.getX();
                y = event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        System.out.println(x);
                        System.out.println(y);
                    case MotionEvent.ACTION_MOVE:
                        System.out.println(x);
                        System.out.println(y);
                    case MotionEvent.ACTION_UP:
                        x = event.getX();
                        y = event.getY();
                        System.out.println(x);
                        System.out.println(y);


                }
                //float angle1 = (float) Math.atan2( (fY - sY), (fX - sX) );
                //float angle2 = (float) Math.atan2( (nfY - nsY), (nfX - nsX) );
                //float angle = ((float)Math.toDegrees(angle1 - angle2)) % 360;
                float angle = ((float)Math.toDegrees(50f - 30f)) % 360;
                RotateAnimation rotateAnimation = new RotateAnimation(0f, angle,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(1000);
                rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                bottle.startAnimation(rotateAnimation);

                return true;
            }
        };




    /*public void spinBottle(View v){
        if (!spinning) {
        int newDir = random.nextInt(1800);
        float pivotX = bottle.getWidth() / 2;
        float pivotY = bottle.getHeight() / 2;

        Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
        rotate.setDuration(2500);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                spinning = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                spinning = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        lastDir = newDir;
        bottle.startAnimation(rotate);
    }
    }*/
}