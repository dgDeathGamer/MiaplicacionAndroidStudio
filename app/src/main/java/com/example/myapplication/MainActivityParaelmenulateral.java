package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivityParaelmenulateral extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paraelmenulateral);
        //referencia al Toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        /*incorporamos el menu lateral*/
        NavigationView nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //obtener una opcion del menu. Que estresanteTodo;_;
                int id = item.getItemId(); //Esto es para recuperar el id del item seleccionado, creo
                if(id==R.id.opcion1){
                    Toast.makeText(getApplicationContext(), "Esta es la Lista de tareas", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contenedor, new ListaParaAgregarTareas())
                            .addToBackStack(null) // Agrega el fragmento a la pila de retroceso
                            .commit();
                }
                else if(id==R.id.opcion2){
                    Toast.makeText(getApplicationContext(), "Estas son las Tareas a realizar", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contenedor, new ListaTareasARealizar())
                            .addToBackStack(null) // Agrega el fragmento a la pila de retroceso
                            .commit();
                }
                else if(id==R.id.opcion3){
                    Toast.makeText(getApplicationContext(), "Estas son las Tareas ya realizadas", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contenedor, new ListaTareasCompletadas())
                            .addToBackStack(null) // Agrega el fragmento a la pila de retroceso
                            .commit();
                }
                else if(id==R.id.opcion4){
                    Toast.makeText(getApplicationContext(), "Esta es la configuracion", Toast.LENGTH_SHORT).show();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contenedor, new Configuracion())
                            .addToBackStack(null) // Agrega el fragmento a la pila de retroceso
                            .commit();
                }

                return false;
            }
        });
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.irAconfiraguracion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl,R.string.Drawer_Abierto, R.string.Drawer_Cerrado);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dl.isDrawerOpen(GravityCompat.START)){
                    dl.closeDrawer(GravityCompat.START);
                }
                else{
                    dl.openDrawer((int) Gravity.START);
                }
            }
        });
    }
}