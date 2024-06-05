package Vistas.Paneles;

import Modelos.Visible;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** Un panel que muestra un objeto visualmente y obtiene información del mismo
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelObjeto <T extends Visible> extends JPanel {

    /** Objeto genérico que se visualiza */
    private T objeto;

    /** Pop-Up que muestra información sobre el objeto genérico */
    private JPopupMenu popupSerie;

    /** Cuadro de texto que se muestra dentro del Pop-Up */
    private JLabel lSerie;

    /** Entero que contiene una desviación de la coordenada Y dependiendo de la circunstancias */
    private int yOffSet;

    /** Booleano que indica si el panel es visible o invisible */
    private boolean visible;

    /** Constructor donde se crea el panel y su Pop-Up
     * @param x      La coordenada X del panel
     * @param y      La coordenada Y del panel
     * @param width  El ancho del panel
     * @param height El alto del panel */
    public PanelObjeto(int x, int y, int width, int height) {
        super();
        this.setOpaque(false);
        this.setBounds(x, y, width, height);
        this.addMouseListener(new PanelListener());
        lSerie = new JLabel();
        visible = false;
        popupSerie = new JPopupMenu();
        popupSerie.setBackground(Color.WHITE);
        popupSerie.add(lSerie);
        yOffSet = 0;
    }

    /** Método para entregarle un objeto al panel para visualizar
     * @param objeto El objeto genérico a visualizar */
    public void setObjeto(T objeto) {
        this.objeto = objeto;
        this.objeto.setPosition(0, 0);
        lSerie.setText(" " + objeto.getSerie() + " ");
        visible = true;
        if (lSerie.getText().length() < 8)
            yOffSet = 50;
    }

    /** Método para volver invisible al panel y sus componentes */
    public void lockPanel() {
        visible = false;
    }

    /** Método para volver visible o invisible al panel y sus componentes */
    public void togglePanel() {
        visible = !visible;
    }

    /** Un escuchador de acciones realizadas con el mouse al panel objeto
     * @author Chloe Yañez Lavin
     * @author Emily Osvaldo Gaete Bobadilla */
    private class PanelListener implements MouseListener {

        /** Método para realizar una acción al detectar al mouse hacer clic en el panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mouseClicked(MouseEvent event) {}

        /** Método para mostrar el Pop-Up al detectar el mouse entrar al panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mouseEntered(MouseEvent event) {
            if(visible) {
                popupSerie.setVisible(true);
                popupSerie.show(event.getComponent(), 50, yOffSet);
            }
        }

        /** Método para dejar de mostrar el Pop-Up al detectar el mouse salir del panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mouseExited(MouseEvent event) {
            if(visible) {
                popupSerie.setVisible(false);
                repaint();
            }
        }

        /** Método para imprimir la información del objeto al detectar que el mouse está presionando el panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mousePressed(MouseEvent event) {
            if(visible)
                System.out.println(objeto.getClass().getSimpleName()+" | Número de serie: "+lSerie.getText());
        }

        /** Método para realizar una acción al detectar que el mouse liberó el panel
         * @param event El evento realizado al panel deposito */
        @Override
        public void mouseReleased(MouseEvent event) {}
    }

    /** Método para dibujar el componente del panel
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(visible)
            objeto.paintComponent(g, this);
    }
}
