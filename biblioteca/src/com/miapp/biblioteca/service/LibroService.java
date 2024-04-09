package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;

import java.util.ArrayList;

public class LibroService {
    // Atributo para almacenar la lista de libros
    private ArrayList<Libro> biblioteca;

    // Constructor que inicializa la lista de libros
    public LibroService(ArrayList<Libro> biblioteca) {
        this.biblioteca = biblioteca;
    }

    //funciones o metodos el CRUD

    public void crearLibro(String titulo, String autor, String ISBN, String genero) {

        Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);

        biblioteca.add(nuevoLibro);

    }

    public ArrayList<Libro> obtenerTodosLosLibros() {
        return biblioteca;

    }

    public void actualizarLibro(String nuevoTitulo, String nuevoAutor, String ISBN, String nuevoGenero) {

        for (Libro libro : biblioteca) {
            if (libro.getISBN().equals(ISBN)) {
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setGenero(nuevoGenero);
            }
        }
    }

    public  void eliminarLibro(String ISBN){

        biblioteca.removeIf(libro -> libro.getISBN().equals(ISBN));

    }

    public  Libro buscarLibroPorISBN(String ISBN){

       for(Libro libro:biblioteca){
           if(libro.getISBN().equalsIgnoreCase(ISBN)){
               return  libro;
           }

       }
       return  null;
    }


    public Libro buscarLibroPorTitulo(String tituloLibro) {
        for (Libro libro : biblioteca) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                return libro;
            }
        }
        return null;
    }
}



