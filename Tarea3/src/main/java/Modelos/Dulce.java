package Modelos;

/** Un producto comestible y dulce que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Dulce extends Producto {

    /** Constructor que guarda el número de serie del dulce
     * @param serie Número entero con la serie del dulce */
    public Dulce(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del dulce
     * @return String con el sabor del dulce */
    public abstract String sabor();
    public abstract int getNumProducto();
}
