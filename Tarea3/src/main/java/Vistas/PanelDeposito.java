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

    public PanelDeposito(Deposito<T> deposito,BufferedImage imagen) {
        super();
        dep = deposito;
        img = imagen;
        this.setOpaque(false);
    }

    public void ActualizarContenido(){
        for(int i=0;i<dep.getCantidadContenido();i++){
            T contenido = dep.getList().get(i);
            contenido.setPosition(10*i,0);
            contenido.setImage(img);

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ActualizarContenido();
        for(int j=0;j<dep.getCantidadContenido();j++) {
            dep.getList().get(j).paintComponent(g, this);
        }

    }


}
