package Vistas;

import javax.swing.*;
import java.awt.*;

public class TextoPantalla extends JLabel {

    public TextoPantalla(String texto) {
        super();
        this.setText(texto);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
    }
}
