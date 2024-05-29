package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel {
    private Boton[] NumPad;
    private Boton[] bMonedas;
    private Boton bVuelto;
    private Boton bGetProducto;
    private TextoPantalla lProducto;
    private TextoPantalla lMonto;
    private TextoPantalla lMensaje;
    private TextoBilletera lBilletera;
    private int select;
    private Comprador comprador;

    private Intermediario inter;
    public PanelComprador(Comprador comprador) {
        this.comprador = comprador;
        NumPad = new Boton[4];
        bMonedas = new Boton[3];
        select = 0;

        this.setLayout((new BorderLayout()));
        this.setBackground(new Color(0,0, 0, 0));
        InteraccionSelector listenerCompra = new InteraccionSelector();
        InteraccionExpendedor listenerMoneda = new InteraccionExpendedor();
        PanelSelector panelSelector = new PanelSelector();
        PanelPago panelPago = new PanelPago();
        PanelInventario panelInv = new PanelInventario();

        JPanel subPanel = new JPanel();
        subPanel.setBackground(new Color(0,0, 0, 0));
        subPanel.setLayout(new GridLayout(2, 1));
        subPanel.setPreferredSize(new Dimension(352,720));

        for(int i=0; i<4; i++) {
            NumPad[i] = new Boton(Color.BLACK,true,"imgBoton"+(i+1)+".png");
            NumPad[i].addActionListener(listenerCompra);
            panelSelector.addButton(NumPad[i], 1);
        }

        for(int i=0; i<3; i++) {
            bMonedas[i] = new Boton(new Color(133,170, 215),false,"imgMoneda"+(i+1)+".png");
            bMonedas[i].addActionListener(listenerMoneda);
            panelPago.addButton(bMonedas[i]);
        }

        bVuelto = new Boton(Color.BLACK,true,"imgBotonVuelto.png");
        bGetProducto = new Boton(Color.BLACK,true,"imgBotonProducto.png");
        lProducto = new TextoPantalla("Codigo: __");
        lMonto = new TextoPantalla("Pago Ingresado: 0");
        lMensaje = new TextoPantalla(" ");
        lBilletera = new TextoBilletera("Billetera: 0");

        panelSelector.addButton(bVuelto, 2);
        panelSelector.addButton(bGetProducto, 2);
        panelSelector.addText(lProducto);
        panelSelector.addText(lMonto);
        panelSelector.addText(lMensaje);
        panelPago.addText(lBilletera);

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
                lProducto.setText("Codigo: "+select+"_");
            else {
                lProducto.setText("Codigo: "+select);
                try {
                    inter.getPanelExp().comprarEnExpendedor(comprador.getnumPago(), comprador.getdepoPago(), compra);
                    int vuelto = comprador.getnumPago()-compra.getPrecio();
                    comprador.setnumPago(0);
                    lMonto.setText("Pago Ingresado: "+comprador.getnumPago());
                    lMensaje.setText("Vuelto: "+vuelto);
                    lProducto.setText("Codigo: "+select+" | Producto Comprado");
                } catch (Exception exception) {
                    lMensaje.setText(exception.getMessage());
                }
                select = 0;
            }
        }
    }
    private class InteraccionExpendedor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==bMonedas[0]) {
                comprador.addMoneda(new Moneda100());
            }
            else if(e.getSource()==bMonedas[1]) {
                comprador.addMoneda(new Moneda500());
            }
            else if(e.getSource()==bMonedas[2]) {
                comprador.addMoneda(new Moneda1000());
            }
            else if(e.getSource()==bVuelto) {
                comprador.obtenerVuelto(inter.getPanelExp().entregarVuelto());
                if(comprador.getVuelto() != 0)
                    lMensaje.setText("Vuelto Retirado");
                else {
                    inter.getPanelExp().devolverPagoExp(comprador.getdepoPago());
                    lMensaje.setText("Pago Devuelto");
                }
                lBilletera.setText("Billetera: "+comprador.getNumBilletera());
            }
            else {
                Producto producto = inter.getPanelExp().obtenerProducto();
                if(producto != null) {
                    System.out.println(producto.sabor());
                    lProducto.setText("Codigo: __");
                    lMensaje.setText(" ");
                }
            }
            lMonto.setText("Pago Ingresado: "+comprador.getnumPago());
        }
    }

    public void setIntermediario(Intermediario inter) { this.inter = inter;}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}