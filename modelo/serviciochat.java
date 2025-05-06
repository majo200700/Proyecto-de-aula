/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo.modelo;

/**
 *
 * @author jorjo
 */


import java.util.*;

public class serviciochat {
    private Map<String, List<String>> mensajesPorUsuario;

    public serviciochat() {
        mensajesPorUsuario = new HashMap<>();
    }

    public void enviarMensaje(String nombreUsuario, String mensaje) {
        mensajesPorUsuario.putIfAbsent(nombreUsuario, new ArrayList<>());
        mensajesPorUsuario.get(nombreUsuario).add("Cliente: " + mensaje);
    }

    public void responderMensaje(String nombreUsuario, String respuesta) {
        mensajesPorUsuario.putIfAbsent(nombreUsuario, new ArrayList<>());
        mensajesPorUsuario.get(nombreUsuario).add("Especialista: " + respuesta);
    }

    public List<String> obtenerMensajes(String nombreUsuario) {
        return mensajesPorUsuario.getOrDefault(nombreUsuario, new ArrayList<>());
    }

    public Set<String> getUsuariosConMensajes() {
        return mensajesPorUsuario.keySet();
    }
}
