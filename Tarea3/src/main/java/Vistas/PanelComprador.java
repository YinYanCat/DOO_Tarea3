package Vistas;

import Modelos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel {
    private Boton[] NumPad;
    private Boton[] bMonedas;
    private JButton bVuelto;
    private JButton bGetProducto;
    private TextoPantalla lProducto;
    private TextoPantalla lMonto;
    private TextoPantalla lMensaje;
    private JLabel lBilletera;
    private int select;
    private Comprador comprador;
    private Expendedor expendedor;

    public PanelComprador(Comprador comprador, Expendedor expendedor) {
        this.comprador = comprador;
        this.expendedor = expendedor;
        NumPad = new Boton[4];
        bMonedas = new Boton[3];
        select = 0;

        this.setLayout(new GridLayout(2, 1));
        InteraccionSelector listenerCompra = new InteraccionSelector();
        InteraccionExpendedor listenerMoneda = new InteraccionExpendedor();
        PanelSelector panelSelector = new PanelSelector();
        PanelPago panelPago = new PanelPago();

        for(int i=0; i<4; i++) {
            NumPad[i] = new Boton(70, 70, "boton1.png");
            NumPad[i].addActionListener(listenerCompra);
            panelSelector.addButton(NumPad[i], 1);
        }

        for(int i=0; i<3; i++) {
            bMonedas[i] = new Boton(70, 70, "boton1.png");
            bMonedas[i].addActionListener(listenerMoneda);
            panelPago.addButton(bMonedas[i]);
        }

        bVuelto = new JButton("VUELTO");
        bGetProducto = new JButton("PRODUCTO");
        lProducto = new TextoPantalla("Codigo: __");
        lMonto = new TextoPantalla("Pago Ingresado: 0");
        lMensaje = new TextoPantalla(" ");
        lBilletera = new JLabel("Vuelto: 0 | Billetera: 0");

        panelSelector.addButton(bVuelto, 2);
        panelSelector.addButton(bGetProducto, 2);
        panelSelector.addText(lProducto);
        panelSelector.addText(lMonto);
        panelSelector.addText(lMensaje);
        panelPago.addText(lBilletera);

        bGetProducto.addActionListener(listenerMoneda);
        bVuelto.addActionListener(listenerMoneda);
        this.add(panelSelector);
        this.add(panelPago);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class InteraccionSelector implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Seleccion compra = null;

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
                    comprador.comprarEnExpendedor(expendedor, compra);
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
                comprador.obtenerVuelto(expendedor);
                if(comprador.getVuelto() != 0)
                    lMensaje.setText("Vuelto Retirado");
                else {
                    comprador.obtenerPagoDevuelta(expendedor);
                    lMensaje.setText("Pago Devuelto");
                }
                lBilletera.setText("Vuelto: "+comprador.getVuelto()+" | Billetera: "+comprador.getNumBilletera());
            }
            else {
                Producto producto = expendedor.getProducto();
                if(producto != null) {
                    System.out.println(producto.sabor());
                    lProducto.setText("Codigo: __");
                    lMensaje.setText(" ");
                }
            }
            lMonto.setText("Pago Ingresado: "+comprador.getnumPago());
        }
    }
}