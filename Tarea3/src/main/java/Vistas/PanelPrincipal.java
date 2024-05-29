package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelPrincipal extends JPanel {
    private PanelComprador panelCom;
    private PanelExpendedor panelExp;
    private Expendedor expendedor;
    private Comprador comprador;

    private Intermediario intermediario;

    private BufferedImage image;

    public PanelPrincipal(BorderLayout borderLayout) {
        super(borderLayout);
        Color transparent = new Color(0,0, 0, 0);
        expendedor = new Expendedor(5);
        comprador = new Comprador();
        this.setBackground(new Color(0,0, 0, 0));
        this.setLayout(new BorderLayout());
        panelExp = new PanelExpendedor(expendedor);
        panelExp.setBackground(transparent);
        panelExp.setPreferredSize(new Dimension(675,720));
        this.add(panelExp, BorderLayout.WEST);
        panelCom = new PanelComprador(comprador);
        panelCom.setBackground(transparent);
        panelCom.setPreferredSize(new Dimension(605,720));
        this.add(panelCom, BorderLayout.EAST);

        intermediario = new Intermediario(panelCom, panelExp);
        panelExp.setIntermediario(intermediario);
        panelCom.setIntermediario(intermediario);

        try {
            image = ImageIO.read(getClass().getClassLoader().getResource("imgBackground.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public PanelExpendedor getPanelExpendedor() {
        return panelExp;
    }

    public Producto VisualizarCompra(int select){
        panelExp.MoverProducto(select);
        Producto p = expendedor.getProducto();
        return p;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        panelExp.paintComponent(g);
        panelCom.paintComponent(g);

    }
}
