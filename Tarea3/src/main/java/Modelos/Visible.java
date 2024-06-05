package Modelos;

import java.awt.*;
import java.awt.image.BufferedImage;

/** Una interfaz para entregarle métodos de Moneda y Producto a objetos génericos
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */
public interface Visible {

    /** Método para guardar la posición en el eje x y eje Y de un Objeto */
    public void setPosition(int x, int y);

    /** Metodo para obtener la serie de un Objeto
     * @return int serie de un Objeto*/
    public int getSerie();

    /** Metodo para dibujar en un Component de Swing un Objeto */
    public void paintComponent(Graphics g,Component observer);

}
