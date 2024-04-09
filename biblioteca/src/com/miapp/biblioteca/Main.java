package com.miapp.biblioteca;

import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.ui.LibroUI;

import com.miapp.biblioteca.service.UsuarioService;
import com.miapp.biblioteca.ui.UsuarioUI;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de servicios y UI
        LibroService libroService = new LibroService(new ArrayList<>());
        LibroUI librosUI = new LibroUI(libroService);

        UsuarioService usuarioService= new UsuarioService(new ArrayList<>());
        UsuarioUI usuarioUI = new UsuarioUI(usuarioService);

        // Inicializar scanner para entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostrar menú principal
        int opcion;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar Libros");
            System.out.println("1. Gestionar Usuarios");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    librosUI.mostrarMenuLibros();
                    break;
                case 2:
                    usuarioUI.mostrarMenuUsuarios();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}
