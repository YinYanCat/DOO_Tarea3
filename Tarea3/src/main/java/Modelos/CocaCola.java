package Modelos;

import javax.imageio.ImageIO;
import java.io.IOException;
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
            try {
                img = ImageIO.read(getClass().getClassLoader().getResource("imgSecretCocaCola.png"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /** Método para obtener el sabor (nombre) de la CocaCola
     * @return String "CocaCola" como su sabor */
    public String sabor() {
        return "CocaCola";
    }

    public int getNumProducto() { return 8; }

}