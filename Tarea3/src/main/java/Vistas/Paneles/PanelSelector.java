package Vistas.Paneles;

import Vistas.Boton;
import Vistas.CuadroTexto;

import javax.swing.JPanel;
import java.awt.*;

public class PanelSelector extends JPanel {
    private JPanel[] Paneles;
    public PanelSelector(int x, int y, int width, int height) {
        super(null);
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0,0,0,0));
        Paneles = new JPanel[3];

        for(int i=0; i<3; i++) {
            Paneles[i] = new JPanel();
            Paneles[i].setBackground(new Color(0,0,0,0));
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

    public void crearPantalla(CuadroTexto[] cuadros) {
        cuadros[0] = new CuadroTexto("Codigo: __", Color.BLACK, Color.WHITE, "OCR A Extended");
        cuadros[1] = new CuadroTexto("Pago Ingresado: 0", Color.BLACK, Color.WHITE, "OCR A Extended");
        cuadros[2] = new CuadroTexto(" ", Color.BLACK, Color.WHITE, "OCR A Extended");
        for(int i=0; i<3; i++) {
            Paneles[0].add(cuadros[i]);
        }
    }

    public void addBoton(Boton boton) {
        this.add(boton);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
