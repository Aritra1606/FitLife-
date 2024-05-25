package com.jis.fitlife.activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.jis.fitlife.R;


public class AppIntroActivity extends AppIntro {

    String  name = "";

    @Override
    public void init(Bundle savedInstanceState) {
        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance("Eye Catching Visuals", "Your Daily Statistics", R.drawable.appintro1, getResources().getColor(R.color.appintro1)));
        addSlide(AppIntroFragment.newInstance("Invite Friends", "Share A Run with them", R.drawable.appintro3, getResources().getColor(R.color.appintro3)));
        addSlide(AppIntroFragment.newInstance("", "Get Started", R.drawable.appintro4, getResources().getColor(R.color.appintro4)));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#F44336"));
        setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity.
        setVibrate(true);
        setVibrateIntensity(30);


    }

    @Override
    public void onSkipPressed() {
        // Do something when users tap on Skip button.
        name =  getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getString("USER_NAME", "");
        if (name.equals("")){
            Intent i = new Intent(AppIntroActivity.this, LoginActivity.class);
            startActivity(i);
        }else {
            Intent i = new Intent(AppIntroActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

    }

    @Override
    public void onDonePressed() {
        // Do something when users tap on Done button.
        name =  getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getString("USER_NAME", "");
        if (name.equals("")){
            Intent i = new Intent(AppIntroActivity.this, LoginActivity.class);
            startActivity(i);
        }else {
            Intent i = new Intent(AppIntroActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }


    }

    @Override
    public void onSlideChanged() {

    }

    @Override
    public void onNextPressed() {

    }

}