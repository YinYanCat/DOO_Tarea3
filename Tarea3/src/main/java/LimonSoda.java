/** Una bebida azucarada de sabor a limón, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class LimonSoda extends Bebida {

    /** Constructor que guarda el número de serie de la LimonSoda
     * @param serie Número entero con la serie de la LimonSoda */
    public LimonSoda(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la LimonSoda
     * @return String "limon soda" como su sabor */
    public String sabor() {
        return "limon soda";
    }
}