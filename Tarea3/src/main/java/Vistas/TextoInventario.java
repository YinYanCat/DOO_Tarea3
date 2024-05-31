package Vistas;

import javax.swing.*;
import java.awt.*;

public class TextoInventario extends JLabel {

    public TextoInventario(String texto, Color bg, Color color) {
        super();
        this.setOpaque(true);
        this.setBackground(bg);
        this.setText(texto);
        this.setForeground(color);
        this.setFont(new Font("Arial", Font.BOLD, 15));
    }
}
