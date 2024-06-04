package Modelos.Excepciones;

/** Esta excepción es resultante de un ingreso incorrecto o inexistente de una moneda */
public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String errorMessage) {
        super(errorMessage);
    }
}
