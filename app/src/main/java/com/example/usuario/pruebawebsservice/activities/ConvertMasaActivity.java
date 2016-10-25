package com.example.usuario.pruebawebsservice.activities;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.StrictMode;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.usuario.pruebawebsservice.R;
import com.example.usuario.pruebawebsservice.ws.SOAPClient;

public class ConvertMasaActivity extends AppCompatActivity {

    /**
     * Objeto controla el campo
     */
    private EditText etWeight;
    /**
     * Objeto que controla el spinner
     */
    private Spinner spFromUnit;
    /**
     * Objeto que controla el spinner
     */
    private Spinner spToUnit;

    /**
     * Array de strings para guardar las unidades
     */
    private String[] Units;

    private Handler handler;
    private ProgressDialog progressDialog;
    private boolean ready;
    private String convertedWeightValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_masa);

        initComponents();
    }

    private void initComponents(){

        handler = new Handler();
        etWeight = (EditText) findViewById(R.id.etWeight);
        spFromUnit = (Spinner) findViewById(R.id.spFromUnit);
        spToUnit = (Spinner) findViewById(R.id.spToUnit);

        Units = getResources().getStringArray(R.array.wight_units);

        spFromUnit.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Units));
        spToUnit.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Units));

    }

    public void convertWeight(View view){
        progressDialog = ProgressDialog.show(this,"","Precessed request...");
        Toast.makeText(this,"Weight: "+etWeight.getText().toString()+" from: "+(String) spFromUnit.getSelectedItem()+" to: "+(String) spToUnit.getSelectedItem(),Toast.LENGTH_LONG).show();
        new Thread(){
          @Override
          public void run(){
              ready = false;
              convertedWeightValue = SOAPClient.convertWeight(etWeight.getText().toString(),(String) spFromUnit.getSelectedItem(),(String) spToUnit.getSelectedItem());
              ready= true;
          }
        }.start();

        handler.postDelayed(verifyConvertedWeight,1000);
    }


    private Runnable verifyConvertedWeight = new Runnable() {
        @Override
        public void run() {
            if(ready){
                showConvertedWeight();
            }else{
                handler.postDelayed(verifyConvertedWeight,500);
            }
        }
    };

    private void showConvertedWeight(){
        progressDialog.cancel();
        Toast.makeText(this,"Weight: "+convertedWeightValue,Toast.LENGTH_LONG).show();
    }
}
