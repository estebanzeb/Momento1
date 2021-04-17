package com.example.loginsabado;


import java.io.Serializable;

public class Trabajador implements Serializable {

    String nombres, descripciones;
    int fotos;


    public Trabajador(String nombre, String descripcion, int foto) {
        this.nombres = nombre;
        this.descripciones = descripcion;
        this.fotos = foto;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public String getDescripcion() {
        return descripciones;
    }

    public void setDescripcion(String descripcion) {
        this.descripciones = descripcion;
    }

    public int getFoto() {
        return fotos;
    }

    public void setFoto(int foto) {
        this.fotos = foto;
    }
}
