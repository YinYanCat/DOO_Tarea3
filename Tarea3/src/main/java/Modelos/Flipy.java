package Modelos;

/** Unas gomitas bicapas de gelatina en forma de delfines, que se pueden comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Flipy extends Dulce{

    /** Constructor que guarda el número de serie del Flipy
     * @param serie Número entero con la serie del Flipy */
    public Flipy(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del Flipy
     * @return String "flipy" como su sabor */
    public String sabor() {
        return "flipy";
    }
}
