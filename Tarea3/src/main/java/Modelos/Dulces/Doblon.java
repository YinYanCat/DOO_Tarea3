package Modelos.Dulces;

import java.awt.image.BufferedImage;

/** Una galleta bañada en chocolate y rellena con crema sabor vainilla, que se pueden comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Doblon extends Dulce{

    /** Constructor que guarda el número de serie del Doblon
     * @param serie Número entero con la serie del Doblon */
    public Doblon(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del Doblon
     * @return String "Doblon" como su sabor */
    public String sabor() {
        return "Doblon";
    }

    /** Metodo para obtener el número de la imagen del producto
     * @return int con el número asociado a la imagen (5) del producto */
    public int getNumImgProducto() { return 5; }

    /** Metodo para obtener la imagen del Doblon
     * @return La imagen del producto en el buffer */
    public BufferedImage getImageProducto() { return img; };
}
