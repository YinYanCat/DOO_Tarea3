package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelInventario  extends JPanel {
    private TextoInventario lProducto;
    private TextoInventario lMonedas;
    private TextoInventario lBolsa;
    private TextoInventario lBilletera;
    private JPanel SupPanel;
    private JPanel InfPanel;

    public PanelInventario() {
        super();
        this.setLayout(new GridLayout(2, 1, 50, 50));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setPreferredSize(new Dimension(265, 720));
        this.setBorder(BorderFactory.createMatteBorder(80, 55, 10, 20, new Color(0, 0, 0, 0)));

        SupPanel = new JPanel();
        SupPanel.setLayout(new BorderLayout());
        SupPanel.setBackground(new Color(0, 0, 0, 0));
        SupPanel.setBorder(BorderFactory.createMatteBorder(0, 45, 100, 0, new Color(0, 0, 0, 0)));

        InfPanel = new JPanel();
        InfPanel.setLayout(new BorderLayout());
        InfPanel.setBackground(new Color(0, 0, 0, 0));
        InfPanel.setBorder(BorderFactory.createMatteBorder(185, 0, 0, 60, new Color(0, 0, 0, 0)));

        this.add(SupPanel);
        this.add(InfPanel);
        lProducto = new TextoInventario("Producto", new Color(20,20, 68), Color.WHITE);
        lMonedas = new TextoInventario("Monedas", new Color(20,20, 68), Color.WHITE);
        lBolsa = new TextoInventario("Bolsa: 0", new Color(199,199, 199), Color.BLACK);
        lBilletera = new TextoInventario("Billetera: 0", new Color(139,108, 88), Color.BLACK);
        SupPanel.add(lProducto, BorderLayout.NORTH);
        SupPanel.add(lMonedas, BorderLayout.SOUTH);
        InfPanel.add(lBolsa, BorderLayout.NORTH);
        InfPanel.add(lBilletera, BorderLayout.SOUTH);
    }

    public void setBilletera(int cantidad) {
        lBilletera.setText("Billetera: "+cantidad);
    }
    public void displayProducto(String sabor, int cantidad) {
        lProducto.setText(sabor);
        lBolsa.setText("Bolsa: "+cantidad);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
