package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelPago extends JPanel {
    JPanel panelDisplay;
    JPanel panelMonedas;

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
        panelMonedas.setBorder(BorderFactory.createMatteBorder(61, 19, 16, 19, transparent));
        this.add(panelMonedas);

        panelDisplay = new JPanel();
        panelDisplay.setLayout(new BorderLayout());
        panelDisplay.setBackground(transparent);
        panelMonedas.setPreferredSize(new Dimension(354,184));
        panelDisplay.setBorder(BorderFactory.createMatteBorder(40, 50, 40, 50, transparent));
        this.add(panelDisplay);

    }

    public void addButton(JButton button) {
        panelMonedas.add(button);
    }
    public void addText(JLabel text) {
        panelDisplay.add(text);
    }
}
