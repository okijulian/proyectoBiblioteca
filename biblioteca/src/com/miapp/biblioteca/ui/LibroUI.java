package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.service.LibroService;

import java.util.ArrayList;
import java.util.Scanner;

public class LibroUI {
    private LibroService libroService;
    private Scanner scanner;

    public LibroUI(LibroService libroService) {
        this.libroService = libroService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuLibros() {
        int opcion;
        do {
            System.out.println("=== MENÚ DE GESTIÓN DE LIBROS ===");
            System.out.println("1. Agregar libro");
            System.out.println("2. Actualizar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Buscar libro por ISBN");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    actualizarLibro();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 4:
                    mostrarTodosLosLibros();
                    break;
                case 5:
                    buscarLibroPorISBN();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }

    private void agregarLibro() {
        System.out.println("=== AGREGAR NUEVO LIBRO ===");
        System.out.print("Ingrese título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese ISBN del libro: ");
        String ISBN = scanner.nextLine();
        System.out.print("Ingrese género del libro: ");
        String genero = scanner.nextLine();

        libroService.crearLibro(titulo, autor, ISBN, genero);
        System.out.println("Libro agregado con éxito.");
    }

    private void actualizarLibro() {
        System.out.println("=== ACTUALIZAR LIBRO ===");
        System.out.print("Ingrese el ISBN del libro a actualizar: ");
        String ISBN = scanner.nextLine();

        Libro libroExistente = libroService.buscarLibroPorISBN(ISBN);
        if (libroExistente != null) {
            System.out.println("Ingrese los nuevos detalles del libro:");
            System.out.print("Nuevo título: ");
            String nuevoTitulo = scanner.nextLine();
            System.out.print("Nuevo autor: ");
            String nuevoAutor = scanner.nextLine();
            System.out.print("Nuevo género: ");
            String nuevoGenero = scanner.nextLine();

            libroService.actualizarLibro(nuevoTitulo, nuevoAutor, ISBN, nuevoGenero);
            System.out.println("Libro actualizado con éxito.");
        } else {
            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
        }
    }

    private void eliminarLibro() {
        System.out.println("=== ELIMINAR LIBRO ===");
        System.out.print("Ingrese el ISBN del libro a eliminar: ");
        String ISBN = scanner.nextLine();

        Libro libroExistente = libroService.buscarLibroPorISBN(ISBN);
        if (libroExistente != null) {
            libroService.eliminarLibro(ISBN);
            System.out.println("Libro eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
        }
    }

    private void mostrarTodosLosLibros() {
        System.out.println("=== TODOS LOS LIBROS ===");
        ArrayList<Libro> todosLosLibros = libroService.obtenerTodosLosLibros();
        for (Libro libro : todosLosLibros) {
            System.out.println(libro);
        }
    }

    private void buscarLibroPorISBN() {
        System.out.println("=== BUSCAR LIBRO POR ISBN ===");
        System.out.print("Ingrese el ISBN del libro a buscar: ");
        String ISBN = scanner.nextLine();

        Libro libroEncontrado = libroService.buscarLibroPorISBN(ISBN);
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado:");
            System.out.println(libroEncontrado);
        } else {
            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
        }
    }
}
