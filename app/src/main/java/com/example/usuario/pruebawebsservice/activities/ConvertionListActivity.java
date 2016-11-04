package com.example.usuario.pruebawebsservice.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.usuario.pruebawebsservice.R;
import com.example.usuario.pruebawebsservice.db.ConvertionTableManager;
import com.example.usuario.pruebawebsservice.objects.Convertion;

import java.util.ArrayList;
import java.util.List;

public class ConvertionListActivity extends AppCompatActivity {
    private ListView lvConvertion;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertion_list);

        initComponentes();
    }

    private void initComponentes(){
        lvConvertion = (ListView) findViewById(R.id.lv_convertion);

        final List<Convertion> convertionList= ConvertionTableManager.getConvertions(this);
        final List<String> convertionArray = new ArrayList<>();

        for(int i=0;i< convertionList.size(); i++){
            convertionArray.add(convertionList.get(i).toString());
        }

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,convertionArray);
        lvConvertion.setAdapter(adapter);

        lvConvertion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),String.valueOf(convertionList.get(i)),Toast.LENGTH_LONG).show();

                Convertion convertion = convertionList.get(i);
                if(ConvertionTableManager.deleteConvertion(getApplicationContext(), convertion)){
                    convertionList.remove(i);
                    adapter.remove(convertion.toString());

                    Toast.makeText(getApplicationContext(), "Eliminacion exitosa", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Todo esta mal", Toast.LENGTH_LONG).show();
                }
            };
        });
    }
}
