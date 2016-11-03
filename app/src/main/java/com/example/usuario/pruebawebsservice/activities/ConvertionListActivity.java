package com.example.usuario.pruebawebsservice.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.usuario.pruebawebsservice.R;
import com.example.usuario.pruebawebsservice.db.ConvertionTableManager;
import com.example.usuario.pruebawebsservice.objects.Convertion;

import java.util.List;

public class ConvertionListActivity extends AppCompatActivity {
    private ListView lvConvertion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertion_list);
        initComponents();
    }

    private void initComponents(){
        lvConvertion = (ListView) findViewById(R.id.lv_convertion);
        List<Convertion> convertionList = ConvertionTableManager.getConvertions(this);
        String[] convertionArray = new String[convertionList.size()];

        for (int i=0; i < convertionList.size(); i++){
            convertionArray[i] = convertionList.get(i).toString();
        }

        lvConvertion.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,convertionArray));

    }
}
