package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private ImageView rocketb;

    private Drawable rocket;

    private float rocketbX;

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

    private int score = 0;

    private boolean lost = false;


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
        //Display display =
        Point size = new Point();
        window.getDefaultDisplay().getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;





        asteroid.setX(-95.0f);
        asteroid.setY(screenHeight + 310.0f);

        asteroid2.setX(-95.0f);
        asteroid2.setY(screenHeight + 310.0f);

        asteroid3.setX(-95.0f);
        asteroid3.setY(screenHeight + 310.0f);

        asteroid4.setX(-95.0f);
        asteroid4.setY(screenHeight + 310.0f);


        TextView finalS = findViewById(R.id.finalScore);
        finalS.setVisibility(View.INVISIBLE);

        TextView scoreD = findViewById(R.id.descriptionScore);
        scoreD.setVisibility(View.INVISIBLE);

        TextView loseLabel = findViewById(R.id.loseLabel);
        loseLabel.setVisibility(View.INVISIBLE);

        Button startbutton = findViewById(R.id.startButton);
        TextView welcome = findViewById(R.id.welcomeLabel);

        Button moveLeft = findViewById(R.id.leftButton);
        Button moveRight = findViewById(R.id.rightButton);
        moveLeft.setVisibility(View.INVISIBLE);
        moveRight.setVisibility(View.INVISIBLE);

        asteroid.setVisibility(View.INVISIBLE);
        asteroid2.setVisibility(View.INVISIBLE);
        asteroid3.setVisibility(View.INVISIBLE);
        asteroid4.setVisibility(View.INVISIBLE);

        rocketb = findViewById(R.id.rock);
        rocket = getResources().getDrawable(R.drawable.rocketpic);


        //Start Button
        startbutton.setOnClickListener(v -> {
            startbutton.setVisibility(View.INVISIBLE);
            welcome.setVisibility(View.INVISIBLE);
            moveLeft.setVisibility(View.VISIBLE);
            moveRight.setVisibility(View.VISIBLE);

            asteroid.setVisibility(View.VISIBLE);
            asteroid2.setVisibility(View.VISIBLE);
            asteroid3.setVisibility(View.VISIBLE);
            asteroid4.setVisibility(View.VISIBLE);

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
            }, 0, 25);

            moveLeft.setOnClickListener(a -> {
                moveRocketLeft();

            });

            moveRight.setOnClickListener(b -> {
                moveRocketRight();

            });

        });

    }

    public void moveTheAsteroid() {

        //Asteroid Movement
        asteroidY = asteroidY + 10;
        asteroidY2 = asteroidY2 + 10;
        asteroidY3 = asteroidY3 + 10;
        asteroidY4 = asteroidY4 + 10;
        if (asteroid.getY() > screenHeight) {
            asteroidX = (float) Math.floor(Math.random() * (screenWidth - asteroid.getWidth()));
            asteroidY = -100.0f;

        }
        asteroid.setX(asteroidX);
        asteroid.setY(asteroidY);

        if (asteroid2.getY() > screenHeight) {
            asteroidX2 = (float) Math.floor(Math.random() * (screenWidth - asteroid2.getWidth() + 10));
            asteroidY2 = -100.0f;

        }
        asteroid2.setX(asteroidX2);
        asteroid2.setY(asteroidY2);

        if (asteroid3.getY() > screenHeight) {
            asteroidX3 = (float) Math.floor(Math.random() * (screenWidth - asteroid3.getWidth() - 10));
            asteroidY3 = -100.0f;

        }
        asteroid3.setX(asteroidX3);
        asteroid3.setY(asteroidY3);

        if (asteroid4.getY() > screenHeight) {
            asteroidX4 = (float) Math.floor(Math.random() * (screenWidth - asteroid4.getWidth() + 5));
            asteroidY4 = -100.0f;

        }
        asteroid4.setX(asteroidX4);
        asteroid4.setY(asteroidY4);

        checkIfHit();

    }

    public void checkIfHit() {
        final MediaPlayer explosionSound = MediaPlayer.create(this, R.raw.explosion);

        //Intersection Check
        Rect rectR = new Rect();
        rocketb.getHitRect(rectR);

        Rect asteroidRect = new Rect();
        asteroid.getHitRect(asteroidRect);

        Rect asteroid2Rect = new Rect();
        asteroid2.getHitRect(asteroid2Rect);

        Rect asteroid3Rect = new Rect();
        asteroid3.getHitRect(asteroid3Rect);

        Rect asteroid4Rect = new Rect();
        asteroid4.getHitRect(asteroid4Rect);

        if (Rect.intersects(rectR, asteroidRect)
                || Rect.intersects(rectR, asteroid2Rect)
                || Rect.intersects(rectR, asteroid3Rect)
                || Rect.intersects(rectR, asteroid4Rect)) {
            //Begin end screen
            System.out.println(("you lose"));
            asteroid.setVisibility(View.INVISIBLE);
            asteroid2.setVisibility(View.INVISIBLE);
            asteroid3.setVisibility(View.INVISIBLE);
            asteroid4.setVisibility(View.INVISIBLE);

            Button moveL = findViewById(R.id.leftButton);
            Button moveR = findViewById(R.id.rightButton);
            moveL.setVisibility(View.INVISIBLE);
            moveR.setVisibility(View.INVISIBLE);

            TextView loseLabel = findViewById(R.id.loseLabel);
            loseLabel.setVisibility(View.VISIBLE);

            TextView sc = findViewById(R.id.score);
            sc.setVisibility(View.INVISIBLE);

            TextView scoreD = findViewById(R.id.descriptionScore);
            scoreD.setVisibility(View.VISIBLE);

            int finalScore = score;
            TextView finalS = findViewById(R.id.finalScore);
            finalS.setText(Integer.toString(finalScore));
            finalS.setVisibility(View.VISIBLE);

            Button startAgain = findViewById(R.id.startButton);
            startAgain.setVisibility(View.VISIBLE);

            startAgain.setOnClickListener(a -> {
                this.recreate();

            });
            lost = true;
            explosionSound.start();

            rocketb.setVisibility(View.INVISIBLE);

            return;

        } else {

            if (lost == true) {
                score = score;
            } else {
                score = score + 1;

                TextView scoreL = findViewById(R.id.score);
                scoreL.setText(Integer.toString(score));
            }

        }

    }

    public void moveRocketLeft() {

        rocketbX = rocketb.getX();

        rocketbX = rocketbX - 60;

        rocketb.setX(rocketbX);
        rocketb.setImageDrawable(rocket);

    }

    public void moveRocketRight() {

        rocketbX = rocketb.getX();

        rocketbX = rocketbX + 60;

        rocketb.setX(rocketbX);
        rocketb.setImageDrawable(rocket);

    }

}
