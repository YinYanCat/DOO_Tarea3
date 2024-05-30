package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class PanelDeposito<T> extends JPanel {

    private Deposito<T> dep;
    private BufferedImage imgDep;
    private PanelContenido contenido[];

    int largo;
    public PanelDeposito(Deposito<T> deposito, Rectangle bounds, String pathImgDeposito, String pathImgCont) {
        super(null);
        dep = deposito;
        largo = dep.getCantidadContenido();
        try{
        imgDep = ImageIO.read(getClass().getClassLoader().getResource(pathImgDeposito));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }


        try{
            imgDep = ImageIO.read(getClass().getClassLoader().getResource(pathImgDeposito));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        setBounds(bounds);
    }


    public void paintComponent(Graphics g){

    }
}
