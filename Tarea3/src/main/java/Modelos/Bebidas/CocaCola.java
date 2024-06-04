package Modelos.Bebidas;

import Vistas.ImageLoader;
import java.util.Random;

/** Una bebida azucarada gaseosa, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class CocaCola extends Bebida {

    /** Constructor que guarda el número de serie de la CocaCola
     * @param serie Número entero con la serie de la CocaCola */
    public CocaCola(int serie) {
        super(serie);
        Random random = new Random();
        if(random.nextInt(10)<1) {
            img = ImageLoader.getInstancia().getImagenProductoEspecial(getNumImgProductoEspecial());
        }
    }

    /** Método para obtener el sabor (nombre) de la CocaCola
     * @return String "CocaCola" como su sabor */
    public String sabor() {
        return "CocaCola";
    }

    /** Metodo para obtener el número de la imagen de la CocaCola
     * @return int con el número asociado a la imagen (8) de la CocaCola */
    public int getNumImgProducto() { return 8; }

    /** Metodo para obtener el número de la imagen especial de la CocaCola
     * @return int con el número asociado a la imagen especial (0) del CocaCola */
    public int getNumImgProductoEspecial() {
        return 0;
    }
}