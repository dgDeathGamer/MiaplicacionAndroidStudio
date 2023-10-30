package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Modelo.Tareas;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context contexto;

    public Adaptador(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(contexto).inflate(R.layout.items_listview,null);
        TextView tvTarea1 = (TextView) view.findViewById(R.id.tvTarea1);
        TextView tvTarea2 = (TextView) view.findViewById(R.id.tvTarea2);
        TextView tvTarea3 = (TextView) view.findViewById(R.id.tvTarea3);

        Tareas t = (Tareas) getItem(i);
        tvTarea1.setText(t.getNombre());
        tvTarea2.setText(t.getDescripcion());
        tvTarea3.setText(t.getTipo());
        return view;
    }
}
