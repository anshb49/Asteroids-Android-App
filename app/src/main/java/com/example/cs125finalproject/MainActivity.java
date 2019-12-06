package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.graphics.Rect;
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
    private ImageView asteroid2;
    private ImageView asteroid3;
    private ImageView asteroid4;

    private float asteroidX;
    private float asteroidY;

    private float asteroidX2;
    private float asteroidY2;

    private float asteroidX3;
    private float asteroidY3;

    private float asteroidX4;
    private float asteroidY4;

    public Button moveLeft = findViewById(R.id.leftBtn);
    public Button moveRight = findViewById(R.id.rightBtn);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("check");

        asteroid = (ImageView)findViewById(R.id.asteroidPic);
        asteroid2 = (ImageView)findViewById(R.id.asteroidPic2);
        asteroid3 = (ImageView)findViewById(R.id.asteroidPic3);
        asteroid4 = (ImageView)findViewById(R.id.asteroidPic4);



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

        asteroid2.setX(-80.0f);
        asteroid2.setY(screenHeight + 80.0f);

        asteroid3.setX(-80.0f);
        asteroid3.setY(screenHeight + 80.0f);

        asteroid4.setX(-80.0f);
        asteroid4.setY(screenHeight + 80.0f);

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



        Button startbutton = findViewById(R.id.startButton);
        TextView welcome = findViewById(R.id.welcomeLabel);




        moveLeft.setVisibility(View.INVISIBLE);
        moveRight.setVisibility(View.INVISIBLE);

        asteroid.setVisibility(View.INVISIBLE);
        asteroid2.setVisibility(View.INVISIBLE);
        asteroid3.setVisibility(View.INVISIBLE);
        asteroid4.setVisibility(View.INVISIBLE);


        box = findViewById(R.id.box);
        frame = findViewById(R.id.frame);
        rocket = getResources().getDrawable(R.drawable.rocketpic);




        final ImageView boxImage = findViewById(R.id.box);


        //Start Game
        startbutton.setOnClickListener(v -> {
            startbutton.setVisibility(View.INVISIBLE);
            welcome.setVisibility(View.INVISIBLE);
            moveLeft.setVisibility(View.VISIBLE);
            moveRight.setVisibility(View.VISIBLE);


            asteroid.setVisibility(View.VISIBLE);
            asteroid2.setVisibility(View.VISIBLE);
            asteroid3.setVisibility(View.VISIBLE);
            asteroid4.setVisibility(View.VISIBLE);

            moveLeft.setOnClickListener(a -> {
                moveRocketLeft();

            });

            moveRight.setOnClickListener(b -> {
                moveRocketRight();

            });


            moveTheAsteroid();


        });





















    }

    public void moveTheAsteroid() {
        //Asteroid Movement
        asteroidY = asteroidY + 10;
        asteroidY2 = asteroidY2 + 10;
        asteroidY3 = asteroidY3 + 10;
        asteroidY4 = asteroidY4 + 10;
        if (asteroid.getY() > screenHeight) {
            asteroidX = (float)Math.floor(Math.random() * (screenWidth - asteroid.getWidth()));
            asteroidY = -100.0f;

        }
        asteroid.setX(asteroidX);
        asteroid.setY(asteroidY);

        if (asteroid2.getY() > screenHeight) {
            asteroidX2 = (float)Math.floor(Math.random() * (screenWidth - asteroid2.getWidth() + 10));
            asteroidY2 = -100.0f;

        }
        asteroid2.setX(asteroidX2);
        asteroid2.setY(asteroidY2);

        if (asteroid3.getY() > screenHeight) {
            asteroidX3 = (float)Math.floor(Math.random() * (screenWidth - asteroid3.getWidth() - 10));
            asteroidY3 = -100.0f;

        }
        asteroid3.setX(asteroidX3);
        asteroid3.setY(asteroidY3);

        if (asteroid4.getY() > screenHeight) {
            asteroidX4 = (float)Math.floor(Math.random() * (screenWidth - asteroid4.getWidth() + 5));
            asteroidY4 = -100.0f;

        }
        asteroid4.setX(asteroidX4);
        asteroid4.setY(asteroidY4);


        //Intersection Check
        Rect boxRect = new Rect();
        box.getHitRect(boxRect);

        Rect asteroidRect = new Rect();
        asteroid.getHitRect(asteroidRect);

        Rect asteroid2Rect = new Rect();
        asteroid2.getHitRect(asteroid2Rect);

        Rect asteroid3Rect = new Rect();
        asteroid3.getHitRect(asteroid3Rect);

        Rect asteroid4Rect = new Rect();
        asteroid4.getHitRect(asteroid4Rect);

        if (Rect.intersects(boxRect, asteroidRect)
                || Rect.intersects(boxRect, asteroid2Rect)
                || Rect.intersects(boxRect, asteroid3Rect)
                || Rect.intersects(boxRect, asteroid4Rect)) {
            //Begin end screen
            asteroid.setVisibility(View.INVISIBLE);
            asteroid2.setVisibility(View.INVISIBLE);
            asteroid3.setVisibility(View.INVISIBLE);
            asteroid4.setVisibility(View.INVISIBLE);

            moveLeft.setVisibility(View.INVISIBLE);
            moveRight.setVisibility(View.INVISIBLE);

        }





        /*
        if (Math.abs(box.getX() - asteroid.getX()) <= 1000 && box.getY() == asteroid.getY()) {
            System.out.println("first if statement is working");
        }
        if (Math.abs(box.getX() - asteroid2.getX()) <= 1000 && box.getY() == asteroid2.getY()) {
            System.out.println("second if statement is working");
        }
        if (Math.abs(box.getX() - asteroid3.getX()) <= 1000 && box.getY() == asteroid3.getY()) {
            System.out.println("third if statement is working");
        }
        if (Math.abs(box.getX() - asteroid4.getX()) <= 1000 && box.getY() == asteroid4.getY()) {
            System.out.println("fourth if statement is working");
        }

        if (box.getX() == asteroid.getX() && box.getY() == asteroid.getY()
                || box.getX() == asteroid2.getX() && box.getY() == asteroid2.getY()
                || box.getX() == asteroid3.getX() && box.getY() == asteroid3.getY()
                || box.getX() == asteroid4.getX() && box.getY() == asteroid4.getY()) {
            System.out.println("this is working");
        }
        */





    }

    public void moveRocketLeft() {

        //System.out.println("move left");



        boxX = box.getX();



        boxX = boxX - 60;

        box.setX(boxX);
        box.setImageDrawable(rocket);



    }

    public void moveRocketRight() {
        //System.out.println("move right");


        boxX = box.getX();


        boxX = boxX + 60;

        box.setX(boxX);
        box.setImageDrawable(rocket);



    }
}
