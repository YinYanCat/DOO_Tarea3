package Vistas;

import Modelos.Deposito;
import Modelos.Moneda;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PanelMonedas extends JPanel {
    private boolean visible;
    private BufferedImage ImgBackground;
    private int starPosition[];
    private int extraMonedas;
    private ArrayList<PanelObjeto> panelMoneda;
    private TextoInventario lExtraMonedas;
    private JPopupMenu popupSerie;
    private JLabel lSerie;

    public PanelMonedas() {
        super(null);
        visible = false;
        starPosition = new int [2];
        extraMonedas = 0;
        this.setBounds(30, 100,603,525);
        this.setBackground(new Color(0,0,0,0));
        lExtraMonedas = new TextoInventario("", new Color(0,0,0,0), Color.WHITE);
        //this.add(lExtraMonedas, BorderLayout.SOUTH);
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelMonedas.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        panelMoneda = new ArrayList<>();
        lSerie = new JLabel("");
        popupSerie = new JPopupMenu();
        popupSerie.add(lSerie);
    }

    public void togglePanel() {
        visible = !visible;
        togglePanels();
        for(int i=0; i<panelMoneda.size(); i++) {
            panelMoneda.get(i).togglePanel();
        }
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
        for(int j=starPosition[0]; j<depoExp.getCantidadContenido(); j++) {
            panelMoneda.add(new PanelObjeto(12+28*(j%18),75+100*starPosition[1],100,100));
            panelMoneda.get(j).addMouseListener(new PanelListener());
            panelMoneda.get(j).setObjeto(depoExp.checkContenido(j));
            this.add(panelMoneda.get(j));
            if(j%18==17)
                starPosition[1]++;
            if(j>=72)
                break;
        }
        starPosition[0] = depoExp.getCantidadContenido();
        //setExtraText(extraMonedas);
        repaint();
    }

    public void togglePanels() {
        for(int i=0; i<panelMoneda.size(); i++) {
            if(visible)
                this.add(panelMoneda.get(i));
            else
                this.remove(panelMoneda.get(i));
        }
    }

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
            PanelObjeto auxPanel = (PanelObjeto)e.getSource();
            if(auxPanel.getPaint()) {
                lSerie.setText(" "+auxPanel.getObjeto().getSerie()+" ");
                popupSerie.show(e.getComponent(), 50,0);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(((PanelObjeto)e.getSource()).getPaint()) {
                popupSerie.setVisible(false);
                repaint();
            }

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(visible)
            g.drawImage(ImgBackground, 0, 0, this);
    }
}
