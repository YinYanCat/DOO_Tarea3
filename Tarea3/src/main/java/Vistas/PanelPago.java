package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelPago extends JPanel {
    private JPanel panelRetiro;
    private JPanel panelMonedas;

    public PanelPago() {
        super();
        Color transparent = new Color(0,0, 0, 0);
        this.setLayout(new GridLayout(2, 1, 10, 10));
        this.setBackground(transparent);
        this.setPreferredSize(new Dimension(354,360));

        panelMonedas = new JPanel();
        panelMonedas.setLayout(new GridLayout(1, 3, 8, 8));
        panelMonedas.setBackground(transparent);
        panelMonedas.setPreferredSize(new Dimension(354,177));
        panelMonedas.setBorder(BorderFactory.createMatteBorder(61, 22, 16, 16, transparent));
        this.add(panelMonedas);

        panelRetiro = new JPanel();
        panelRetiro.setLayout(new BorderLayout());
        panelRetiro.setBackground(transparent);
        panelRetiro.setPreferredSize(new Dimension(354,184));
        panelRetiro.setBorder(BorderFactory.createMatteBorder(75, 194, 40, 38, transparent));
        this.add(panelRetiro);
    }

    public void addButton(JButton button) {
        panelMonedas.add(button);
    }
    public void addRetirar(JButton button) {
        panelRetiro.add(button);
    }
}
