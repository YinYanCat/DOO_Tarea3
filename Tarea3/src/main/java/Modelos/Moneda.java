package Modelos;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Un objeto con un valor definido que utiliza para comprar un producto, se puede almacenar en un deposito
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public abstract class Moneda implements Comparable, Visible {
    private int serie;
    private int posX;
    private int posY;

    /** Imagen del producto */
    protected BufferedImage img;

    /** Constructor por defecto de Moneda */
    public Moneda(int sr) {
        serie = sr;
        try {
            img = ImageIO.read(getClass().getClassLoader().getResource("imgMoneda"+this.getValor()+".png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /** Método para obtener el valor económico de la moneda
     * @return Número entero con el valor de la moneda */
    public abstract int getValor();

    /** Método para obtener el número de serie del producto
     * @return Número entero con la serie del producto */
    public int getSerie() {
        return serie;
    }

    /** Método de la interfaz 'Comparable' para comparar este objeto con otro objeto
     * @param o El objeto a comparar */
    public abstract int compareTo(Object o);

    @Override
    public void setPosition(int x, int y) {
        posX=x;
        posY=y;
    }

    @Override
    public void setImage(BufferedImage image){
        img = image;
    }
    public void paintComponent(Graphics g, Component observer){
        g.drawImage(img,posX,posY,observer);
    }
}