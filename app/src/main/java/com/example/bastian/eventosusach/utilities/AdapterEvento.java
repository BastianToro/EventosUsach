package com.example.bastian.eventosusach.utilities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bastian.eventosusach.R;
import com.example.bastian.eventosusach.models.Evento;

import java.util.ArrayList;

/**
 * Created by bastian on 20-05-16.
 */
public class AdapterEvento extends BaseAdapter{

    protected Activity activity;
    protected ArrayList<Evento> lista;

    public AdapterEvento(Activity activity,ArrayList<Evento> lista){
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if(view == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.itemlista,null);
        }

        Evento evento = lista.get(i);

        TextView textView = (TextView) v.findViewById(R.id.textoTitulo);
        textView.setText(evento.getTitulo());

        return v;
    }
}
