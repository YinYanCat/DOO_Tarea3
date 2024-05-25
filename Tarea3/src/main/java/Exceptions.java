/** Esta excepción es resultante de la carencia o inexistencia de un producto */
class NoHayProductoException extends Exception {
    public NoHayProductoException(String errorMessage) {
        super(errorMessage);
    }
}

/** Esta excepción es resultante de un precio del producto mayor al valor de la moneda entregada */
class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(String errorMessage) {
        super(errorMessage);
    }
}

/** Esta excepción es resultante de un ingreso incorrecto o inexistente de una moneda */
class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String errorMessage) {
        super(errorMessage);
    }
}