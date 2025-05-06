/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo.controlador;


import codigo_completo.modelo.serviciochat;
import codigo_completo.vista.vistachat;
import codigo_completo.Registro;
import codigo_completo.vista.ConsolaVista;


public class ControladorPrincipal {
    private Registro registro;
    private ConsolaVista vista;
    private serviciochat chatService;
    private ControladorChat controladorChat;

    public ControladorPrincipal(Registro registro, ConsolaVista vista) {
        this.registro = registro;
        this.vista = vista;
        this.chatService = new serviciochat();
        this.controladorChat = new ControladorChat(chatService, new vistachat());
    }

    public void iniciar() {
        vista.mostrarMenuInicio(registro, controladorChat);
    }
}

