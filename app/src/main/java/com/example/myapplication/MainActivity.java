package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttoniniciarsesion;
    Button buttonregistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttoniniciarsesion= findViewById(R.id.buttoniniciarsesion);
        buttonregistrarse= findViewById(R.id.buttonregistrarse);
        buttoniniciarsesion.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);

        });

        buttonregistrarse.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(i);
        });
    }
}