package Modelos.Monedas;

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

    /** Metodo para obtener el número de la imagen de la moneda
     * @return El número 0, asociado a la imagen de la moneda */
    public int getNumImgMoneda() {
        return 0;
    }
}
