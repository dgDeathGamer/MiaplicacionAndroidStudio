package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class MainActivity2 extends AppCompatActivity {


    Button buttoniniciarsesion2;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttoniniciarsesion2= findViewById(R.id.buttoniniciarsesion2);

        db = FirebaseFirestore.getInstance();

        buttoniniciarsesion2.setOnClickListener(v -> {

            login();

        });
    }
    public void login(){

        EditText inicioCorreo = findViewById(R.id.inicioCorreo);
        String correo = inicioCorreo.getText().toString();
        EditText inicioContrasenia = findViewById(R.id.inicioContrasenia);
        String contraseña = inicioContrasenia.getText().toString();

        db.collection("Usuario")
                .whereEqualTo("correo",correo)
                .whereEqualTo("contraseña", contraseña)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()){
                        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this); //guarda los datos de manera global por si los quiero ocupar
                        SharedPreferences.Editor editor = datos.edit();
                        editor.putString("correo",correo);

                        QueryDocumentSnapshot documentoUser = (QueryDocumentSnapshot)queryDocumentSnapshots.getDocuments().get(0); //se guarda lo obtenido de la firestore

                        editor.putString("nombre", documentoUser.getString("nombre"));
                        //editor.putString("correo", documentoUser.getString("correo"));
                        editor.putString("contraseña",contraseña);
                        editor.apply();
                        Toast.makeText(this, "Usted ha iniciado Sesión", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity2.this, MainActivityParaelmenulateral.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(this, "Hubo un error al reconocer la cuenta", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e ->{
                    Toast.makeText(this,"Error:"+e.getMessage(),Toast.LENGTH_SHORT).show();
                });
    }

}