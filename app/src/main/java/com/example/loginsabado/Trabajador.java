package com.example.loginsabado;


import java.io.Serializable;

public class Trabajador implements Serializable {

    String nombre, foto,foto2,fondo;

    public Trabajador(String nombre, String foto, String foto2, String fondo) {
        this.nombre = nombre;
        this.foto = foto;
        this.foto2 = foto2;
        this.fondo = fondo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

}