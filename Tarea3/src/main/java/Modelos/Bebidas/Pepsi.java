package Modelos.Bebidas;

import java.awt.image.BufferedImage;

/** Una bebida azucarada gaseosa, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Pepsi extends Bebida {

    /** Constructor que guarda el número de serie de la Pepsi
     * @param serie Número entero con la serie de la Pepsi */
    public Pepsi(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la Pepsi
     * @return String "Pepsi" como su sabor */
    public String sabor() {
        return "Pepsi";
    }

    /** Metodo para obtener el número de la imagen de la Pepsi
     * @return int con el número asociado a la imagen (11) de la Pepsi */
    public int getNumImg() { return 11; }

    /** Metodo para obtener la imagen de la Pepsi
     * @return La imagen del producto en el buffer */
    public BufferedImage getImage() { return img; }
}