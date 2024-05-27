/** Una lista (Enum) de los productos del expendedor, con sus respectivos precios
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public enum Seleccion {
    CocaCola(1100, 0),
    Sprite(1000, 1),
    Fanta(1000, 2),
    Snickers(600, 3),
    Super8(400, 4),
    Flipy(500, 5),
    Kem(900,6),
    Bilz(900,7),
    Pap(900,8);



    /** Número entero que contiene el precio de uno de los productos */
    private final int precio;

    /** Número entero que contiene el número del deposito */
    private final int numDepo;

    /** Constructor donde se iguala el precio entregado por el Enum a la propiedad 'precio'
     * @param precio Número entero con el precio de uno de los productos */
    Seleccion (int precio, int numDepo) {
        this.precio = precio;
        this.numDepo = numDepo;
    }

    /** Método que entrega el precio de un producto del expendedor
     * @return Número entero con el precio del producto elegido */
    public int getPrecio() {
        return precio;
    }

    /** Método que entrega el número del deposito del producto, partiendo de 0
     * @return Número entero con el número del deposito en el expendedor */
    public int getNumDepo() {
        return numDepo;
    }
}