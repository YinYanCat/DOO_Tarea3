package Vistas.Paneles;

import Modelos.Deposito;
import Modelos.Monedas.Moneda;
import Vistas.CuadroTexto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PanelMonedas extends JPanel {
    private boolean visible;
    private BufferedImage ImgBackground;
    private int[] startPos;
    private ArrayList<PanelObjeto> panelMoneda;
    private CuadroTexto[] lExtraMonedas;

    public PanelMonedas() {
        super(null);
        visible = false;
        startPos = new int [2];
        this.setBounds(30, 80,603,550);
        this.setBackground(new Color(0,0,0,0));
        lExtraMonedas = new CuadroTexto[2];
        for(int i=0; i<2; i++) {
            lExtraMonedas[i] = new CuadroTexto("", new Color(0,0,0,0), Color.WHITE, "Arial");
            lExtraMonedas[i].setBounds(30,510-(430*i),150,20);
            this.add(lExtraMonedas[i]);
        }

        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelMonedas.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        panelMoneda = new ArrayList<>();
    }

    public void togglePanel() {
        visible = !visible;
        for(int i=0; i<panelMoneda.size(); i++) {
            if(visible)
                this.add(panelMoneda.get(i));
            else
                this.remove(panelMoneda.get(i));
            panelMoneda.get(i).togglePanel();
        }
    }

    public boolean getVisible() { return visible; }

    public void setText(String text, int i) {
        if (visible) {
            lExtraMonedas[i].setText(text);
            lExtraMonedas[i].setBackground(new Color(20, 20, 68));
        } else {
            lExtraMonedas[i].setText("");
            lExtraMonedas[i].setBackground(new Color(0, 0, 0, 0));
        }
    }

    public void setMonedas(Deposito<Moneda> depoExp, int total) {
        for(int j = startPos[0]; j<depoExp.getSizeCont(); j++) {
            if(j>=72)
                break;
            panelMoneda.add(new PanelObjeto(12+28*(j%18),110+100* startPos[1],100,100));
            panelMoneda.get(j).setObjeto(depoExp.checkContenido(j));
            this.add(panelMoneda.get(j));
            if(j%18==17)
                startPos[1]++;
        }
        if(depoExp.getSizeCont()-72>0)
            setText("+"+(depoExp.getSizeCont()-72)+" Monedas", 0);
        setText("Total: "+total, 1);
        startPos[0] = depoExp.getSizeCont();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(visible)
            g.drawImage(ImgBackground, 0, 0, this);
    }
}
