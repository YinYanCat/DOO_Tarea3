package Modelos;

import Vistas.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/** Un objeto que se puede comprar utilizando dinero, se puede almacenar en un depósito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Producto implements Visible {

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
        ImageLoader imgLoader = ImageLoader.getInstancia();
        img = imgLoader.getImagenProducto(getNumImgProducto());
    }

    /** Metodo para establecer las coordenadas del producto
     * @param x Entero con la posición en el eje x
     * @param y Entero con la posición en el eje y
     */
    public void setPosition(int x, int y){
        posX = x;
        posY = y;
    }

    /** Metodo para obtener el número de la imagen del producto
     * @return int con el número asociado a la imagen del producto */
    public abstract int getNumImgProducto();

    /** Metodo para obtener la imagen del producto
     * @return La imagen del producto en el buffer */
    public abstract BufferedImage getImageProducto();

    /** Método para obtener el número de serie del producto
     * @return Número entero con la serie del producto */
    public int getSerie() {
        return serie;
    }

    /** Método para obtener el sabor (nombre) del producto
     * @return String con el sabor del producto */
    public abstract String sabor();

    /** Método para dibujar la imagen del producto en un componente de Swing */
    public void paintComponent(Graphics g, Component observer){
        g.drawImage(img,posX,posY,observer);
    }
}