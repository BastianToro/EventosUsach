package com.example.bastian.eventosusach.controllers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import com.example.bastian.eventosusach.MainActivity;
import com.example.bastian.eventosusach.models.Usuario;
import com.example.bastian.eventosusach.views.login;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class Login extends AsyncTask<String, Void, String> {

    private Context context;
    private String input_usuario;
    private String input_password;
    private Usuario user;
    private boolean resultadoValidaciones;
    private login mainActivity;

    public Login(login mainActivity, String usuario, String password) {
        this.context = context;
        this.input_usuario = usuario;
        this.input_password = password;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onPreExecute(){
        mainActivity.abrirProgressDialog();
    }

    @Override
    protected String doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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
    }// doInBackground(String... urls)

    @Override
    protected void onPostExecute(String result) {
        if(result!=null) {
            try {
                resultadoValidaciones = validarCredenciales(result, input_usuario, input_password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (resultadoValidaciones == true) {
                mainActivity.onLoginSuccess(user);
            } else {//no hay coincidencias para el usuario y contraseña ingresados
                mainActivity.onLoginFailed();
            }
        }
        else{
            mainActivity.error_internet();
        }
    }

    public boolean validarCredenciales(String json, String usuario, String password) throws JSONException {
        JSONArray ja = new JSONArray(json);
        int i;
        String usuario_aux,password_aux;
        for (i = 0; i < ja.length(); i++) {
            JSONObject row = ja.getJSONObject(i);
            usuario_aux = row.getString("correoUsuario");
            password_aux = row.getString("contrasenhaUsuario");
            if(matchUsuarioPassword(usuario,usuario_aux,password,password_aux)==true){
                user = new Usuario();
                user.setEmail(row.getString("correoUsuario"));
                user.setPassword(row.getString("contrasenhaUsuario"));

                return true;
            }
        }
        return false;
    }

    public boolean matchUsuarioPassword(String usuario1, String usuario2,String password1, String password2){
        if(usuario1.equals(usuario2)&&password1.equals(password2)) {
            return true;
        }
        return false;
    }
}