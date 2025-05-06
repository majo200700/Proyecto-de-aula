package codigo_completo.modelo;

public class Cliente extends Usuario {
    private ResultadoIMC ultimoIMCregistrado;

    public Cliente(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
    }

    public ResultadoIMC getUltimoIMC() {
        return ultimoIMCregistrado;
    }

    public void actualizarUltimoIMC(ResultadoIMC resultadoIMC) {
        this.ultimoIMCregistrado = resultadoIMC;
    }
}