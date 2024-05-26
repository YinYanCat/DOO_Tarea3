/** Esta excepción es resultante de un ingreso incorrecto o inexistente de una moneda */
class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String errorMessage) {
        super(errorMessage);
    }
}