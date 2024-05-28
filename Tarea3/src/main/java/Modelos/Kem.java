package Modelos;

/** Una bebida azucarada de sabor a piña, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Kem extends Bebida {

    /** Constructor que guarda el número de serie de la Kem
     * @param serie Número entero con la serie de la Kem */
    public Kem(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la Kem
     * @return String "kem" como su sabor */
    public String sabor() {
        return "kem";
    }
}