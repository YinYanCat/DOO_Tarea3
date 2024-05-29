package Vistas;

import javax.swing.*;
import java.awt.*;

public class TextoBilletera extends JLabel {

    public TextoBilletera(String texto) {
        super();
        this.setOpaque(true);
        this.setBackground(new Color(139,108,88));
        this.setText(texto);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.BOLD, 15));
    }
}
