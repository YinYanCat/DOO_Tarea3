import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel {

    JRadioButton Button1;
    JRadioButton Button2;
    JRadioButton Button3;
    JRadioButton Button4;
    JRadioButton Button5;
    JRadioButton Button6;
    JRadioButton Button7;
    JRadioButton Button8;
    JRadioButton Button9;
    JRadioButton Button10;
    JRadioButton Button11;
    JRadioButton Button12;
    JButton bComprar;

    public PanelComprador() {
        this.setLayout(new GridLayout(4, 4));
        Button1 = new JRadioButton("CocaCola");
        Button2 = new JRadioButton("Fanta");
        Button3 = new JRadioButton("Sprite");
        Button4 = new JRadioButton("Bilz");
        Button5 = new JRadioButton("Pap");
        Button6 = new JRadioButton("Kem");
        Button7 = new JRadioButton("Snickers");
        Button8 = new JRadioButton("Super8");
        Button9 = new JRadioButton("Flipy");
        Button10 = new JRadioButton("Dulce1");
        Button11 = new JRadioButton("Dulce2");
        Button12 = new JRadioButton("Dulce3");

        ButtonGroup buttongrp = new ButtonGroup();
        buttongrp.add(Button1);
        buttongrp.add(Button2);
        buttongrp.add(Button3);
        buttongrp.add(Button4);
        buttongrp.add(Button5);
        buttongrp.add(Button6);
        buttongrp.add(Button7);
        buttongrp.add(Button8);
        buttongrp.add(Button9);
        buttongrp.add(Button10);
        buttongrp.add(Button11);
        buttongrp.add(Button12);

        this.add(Button1);
        this.add(Button2);
        this.add(Button3);
        this.add(Button4);
        this.add(Button5);
        this.add(Button6);
        this.add(Button7);
        this.add(Button8);
        this.add(Button9);
        this.add(Button10);
        this.add(Button11);
        this.add(Button12);

        bComprar = new JButton("Comprar");
        bComprar.addActionListener(new ComprarProducto());
        this.add(bComprar);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    private class ComprarProducto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Button1.isSelected()) {
                System.out.println("CocaCola");
            }
            else if (Button2.isSelected()) {
                System.out.println("Fanta");
            }
            else if (Button3.isSelected()) {
                System.out.println("Sprite");
            }
            else if (Button4.isSelected()) {
                System.out.println("Bilz");
            }
            else if (Button5.isSelected()) {
                System.out.println("Pap");
            }
            else if (Button6.isSelected()) {
                System.out.println("Kem");
            }
            else if (Button7.isSelected()) {
                System.out.println("Snickers");
            }
            else if (Button8.isSelected()) {
                System.out.println("Super8");
            }
            else if (Button9.isSelected()) {
                System.out.println("Flipy");
            }
            else if (Button10.isSelected()) {
                System.out.println("Dulce1");
            }
            else if (Button11.isSelected()) {
                System.out.println("Dulce2");
            }
            else {
                System.out.println("Dulce3");
            }
        }
    }
}
