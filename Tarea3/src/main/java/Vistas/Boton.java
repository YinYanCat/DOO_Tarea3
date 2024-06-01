package Vistas;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {
    public Boton(Color color, boolean border, String filename) {
        super();
        this.setBackground(color);
        this.setBorderPainted(border);
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(filename)));
    }

    public void changeImage(String filename) {
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(filename)));
    }
}
