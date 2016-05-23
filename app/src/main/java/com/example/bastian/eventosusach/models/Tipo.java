package com.example.bastian.eventosusach.models;

/**
 * Created by bastian on 22-05-16.
 */
public class Tipo {
    private int id;
    private String tipo_evento;
    private String descripcion;

    public Tipo(int id, String tipo_evento, String descripcion){
        setId(id);
        setTipo_evento(tipo_evento);
        setDescripcion(descripcion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
