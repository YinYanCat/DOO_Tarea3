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
    private Intermediario intermediario;

    public PanelPrincipal(BorderLayout borderLayout) {
        super(borderLayout);
        int CantidadDeProductos = 5;
        Comprador comprador = new Comprador();
        this.setBackground(new Color(99,155, 255));
        this.setLayout(new BorderLayout());
        panelExp = new PanelExpendedor(new Expendedor(CantidadDeProductos));
        panelExp.setPreferredSize(new Dimension(663,720));
        this.add(panelExp, BorderLayout.WEST);
        panelCom = new PanelComprador(comprador);
        panelCom.setPreferredSize(new Dimension(603,720));
        this.add(panelCom, BorderLayout.EAST);

        intermediario = new Intermediario(this, panelCom, panelExp);
        panelExp.setIntermediario(intermediario);
        panelCom.setIntermediario(intermediario);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        panelExp.paintComponent(g);
        panelCom.paintComponent(g);
    }
}
