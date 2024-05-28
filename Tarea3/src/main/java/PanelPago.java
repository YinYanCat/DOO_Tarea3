import javax.swing.*;
import java.awt.*;

public class PanelPago extends JPanel {
    JPanel panelDisplay;
    JPanel panelMonedas;

    public PanelPago() {

        this.setLayout(new GridLayout(2, 1, 10, 10));
        this.setBackground(Color.RED);

        panelMonedas = new JPanel();
        panelMonedas.setLayout(new GridLayout(1, 3, 10, 10));
        panelMonedas.setBackground(Color.RED);
        panelMonedas.setBorder(BorderFactory.createMatteBorder(40, 50, 40, 50, Color.RED));
        this.add(panelMonedas);

        panelDisplay = new JPanel();
        panelDisplay.setLayout(new BorderLayout());
        panelDisplay.setBackground(Color.WHITE);
        panelDisplay.setBorder(BorderFactory.createMatteBorder(40, 50, 40, 50, Color.RED));
        this.add(panelDisplay);

    }

    public void addButton(JButton button) {
        panelMonedas.add(button);
    }
    public void addText(JLabel text) {
        panelDisplay.add(text);
    }
}
