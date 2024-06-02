package Vistas;

import Modelos.Producto;
import Modelos.Visible;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelObjeto <T extends Visible> extends JPanel {

    private T objeto;
    private boolean paintPanel;
    private JLabel lSerie;
    private JPopupMenu popupSerie;
    private PanelObjeto pointerThis;
    private int yOffSet;

    public PanelObjeto(int x, int y, int width, int height) {
        super();
        this.setBackground(new Color(0,0,0,0));
        this.setBounds(x, y, width, height);
        this.addMouseListener(new PanelListener());
        pointerThis = this;
        lSerie = new JLabel();
        paintPanel = false;
        popupSerie = new JPopupMenu();
        popupSerie.setBackground(Color.WHITE);
        popupSerie.add(lSerie);
        yOffSet = 0;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
        this.objeto.setPosition(0,0);
        lSerie.setText(" "+objeto.getSerie()+" ");
        paintPanel = true;
        if(lSerie.getText().length()<8)
            yOffSet = 50;
    }

    public void lockPanel() {
        paintPanel = false;
    }
    public void togglePanel() {
        paintPanel = !paintPanel;
    }

    public boolean getPaint() { return paintPanel; }
    public T getObjeto() { return objeto; }

    private class PanelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(paintPanel) {
                popupSerie.setVisible(true);
                popupSerie.show(pointerThis, 50, yOffSet);
                repaint();
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(popupSerie.isVisible()) {
                popupSerie.setVisible(false);
                repaint();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(paintPanel)
            objeto.paintComponent(g, this);
    }
}
