package com.example.usuario.pruebawebsservice.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.usuario.pruebawebsservice.R;
import com.example.usuario.pruebawebsservice.helpers.PreferencesManager;

public class SplashScreenActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler = new Handler();
        handler.postDelayed(runOptions,2000);
    }

    private Runnable runOptions= new Runnable() {
        @Override
        public void run() {
            goToOptions();
        }
    };

    private void goToOptions(){
        if(PreferencesManager.getTermsConditions(this)){
            startActivity(new Intent(this, OptionsActivity.class ));
        }else {
            startActivity(new Intent(this, TermsConditionsActivity.class ));
        }

    }
}
