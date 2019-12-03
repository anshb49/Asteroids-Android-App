package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        Button startbutton = findViewById(R.id.startButton);
        TextView welcome = findViewById(R.id.welcomeLabel);
        startbutton.setOnClickListener(v -> {
            startbutton.setVisibility(View.INVISIBLE);
            welcome.setVisibility(View.INVISIBLE);
        });










        box = findViewById(R.id.box);
        frame = findViewById(R.id.frame);
        rocket = getResources().getDrawable(R.drawable.rocketpic);


        Button moveLeft = findViewById(R.id.leftBtn);
        Button moveRight = findViewById(R.id.rightBtn);

        final ImageView image = findViewById(R.id.box);






        moveLeft.setOnClickListener(v -> {
            moveRocketLeft();

        });

        moveRight.setOnClickListener(v -> {
            action_right = true;
            moveRocketRight();

        });



    }

    public void moveRocketLeft() {

        System.out.println("move left");



        boxX = box.getX();


        boxX = boxX - 60;

        box.setX(boxX);
        box.setImageDrawable(rocket);



    }

    public void moveRocketRight() {
        System.out.println("move right");


        boxX = box.getX();


        boxX = boxX + 60;
        box.setX(boxX);
        box.setImageDrawable(rocket);



    }
}
