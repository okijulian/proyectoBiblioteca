package com.miapp.biblioteca.service;
import com.miapp.biblioteca.Usuario;
import java.util.ArrayList;
public class UsuarioService {
    private  ArrayList<Usuario> usuarios;

    public UsuarioService(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    ///crear nuevo usuario
    public void crearUsuario(String nombre, String apellido, long DNI, String genero) {
        // Verificar si ya existe un usuario con el mismo DNI
        if (buscarUsuarioPorDNI(DNI) != null) {
            System.out.println("Ya existe un usuario con el mismo DNI. Debe verificar datos y volver a cargar el nuevo usuario");
            return;
        }
        // Si no hay ningún usuario con el mismo DNI, crear uno nuevo
        Usuario nuevoUsuario = new Usuario(nombre, apellido, DNI, genero);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario creado exitosamente.");
    }

    ///ver todos los usuarios
    public ArrayList<Usuario> leerTodosUsuarios() {
        return usuarios;
    }

    ///actualizar usuarios

    public  void actualizarUsuarios(String nuevoNombre, String nuevoApellido, long DNI, String nuevoGenero){

        for (Usuario usuario: usuarios){
            if(usuario.getDNI() ==DNI){
                usuario.setNombre(nuevoNombre);
                usuario.setApellido(nuevoApellido);
                usuario.setGenero(nuevoGenero);
            }
        }

    }

    public void eliminarUsuario(long DNI) {
        usuarios.removeIf(usuario -> usuario.getDNI() == DNI);
    }

    public Usuario buscarUsuarioPorDNI(long DNI) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDNI() == DNI) {
                return usuario;
            }
        }
        return null;
    }
}
