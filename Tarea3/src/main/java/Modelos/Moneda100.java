package Modelos;

/** Una moneda de valor 100 que utiliza para comprar un producto, se puede almacenar en un deposito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Moneda100 extends Moneda {

    /** Constructor por defecto de Moneda100 */
    public Moneda100(int serie) {
        super(serie);
    }

    /** Método para obtener el valor económico de la moneda
     * @return Número entero con el valor 100 de la moneda */
    public int getValor() {
        return 100;
    }

    /** Método de la interfaz 'Comparable' para comparar este Objeto con otro Objeto
     * @param o El objeto a comparar
     * @return Número entero dependiendo si este Objeto es menor, igual o mayor que el Objeto especificado */
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
