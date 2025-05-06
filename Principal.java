package codigo_completo;

import codigo_completo.controlador.ControladorPrincipal;
import codigo_completo.vista.ConsolaVista;

public class Principal {
    public static void main(String[] args) {
        Registro registro = new Registro();
        ConsolaVista vista = new ConsolaVista();
        ControladorPrincipal controlador = new ControladorPrincipal(registro, vista);
        controlador.iniciar();
    }
}