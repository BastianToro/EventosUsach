package com.example.bastian.eventosusach.models;

import java.io.Serializable;

/**
 * Created by matias on 23-12-15.
 */
public class Usuario implements Serializable{

    private int idUsuario;
    private int idEstado;
    private String nombre;
    private String apellido;
    private String password;
    private String email;

    public Usuario(){

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
