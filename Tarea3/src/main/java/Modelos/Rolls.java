package Modelos;

/** Unas bolitas de chocolate con centro crocante y cubiertas de leche y chocolate, que se pueden comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Rolls extends Dulce{

    /** Constructor que guarda el número de serie del Rolls
     * @param serie Número entero con la serie del Rolls */
    public Rolls(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del Rolls
     * @return String "rolls" como su sabor */
    public String sabor() {
        return "rolls";
    }
}
