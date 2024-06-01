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
    private JPanel[] panelsInv;
    private BufferedImage ImgBackground;
    private Producto invProducto;
    private JPanel panelProducto;
    private Deposito<Moneda> depoMonedas;
    private boolean paintMonedas;
    private JPopupMenu popupSerie;

    public PanelInventario() {
        super(null);
        paintMonedas = false;
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelInventario.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        this.setPreferredSize(new Dimension(249, 720));

        lablesInv = new TextoInventario[5];
        panelsInv = new JPanel[2];

        panelProducto = new JPanel();
        panelProducto.setBackground(new Color(20,20, 68));
        panelProducto.setBounds(30,100,50,100);
        panelProducto.addMouseListener(new PanelListener());

        this.add(panelProducto);
        popupSerie = new JPopupMenu();
        popupSerie.add(new JLabel("holiwis"));
        panelProducto.setComponentPopupMenu(popupSerie);


        lablesInv[0] = new TextoInventario("Producto", new Color(20,20, 68), Color.WHITE);
        lablesInv[0].setBounds(30,75,150,20);
        lablesInv[1] = new TextoInventario("Vuelto Total: 0", new Color(20,20, 68), Color.WHITE);
        lablesInv[1].setBounds(30,221,150,20);
        lablesInv[2] = new TextoInventario("", new Color(20,20, 68), Color.WHITE);
        lablesInv[2].setBounds(30,540,150,20);
        lablesInv[3] = new TextoInventario("Bolsa: 0", new Color(199,199, 199), Color.BLACK);
        lablesInv[3].setBounds(35,616,100,20);
        lablesInv[4] = new TextoInventario("Billetera: 0", new Color(139,108, 88), Color.BLACK);
        lablesInv[4].setBounds(35,688,100,20);

        this.add(lablesInv[0]);
        this.add(lablesInv[1]);
        this.add(lablesInv[2]);
        this.add(lablesInv[3]);
        this.add(lablesInv[4]);




    }

    public void setBilletera(int cantidad) {
        lablesInv[4].setText("Billetera: "+cantidad);
    }

    public void displayProducto(Producto producto, int cantidad) {
        lablesInv[0].setText(producto.sabor());
        lablesInv[3].setText("Bolsa: "+cantidad);
        invProducto = producto;
        invProducto.setPosition(20,100);
        repaint();
    }

    public void displayMonedas(Deposito<Moneda> depoVuelto, int total) {
        int extra = 0;
        lablesInv[2].setText("");
        paintMonedas = true;
        depoMonedas = depoVuelto;
        int i=0;
        for(int j=0; j<depoMonedas.getCantidadContenido(); j++) {
            depoMonedas.checkContenido(j).setPosition(18+28*(j%5),240+100*i);
            if(j%5==4)
                i++;
            if(j>=15)
                extra++;
        }
        lablesInv[1].setText("Vuelto Total: "+total);
        if(extra!=0)
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
            popupSerie.show(e.getComponent(), 0, 80);
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
        if(invProducto!=null)
            invProducto.paintComponent(g, panelProducto);
        if(paintMonedas) {
            for (int i = 0; i < depoMonedas.getCantidadContenido(); i++) {
                depoMonedas.checkContenido(i).paintComponent(g, this);
                if(i==14) {
                    break;
                }
            }
        }
    }
}
