package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelInventario  extends JPanel {
    private TextoInventario lProducto;
    private TextoInventario lMonedas;
    private TextoInventario lBolsa;
    private TextoInventario lBilletera;
    public PanelInventario() {
        super();

        this.setLayout(new GridLayout(4, 1, 50, 50));
        this.setBackground(new Color(0,0, 0, 0));
        this.setPreferredSize(new Dimension(265,720));
        this.setBorder(BorderFactory.createMatteBorder(20, 60, 10, 20, new Color(0,0, 0, 0)));

        lProducto = new TextoInventario("Producto", Color.WHITE);
        lMonedas = new TextoInventario("Monedas", Color.WHITE);
        lBolsa = new TextoInventario("Bolsa", Color.WHITE);
        lBilletera = new TextoInventario("Billetera: 0", Color.BLACK);
        this.add(lProducto);
        this.add(lMonedas);
        this.add(lBolsa);
        this.add(lBilletera);
    }

    public void setBilletera(String text) {
        lBilletera.setText(text);
    }
}
