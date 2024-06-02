package Modelos;

/** Esta excepción es resultante de producto sin retirar del expendedor */
public class ProductoNoRetiradoException extends Exception {
    public ProductoNoRetiradoException(String errorMessage) {
        super(errorMessage);
    }
}

