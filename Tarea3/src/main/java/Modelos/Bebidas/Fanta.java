package Modelos.Bebidas;

import java.awt.image.BufferedImage;

/** Una bebida azucarada de sabor a naranja, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Fanta extends Bebida {

    /** Constructor que guarda el número de serie de la Fanta
     * @param serie Número entero con la serie de la Fanta */
    public Fanta(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la Fanta
     * @return String "Fanta" como su sabor */
    public String sabor() {
        return "Fanta";
    }

    /** Metodo para obtener el número de la imagen de la Fanta
     * @return int con el número asociado a la imagen (10) de la Fanta */
    public int getNumImgProducto() { return 10; }

    /** Metodo para obtener la imagen de la Fanta
     * @return La imagen del producto en el buffer */
    public BufferedImage getImageProducto() { return img; }
}