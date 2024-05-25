/** Una bebida azucarada gaseosa, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class CocaCola extends Bebida {

    /** Constructor que guarda el número de serie de la CocaCola
     * @param serie Número entero con la serie de la CocaCola */
    public CocaCola(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la CocaCola
     * @return String "cocacola" como su sabor */
    public String sabor() {
        return "cocacola";
    }
}