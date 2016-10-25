package com.example.usuario.pruebawebsservice.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.usuario.pruebawebsservice.R;
import com.example.usuario.pruebawebsservice.helpers.PreferencesManager;

public class TermsConditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);
    }

    public void noAceptoClick(View view){
        Toast.makeText(this,"Teminos no aceptados",Toast.LENGTH_LONG).show();
        PreferencesManager.setTermsConditionAccepted(this, false);
        finish();
    }

    public void siAceptoClick(View view){
        Toast.makeText(this,"Teminos aceptados",Toast.LENGTH_LONG).show();
        PreferencesManager.setTermsConditionAccepted(this,true);
        startActivity(new Intent(this, OptionsActivity.class));
        finish();
    }
}
