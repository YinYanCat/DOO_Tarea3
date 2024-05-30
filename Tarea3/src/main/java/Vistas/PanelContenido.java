package Vistas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class PanelContenido extends JPanel {

    BufferedImage img;
    public PanelContenido(String pathImgCont) {
        try {
            img = ImageIO.read(getClass().getClassLoader().getResource(pathImgCont));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
