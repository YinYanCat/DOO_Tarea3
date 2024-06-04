package Modelos.Excepciones;

/** Esta excepción es resultante de la carencia o inexistencia de un producto */
public class NoHayProductoException extends Exception {
    public NoHayProductoException(String errorMessage) {
        super(errorMessage);
    }
}
