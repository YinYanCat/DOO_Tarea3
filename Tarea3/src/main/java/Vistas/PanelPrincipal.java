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

    private BufferedImage image;

    public PanelPrincipal(BorderLayout borderLayout) {
        super(borderLayout);
        Color transparent = new Color(0,0, 0, 0);
        expendedor = new Expendedor(5);
        comprador = new Comprador();

        this.setBackground(new Color(0,0, 0, 0));
        this.setLayout(new BorderLayout());
        panelExp = new PanelExpendedor();
        panelExp.setBackground(transparent);
        panelExp.setPreferredSize(new Dimension(675,720));
        this.add(panelExp, BorderLayout.WEST);
        panelCom = new PanelComprador(comprador, expendedor);
        panelCom.setBackground(transparent);
        panelCom.setPreferredSize(new Dimension(605,720));
        this.add(panelCom, BorderLayout.EAST);
        try {
            image = ImageIO.read(getClass().getClassLoader().getResource("imgExpendedor.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        panelExp.paintComponent(g);
        panelCom.paintComponent(g);

    }
}
