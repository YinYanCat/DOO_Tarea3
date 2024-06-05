package Vistas.Paneles;

import Modelos.Deposito;
import Modelos.Monedas.Moneda;
import Modelos.Producto;
import Vistas.CuadroTexto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Un panel que contiene el producto de la compra y las monedas obtenidas como vuelto
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelInventario extends JPanel {

    /** Panel con un objeto, en este caso un producto */
    private PanelObjeto panelProducto;

    /** Lista de paneles con un objeto, en este caso una moneda, en cada panel */
    private PanelObjeto[] panelMoneda;

    /** Deposito con las monedas visualizadas en el panel mediante PanelObjeto */
    private Deposito<Moneda> depoMonedas;

    /** Arreglo de cuadros de texto que muestran información sobre el panel */
    private CuadroTexto[] lablesInv;

    /** Imagen que se dibuja al fondo del panel */
    private BufferedImage ImgBackground;

    /** Constructor donde se crea el panel, sus sub paneles, sus cuadros de texto y su imagen de fondo
     * @param x La coordenada X del panel
     * @param y La coordenada Y del panel
     * @param width El ancho del panel
     * @param height El alto del panel */
    public PanelInventario(int x, int y, int width, int height) {
        super(null);
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelInventario.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(20,20, 68));
        lablesInv = new CuadroTexto[5];
        panelProducto = new PanelObjeto(30,100, 50,100);
        panelMoneda = new PanelObjeto[15];

        this.add(panelProducto);
        int i=0;
        for(int j=0; j<15; j++) {
            panelMoneda[j] = new PanelObjeto(18+28*(j%5),245+100*i,100,100);
            this.add(panelMoneda[j]);
            if(j%5==4)
                i++;
        }

        lablesInv[0] = new CuadroTexto("Producto", new Color(20,20, 68), Color.WHITE, "Arial");
        lablesInv[0].setBounds(30,75,150,20);
        lablesInv[1] = new CuadroTexto("Vuelto Total: 0", new Color(20,20, 68), Color.WHITE, "Arial");
        lablesInv[1].setBounds(30,215,150,20);
        lablesInv[2] = new CuadroTexto("", new Color(20,20, 68), Color.WHITE, "Arial");
        lablesInv[2].setBounds(30,545,150,20);
        lablesInv[3] = new CuadroTexto("Bolsa: 0", new Color(199,199, 199), Color.BLACK, "Arial");
        lablesInv[3].setBounds(30,616,150,20);
        lablesInv[4] = new CuadroTexto("Billetera: 0", new Color(139,108, 88), Color.BLACK, "Arial");
        lablesInv[4].setBounds(30,690,150,20);

        for(int num=0; num<5; num++) {
            this.add(lablesInv[num]);
        }
    }

    /** Método para actualizar los textos con la información del valor del vuelto y el valor final total
     * @param billetera El valor total de las monedas en la billetera
     * @param vuelto El valor total del vuelto obtenido en una compra */
    public void setTextoInv(int billetera, int vuelto) {
        lablesInv[4].setText("Billetera: "+billetera);
        lablesInv[1].setText("Vuelto Total: "+vuelto);
    }

    /** Método para mostrar un producto comprado en el panel, utilizando PanelObjeto
     * @param producto El producto comprado que va ser mostrado
     * @param cantidad La cantidad total de productos comprados */
    public void displayProducto(Producto producto, int cantidad) {
        lablesInv[0].setText(producto.sabor());
        lablesInv[3].setText("Bolsa: "+cantidad);
        panelProducto.setObjeto(producto);
        repaint();
    }

    /** Método para mostrar una serie de monedas obtenidas en el panel, utilizando PanelObjeto
     * @param depoVuelto El deposito con monedas con el vuelto obtenido
     * @param total La valor total de las monedas obtenidas en el vuelto */
    public void displayMonedas(Deposito<Moneda> depoVuelto, int total) {
        lablesInv[2].setText("");
        depoMonedas = depoVuelto;
        for(int i=0; i<15; i++) {
            panelMoneda[i].lockPanel();
        }
        for(int j=0; j<depoMonedas.getSizeCont(); j++) {
            panelMoneda[j].setObjeto(depoMonedas.checkContenido(j));
            if(j>=14)
                break;
        }
        int extra = depoMonedas.getSizeCont()-15;
        lablesInv[1].setText("Vuelto Total: "+total);
        if(extra>0)
            lablesInv[2].setText("+"+extra+" Monedas");
        repaint();
    }

    /** Método para dibujar la imagen del fondo del panel y sus componentes
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }
}
