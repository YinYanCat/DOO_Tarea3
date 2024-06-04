package Vistas;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {
    private String filename;
    public Boton(Color color, boolean border, String filename) {
        super();
        this.setBackground(color);
        this.setBorderPainted(border);
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(filename)));
        this.filename = filename;
    }

    public void changeImage(String filename) {
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(filename)));
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
