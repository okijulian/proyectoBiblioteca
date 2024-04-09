package com.miapp.biblioteca;

import com.miapp.biblioteca.service.LibroService;
import com.miapp.biblioteca.ui.LibroUI;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de servicios y UI
        LibroService libroService = new LibroService(new ArrayList<>());
        LibroUI librosUI = new LibroUI(libroService);

        // Inicializar scanner para entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostrar menú principal
        int opcion;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar libros");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    librosUI.mostrarMenuLibros();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);

        // Cerrar el scanner
        scanner.close();
    }
}
