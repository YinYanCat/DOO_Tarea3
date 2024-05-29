package Modelos;

/** Un objeto con un valor definido que utiliza para comprar un producto, se puede almacenar en un deposito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Moneda implements Comparable {
    private int serie;

    /** Constructor por defecto de Moneda */
    public Moneda(int sr) {serie = sr;}

    /** Método para obtener el valor económico de la moneda
     * @return Número entero con el valor de la moneda */
    public abstract int getValor();

    /** Método para obtener el número de serie del producto
     * @return Número entero con la serie del producto */
    public int getSerie() {
        return serie;
    }

    /** Método de la interfaz 'Comparable' para comparar este objeto con otro objeto
     * @param o El objeto a comparar */
    public abstract int compareTo(Object o);
}