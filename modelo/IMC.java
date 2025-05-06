/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo.modelo;


/**
 *
 * @author user
 */
public class IMC {
    private double peso;
    private double altura;

    public IMC(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }
    
// Método para calcular el IMC
    public double calcularIMC() {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que cero.");
        }
        return peso / (altura * altura);
    }

    public ResultadoIMC obtenerResultadoIMC() {
        double imc = peso / (altura * altura);
        String categoria;

        if (imc < 18.5) {
            categoria = "Bajo peso";
        } else if (imc < 24.9) {
            categoria = "Peso normal";
        } else if (imc < 29.9) {
            categoria = "Sobrepeso";
        } else {
            categoria = "Obesidad";
        }

        return new ResultadoIMC(imc, categoria); // Devuelve un nuevo objeto ResultadoIMC
    }
}
