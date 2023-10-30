package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Modelo.Usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity3 extends AppCompatActivity {

    Button buttonpararegistrarse;
    EditText ETNombre, ETContrasenia, ETEmail;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference UsuarioCollection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        UsuarioCollection = db.collection("Usuario");

        buttonpararegistrarse= findViewById(R.id.buttonpararegistrarse);
        buttonpararegistrarse.setOnClickListener(v -> {

            registrarUsuario();
            Intent i = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(i);

        });
    }

    public void registrarUsuario(){
        ETNombre = findViewById(R.id.ETNombre);
        ETContrasenia = findViewById(R.id.ETContrasenia);
        ETEmail = findViewById(R.id.ETEmail);

        String nombre = ETNombre.getText().toString();
        String contraseña = ETContrasenia.getText().toString();
        String email = ETEmail.getText().toString();

        Usuario user = new Usuario("",nombre, contraseña, email);
        UsuarioCollection.add(user)
                .addOnSuccessListener(documentReference -> {
                    user.setId(documentReference.getId());
                    documentReference.set(user)
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(MainActivity3.this, "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
                            })
                            .addOnFailureListener(e ->{
                                Toast.makeText(MainActivity3.this, "Error al registrarse", Toast.LENGTH_SHORT).show();
                            });
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(MainActivity3.this, "Error al registrar su cuenta", Toast.LENGTH_SHORT).show();
                });
    }

}