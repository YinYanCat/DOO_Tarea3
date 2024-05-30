package Modelos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Un objeto que se puede comprar utilizando dinero, se puede almacenar en un depósito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Producto {

    /** Número entero que guarda el número de serie del producto */
    private int serie;

    /** Coordenada del un producto en el eje X */

    private int posX;

    /** Coordenada del un producto en el eje Y */

    private int posY;

    /** Imagen del producto */

    private BufferedImage img;

    /** Constructor donde se guarda el número de serie del producto
     * @param sr Número entero con la serie del producto */
    public Producto(int sr) {
        serie = sr;
    }

    public void Linker(BufferedImage imagen, int x, int y){
        img = imagen;
        posX = x;
        posY = y;
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