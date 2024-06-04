package Modelos.Monedas;

import Modelos.Visible;
import Vistas.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/** Un objeto con un valor definido que utiliza para comprar un producto, se puede almacenar en un deposito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Moneda implements Visible {
    private int serie;
    private int posX;
    private int posY;

    /** Imagen del producto */
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

    /** Metodo para obtener el número de la imagen de la Moneda
     * @return int con el número asociado a la imagen de la Moneda */
    public abstract int getNumImgMoneda();

    @Override
    public void setPosition(int x, int y) {
        posX=x;
        posY=y;
    }

    public void paintComponent(Graphics g, Component observer){
        g.drawImage(img,posX,posY,observer);
    }
}