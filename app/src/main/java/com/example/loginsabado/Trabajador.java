package com.example.loginsabado;


import java.io.Serializable;

public class Trabajador implements Serializable {

    String nombre, descripcion;
    int foto,foto2,fondo;

    public Trabajador(String nombre, String descripcion, int foto, int foto2, int fondo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFotos(int foto) {
        this.foto = foto;
    }

    public int getFoto2() {
        return foto2;
    }

    public void setFoto2(int foto2) {
        this.foto2 = foto2;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }
}
