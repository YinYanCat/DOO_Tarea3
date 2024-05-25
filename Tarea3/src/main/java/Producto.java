/** Un objeto que se puede comprar utilizando dinero, se puede almacenar en un depósito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Producto {

    /** Número entero que guarda el número de serie del producto */
    private int serie;

    /** Constructor donde se guarda el número de serie del producto
     * @param sr Número entero con la serie del producto */
    public Producto(int sr) {
        serie = sr;
    }

    /** Método para obtener el número de serie del producto
     * @return Número entero con la serie del producto */
    public int getSerie() {
        return serie;
    }

    /** Método para obtener el sabor (nombre) del producto
     * @return String con el sabor del producto */
    public abstract String sabor();
}