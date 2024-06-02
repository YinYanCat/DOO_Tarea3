package Modelos.Dulces;

/** Una barra de chocolate de leche, que se pueden comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Trencito extends Dulce{

    /** Constructor que guarda el número de serie del Trencito
     * @param serie Número entero con la serie del Trencito */
    public Trencito(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del Trencito
     * @return String "Trencito" como su sabor */
    public String sabor() {
        return "Trencito";
    }

    /** Metodo para obtener el número de la imagen del Trencito
     * @return int con el número asociado a la imagen (4) del Trencito */
    public int getNumImgProducto() { return 4; }
}