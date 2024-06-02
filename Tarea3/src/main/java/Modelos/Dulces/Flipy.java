package Modelos.Dulces;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

/** Unas gomitas bicapas de gelatina en forma de delfines, que se pueden comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Flipy extends Dulce {

    /** Constructor que guarda el número de serie del Flipy y la utiliza asociarlo a una imágen alternativa del Flipy
     * @param serie Número entero con la serie del Flipy */
    public Flipy(int serie) {
        super(serie);
        Random random = new Random();
        if(random.nextInt(10)<3) {
            try {
                img = ImageIO.read(getClass().getClassLoader().getResource("imgSecretFlipy.png"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /** Método para obtener el sabor (nombre) del Flipy
     * @return String "Flipy" como su sabor */
    public String sabor() {
        return "Flipy";
    }

    /** Metodo para obtener el número de la imagen del Flipy
     * @return int con el número asociado a la imagen (6) del Flipy */
    public int getNumImgProducto() { return 6; }
}