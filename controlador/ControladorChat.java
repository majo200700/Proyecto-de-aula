/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo.controlador;

import codigo_completo.modelo.serviciochat;
import codigo_completo.vista.vistachat;

public class ControladorChat {
    private serviciochat chatService;
    private vistachat vistaChat;

    public ControladorChat(serviciochat chatservice, vistachat vistaChat) {
        this.chatService = chatService;
        this.vistaChat = vistaChat;
    }

    public void chatCliente(String nombreUsuario) {
        vistaChat.mostrarChatCliente(nombreUsuario, chatService);
    }

    public void chatEspecialista() {
        vistaChat.mostrarChatEspecialista(chatService);
    }
}
