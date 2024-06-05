package Modelos.Monedas;

/** Una moneda de valor 500 que utiliza para comprar un producto, se puede almacenar en un deposito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Moneda500 extends Moneda {

    /** Constructor por defecto de Moneda500 */
    public Moneda500(int serie) {
        super(serie);
    }

    /** Método para obtener el valor económico de la moneda
     * @return Número entero con el valor 500 de la moneda */
    public int getValor() {
        return 500;
    }

    /** Metodo para obtener el número de la imagen de la moneda
     * @return El número 1, asociado a la imagen de la moneda */
    public int getNumImg() {
        return 1;
    }
}
