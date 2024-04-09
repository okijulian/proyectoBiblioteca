package com.miapp.biblioteca.ui;

import java.util.Scanner;

public class BibliotecaIU {
    private LibroUI librosUI;
    private UsuarioUI usuarioUI;
    private PrestamosUI prestamosUI;
    private Scanner scanner;

    public BibliotecaIU(LibroUI librosUI, UsuarioUI usuarioUI, PrestamosUI prestamosUI) {
        this.librosUI = librosUI;
        this.usuarioUI = usuarioUI;
        this.prestamosUI = prestamosUI;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println();
            System.out.println();
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Administrar Libros");
            System.out.println("2. Administrar usuarios");
            System.out.println("3. Prestamos/Devolución Libros");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    librosUI.mostrarMenuLibros();
                    break;
                case 2:
                    usuarioUI.mostrarMenuUsuarios();
                    break;
                case 3:
                    prestamosUI.mostrarMenuPrestamos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }
}
