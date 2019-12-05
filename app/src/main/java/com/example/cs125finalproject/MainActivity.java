package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

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


    private int screenWidth;
    private int screenHeight;
    private ImageView asteroid;

    private float asteroidX;
    private float asteroidY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asteroid = (ImageView)findViewById(R.id.asteroidPic);

        //screen size
        WindowManager window = getWindowManager();
        Display display = window.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        //move to out of screen
        asteroid.setX(-80.0f);
        asteroid.setY(screenHeight + 80.0f);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        moveTheAsteroid();
                    }
                });
            }
        }, 0, 10);

        moveTheAsteroid();

        Button startbutton = findViewById(R.id.startButton);
        TextView welcome = findViewById(R.id.welcomeLabel);


        Button moveLeft = findViewById(R.id.leftBtn);
        Button moveRight = findViewById(R.id.rightBtn);

        moveLeft.setVisibility(View.INVISIBLE);
        moveRight.setVisibility(View.INVISIBLE);

        startbutton.setOnClickListener(v -> {
            startbutton.setVisibility(View.INVISIBLE);
            welcome.setVisibility(View.INVISIBLE);
            moveLeft.setVisibility(View.VISIBLE);
            moveRight.setVisibility(View.VISIBLE);
        });










        box = findViewById(R.id.box);
        frame = findViewById(R.id.frame);
        rocket = getResources().getDrawable(R.drawable.rocketpic);




        final ImageView image = findViewById(R.id.box);






        moveLeft.setOnClickListener(v -> {
            moveRocketLeft();

        });

        moveRight.setOnClickListener(v -> {
            moveRocketRight();

        });



    }

    public void moveTheAsteroid() {
        asteroidY = asteroidY + 10;
        if (asteroid.getY() > screenHeight) {
            asteroidX = (float)Math.floor(Math.random() * (screenWidth - asteroid.getWidth()));
            asteroidY = -100.0f;

        }
        asteroid.setX(asteroidX);
        asteroid.setY(asteroidY);

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
