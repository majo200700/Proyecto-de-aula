/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo.modelo;

/**
 *
 * @author user
 */

import java.util.List;

public class Especialista {
    private String nombre;
    private String especialidad;

    // Constructor
    public Especialista(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Método para ver el último IMC de un cliente
    public void verUltimoIMC(Cliente cliente) {
        ResultadoIMC ultimoIMC = cliente.getUltimoIMC();
        if (ultimoIMC != null) {
            System.out.println("Último IMC de " + cliente.getNombreUsuario() + ": " + ultimoIMC.getImc());
            System.out.println("Categoría: " + ultimoIMC.getCategoria());
        } else {
            System.out.println("No hay IMC registrado para " + cliente.getNombreUsuario());
        }
    }

    // Método para ver todos los nombres de usuario
    public void verNombresUsuarios(List<Cliente> clientes) {
        System.out.println("Nombres de usuario registrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombreUsuario());
        }
    }
}