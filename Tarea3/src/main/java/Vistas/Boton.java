package Vistas;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {
    public Boton(int width, int height, String filename) {
        super();
        this.setContentAreaFilled(false);
        ImageIcon icono1 = new ImageIcon(getClass().getClassLoader().getResource(filename));
        Image image = icono1.getImage();
        Image newimg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(newimg));
    }
}
