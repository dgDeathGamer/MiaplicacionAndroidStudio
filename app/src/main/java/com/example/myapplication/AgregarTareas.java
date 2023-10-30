package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AgregarTareas extends AppCompatActivity {


    Button buttonGuardarTarea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tareas);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String[] datos = new String[] {"Diaria", "Semanal", "Mensual"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);

        spinner.setAdapter(adapter);

        buttonGuardarTarea= findViewById(R.id.buttonGuardarTarea);
        buttonGuardarTarea.setOnClickListener(v -> {

            Intent i = new Intent(AgregarTareas.this, ListaParaAgregarTareas.class);
            startActivity(i);

        });
    }
}