package com.example.bastian.eventosusach;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bastian.eventosusach.controllers.EventoGet;
import com.example.bastian.eventosusach.models.Evento;
import com.example.bastian.eventosusach.utilities.AdapterEvento;
import com.example.bastian.eventosusach.views.DescEventView;
import com.example.bastian.eventosusach.views.login;
import com.example.bastian.eventosusach.views.register;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    //final ArrayList<Evento> eventos = new ArrayList<Evento>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.listView);
    }


    public void onclickLogin(View v){

        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }



    public void onclickRegister(View v){
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }


    public void adapterLista(Activity activity, final ArrayList<Evento> evento){
        AdapterEvento ae = new AdapterEvento(activity,evento);
        lista.setAdapter(ae);
        new EventoGet(this,evento).execute("http://10.0.2.2:8080/EventoUsachJava/eventos");
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b = new Bundle();
                Bundle c = new Bundle();
                b.putDouble("latitud",evento.get(i).getLugar().getLatitud());
                c.putDouble("longitud",evento.get(i).getLugar().getLongitud());

                Intent intent = new Intent(MainActivity.this,DescEventView.class);
                intent.putExtra("titulo",evento.get(i).getTitulo());
                intent.putExtra("tipo",evento.get(i).getTipo().getTipo_evento());
                intent.putExtra("lugar",evento.get(i).getLugar().getNombre());
                intent.putExtras(b);
                intent.putExtras(c);
                intent.putExtra("fecha",evento.get(i).getFecha());
                intent.putExtra("horario",evento.get(i).getHora_inicio());
                intent.putExtra("descripcion",evento.get(i).getDescripcion());
                startActivity(intent);
            }
        });
    }
}
