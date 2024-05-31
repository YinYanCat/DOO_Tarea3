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
    private BufferedImage imgBackground;

    public PanelPrincipal(BorderLayout borderLayout) {
        super(borderLayout);
        int CantidadDeProductos = 5;
        expendedor = new Expendedor(CantidadDeProductos);
        comprador = new Comprador();
        this.setBackground(new Color(99,155, 255));
        this.setLayout(new BorderLayout());
        panelExp = new PanelExpendedor(expendedor);
        panelExp.setPreferredSize(new Dimension(663,720));
        this.add(panelExp, BorderLayout.WEST);
        panelCom = new PanelComprador(comprador);
        panelCom.setPreferredSize(new Dimension(603,720));
        this.add(panelCom, BorderLayout.EAST);

        intermediario = new Intermediario(this, panelCom, panelExp);
        panelExp.setIntermediario(intermediario);
        panelCom.setIntermediario(intermediario);

        try {
            imgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgBackground.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imgBackground, 0, 0, this);
        panelExp.paintComponent(g);
        panelCom.paintComponent(g);
    }
}
