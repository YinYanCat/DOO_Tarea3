package Modelos;

/** Una bebida azucarada de sabor a papaya, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Pap extends Bebida {

    /** Constructor que guarda el número de serie de la Pap
     * @param serie Número entero con la serie de la Pap */
    public Pap(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) de la Pap
     * @return String "Pap" como su sabor */
    public String sabor() {
        return "Pap";
    }

    /** Metodo para obtener el número de la imagen de la Pap
     * @return int con el número asociado a la imagen (13) de la Pap */
    public int getNumImgProducto() { return 13; }
}