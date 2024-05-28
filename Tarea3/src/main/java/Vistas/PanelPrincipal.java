package Vistas;

import Modelos.*;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador panelCom;
    private PanelExpendedor panelExp;

    private Expendedor expendedor;
    private Comprador comprador;


    public PanelPrincipal(BorderLayout borderLayout) {
        super(borderLayout);

        expendedor = new Expendedor(5);
        comprador = new Comprador();

        this.setBackground(Color.lightGray);
        this.setLayout(new BorderLayout());
        panelExp = new PanelExpendedor();
        panelExp.setBackground(Color.lightGray);
        this.add(panelExp, BorderLayout.CENTER);
        panelCom = new PanelComprador(comprador, expendedor);
        panelCom.setBackground(Color.lightGray);
        panelCom.setPreferredSize(new Dimension(350,720));
        this.add(panelCom, BorderLayout.EAST);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        panelExp.paintComponent(g);
        panelCom.paintComponent(g);

    }
}
