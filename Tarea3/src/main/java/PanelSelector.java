import javax.swing.*;
import java.awt.*;

public class PanelSelector  extends JPanel {

    JPanel panelDisplay;
    JPanel panelNumberPad;
    JPanel panelOptions;

    public PanelSelector() {

        Color darkRED = new Color(160,0, 0);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.RED);

        panelNumberPad = new JPanel();
        panelNumberPad.setLayout(new GridLayout(2, 2, 10, 10));
        panelNumberPad.setBackground(darkRED);
        panelNumberPad.setBorder(BorderFactory.createMatteBorder(50, 40, 50, 20, darkRED));
        this.add(panelNumberPad, BorderLayout.CENTER);

        panelOptions = new JPanel();
        panelOptions.setLayout(new GridLayout(2, 1, 10, 10));
        panelOptions.setBackground(darkRED);
        panelOptions.setBorder(BorderFactory.createMatteBorder(50, 20, 50, 40, darkRED));
        this.add(panelOptions, BorderLayout.EAST);

        panelDisplay = new JPanel();
        panelDisplay.setLayout(new GridLayout(3, 1));
        panelDisplay.setBackground(Color.BLACK);
        panelDisplay.setBorder(BorderFactory.createMatteBorder(30, 20, 30, 20, Color.RED));
        this.add(panelDisplay, BorderLayout.NORTH);
    }

    public void addButton(JButton button, int panel) {
        switch(panel) {
            case 1:
                panelNumberPad.add(button);
                break;
            case 2:
                panelOptions.add(button);
                break;
        }
    }
    public void addText(TextoPantalla text) {
        panelDisplay.add(text);
    }
}
