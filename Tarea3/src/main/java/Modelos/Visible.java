package Modelos;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface Visible {
    public void setPosition(int x, int y);

    public  void setImage(BufferedImage image);

    public int getSerie();

    public void paintComponent(Graphics g,Component observer);

}
