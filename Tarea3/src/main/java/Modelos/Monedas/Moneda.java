package Modelos.Monedas;

import Modelos.Visible;
import Vistas.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/** Un objeto con un valor definido que utiliza para comprar un producto, se puede almacenar en un deposito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Moneda implements Visible {

    /** El número de serie de la moneda */
    private int serie;

    /** La posición X de la moneda */
    private int posX;

    /** La posición Y de la moneda */
    private int posY;

    /** Imagen de la moneda */
    protected BufferedImage img;

    /** Constructor por defecto de Moneda */
    public Moneda(int sr) {
        serie = sr;
        img = ImageLoader.getInstancia().getImagenMoneda(getNumImgMoneda());
    }

    /** Método para obtener el valor económico de la moneda
     * @return Número entero con el valor de la moneda */
    public abstract int getValor();

    /** Método para obtener el número de serie del producto
     * @return Número entero con la serie del producto */
    public int getSerie() {
        return serie;
    }

    /** Método para obtener el número de la imagen de la Moneda
     * @return int con el número asociado a la imagen de la Moneda */
    public abstract int getNumImgMoneda();

    /** Método para entregar la posición X e Y de la moneda
     * @param x Posición X pixel de la moneda en la pantalla
     * @param y Posición Y pixel de la moneda en la pantalla */
    @Override
    public void setPosition(int x, int y) {
        posX=x;
        posY=y;
    }

    /** Método para dibujar la imagen de la moneda en un componente de Swing */
    public void paintComponent(Graphics g, Component observer){
        g.drawImage(img,posX,posY,observer);
    }
}