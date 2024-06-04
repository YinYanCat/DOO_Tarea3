package Vistas.Paneles;

import Vistas.Boton;
import Vistas.CuadroTexto;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelSelector extends JPanel {
    private JPanel[] Paneles;
    private CuadroTexto[] lPantalla;
    private BufferedImage[] ImgUse;
    private boolean[] ImgDisplay;

    public PanelSelector(int x, int y, int width, int height) {
        super(null);
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0,0,0,0));
        Paneles = new JPanel[3];
        lPantalla = new CuadroTexto[3];
        ImgUse = new BufferedImage[5];
        ImgDisplay = new boolean[2];

        try {
            ImgUse[0] = ImageIO.read(getClass().getClassLoader().getResource("imgVuelto.png"));
            ImgUse[1] = ImageIO.read(getClass().getClassLoader().getResource("imgPush.png"));
            ImgUse[3] = ImageIO.read(getClass().getClassLoader().getResource("imgPushMarco.png"));
            ImgUse[4] = ImageIO.read(getClass().getClassLoader().getResource("imgPanelComprador.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        lPantalla[0] = new CuadroTexto("Codigo: __", Color.BLACK, Color.WHITE, "OCR A Extended");
        lPantalla[1] = new CuadroTexto("Pago Ingresado: 0", Color.BLACK, Color.WHITE, "OCR A Extended");
        lPantalla[2] = new CuadroTexto(" ", Color.BLACK, Color.WHITE, "OCR A Extended");

        for(int i=0; i<3; i++) {
            Paneles[i] = new JPanel();
            Paneles[i].setBackground(new Color(0,0,0,0));
            Paneles[0].add(lPantalla[i]);
            this.add(Paneles[i]);
        }
        Paneles[0].setLayout(new GridLayout(3, 1));
        Paneles[0].setBounds(20,30,312,84);
        Paneles[1].setLayout(new GridLayout(2, 2, 10, 10));
        Paneles[1].setBounds(36,187,130,130);
        Paneles[2].setLayout(new GridLayout(1, 3, 10, 10));
        Paneles[2].setBounds(17,421,318,100);
    }

    public void crearNumPad(Boton[] NumPad) {
        for(int i=0; i<4; i++) {
            NumPad[i] = new Boton(Color.BLACK,true,"imgBoton"+(i+1)+".png");
            Paneles[1].add(NumPad[i]);
        }
    }

    public void crearSelectMonedas(Boton[] MonedasPad) {
        for(int i=0; i<3; i++) {
            MonedasPad[i] = new Boton(new Color(133,170, 215),false,"imgMoneda"+i+".png");
            Paneles[2].add(MonedasPad[i]);
        }
    }

    public void setImageProduct(BufferedImage image) {
        ImgUse[2] = image;
    }

    public void setCaseVisible(int setCase, boolean visible) {
        ImgDisplay[setCase] = visible;
    }

    public void setPantalla(int Pantalla, String texto) {
        lPantalla[Pantalla].setText(texto);
    }

    public void addBoton(Boton boton) {
        this.add(boton);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgUse[4],0,0,this);
        if(ImgDisplay[0])
            g.drawImage(ImgUse[0],197,257,this);
        if(ImgDisplay[1]) {
            g.drawImage(ImgUse[1], 30, 596, this);
            g.drawImage(ImgUse[2], 70, 636, this);
            g.drawImage(ImgUse[3], 30, 596, this);
        }
    }
}
