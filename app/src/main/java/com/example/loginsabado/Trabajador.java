package com.example.loginsabado;


import java.io.Serializable;

public class Trabajador implements Serializable {

    String fondo, foto,foto2, nombre;

    public Trabajador(String fondo, String foto, String foto2, String nombre) {
        this.fondo = fondo;
        this.foto = foto;
        this.foto2 = foto2;
        this.nombre = nombre;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}