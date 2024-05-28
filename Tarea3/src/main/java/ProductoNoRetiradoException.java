/** Esta excepción es resultante de un precio del producto mayor al valor de la moneda entregada */
public class ProductoNoRetiradoException extends Exception {
    public ProductoNoRetiradoException(String errorMessage) {
        super(errorMessage);
    }
}

