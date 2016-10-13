package com.example.usuario.pruebawebsservice;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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

        Units = getResources().getStringArray(R.array.wight_units);

        spFromUnit.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Units));
        spToUnit.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Units));

    }

    public void convertWeight(){

    }
}
