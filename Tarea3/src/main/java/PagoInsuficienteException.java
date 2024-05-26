/** Esta excepción es resultante de un precio del producto mayor al valor de la moneda entregada */
class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(String errorMessage) {
        super(errorMessage);
    }
}

