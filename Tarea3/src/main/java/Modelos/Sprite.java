package Modelos;

/** Una bebida azucarada de sabor a lima y limón, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Sprite extends Bebida {

    /** Constructor que guarda el número de serie de la Sprite
     * @param serie Número entero con la serie de la Sprite */
    public Sprite(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la Sprite
     * @return String "Sprite" como su sabor*/
    public String sabor() {
        return "Sprite";
    }
}