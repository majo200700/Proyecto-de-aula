/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo_completo;

/**
 *
 * @author jorjo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class VentanaChatCliente extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private String nombreUsuario;
    private PrintWriter out;

    public VentanaChatCliente(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

        setTitle("Chat - " + nombreUsuario);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Enviar");

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> enviarMensaje());
        inputField.addActionListener(e -> enviarMensaje());

        conectarAlServidor();

        setVisible(true);
    }

    private void conectarAlServidor() {
        try {
            Socket socket = new Socket("localhost", 12345);  // Puedes cambiar localhost por la IP real del servidor si es en red
            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Hilo para recibir mensajes en tiempo real
            new Thread(() -> {
                try {
                    String mensaje;
                    while ((mensaje = in.readLine()) != null) {
                        chatArea.append(mensaje + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarMensaje() {
        String mensaje = inputField.getText().trim();
        if (!mensaje.isEmpty()) {
            out.println(nombreUsuario + ": " + mensaje);
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        String nombreUsuario = JOptionPane.showInputDialog("Ingresa tu nombre de usuario:");
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            SwingUtilities.invokeLater(() -> new VentanaChatCliente(nombreUsuario));
        } else {
            System.exit(0);
        }
    }
}