package com.miapp.biblioteca.service;
import com.miapp.biblioteca.Usuario;
import java.util.ArrayList;
public class UsuarioService {



    private  ArrayList<Usuario> usuarios;


    public UsuarioService(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    ///crear nuevo usuario
    public  void crearUsuario(String nombre, String apellido, long DNI, String genero){
        Usuario nuevoUsuario= new Usuario(nombre, apellido,DNI,genero);

        usuarios.add(nuevoUsuario);
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


}
