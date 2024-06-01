package Modelos;

/** Una lista (Enum) de los productos del expendedor, con sus respectivos precios
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public enum Seleccion {
    Snickers(800, 0),
    Super8(400, 1),
    Rolls(800, 2),
    SahneNuss(500, 3),
    Trencito(500, 4),
    Doblon(400, 5),
    Flipy(600, 6),
    Ambrosito(600, 7),
    CocaCola(1200, 8),
    Sprite(1200, 9),
    Fanta(1200, 10),
    Pepsi(1000, 11),
    Bilz(800,12),
    Pap(800,13),
    Kem(800,14),
    LimonSoda(900,15);


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