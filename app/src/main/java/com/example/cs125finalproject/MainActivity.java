package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private ImageView box;

    private FrameLayout frame;

    private Drawable imageBoxRight;
    private Drawable imageBoxLeft;

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
        imageBoxLeft = getResources().getDrawable(R.drawable.rocketPic);
        imageBoxRight = getResources().getDrawable((R.drawable.box_right);

        Button moveLeft = findViewById(R.id.leftBtn);
        Button moveRight = findViewById(R.id.rightBtn);


        moveLeft.setOnClickListener(v -> {
            action_left = true;
            moveMethod();

        });

        moveRight.setOnClickListener(v -> {
            action_right = true;
            moveMethod();

        });



    }

    public void moveMethod() {


        boxX = box.getX();
        boxY = box.getY();

        if (action_left == true) {
            boxX = boxX - 20;
            box.setImageDrawable(imageBoxLeft);

        }

        if (action_right == true) {
            boxX = boxX + 20;
            box.setImageDrawable(imageBoxRight);

        }

    }
}
