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
    private int starPosition[];
    private int extraMonedas;
    private TextoInventario lExtraMonedas;

    public PanelMonedas() {
        visible = false;
        starPosition = new int [2];
        extraMonedas = 0;
        this.setLayout(new BorderLayout());
        this.setBounds(30, 100,603,525);
        this.setBackground(new Color(0,0,0,0));
        this.setBorder(BorderFactory.createMatteBorder(0, 40, 20, 40, new Color(0,0,0,0)));
        lExtraMonedas = new TextoInventario("", new Color(0,0,0,0), Color.WHITE);
        this.add(lExtraMonedas, BorderLayout.SOUTH);
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelMonedas.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void togglePanel() {
        visible = !visible;
    }

    public void setExtraText(int extra) {
        if(visible && extra>0) {
            lExtraMonedas.setText("+" + extra + " Monedas");
            lExtraMonedas.setBackground(new Color(20,20, 68));
        } else {
            lExtraMonedas.setText("");
            lExtraMonedas.setBackground(new Color(0,0,0,0));
        }
    }

    public void setMonedas(Deposito<Moneda> depoExp) {
        depoMonedas = depoExp;
        for(int j=starPosition[0]; j<depoMonedas.getCantidadContenido(); j++) {
            depoMonedas.checkContenido(j).setPosition(12+28*(j%18),75+100*starPosition[1]);
            if(j%18==17)
                starPosition[1]++;
            if(j>=72)
                extraMonedas++;
        }
        starPosition[0] = depoMonedas.getCantidadContenido();
        setExtraText(extraMonedas);
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
