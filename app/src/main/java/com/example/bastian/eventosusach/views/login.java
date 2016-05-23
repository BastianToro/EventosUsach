package com.example.bastian.eventosusach.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bastian.eventosusach.R;
import com.example.bastian.eventosusach.controllers.Login;
import com.example.bastian.eventosusach.models.Usuario;

public class login extends AppCompatActivity {

    EditText correo;
    EditText pass;
    Usuario usuari;
    private ProgressDialog dialogAutentificando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public Usuario getLogin(){
        Usuario user = new Usuario();
        correo = (EditText) findViewById(R.id.editTextCorreo);
        pass = (EditText) findViewById(R.id.editTextPass);
        user.setEmail(correo.toString());
        user.setPassword(pass.toString());
        return user;
    }

    public void onclick(View v){
        ///get
        usuari = getLogin();
        //Login logi = new Login(this,usuari.getEmail(),usuari.getPassword());
        new Login(this,usuari.getEmail(),usuari.getPassword()).execute("http://10.0.2.2:8080/EventoUsachJava/usuarios");

    }

    public void onLoginSuccess(Usuario usuario){
        Toast.makeText(login.this, usuario.getEmail() + ", " + usuario.getPassword(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,perfilUsuario.class);
        startActivity(intent);
    }

    public void abrirProgressDialog(){
        dialogAutentificando.setIndeterminate(true);
        dialogAutentificando.setMessage("Autentificando...");
        dialogAutentificando.show();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Usuario y contraseña no coinciden", Toast.LENGTH_LONG).show();
        cerrarProgressDialog();
    }


    private void cerrarProgressDialog(){
        dialogAutentificando.dismiss();

    }

    public void error_internet(){
        Toast.makeText(login.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
        cerrarProgressDialog();
    }
}
