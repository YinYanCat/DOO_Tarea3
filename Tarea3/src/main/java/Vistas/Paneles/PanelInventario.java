package Vistas.Paneles;

import Modelos.Deposito;
import Modelos.Monedas.Moneda;
import Modelos.Producto;
import Vistas.CuadroTexto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelInventario extends JPanel {
    private CuadroTexto[] lablesInv;
    private BufferedImage ImgBackground;
    private PanelObjeto panelProducto;
    private PanelObjeto[] panelMoneda;
    private Deposito<Moneda> depoMonedas;

    public PanelInventario() {
        super(null);
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelInventario.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        this.setPreferredSize(new Dimension(249, 720));
        this.setBackground(new Color(20,20, 68));
        lablesInv = new CuadroTexto[5];
        panelProducto = new PanelObjeto(30,100, 50,100);
        panelMoneda = new PanelObjeto[15];

        this.add(panelProducto);
        int i=0;
        for(int j=0; j<15; j++) {
            panelMoneda[j] = new PanelObjeto(18+28*(j%5),245+100*i,100,100);
            this.add(panelMoneda[j]);
            if(j%5==4)
                i++;
        }

        lablesInv[0] = new CuadroTexto("Producto", new Color(20,20, 68), Color.WHITE, "Arial");
        lablesInv[0].setBounds(30,75,150,20);
        lablesInv[1] = new CuadroTexto("Vuelto Total: 0", new Color(20,20, 68), Color.WHITE, "Arial");
        lablesInv[1].setBounds(30,215,150,20);
        lablesInv[2] = new CuadroTexto("", new Color(20,20, 68), Color.WHITE, "Arial");
        lablesInv[2].setBounds(30,545,150,20);
        lablesInv[3] = new CuadroTexto("Bolsa: 0", new Color(199,199, 199), Color.BLACK, "Arial");
        lablesInv[3].setBounds(30,616,150,20);
        lablesInv[4] = new CuadroTexto("Billetera: 0", new Color(139,108, 88), Color.BLACK, "Arial");
        lablesInv[4].setBounds(30,690,150,20);

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }
}
