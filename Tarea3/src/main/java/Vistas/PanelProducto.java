package Vistas;

import Modelos.Deposito;
import Modelos.Producto;
import Modelos.Visible;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelProducto <T extends Visible> extends JPanel {

    private Deposito<Producto> dep;
    private BufferedImage img;
    private boolean paintPanel;
    int xPos;
    int yPos;

    public PanelProducto() {
        super();
        xPos=0;
        yPos=0;
        paintPanel = false;
        this.setBackground(new Color(0,0,0,0));
        this.setBounds(0, 0,50,100);
    }

    public void setParametros(Deposito<Producto> deposito, BufferedImage imagen, int coord) {
        dep = deposito;
        img = imagen;
        xPos = 100+151*(coord%4);
        yPos = 45+165*(coord-coord%4)/4;
        Producto contenido = dep.checkContenido(0);
        this.setLocation(xPos, yPos);
        contenido.setPosition(0,0);
        contenido.setImage(img);
        paintPanel = true;
    }

    public void caidaProducto() {
        do {
            this.setLocation(xPos, yPos+=50);
            repaint();
        } while (yPos > 757);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(paintPanel)
            dep.checkContenido(0).paintComponent(g, this);
    }
}
