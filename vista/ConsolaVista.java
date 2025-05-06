/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo.vista;

import codigo_completo.modelo.Usuario;
import codigo_completo.modelo.Cliente;
import codigo_completo.modelo.IMC;
import codigo_completo.modelo.ResultadoIMC;
import codigo_completo.Registro;
import codigo_completo.controlador.ControladorChat;


import java.util.Scanner;
import java.text.DecimalFormat;

public class ConsolaVista {
    private Scanner scanner = new Scanner(System.in);
    private DecimalFormat df = new DecimalFormat("#.###");

    public void mostrarMenuInicio(Registro registro, ControladorChat controladorChat) {
        while (true) {
            System.out.println("Menú de Inicio:");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario(registro);
                    break;
                case 2:
                    iniciarSesion(registro, controladorChat);
                    break;
                
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void registrarUsuario(Registro registro) {
        System.out.print("Nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Contraseña: ");
        String pass = scanner.nextLine();
        registro.registrarUsuario(nombre, pass, true);
        System.out.println("Usuario registrado.");
    }

    private void iniciarSesion(Registro registro, ControladorChat controladorChat){
        System.out.print("Usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Contraseña: ");
        String pass = scanner.nextLine();

        Usuario usuario = registro.iniciarSesion(nombre, pass);
        if (usuario != null) {
            if (nombre.equals("especialista") && pass.equals("especialista")) {
                    mostrarMenuEspecialista(registro, controladorChat);
            } else {
                     mostrarMenuCliente((Cliente) usuario, controladorChat);
            }
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private void mostrarMenuCliente(Cliente cliente, ControladorChat controladorChat){
        while (true) {
            System.out.println("Menú Cliente:");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Ver último IMC");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Altura (cm): ");
                    double alturaCm = scanner.nextDouble();
                    scanner.nextLine();

                    cliente.setPeso(peso);
                    cliente.setAltura(alturaCm / 100.0);

                    IMC imc = new IMC(peso, alturaCm / 100.0);
                    ResultadoIMC resultado = imc.obtenerResultadoIMC();
                    cliente.actualizarUltimoIMC(resultado);

                    System.out.println("IMC: " + df.format(resultado.getImc()));
                    System.out.println("Categoría: " + resultado.getCategoria());
                    break;
                case 2:
                    ResultadoIMC ultimo = cliente.getUltimoIMC();
                    if (ultimo != null) {
                        System.out.println("Último IMC: " + df.format(ultimo.getImc()));
                        System.out.println("Categoría: " + ultimo.getCategoria());
                    } else {
                        System.out.println("Aún no se ha calculado el IMC.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void mostrarMenuEspecialista(Registro registro, ControladorChat controladorChat) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("Menú del Especialista:");
        System.out.println("1. Ver datos de usuarios");
        System.out.println("2. Hablar con un cliente");
        System.out.println("3. Cerrar sesión");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                // Ver datos de usuarios registrados
                for (Usuario usuario : registro.getUsuarios()) {
                    if (usuario instanceof Cliente) {
                        Cliente cliente = (Cliente) usuario;
                        System.out.println("Nombre de usuario: " + cliente.getNombreUsuario());
                        System.out.println("Peso: " + cliente.getPeso() + " kg");
                        System.out.println("Altura: " + cliente.getAltura() + " m");
                        ResultadoIMC ultimoIMC = cliente.getUltimoIMC();
                        if (ultimoIMC != null) {
                            System.out.println("Último IMC: " + ultimoIMC.getImc());
                            System.out.println("Categoría: " + ultimoIMC.getCategoria());
                        } else {
                            System.out.println("No hay IMC registrado.");
                        }
                        System.out.println("---------------------------");
                    }
                }
                break;

            case 2:
                controladorChat.chatEspecialista();
                break;

            case 3:
                System.out.println("Cerrando sesión...");
                return;

            default:
                System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
        }
    }
}
}

