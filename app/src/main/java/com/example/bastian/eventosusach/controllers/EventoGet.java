package com.example.bastian.eventosusach.controllers;

import android.os.AsyncTask;
import android.util.Log;

import com.example.bastian.eventosusach.MainActivity;
import com.example.bastian.eventosusach.models.Evento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bastian on 22-05-16.
 */
public class EventoGet extends AsyncTask<String, Void, String> {

    private ArrayList<Evento> eventos;
    private MainActivity mainActivity;

    public EventoGet(MainActivity mainActivity, ArrayList<Evento> eventos){
        this.mainActivity = mainActivity;
        this.eventos = eventos;
    }

    @Override
    protected String doInBackground(String... url) {
        try {
            URL u = new URL(url[0]);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            return new Scanner(connection.getInputStream(), "UTF-8").useDelimiter("\\A").next();
        } catch (MalformedURLException e) {
            Log.e("ERROR", this.getClass().toString() + " " + e.toString());
        } catch (ProtocolException e) {
            Log.e("ERROR", this.getClass().toString() + " " + e.toString());
        } catch (IOException e) {
            Log.e("ERROR", this.getClass().toString() + " " + e.toString());
        }
        return null;
    }


    public void getServiciosOfrecidos(String json) {
        try {
            JSONArray ja = new JSONArray(json);;
            eventos = new ArrayList<Evento>();
            int largo = ja.length()-1;
            for (int i = 0; i < ja.length(); i++) {
                JSONObject row = ja.getJSONObject(largo);
                Evento evento = new Evento();
                evento.setTitulo(row.getString("titulo"));
                eventos.add(evento);
                largo--;
            }
        } catch (JSONException e) {
            Log.e("ERROR", this.getClass().toString() + " " + e.toString());
        }
    }

    @Override
    protected void onPostExecute(String result) {
         mainActivity.adapterLista(mainActivity,eventos);
    }
}
