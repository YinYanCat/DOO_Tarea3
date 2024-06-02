package Modelos;

/** Una barra de chocolate con turrón y mantequilla de maní, que se puede comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Snickers extends Dulce{

    /** Constructor que guarda el número de serie del Snickers
     * @param serie Número entero con la serie del Snickers */
    public Snickers(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del Snickers
     * @return String "Snickers" como su sabor */
    public String sabor() {
        return "Snickers";
    }

    public int getNumProducto() { return 0; }
}
