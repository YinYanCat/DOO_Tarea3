/** Una moneda de valor 1500 que utiliza para comprar un producto, se puede almacenar en un deposito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Moneda1500 extends Moneda {

    /** Constructor por defecto de Moneda1500 */
    public Moneda1500() {
        super();
    }

    /** Método para obtener el valor económico de la moneda
     * @return Número entero con el valor 1500 de la moneda */
    public int getValor() {
        return 1500;
    }

    /** Método de la interfaz 'Comparable' para comparar este Objeto con otro Objeto
     * @param o El objeto a comparar
     * @return Número entero dependiendo si este Objeto es menor, igual o mayor que el Objeto especificado */
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
