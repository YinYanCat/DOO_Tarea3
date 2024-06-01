package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class PanelDeposito<T extends Visible> extends JPanel {

    private Deposito<T> dep;

    private Class<T> type;
    private BufferedImage img;
    private BufferedImage background;

    public PanelDeposito(Deposito<T> deposito,BufferedImage imagen) {
        super(null);
        dep = deposito;
        type = (Class<T>) dep.checkContenido(0).getClass();
        img = imagen;
        this.setOpaque(false);
        try {
            background = ImageIO.read(getClass().getClassLoader().getResource("imgFondoDepo.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        BtnRellenar bRelleno = new BtnRellenar(130,105);
        bRelleno.addActionListener(new EscucharRelleno());
        this.add(bRelleno);
    }

    public void ActualizarContenido() {
        int movProd = 10*(5-dep.getCantidadContenido());
        for(int i=0;i<dep.getCantidadContenido();i++){
            T contenido = dep.checkContenido(i);
            contenido.setPosition(10*i+20+movProd,5);
            contenido.setImage(img);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        ActualizarContenido();
        for(int j=0;j<dep.getCantidadContenido();j++) {
            dep.checkContenido(j).paintComponent(g, this);
        }
    }

    private class EscucharRelleno implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                dep.addContenido(type.newInstance());
            } catch (InstantiationException | IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
