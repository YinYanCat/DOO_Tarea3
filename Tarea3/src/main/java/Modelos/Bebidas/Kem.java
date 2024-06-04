package Modelos.Bebidas;

import java.awt.image.BufferedImage;

/** Una bebida azucarada de sabor a piña, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Kem extends Bebida {

    /** Constructor que guarda el número de serie de la Kem
     * @param serie Número entero con la serie de la Kem */
    public Kem(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la Kem
     * @return String "Kem" como su sabor */
    public String sabor() {
        return "Kem";
    }

    /** Metodo para obtener el número de la imagen de la Kem
     * @return int con el número asociado a la imagen (14) de la Kem */
    public int getNumImgProducto() { return 14; }

    /** Metodo para obtener la imagen de la Kem
     * @return La imagen del producto en el buffer */
    public BufferedImage getImageProducto() { return img; };
}