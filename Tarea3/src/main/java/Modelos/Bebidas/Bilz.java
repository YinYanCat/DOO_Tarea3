package Modelos.Bebidas;

/** Una bebida azucarada de sabor a granadina, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Bilz extends Bebida {

    /** Constructor que guarda el número de serie de la Bilz
     * @param serie Número entero con la serie de la Bilz */
    public Bilz(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la Bilz
     * @return String "Bilz" como su sabor */
    public String sabor() {
        return "Bilz";
    }

    /** Metodo para obtener el número de la imagen de la Bilz
     * @return int con el número asociado a la imagen (12) de la Bilz */
    public int getNumImgProducto() { return 12; }
}