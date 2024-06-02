package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelDeposito <T extends Visible> extends JPanel {
    private Deposito<T> dep;
    private BufferedImage[] backgrounds;
    private int pSelect;
    private Expendedor exp;

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
        for(int i=0;i<dep.getCantidadContenido();i++){
            T contenido = dep.checkContenido(i);
            contenido.setPosition(60-10*i,5);
        }
    }

    public void ActualizarContenido() {
        int movProd = 5*(5-dep.getCantidadContenido());
        for(int i=0;i<dep.getCantidadContenido();i++){
            T contenido = dep.checkContenido(i);
            contenido.setPosition(60-10*i-movProd,5);
        }
    }

    private class PanelListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent event) {
            if(dep.getCantidadContenido()==0) {
                backgrounds[2] = backgrounds[0];
                dep = (Deposito<T>) exp.rellenarDposito(pSelect);
                ActualizarContenido();
                repaint();
            }
        }
        @Override
        public void mouseEntered(MouseEvent event) {
            if(dep.getCantidadContenido()==0) {
                backgrounds[2] = backgrounds[1];
                repaint();
            }
        }
        @Override
        public void mouseExited(MouseEvent event) {
            if(dep.getCantidadContenido()==0) {
                backgrounds[2] = backgrounds[0];
                repaint();
            }
        }
        @Override
        public void mousePressed(MouseEvent arg0) {}
        @Override
        public void mouseReleased(MouseEvent arg0) {}

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgrounds[2], 0, 0, this);
        for(int j=dep.getCantidadContenido()-1;j>=0;j--) {
            dep.checkContenido(j).paintComponent(g, this);
        }
    }
}
