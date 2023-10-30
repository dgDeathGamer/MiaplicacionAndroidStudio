package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaParaAgregarTareas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaParaAgregarTareas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaParaAgregarTareas() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaParaAgregarTareas.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaParaAgregarTareas newInstance(String param1, String param2) {
        ListaParaAgregarTareas fragment = new ListaParaAgregarTareas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_lista_para_agregar_tareas, container, false);

        // Infla el diseño del fragmento y obtén la vista raíz
        View rootView = inflater.inflate(R.layout.fragment_lista_para_agregar_tareas, container, false);

        // Obtén una referencia al botón
        Button buttonAgregarTarea = rootView.findViewById(R.id.buttonAgregarTarea);


        //obtengo el tab
        TabLayout tab = rootView.findViewById(R.id.tablayout);
        //agrego un lister al tab para poder seleccionar una opcion
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selectedFragment;
                switch (position) {
                    case 0:
                        selectedFragment = new tabDiarias();
                        break;
                    case 1:
                        selectedFragment = new tabSemanales();
                        break;
                    case 2:
                        selectedFragment = new tabMensuales();
                        break;
                    default:
                        selectedFragment = new tabDiarias(); // Fragmento predeterminado si no hay coincidencia
                        break;
                }

                // Reemplaza el fragmento actual en el contenedor con el fragmento seleccionado
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.contenedor2, selectedFragment)
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //dependiendo de la opcion cargo un fragmento en el contenedor


        // Configura un OnClickListener para el botón
        buttonAgregarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crea un Intent para abrir la actividad AgregarTareas
                Intent intent = new Intent(getActivity(), AgregarTareas.class);

                // Inicia la actividad AgregarTareas
                startActivity(intent);
            }
        });

        return rootView;

    }
}