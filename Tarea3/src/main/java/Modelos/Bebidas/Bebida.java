package Modelos.Bebidas;

import Modelos.Producto;

/** Un producto bebestible y gaseoso que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Bebida extends Producto {

    /** Constructor que guarda el número de serie de la bebida
     * @param serie Número entero con la serie de la bebida */
    public Bebida(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la bebida
     * @return String con el sabor de la bebida */
    public abstract String sabor();

}
