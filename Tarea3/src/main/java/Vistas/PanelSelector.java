package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelSelector  extends JPanel {

    private JPanel panelDisplay;
    private JPanel panelNumberPad;
    private JPanel panelOptions;

    public PanelSelector() {
        super();
        Color transparent = new Color(0,0, 0, 0);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0,0, 0, 0));
        this.setPreferredSize(new Dimension(354,360));

        panelNumberPad = new JPanel();
        panelNumberPad.setBackground(transparent);
        panelNumberPad.setLayout(new GridLayout(2, 2, 10, 10));
        panelNumberPad.setPreferredSize(new Dimension(181,215));
        panelNumberPad.setBorder(BorderFactory.createMatteBorder(42, 36, 43, 15, transparent));
        this.add(panelNumberPad, BorderLayout.CENTER);

        panelOptions = new JPanel();
        panelOptions.setBackground(transparent);
        panelOptions.setLayout(new GridLayout(2, 1, 10, 10));
        panelOptions.setPreferredSize(new Dimension(172,215));
        panelOptions.setBorder(BorderFactory.createMatteBorder(42, 16, 43, 36, transparent));
        this.add(panelOptions, BorderLayout.EAST);

        panelDisplay = new JPanel();
        panelDisplay.setBackground(transparent);
        panelDisplay.setLayout(new GridLayout(3, 1));
        panelDisplay.setPreferredSize(new Dimension(354,145));
        panelDisplay.setBorder(BorderFactory.createMatteBorder(30, 30, 30, 20, transparent));
        this.add(panelDisplay, BorderLayout.NORTH);
    }

    public void addNumPadButton(JButton button) {
        panelNumberPad.add(button);
    }
    public void addVueltoButton(JButton button) {
        panelOptions.add(button);
    }

    public void addText(TextoPantalla text) {
        panelDisplay.add(text);
    }
}
