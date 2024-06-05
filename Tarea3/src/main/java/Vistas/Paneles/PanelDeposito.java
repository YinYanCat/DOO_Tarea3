package Vistas.Paneles;

import Modelos.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Un panel que muestra el contenido de un deposito con objetos de forma ordenada
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelDeposito <T extends Visible> extends JPanel {

    /** Deposito que contiene los objetos a mostrarse */
    private Deposito<T> dep;

    /** Arreglo de imagenes que se dibujan al fondo del panel */
    private BufferedImage[] backgrounds;

    /** Entero con el número del deposito actual */
    private int pSelect;

    /** Expendedor donde se obtienen y se rellenan los depositos */
    private Expendedor exp;

    /** Constructor se crea el panel y sus componentes
     * @param deposito El deposito con los objetos que van a ser mostrados
     * @param select El número del deposito a ser mostrado
     * @param expendedor El expendedor donde se rellenan los depositos */
    public PanelDeposito(Deposito<T> deposito, int select, Expendedor expendedor) {
        super(null);
        pSelect = select;
        dep = deposito;
        exp = expendedor;
        this.setOpaque(false);
        backgrounds = new BufferedImage[3];
        try {
            backgrounds[0] = ImageIO.read(getClass().getClassLoader().getResource("imgDepoFondo.png"));
            backgrounds[1] = ImageIO.read(getClass().getClassLoader().getResource("imgDepoSelect.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        backgrounds[2] = backgrounds[0];

        PanelListener listener = new PanelListener();
        this.addMouseListener(listener);
        for(int i=0;i<dep.getSizeCont();i++){
            T contenido = dep.checkContenido(i);
            contenido.setPosition(60-10*i,5);
        }
    }

    /** Método para actualizar el contenido mostrado en el panel cuando el deposito es modificado */
    public void ActualizarContenido() {
        int movProd = 5*(5-dep.getSizeCont());
        for(int i=0;i<dep.getSizeCont();i++){
            T contenido = dep.checkContenido(i);
            contenido.setPosition(60-10*i-movProd,5);
        }
    }

    /** Un escuchador de acciones realizadas con el mouse al panel deposito
     * @author Chloe Yañez Lavin
     * @author Emily Osvaldo Gaete Bobadilla */
    private class PanelListener implements MouseListener {

        /** Método para rellenar el panel vacio al detectar al mouse hacer clic en el panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mouseClicked(MouseEvent event) {
            if(dep.getSizeCont()==0) {
                backgrounds[2] = backgrounds[0];
                dep = (Deposito<T>) exp.rellenarDeposito(pSelect);
                ActualizarContenido();
                repaint();
            }
        }

        /** Método para iluminar el panel vacio al detectar el mouse entrar al panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mouseEntered(MouseEvent event) {
            if(dep.getSizeCont()==0) {
                backgrounds[2] = backgrounds[1];
                repaint();
            }
        }

        /** Método para dejar de iluminar el panel vacio al detectar el mouse salir del panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mouseExited(MouseEvent event) {
            if(dep.getSizeCont()==0) {
                backgrounds[2] = backgrounds[0];
                repaint();
            }
        }

        /** Método para rellenar el panel vacio al detectar que el mouse está presionando el panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mousePressed(MouseEvent event) {
            if(dep.getSizeCont()==0) {
                backgrounds[2] = backgrounds[0];
                dep = (Deposito<T>) exp.rellenarDeposito(pSelect);
                ActualizarContenido();
                repaint();
            }
        }

        /** Método para realizar una acción al detectar que el mouse liberó el panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mouseReleased(MouseEvent event) {}

    }

    /** Método para dibujar los componentes de Swing del panel
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgrounds[2], 0, 0, this);
        for(int j=dep.getSizeCont()-1;j>=0;j--) {
            dep.checkContenido(j).paintComponent(g, this);
        }
    }
}
