package Modelos.Monedas;

/** Una moneda de valor 1000 que utiliza para comprar un producto, se puede almacenar en un deposito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Moneda1000 extends Moneda {

    /** Constructor por defecto de Moneda1000 */
    public Moneda1000(int serie) {
        super(serie);
    }

    /** Método para obtener el valor económico de la moneda
     * @return Número entero con el valor 1000 de la moneda */
    public int getValor() {
        return 1000;
    }

    /** Método de la interfaz 'Comparable' para comparar este Objeto con otro objeto
     * @param o El objeto a comparar
     * @return Número entero dependiendo si este objeto es menor, igual o mayor que el objeto especificado */
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
