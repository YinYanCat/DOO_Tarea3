package Vistas;

import Modelos.Producto;
import Modelos.Visible;

import javax.swing.*;
import java.awt.*;

public class PanelObjeto <T extends Visible> extends JPanel {

    private T objeto;
    private boolean paintPanel;

    public PanelObjeto(int x, int y, int width, int height) {
        super();
        paintPanel = false;
        this.setBackground(new Color(0,0,0,0));
        this.setBounds(x, y, width, height);
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
        this.objeto.setPosition(0,0);
        paintPanel = true;
    }

    public void lockPanel() {
        paintPanel = false;
    }

    public boolean getPaint() { return paintPanel; }
    public T getObjeto() { return objeto; }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(paintPanel)
            objeto.paintComponent(g, this);
    }
}
