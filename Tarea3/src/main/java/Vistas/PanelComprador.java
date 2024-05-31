package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelComprador extends JPanel {
    private Boton[] NumPad;
    private Boton[] bMonedas;
    private Boton bVuelto;
    private Boton bGetProducto;
    private BufferedImage ImgBackground;
    private TextoPantalla[] lPantalla;
    private int select;
    private Comprador comprador;
    private PanelInventario panelInv;
    private Intermediario inter;

    public PanelComprador(Comprador comprador) {
        this.comprador = comprador;
        NumPad = new Boton[4];
        bMonedas = new Boton[3];
        lPantalla = new TextoPantalla[3];
        select = 0;

        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelComprador.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        this.setLayout((new BorderLayout()));
        InteraccionSelector listenerCompra = new InteraccionSelector();
        InteraccionExpendedor listenerMoneda = new InteraccionExpendedor();
        PanelSelector panelSelector = new PanelSelector();
        PanelPago panelPago = new PanelPago();
        panelInv = new PanelInventario();

        JPanel subPanel = new JPanel();
        subPanel.setBackground(new Color(0,0, 0, 0));
        subPanel.setLayout(new GridLayout(2, 1));
        subPanel.setPreferredSize(new Dimension(354,720));

        for(int i=0; i<4; i++) {
            NumPad[i] = new Boton(Color.BLACK,true,"imgBoton"+(i+1)+".png");
            NumPad[i].addActionListener(listenerCompra);
            panelSelector.addNumPadButton(NumPad[i]);
        }

        lPantalla[0] = new TextoPantalla("Codigo: __");
        lPantalla[1] = new TextoPantalla("Pago Ingresado: 0");
        lPantalla[2] = new TextoPantalla(" ");

        for(int i=0; i<3; i++) {
            bMonedas[i] = new Boton(new Color(133,170, 215),false,"imgMoneda"+(i+1)+".png");
            bMonedas[i].addActionListener(listenerMoneda);
            panelPago.addButton(bMonedas[i]);
            panelSelector.addText(lPantalla[i]);
        }

        bVuelto = new Boton(Color.BLACK,true,"imgBotonVuelto.png");
        bGetProducto = new Boton(Color.BLACK,true,"imgBotonProducto.png");
        panelSelector.addVueltoButton(bVuelto);
        panelPago.addRetirar(bGetProducto);

        bGetProducto.addActionListener(listenerMoneda);
        bVuelto.addActionListener(listenerMoneda);

        subPanel.add(panelSelector);
        subPanel.add(panelPago);
        this.add(subPanel, BorderLayout.WEST);
        this.add(panelInv, BorderLayout.EAST);
    }

    private class InteraccionSelector implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Seleccion compra = null;
            //Crear metodo Encontrar serie en Enum Seleccion para facilitar y permitir reutilizacion de codigo
            if(e.getSource()==NumPad[0]) {
                select = 1+select*10;
                if(select == 11)
                    compra = Seleccion.Snickers;
                else if(select == 21)
                    compra = Seleccion.Trencito;
                else if(select == 31)
                    compra = Seleccion.CocaCola;
                else if(select == 41)
                    compra = Seleccion.Bilz;
            }
            else if(e.getSource()==NumPad[1]) {
                select = 2+select*10;
                if(select == 12)
                    compra = Seleccion.Super8;
                else if(select == 22)
                    compra = Seleccion.Doblon;
                else if(select == 32)
                    compra = Seleccion.Sprite;
                else if(select == 42)
                    compra = Seleccion.Pap;
            }
            else if(e.getSource()==NumPad[2]) {
                select = 3+select*10;
                if(select == 13)
                    compra = Seleccion.Rolls;
                else if(select == 23)
                    compra = Seleccion.Flipy;
                else if(select == 33)
                    compra = Seleccion.Fanta;
                else if(select == 43)
                    compra = Seleccion.Kem;
            }
            else {
                select = 4+select*10;
                if(select == 14)
                    compra = Seleccion.SahneNuss;
                else if(select == 24)
                    compra = Seleccion.Ambrosito;
                else if(select == 34)
                    compra = Seleccion.Pepsi;
                else if(select == 44)
                    compra = Seleccion.LimonSoda;
            }

            if(compra == null)
                lPantalla[0].setText("Codigo: "+select+"_");
            else {
                lPantalla[0].setText("Codigo: "+select);
                try {
                    inter.getPanelExp().comprarEnExpendedor(comprador.getnumPago(), comprador.getdepoPago(), compra);
                    int vuelto = comprador.getnumPago()-compra.getPrecio();
                    comprador.setnumPago(0);
                    lPantalla[1].setText("Pago Ingresado: "+comprador.getnumPago());
                    lPantalla[2].setText("Vuelto: "+vuelto);
                    lPantalla[0].setText("Codigo: "+select+" | Producto Comprado");
                } catch (Exception exception) {
                    lPantalla[2].setText(exception.getMessage());
                }
                select = 0;
            }
        }
    }
    private class InteraccionExpendedor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            lPantalla[2].setText(" ");
            if(e.getSource()==bMonedas[0]) {
                comprador.addMoneda(new Moneda100(1));
            }
            else if(e.getSource()==bMonedas[1]) {
                comprador.addMoneda(new Moneda500(1));
            }
            else if(e.getSource()==bMonedas[2]) {
                comprador.addMoneda(new Moneda1000(1));
            }
            else if(e.getSource()==bVuelto) {
                comprador.obtenerVuelto(inter.getPanelExp().entregarVuelto());
                if(comprador.getVuelto() != 0)
                    lPantalla[2].setText("Vuelto Retirado");
                else if(comprador.getnumPago() != 0) {
                    inter.getPanelExp().devolverPagoExp(comprador.getdepoPago());
                    lPantalla[2].setText("Pago Devuelto");
                    comprador.setnumPago(0);
                }
                panelInv.setBilletera(comprador.getNumBilletera());
            }
            else {
                Producto producto = inter.getPanelExp().obtenerProducto();
                if(producto != null) {
                    comprador.addProducto(producto);
                    panelInv.changeTextProducto(producto.sabor(), comprador.getSizeBolsa());
                    panelInv.displayProducto(producto);
                    lPantalla[0].setText("Codigo: __");
                    lPantalla[2].setText(" ");
                }
            }
            lPantalla[1].setText("Pago Ingresado: "+comprador.getnumPago());
        }
    }

    public void setIntermediario(Intermediario inter) { this.inter = inter;}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground,0,0,this);
    }
}