package com.example.morga.applistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] datos = new String[]{"Elemento1","Elemento2","Elemento3","Elemento4","Elemento5"};

        ArrayAdapter<String> adaptator = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);

        ListView lstOpciones = (ListView)findViewById(R.id.listViewDatos);

        lstOpciones.setAdapter(adaptator);

    }




}
