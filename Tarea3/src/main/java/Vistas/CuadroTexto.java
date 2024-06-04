package Vistas;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class CuadroTexto extends JLabel {

    public CuadroTexto(String texto, Color bg, Color color, String fuente) {
        super();
        this.setOpaque(true);
        this.setBackground(bg);
        this.setText(texto);
        this.setForeground(color);
        this.setFont(new Font(fuente, Font.BOLD, 15));
    }
}
