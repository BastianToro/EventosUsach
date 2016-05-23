package com.example.bastian.eventosusach.utilities;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase que se utiliza para manipular objetos JSON
 */
public class JsonHandler {

    /*
    Metodo par obtener todos los eventos-
     */
    public String[] getEventos(String cadena) {
        try {
            JSONArray ja = new JSONArray(cadena);
            String[] result = new String[ja.length()];
            String evento;
            for (int i = 0; i < ja.length(); i++) {
                JSONObject row = ja.getJSONObject(i);
                evento = " " + row.getString("nombre") + " " + row.getString("apellido");
                result[i] = evento;
            }
            return result;
        } catch (JSONException e) {
            Log.e("ERROR", this.getClass().toString() + " " + e.toString());
        }
        return null;
    }// getEventos(String cadena)



    public String [] getMailPass(String usuario) {
        try{
            JSONArray ja = new JSONArray(usuario);
            String[] result = new String[ja.length()];
            String user;
            for(int i=0; i<ja.length();i++){
                JSONObject row = ja.getJSONObject(i);
                user =" " + row.getString("correoUsuario")+" "+row.getString("contrasenhaUsuario");
                result[i]=user;
            }
            return result;

        }catch(JSONException e){
            Log.e("Error",this.getClass().toString());
        }
        return null;

    }// getMailPass(String actors)


}// JsonHandler