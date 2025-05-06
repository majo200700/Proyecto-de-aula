/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo.modelo;


/**
 *
 * @author user
 */
public class Usuario {
    private String nombreUsuario;
    private String contraseña;
    private double peso; // Atributo para almacenar el peso del usuario
    private double altura; // Atributo para almacenar la altura del usuario

    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.peso = 0; // Inicializar peso a 0
        this.altura = 0; // Inicializar altura a 0
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean validarContraseña(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}