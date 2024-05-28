import javax.swing.*;
import java.awt.*;

public class PanelPago extends JPanel {

    public PanelPago() {
        this.setLayout(new GridLayout(1, 3, 10, 10));
        this.setBorder(BorderFactory.createMatteBorder(80, 40, 80, 40, Color.RED));
        this.setBackground(Color.RED);
    }

    public void addButton(JButton button) {
        this.add(button);
    }
}
