package com.miapp.biblioteca;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {

    //atributos
    private String nombre;
    private String apellido;
    private  long DNI;
    private String genero;

    private ArrayList<Libro> libroPrestado;

    //CONSTRUCTOR
    public Usuario() {
    }
    public Usuario(String nombre, String apellido, long DNI, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.genero = genero;
        this.libroPrestado=new ArrayList<>();
    }


//METODOS

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI=" + DNI +
                ", genero='" + genero + '\'' +
                '}';
    }


    //GET  Y SET


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

    public long getDNI() {
        return DNI;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<Libro> getLibroPrestado() {
        return libroPrestado;
    }


}