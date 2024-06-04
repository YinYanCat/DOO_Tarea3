package Vistas.Paneles;

import Modelos.*;
import Vistas.Intermediario;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador panelCom;
    private PanelExpendedor panelExp;

    public PanelPrincipal(BorderLayout borderLayout) {
        super(borderLayout);
        int CantidadDeProductos = 5;
        this.setBackground(new Color(99,155, 255));
        this.setLayout(new BorderLayout());
        panelExp = new PanelExpendedor(new Expendedor(CantidadDeProductos));
        panelExp.setPreferredSize(new Dimension(663,720));
        this.add(panelExp, BorderLayout.WEST);
        panelCom = new PanelComprador(new Comprador());
        panelCom.setPreferredSize(new Dimension(603,720));
        this.add(panelCom, BorderLayout.EAST);

        Intermediario intermediario = new Intermediario(this, panelCom, panelExp);
        panelExp.setIntermediario(intermediario);
        panelCom.setIntermediario(intermediario);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        panelExp.paintComponent(g);
        panelCom.paintComponent(g);
    }
}
