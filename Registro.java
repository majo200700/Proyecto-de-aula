/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo;


/**
 *
 * @author user
 */
import codigo_completo.modelo.Cliente;
import codigo_completo.modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registro {
    private List<Usuario> usuarios;
    private Map<Usuario, Cliente> clientes;

    public Registro() {
        usuarios = new ArrayList<>();
        clientes = new HashMap<>();
    }

    // Método para registrar un usuario
    public void registrarUsuario(String nombreUsuario, String contraseña, boolean esCliente) {
        Usuario usuario;
        if (esCliente) {
            usuario = new Cliente(nombreUsuario, contraseña); // Crear un cliente
            clientes.put(usuario, (Cliente) usuario); // Almacenar la relación entre Usuario y Cliente
        } else {
            usuario = new Usuario(nombreUsuario, contraseña); // Crear un usuario regular
        }
        usuarios.add(usuario); // Agregar el usuario a la lista de usuarios
    }

    // Método para iniciar sesión
    public Usuario iniciarSesion(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.validarContraseña(contraseña)) {
                return usuario;
            }
        }
        return null; // Retornar null si no se encuentra el usuario
    }

    // Método para obtener el cliente asociado a un usuario
    public Cliente getClientePorUsuario(Usuario usuario) {
        return clientes.get(usuario); // Retornar el cliente asociado al usuario
    }

    // Método para obtener la lista de usuarios
    public List<Usuario> getUsuarios() {
        return usuarios; // Retorna la lista de usuarios
    }
}