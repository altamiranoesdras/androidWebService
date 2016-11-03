package com.example.usuario.pruebawebsservice.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.usuario.pruebawebsservice.R;
import com.example.usuario.pruebawebsservice.ws.RestFulClient;

public class OptionsActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Handler handler;
    private  boolean ready;
    private String serviceResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        handler = new Handler();
    }

    public void goToSOAP(View view) {
        startActivity(new Intent(this,ConvertMasaActivity.class));
    }

    public void consumoGet(View view){
        progressDialog = ProgressDialog.show(this, "","Processed Request");

        new Thread()   {
            @Override
            public void run(){
                ready = false;
                serviceResult = RestFulClient.connectToServerGet();
                ready = true;
            }
        }.start();

        handler.postDelayed(monitoringService,1000);
    }

    public void consumoPost(View view){
        progressDialog = ProgressDialog.show(this, "","Processed Request");

        new Thread()   {
            @Override
            public void run(){
                ready = false;
                serviceResult = RestFulClient.connectToServerPost();
                ready = true;
            }
        }.start();

        handler.postDelayed(monitoringService,1000);
    }

    private Runnable monitoringService = new Runnable() {
        @Override
        public void run() {
            if(ready){
                //Show Activity
                showResult();
            }else{
                handler.postDelayed(monitoringService,1000);
            }
        }
    };

    private void  showResult(){
        progressDialog.cancel();
        Toast.makeText(this, serviceResult,Toast.LENGTH_LONG).show();
    }

    public void listConvertionClick(View view){
        startActivity(new Intent(this,ConvertionListActivity.class));
    }


}
