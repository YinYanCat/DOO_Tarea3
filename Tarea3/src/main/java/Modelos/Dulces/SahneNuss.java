package Modelos.Dulces;

import java.awt.image.BufferedImage;

/** Un chocolate suave con crujientes trozos de nuez, que se pueden comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class SahneNuss extends Dulce{

    /** Constructor que guarda el número de serie del SahneNuss
     * @param serie Número entero con la serie del SahneNuss */
    public SahneNuss(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del SahneNuss
     * @return String "Sahne-Nuss" como su sabor */
    public String sabor() {
        return "Sahne-Nuss";
    }

    /** Metodo para obtener el número de la imagen del SahneNuss
     * @return int con el número asociado a la imagen (3) de la SahneNuss */
    public int getNumImgProducto() { return 3; }

    /** Metodo para obtener la imagen del SahneNuss
     * @return La imagen del producto en el buffer */
    public BufferedImage getImageProducto() { return img; }
}
