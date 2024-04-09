package com.miapp.biblioteca;

import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.UsuarioService;
import com.miapp.biblioteca.service.PrestamoLibroService;
import com.miapp.biblioteca.ui.BibliotecaIU;
import com.miapp.biblioteca.ui.LibroUI;
import com.miapp.biblioteca.ui.UsuarioUI;
import com.miapp.biblioteca.ui.PrestamosUI;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de libros vacía para pasar al servicio de libros
        ArrayList<Libro> listaLibros = new ArrayList<>();

        // Crear una lista de usuarios vacía para pasar al servicio de usuarios
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        // Crear instancias de los servicios
        LibroService libroService = new LibroService(listaLibros);
        UsuarioService usuarioService = new UsuarioService(listaUsuarios);
        PrestamoLibroService prestamoLibroService = new PrestamoLibroService(libroService, usuarioService);

        // Crear instancias de las interfaces de usuario
        LibroUI librosUI = new LibroUI(libroService);
        UsuarioUI usuarioUI = new UsuarioUI(usuarioService);
        PrestamosUI prestamosUI = new PrestamosUI(prestamoLibroService, libroService, usuarioService);


        BibliotecaIU bibliotecaUI = new BibliotecaIU(librosUI, usuarioUI, prestamosUI);

        // Mostrar el menú principal
        bibliotecaUI.mostrarMenuPrincipal();
    }
}
