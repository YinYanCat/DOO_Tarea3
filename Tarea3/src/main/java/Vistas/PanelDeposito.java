package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class PanelDeposito<T extends Visible> extends JPanel {

    private Deposito<T> dep;
    private BufferedImage img;
    private BufferedImage background;

    public PanelDeposito(Deposito<T> deposito,BufferedImage imagen) {
        super();
        dep = deposito;
        img = imagen;
        this.setOpaque(false);
        try {
            background = ImageIO.read(getClass().getClassLoader().getResource("imgFondoDepo.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void ActualizarContenido() {
        int movProd = 10*(5-dep.getCantidadContenido());
        for(int i=0;i<dep.getCantidadContenido();i++){
            T contenido = dep.getList().get(i);
            contenido.setPosition(10*i+20+movProd,5);
            contenido.setImage(img);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        ActualizarContenido();
        for(int j=0;j<dep.getCantidadContenido();j++) {
            dep.getList().get(j).paintComponent(g, this);
        }
    }
}
