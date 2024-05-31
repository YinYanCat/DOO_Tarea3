package Vistas;

import Modelos.Producto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelInventario  extends JPanel {
    private TextoInventario[] lInventario;
    private JPanel[] pInventario;
    private BufferedImage ImgBackground;
    private Producto invProducto;

    public PanelInventario() {
        super();
        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelInventario.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Color trasnparent = new Color(0, 0, 0, 0);
        this.setLayout(new GridLayout(2, 1, 50, 50));
        this.setPreferredSize(new Dimension(249, 720));
        this.setBorder(BorderFactory.createMatteBorder(80, 30, 10, 20, trasnparent));

        lInventario = new TextoInventario[4];
        pInventario= new JPanel[2];
        lInventario[0] = new TextoInventario("Producto", new Color(20,20, 68), Color.WHITE);
        lInventario[2] = new TextoInventario("Monedas", new Color(20,20, 68), Color.WHITE);
        lInventario[1] = new TextoInventario("Bolsa: 0", new Color(199,199, 199), Color.BLACK);
        lInventario[3] = new TextoInventario("Billetera: 0", new Color(139,108, 88), Color.BLACK);

        for(int i=0; i<2; i++){
            pInventario[i] = new JPanel();
            pInventario[i].setLayout(new BorderLayout());
            pInventario[i].setBackground(new Color(0, 0, 0, 0));
            pInventario[i].setBorder(BorderFactory.createMatteBorder(185*i, 10*i, 140*((i+1)%2), 60*i, trasnparent));
            this.add(pInventario[i]);
            pInventario[i].add(lInventario[i], BorderLayout.NORTH);
            pInventario[i].add(lInventario[i+2], BorderLayout.SOUTH);
        }
    }

    public void setBilletera(int cantidad) {
        lInventario[3].setText("Billetera: "+cantidad);
    }

    public void displayProducto(Producto producto, int cantidad) {
        lInventario[0].setText(producto.sabor());
        lInventario[1].setText("Bolsa: "+cantidad);
        invProducto = producto;
        invProducto.setPosition(30,100);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
        if(invProducto!=null)
            invProducto.paintComponent(g, this);
    }
}
