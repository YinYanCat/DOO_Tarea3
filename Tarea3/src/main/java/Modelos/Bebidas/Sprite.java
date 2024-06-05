package Modelos.Bebidas;

import java.awt.image.BufferedImage;

/** Una bebida azucarada de sabor a lima y limón, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Sprite extends Bebida {

    /** Constructor que guarda el número de serie de la Sprite
     * @param serie Número entero con la serie de la Sprite */
    public Sprite(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la Sprite
     * @return String "Sprite" como su sabor*/
    public String sabor() {
        return "Sprite";
    }

    /** Metodo para obtener el número de la imagen de la Sprite
     * @return int con el número asociado a la imagen (9) de la Sprite */
    public int getNumImg() { return 9; }

    /** Metodo para obtener la imagen de la Sprite
     * @return La imagen del producto en el buffer */
    public BufferedImage getImage() { return img; }
}