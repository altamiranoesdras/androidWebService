package com.example.usuario.pruebawebsservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class ConvertMasaActivity extends AppCompatActivity {

    private EditText etWeight;
    private Spinner spFromUnit;
    private Spinner spToUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_masa);

        initComponents();
    }

    private void initComponents(){
        etWeight = (EditText) findViewById(R.id.etWeight);
        spFromUnit = (Spinner) findViewById(R.id.spFromUnit);
        spToUnit = (Spinner) findViewById(R.id.spToUnit);
    }

    public void convertWeight(){

    }
}
