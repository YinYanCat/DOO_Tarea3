package Vistas;

import javax.swing.*;
import java.awt.*;

public class TextoInventario extends JLabel {

    public TextoInventario(String texto, Color color) {
        super();
        this.setOpaque(true);
        this.setBackground(new Color(0,0, 0, 0));
        this.setText(texto);
        this.setForeground(color);
        this.setFont(new Font("Arial", Font.BOLD, 15));
    }
}
