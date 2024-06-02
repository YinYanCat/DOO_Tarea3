package Vistas;

import Modelos.Deposito;
import Modelos.Moneda;
import Modelos.Producto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelInventario extends JPanel {
    private TextoInventario[] lablesInv;
    private BufferedImage ImgBackground;
    private PanelObjeto panelProducto;
    private PanelObjeto[] panelMoneda;
    private Deposito<Moneda> depoMonedas;
    private JPopupMenu popupSerie;
    private JLabel lSerie;

    public PanelInventario() {
        super(null);
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelInventario.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        this.setPreferredSize(new Dimension(249, 720));
        lablesInv = new TextoInventario[5];

        panelProducto = new PanelObjeto(30,100, 50,100);
        panelProducto.addMouseListener(new PanelListener());
        panelMoneda = new PanelObjeto[15];
        lSerie = new JLabel("");

        this.add(panelProducto);
        popupSerie = new JPopupMenu();
        popupSerie.add(lSerie);
        panelProducto.setComponentPopupMenu(popupSerie);
        int i=0;
        for(int j=0; j<15; j++) {
            panelMoneda[j] = new PanelObjeto(18+28*(j%5),245+100*i,100,100);
            panelMoneda[j].addMouseListener(new PanelListener());
            this.add(panelMoneda[j]);
            if(j%5==4)
                i++;
        }

        lablesInv[0] = new TextoInventario("Producto", new Color(20,20, 68), Color.WHITE);
        lablesInv[0].setBounds(30,75,150,20);
        lablesInv[1] = new TextoInventario("Vuelto Total: 0", new Color(20,20, 68), Color.WHITE);
        lablesInv[1].setBounds(30,215,150,20);
        lablesInv[2] = new TextoInventario("", new Color(20,20, 68), Color.WHITE);
        lablesInv[2].setBounds(30,545,150,20);
        lablesInv[3] = new TextoInventario("Bolsa: 0", new Color(199,199, 199), Color.BLACK);
        lablesInv[3].setBounds(30,616,150,20);
        lablesInv[4] = new TextoInventario("Billetera: 0", new Color(139,108, 88), Color.BLACK);
        lablesInv[4].setBounds(30,688,150,20);

        for(int num=0; num<5; num++) {
            this.add(lablesInv[num]);
        }
    }

    public void setBilletera(int cantidad) {
        lablesInv[4].setText("Billetera: "+cantidad);
    }

    public void displayProducto(Producto producto, int cantidad) {
        lablesInv[0].setText(producto.sabor());
        lablesInv[3].setText("Bolsa: "+cantidad);
        panelProducto.setObjeto(producto);
        repaint();
    }

    public void displayMonedas(Deposito<Moneda> depoVuelto, int total) {
        lablesInv[2].setText("");
        depoMonedas = depoVuelto;
        for(int i=0; i<15; i++) {
            panelMoneda[i].lockPanel();
        }
        for(int j=0; j<depoMonedas.getCantidadContenido(); j++) {
            panelMoneda[j].setObjeto(depoMonedas.checkContenido(j));
            if(j>=14)
                break;
        }
        int extra = depoMonedas.getCantidadContenido()-15;
        lablesInv[1].setText("Vuelto Total: "+total);
        if(extra>0)
            lablesInv[2].setText("+"+extra+" Monedas");
        repaint();
    }

    public void setVueltoText(int num) {
        lablesInv[1].setText("Vuelto Total: "+num);
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
                int y = 0;
                if(lSerie.getText().length()<8)
                    y = 50;
                popupSerie.show(e.getComponent(), 50, y);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            popupSerie.setVisible(false);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }
}
