package com.miapp.biblioteca.service;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.PrestamoLibros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoLibroService {
    private List<PrestamoLibros> prestamos;

    public PrestamoLibroService() {
        this.prestamos = new ArrayList<>();
    }

    public PrestamoLibroService(List<PrestamoLibros> prestamos) {
        this.prestamos = prestamos;
    }

    public PrestamoLibroService(LibroService libroService, UsuarioService usuarioService) {
        this();
    }

    public void prestarLibro(Usuario usuario, Libro libro) {
        if (libro.isDisponible()) {
            libro.setDisponible(false);
            PrestamoLibros prestamo = new PrestamoLibros(libro, usuario, LocalDate.now());
            prestamos.add(prestamo);
            System.out.println("El libro '" + libro.getTitulo() + "' ha sido prestado a " + usuario.getNombre() + " " + usuario.getApellido());
        } else {
            System.out.println("El libro '" + libro.getTitulo() + "' no está disponible en este momento.");
        }
    }

    public void devolverLibro(Usuario usuario, Libro libro) {
        for (PrestamoLibros prestamo : prestamos) {
            if (prestamo.getLibro().equals(libro) && prestamo.getUsuario().equals(usuario)) {
                libro.setDisponible(true);
                prestamos.remove(prestamo);
                System.out.println("El libro '" + libro.getTitulo() + "' ha sido devuelto correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un préstamo válido para el usuario o el libro especificado.");
    }
}
