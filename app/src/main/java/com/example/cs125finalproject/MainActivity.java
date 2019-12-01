package com.example.cs125finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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

    private boolean action_up;
    private boolean action_down;

    private Timer timer = new Timer();

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box = findViewById(R.id.box);
        frame = findViewById(R.id.frame);
        imageBoxLeft = getResources().getDrawable((R.drawable.box_left));

    }
}
