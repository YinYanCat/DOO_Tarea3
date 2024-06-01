package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelDeposito<T extends Visible> extends JPanel {
    private Deposito<T> dep;
    private Class<T> type;
    private BufferedImage img;
    private BufferedImage background;
    private String depoTEXT;
    private int pSelect;
    private Expendedor exp;

    public PanelDeposito(Deposito<T> deposito, BufferedImage imagen, int select, Expendedor expendedor) {
        super(null);
        pSelect = select;
        depoTEXT = "Prod "+select;
        dep = deposito;
        type = (Class<T>) dep.checkContenido(0).getClass();
        exp = expendedor;
        img = imagen;
        this.setOpaque(false);
        try {
            background = ImageIO.read(getClass().getClassLoader().getResource("imgFondoDepo.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        PanelListener listener = new PanelListener();
        this.addMouseListener(listener);
        for(int i=0;i<dep.getCantidadContenido();i++){
            T contenido = dep.checkContenido(i);
            contenido.setPosition(10*i+20,5);
            contenido.setImage(img);
        }
    }

    public void ActualizarContenido() {
        int movProd = 10*(5-dep.getCantidadContenido());
        for(int i=0;i<dep.getCantidadContenido();i++){
            T contenido = dep.checkContenido(i);
            contenido.setPosition(10*i+20+movProd,5);
            contenido.setImage(img);
        }
    }

    private class PanelListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent event) {
            if(dep.getCantidadContenido()==0) {
                dep = (Deposito<T>) exp.rellenarDposito(pSelect);
                ActualizarContenido();
                repaint();
            }
        }
        @Override
        public void mouseEntered(MouseEvent arg0) {}
        @Override
        public void mouseExited(MouseEvent arg0) {}
        @Override
        public void mousePressed(MouseEvent arg0) {}
        @Override
        public void mouseReleased(MouseEvent arg0) {}

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        for(int j=0;j<dep.getCantidadContenido();j++) {
            dep.checkContenido(j).paintComponent(g, this);
        }
    }
}
