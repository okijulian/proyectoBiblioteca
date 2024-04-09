package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.service.PrestamoLibroService;
import com.miapp.biblioteca.service.UsuarioService;

import java.util.Scanner;

public class PrestamosUI {
    private PrestamoLibroService prestamoLibroService;
    private LibroService libroService;
    private UsuarioService usuarioService;
    private Scanner scanner;

    public PrestamosUI(PrestamoLibroService prestamoLibroService, LibroService libroService, UsuarioService usuarioService) {
        this.prestamoLibroService = prestamoLibroService;
        this.libroService = libroService;
        this.usuarioService = usuarioService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrestamos() {
        int opcion;
        do {
            System.out.println();
            System.out.println("=== MENÚ DE PRÉSTAMOS DE LIBROS ===");
            System.out.println();
            System.out.println("1. Verificar Disponiblidad Libro");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verificarDisponibilidadPorTitulo();
                    break;
                case 2:
                    prestarLibro();
                    break;
                case 3:
                    devolverLibro();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }

    private void prestarLibro() {
        System.out.println("------------------------------");
        System.out.println("=== PRESTAR LIBRO ===");
        System.out.println("------------------------------");
        System.out.print("Ingrese el ISBN del libro que desea prestar: ");
        String ISBN = scanner.nextLine();
        Libro libro = libroService.buscarLibroPorISBN(ISBN);
        if (libro != null) {
            System.out.print("Ingrese el DNI del usuario que desea prestar el libro: ");
            long DNI = scanner.nextLong();
            scanner.nextLine();
            Usuario usuario = usuarioService.buscarUsuarioPorDNI(DNI);
            if (usuario != null) {
                prestamoLibroService.prestarLibro(usuario, libro);
            } else {
                System.out.println("No se encontró ningún usuario con el DNI proporcionado.");
            }
        } else {
            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
        }
    }

    private void devolverLibro() {
        System.out.println("------------------------------");
        System.out.println("=== DEVOLVER LIBRO ===");
        System.out.println("------------------------------");
        System.out.print("Ingrese el ISBN del libro que desea devolver: ");
        String ISBN = scanner.nextLine();
        Libro libro = libroService.buscarLibroPorISBN(ISBN);
        if (libro != null) {
            System.out.print("Ingrese el DNI del usuario que desea devolver el libro: ");
            long DNI = scanner.nextLong();
            scanner.nextLine();
            Usuario usuario = usuarioService.buscarUsuarioPorDNI(DNI);
            if (usuario != null) {
                prestamoLibroService.devolverLibro(usuario, libro);
            } else {
                System.out.println("No se encontró ningún usuario con el DNI proporcionado.");
            }
        } else {
            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
        }
    }

    private void verificarDisponibilidadPorTitulo() {
        System.out.println("--------------------------------------------");
        System.out.println("=== VERIFICAR DISPONIBILIDAD POR TÍTULO ===");
        System.out.println("--------------------------------------------");
        System.out.print("Ingrese el título del libro que desea verificar: ");
        String tituloLibro = scanner.nextLine();

        // Verificar la disponibilidad del libro por su título
        Libro libro = libroService.buscarLibroPorTitulo(tituloLibro);
        if (libro != null) {
            if (libro.isDisponible()) {
                System.out.println("El libro '" + tituloLibro + "' está disponible. ISBN: " + libro.getISBN());
            } else {
                System.out.println("El libro '" + tituloLibro + "' no está disponible en este momento.");
            }
        } else {
            System.out.println("No se encontró ningún libro con el título especificado.");
        }
    }


}
