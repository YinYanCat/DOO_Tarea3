package Vistas;

import Modelos.Deposito;
import Modelos.Moneda;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelMonedas extends JPanel {
    private boolean visible;
    private BufferedImage ImgBackground;
    private Deposito<Moneda> depoMonedas;
    private int starXPosition;
    private int starYPosition;

    public PanelMonedas() {
        visible = false;
        starXPosition = 0;
        starYPosition = 0;
        this.setBounds(30, 100,603,525);
        this.setBackground(new Color(0,0,0,0));
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelMonedas.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void togglePanel() {
        visible = !visible;
    }

    public void setMonedas(Deposito<Moneda> depoExp) {
        depoMonedas = depoExp;
        for(int j=starXPosition; j<depoMonedas.getCantidadContenido(); j++) {
            depoMonedas.checkContenido(j).setPosition(12+28*(j%18),75+100*starYPosition);
            if(j%18==17)
                starYPosition++;
        }
        starXPosition = depoMonedas.getCantidadContenido();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(visible){
            g.drawImage(ImgBackground, 0, 0, this);
            for (int i = 0; i < depoMonedas.getCantidadContenido(); i++) {
                depoMonedas.checkContenido(i).paintComponent(g, this);
                if(i==71) {
                    break;
                }
            }
        }
    }
}
