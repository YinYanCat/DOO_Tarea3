/** Un objeto con un valor definido que utiliza para comprar un producto, se puede almacenar en un deposito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Moneda implements Comparable {

    /** Constructor por defecto de Moneda */
    public Moneda() {}

    /** Método para obtener el valor económico de la moneda
     * @return Número entero con el valor de la moneda */
    public abstract int getValor();

    /** Método de la interfaz 'Comparable' para comparar este objeto con otro objeto
     * @param o El objeto a comparar */
    public abstract int compareTo(Object o);
}