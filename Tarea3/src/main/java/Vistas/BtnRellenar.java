package Vistas;

import javax.swing.*;

public class BtnRellenar extends JButton {

    private final int width;
    private final int height;

    public BtnRellenar(int width, int height){
        this.width=width;
        this.height=height;
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
        this.setBounds(0,0,this.width,this.height);
    }
}
