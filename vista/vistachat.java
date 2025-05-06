/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo.vista;

/**
 *
 * @author jorjo
 */
import codigo_completo.modelo.serviciochat;

import java.util.List;
import java.util.Scanner;

public class vistachat {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarChatCliente(String nombreUsuario, serviciochat chatService) {
        System.out.println("=== Chat con el especialista ===");
        System.out.println("Escribe tu mensaje (escribe 'salir' para volver):");

        while (true) {
            String mensaje = scanner.nextLine();
            if (mensaje.equalsIgnoreCase("salir")) break;
            chatService.enviarMensaje(nombreUsuario, mensaje);
            System.out.println("Mensaje enviado.");
        }
    }

    public void mostrarChatEspecialista(serviciochat chatService) {
        System.out.println("=== Chat con clientes ===");
        for (String usuario : chatService.getUsuariosConMensajes()) {
            System.out.println("- " + usuario);
        }

        System.out.print("¿Con qué usuario deseas hablar?: ");
        String usuarioElegido = scanner.nextLine();

        List<String> mensajes = chatService.obtenerMensajes(usuarioElegido);
        System.out.println("Mensajes con " + usuarioElegido + ":");
        for (String mensaje : mensajes) {
            System.out.println(mensaje);
        }

        System.out.println("Escribe tu respuesta (o 'salir' para volver):");
        while (true) {
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("salir")) break;
            chatService.responderMensaje(usuarioElegido, respuesta);
            System.out.println("Respuesta enviada.");
        }
    }
}
