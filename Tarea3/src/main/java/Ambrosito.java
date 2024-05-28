/** Unas gomitas de gelatina en forma de osos, que se pueden comprar utilizando dinero
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Ambrosito extends Dulce{

    /** Constructor que guarda el número de serie del Ambrosito
     * @param serie Número entero con la serie del Ambrosito */
    public Ambrosito(int serie) {
        super(serie);
    }

    /** Método para obtener el sabor (nombre) del Ambrosito
     * @return String "ambrosito" como su sabor */
    public String sabor() {
        return "ambrosito";
    }
}
