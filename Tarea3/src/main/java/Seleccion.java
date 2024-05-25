/** Una lista (Enum) de los productos del expendedor, con sus respectivos precios
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public enum Seleccion {
    CocaCola(800),
    Sprite(800),
    Fanta(800),
    Snickers(600),
    Super8(400),
    Flipy(500);

    /** Número entero que contiene el precio de uno de los productos */
    private final int precio;

    /** Constructor donde se iguala el precio entregado por el Enum a la propiedad 'precio'
     * @param precio Número entero con el precio de uno de los productos */
    Seleccion (int precio) {
        this.precio = precio;
    }

    /** Método que entrega el precio de un producto del expendedor
     * @return Número entero con el precio del producto elegido */
    public int getPrecio() {
        return precio;
    }
}