package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;//动画AnimationUtils引用需要import新对象
import android.widget.TextView;

//import com.google.android.material.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;

    //Hooks
    TextView logo,slogan;

    //Animations
    Animation topAnimation,bottomAniamation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAniamation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        logo=findViewById(R.id.main_tv_QWJLogo);
        slogan=findViewById(R.id.main_tv_tagline);

        logo.setAnimation(topAnimation);
        slogan.setAnimation(bottomAniamation);

        //Splash Screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}