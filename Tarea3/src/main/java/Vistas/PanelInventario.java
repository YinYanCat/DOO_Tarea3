package Vistas;

import Modelos.Deposito;
import Modelos.Moneda;
import Modelos.Producto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelInventario  extends JPanel {
    private TextoInventario[] lablesInv;
    private JPanel[] panelsInv;
    private BufferedImage ImgBackground;
    private Producto invProducto;
    private Deposito<Moneda> depoMonedas;
    private boolean paintMonedas;

    public PanelInventario() {
        super();
        paintMonedas = false;
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelInventario.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Color trasnparent = new Color(0, 0, 0, 0);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(249, 720));
        this.setBorder(BorderFactory.createMatteBorder(80, 30, 10, 20, trasnparent));
        lablesInv = new TextoInventario[5];
        panelsInv = new JPanel[2];

        lablesInv[0] = new TextoInventario("Producto", new Color(20,20, 68), Color.WHITE);
        lablesInv[1] = new TextoInventario("Vuelto Total:", new Color(20,20, 68), Color.WHITE);
        lablesInv[2] = new TextoInventario("", new Color(20,20, 68), Color.WHITE);
        lablesInv[3] = new TextoInventario("Bolsa: 0", new Color(199,199, 199), Color.BLACK);
        lablesInv[4] = new TextoInventario("Billetera: 0", new Color(139,108, 88), Color.BLACK);

        for(int i=0; i<2; i++) {
            panelsInv[i] = new JPanel();
            panelsInv[i].setLayout(new GridLayout(2+i, 1,10,110-55*i));
            panelsInv[i].setBackground(new Color(0, 0, 0, 0));
            panelsInv[i].setBorder(BorderFactory.createMatteBorder(0, 5*i, 5*i, 50*i, new Color(0, 0, 0, 0)));
        }
        this.add(panelsInv[0], BorderLayout.NORTH);
        this.add(panelsInv[1], BorderLayout.SOUTH);
        panelsInv[0].add(lablesInv[0]);
        panelsInv[0].add(lablesInv[1]);
        panelsInv[1].add(lablesInv[2]);
        panelsInv[1].add(lablesInv[3]);
        panelsInv[1].add(lablesInv[4]);
    }

    public void setBilletera(int cantidad) {
        lablesInv[4].setText("Billetera: "+cantidad);
    }

    public void displayProducto(Producto producto, int cantidad) {
        lablesInv[0].setText(producto.sabor());
        lablesInv[3].setText("Bolsa: "+cantidad);
        invProducto = producto;
        invProducto.setPosition(30,100);
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
        if(invProducto!=null)
            invProducto.paintComponent(g, this);
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
