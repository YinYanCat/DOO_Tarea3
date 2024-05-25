/** Una galleta con capas de barquillo y recubierta de chocolate, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Super8 extends Dulce{

    /** Constructor que guarda el número de serie del Super8
     * @param serie Número entero con la serie del Super8 */
    public Super8(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del Super8
     * @return String "super8" como su sabor */
    public String sabor() {
        return "super8";
    }
}
