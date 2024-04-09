package com.miapp.biblioteca.ui;

import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.UsuarioService;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioUI {
    private UsuarioService usuarioService;
    private Scanner scanner;

    public UsuarioUI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuUsuarios() {
        int opcion;
        do {
            System.out.println();
            System.out.println();
            System.out.println("=== MENÚ DE GESTIÓN DE USUARIOS ===");
            System.out.println("1. Crear nuevo usuario");
            System.out.println("2. Mostrar todos los usuarios");
            System.out.println("3. Buscar Usuario por DNI");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearUsuario();
                    break;
                case 2:
                    mostrarTodosLosUsuarios();

                    break;
                case 3:
                    mostrarUsuarioPorDNI();
                    break;
                case 4:
                    actualizarUsuario();
                    break;
                case 5:
                    eliminarUsuario();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }

    private void crearUsuario() {

        System.out.print("Ingrese nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del usuario: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese DNI del usuario: ");
        long dni = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Ingrese género del usuario: ");
        String genero = scanner.nextLine();

        usuarioService.crearUsuario(nombre, apellido, dni, genero);
        System.out.println("Usuario creado con éxito.");
    }

    private void mostrarTodosLosUsuarios() {
        System.out.println("------------------------------");
        System.out.println("=== TODOS LOS USUARIOS ===");
        System.out.println("------------------------------");
        ArrayList<Usuario> todosLosUsuarios = usuarioService.leerTodosUsuarios();
        for (Usuario usuario : todosLosUsuarios) {
            System.out.println(usuario);
        }
    }

    private void mostrarUsuarioPorDNI() {
        System.out.println("------------------------------");
        System.out.println("=== BUSCAR USUARIO POR DNI ===");
        System.out.println("------------------------------");
        System.out.print("Ingrese el DNI del usuario a buscar: ");
        long dni = scanner.nextLong();
        scanner.nextLine();

        Usuario usuarioEncontrado = usuarioService.buscarUsuarioPorDNI(dni);
        if (usuarioEncontrado != null) {
            System.out.println("Usuario encontrado:");
            System.out.println(usuarioEncontrado);
        } else {
            System.out.println("No se encontró ningún usuario con el DNI proporcionado.");
        }
    }

    private void actualizarUsuario() {
        System.out.println("------------------------------");
        System.out.println("=== ACTUALIZAR USUARIO ===");
        System.out.println("------------------------------");
        System.out.print("Ingrese el DNI del usuario a actualizar: ");
        long dni = scanner.nextLong();
        scanner.nextLine();

        Usuario usuarioExistente = usuarioService.buscarUsuarioPorDNI(dni);
        if (usuarioExistente != null) {
            System.out.println("Ingrese los nuevos detalles del usuario:");
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nuevo apellido: ");
            String nuevoApellido = scanner.nextLine();
            System.out.print("Nuevo género: ");
            String nuevoGenero = scanner.nextLine();

            usuarioService.actualizarUsuarios(nuevoNombre, nuevoApellido, dni, nuevoGenero);
            System.out.println("Usuario actualizado con éxito.");
        } else {
            System.out.println("No se encontró ningún usuario con el DNI proporcionado.");
        }
    }

    private void eliminarUsuario() {
        System.out.println("------------------------------");
        System.out.println("=== ELIMINAR USUARIO ===");
        System.out.println("------------------------------");
        System.out.print("Ingrese el DNI del usuario a eliminar: ");
        long dni = scanner.nextLong();
        scanner.nextLine();

        Usuario usuarioExistente = usuarioService.buscarUsuarioPorDNI(dni);
        if (usuarioExistente != null) {
            usuarioService.eliminarUsuario(dni);
            System.out.println("Usuario eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún usuario con el DNI proporcionado.");
        }
    }




}
