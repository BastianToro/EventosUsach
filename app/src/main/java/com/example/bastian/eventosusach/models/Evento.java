package com.example.bastian.eventosusach.models;

import java.io.Serializable;

/**
 * Created by bastian on 22-05-16.
 */
public class Evento implements Serializable{
    private int id;
    private String titulo;
    private Lugar lugar;
    private Tipo tipo;
    private String fecha;
    private String hora_inicio;
    private String hora_final;
    private String descripcion;

    public Evento(){
    }

    public Evento(String titulo,Tipo tipo,Lugar lugar,String fecha
            ,String hora_inicio,String hora_final,String descripcion){
        this.setTitulo(titulo);
        this.setFecha(fecha);
        this.setHora_inicio(hora_inicio);
        this.setHora_final(hora_final);
        this.setDescripcion(descripcion);
        this.setTipo(tipo);
        this.setLugar(lugar);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
