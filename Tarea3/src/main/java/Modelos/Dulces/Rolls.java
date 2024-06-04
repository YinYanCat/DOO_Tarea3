package Modelos.Dulces;

import java.awt.image.BufferedImage;

/** Unas bolitas de chocolate con centro crocante y cubiertas de leche y chocolate, que se pueden comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Rolls extends Dulce{

    /** Constructor que guarda el número de serie del Rolls
     * @param serie Número entero con la serie del Rolls */
    public Rolls(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del Rolls
     * @return String "Rolls" como su sabor */
    public String sabor() {
        return "Rolls";
    }

    /** Metodo para obtener el número de la imagen del Rolls
     * @return int con el número asociado a la imagen (2) del Rolls */
    public int getNumImgProducto() { return 2; }

    /** Metodo para obtener la imagen del Rolls
     * @return La imagen del producto en el buffer */
    public BufferedImage getImageProducto() { return img; };
}
