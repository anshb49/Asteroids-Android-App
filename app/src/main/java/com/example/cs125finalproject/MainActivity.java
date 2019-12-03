package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {


    private ImageView box;

    private FrameLayout frame;

    private Drawable rocket;

    private float boxX;
    private float boxY;

    private boolean action_left = false;
    private boolean action_right = false;

    private Timer timer = new Timer();

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);










        box = findViewById(R.id.box);
        frame = findViewById(R.id.frame);
        rocket = getResources().getDrawable(R.drawable.rocketpic);


        Button moveLeft = findViewById(R.id.leftBtn);
        Button moveRight = findViewById(R.id.rightBtn);

        final ImageView image = findViewById(R.id.box);
        moveLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewGroup.MarginLayoutParams)image.getLayoutParams()).topMargin += 1;
                image.requestLayout();
            }
        });


        moveLeft.setOnClickListener(v -> {
            action_left = true;
            moveRocketLeft();

        });

        moveRight.setOnClickListener(v -> {
            action_right = true;
            moveRocketRight();

        });



    }

    public void moveRocketLeft() {


        boxX = box.getX();
        boxY = box.getY();

        boxX = boxX - 20;
        box.setImageDrawable(rocket);



    }

    public void moveRocketRight() {


        boxX = box.getX();
        boxY = box.getY();

        boxX = boxX + 100;
        box.setImageDrawable(rocket);



    }
}
