package Modelos;

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

    public int getNumProducto() { return 3; }
}
