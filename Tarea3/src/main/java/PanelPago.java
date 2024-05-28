import javax.swing.*;
import java.awt.*;

public class PanelPago extends JPanel {

    public PanelPago() {
        this.setLayout(new GridLayout(1, 3));
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 40));
        this.setBackground(Color.RED);
    }

    public void addButton(JButton button) {
        this.add(button);
    }
}
