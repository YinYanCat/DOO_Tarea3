package Modelos;

/** Una galleta bañada en chocolate y rellena con crema sabor vainilla, que se pueden comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Doblon extends Dulce{

    /** Constructor que guarda el número de serie del Doblon
     * @param serie Número entero con la serie del Doblon */
    public Doblon(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del Doblon
     * @return String "Doblon" como su sabor */
    public String sabor() {
        return "Doblon";
    }
}
