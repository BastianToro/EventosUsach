package com.example.bastian.eventosusach.models;

/**
 * Created by bastian on 22-05-16.
 */
public class Lugar {
    private int id;
    private String nombre;
    private double latitud;
    private double longitud;

    public Lugar(int id,String nombre, double latitud, double longitud){
        setId(id);
        setNombre(nombre);
        setLatitud(latitud);
        setLongitud(longitud);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
