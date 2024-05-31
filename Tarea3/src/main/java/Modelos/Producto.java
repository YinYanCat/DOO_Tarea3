package Modelos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Un objeto que se puede comprar utilizando dinero, se puede almacenar en un depósito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Producto implements Visible{

    /** Número entero que guarda el número de serie del producto */
    private int serie;

    /** Coordenada del un producto en el eje X */

    private int posX;

    /** Coordenada del un producto en el eje Y */

    private int posY;

    /** Imagen del producto */

    protected BufferedImage img;

    /** Constructor donde se guarda el número de serie del producto
     * @param sr Número entero con la serie del producto */
    public Producto(int sr) {
        serie = sr;
    }

    /** Metodo para establecer las coordenadas del producto
     * @param x Entero con la posición en el eje x
     * @param y Entero con la posición en el eje y
     */
    public void setPosition(int x, int y){
        posX = x;
        posY = y;
    }


    public void setImage(BufferedImage image){
        img = image;

    }

    /** Método para obtener el número de serie del producto
     * @return Número entero con la serie del producto */
    public int getSerie() {
        return serie;
    }

    /** Método para obtener el sabor (nombre) del producto
     * @return String con el sabor del producto */
    public abstract String sabor();

    public void paintComponent(Graphics g, Component observer){
        g.drawImage(img,posX,posY,observer);
    }
}