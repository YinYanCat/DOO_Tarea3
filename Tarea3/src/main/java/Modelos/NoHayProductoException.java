package Modelos;

/**
 * Esta excepción es resultante de la carencia o inexistencia de un producto
 */
class NoHayProductoException extends Exception {
    public NoHayProductoException(String errorMessage) {
        super(errorMessage);
    }
}
