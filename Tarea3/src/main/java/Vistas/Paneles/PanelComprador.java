package Vistas.Paneles;

import Modelos.*;
import Modelos.Monedas.*;
import Vistas.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Un panel que contiene paneles y botones interactuables con el comprador
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelComprador extends JPanel {

    /** Panel donde se presentan los botones interactuables para comprar y retirar un producto */
    private PanelSelector panelSelect;

    /** Panel donde se presentan los productos y monedas obtenidas durante una compra en un expendedor */
    private PanelInventario panelInv;

    /** Comprador que interactua con el expendedor */
    private Comprador comprador;

    /** Arreglo de 4 botones que ingresan el código del producto a comprar */
    private Boton[] NumPad;     //1,2,3,4

    /** Arreglo de 3 botones que ingresan las monedas al expendedor */
    private Boton[] bMonedas;   //100, 500, 1000

    /** Bóton que entrega el vuelto o devuelve el pago ingresado */
    private Boton bVuelto;

    /** Bóton que entrega el producto comprado */
    private Boton bGetProducto;

    /** Entero que contiene el código del producto a comprar */
    private int select;

    /** Arreglo de enteros que contienen la serie de las monedas ingresadas */
    private int[] serieMonedas;

    /** Constructor se crea el panel, sus sub paneles y sus botones
     * @param comprador El comprador que va a interactuar con el panel */
    public PanelComprador(Comprador comprador) {
        super(null);
        this.comprador = comprador;
        NumPad = new Boton[4];
        bMonedas = new Boton[3];
        serieMonedas = new int[3];
        select = 0;

        this.setBackground(new Color(99,155, 255));
        panelSelect =  new PanelSelector(0,0,354,720);
        panelInv = new PanelInventario(354, 0, 249, 720);
        InteraccionSelector listenerCompra = new InteraccionSelector();
        InteraccionExpendedor listenerOpcion = new InteraccionExpendedor();

        panelSelect.crearNumPad(NumPad);
        panelSelect.crearSelectMonedas(bMonedas);
        for(int i=0; i<4; i++) {
            NumPad[i].addActionListener(listenerCompra);
            if(i!=3) {
                bMonedas[i].addActionListener(listenerOpcion);
                serieMonedas[i] = 1;
            }
        }

        bVuelto = new Boton(Color.BLACK,true,"imgBotonVacio.png");
        bVuelto.setBounds(197,187,120,60);
        bGetProducto = new Boton(Color.BLACK,true,"imgBotonProducto.png");
        bGetProducto.setBounds(197,620,120,60);
        panelSelect.addBoton(bVuelto);
        panelSelect.addBoton(bGetProducto);
        bGetProducto.addActionListener(listenerOpcion);
        bVuelto.addActionListener(listenerOpcion);
        this.add(panelSelect);
        this.add(panelInv);
    }

    /** Un escuchador de acciones realizadas a los 4 botones NumPad, que ingresan el código del producto
     * @author Chloe Yañez Lavin
     * @author Emily Osvaldo Gaete Bobadilla */
    private class InteraccionSelector implements ActionListener {

        /** Método para realizar una acción al presionarse uno de los botones NumPad
         * @param event El evento realizado a uno de los botones */
        @Override
        public void actionPerformed(ActionEvent event) {
            PanelLinker.getPanelExpendendor().closeInfo();
            panelSelect.setPantalla(2, " ");
            Seleccion compra = null;
            if(event.getSource()==NumPad[0]) {
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
            else if(event.getSource()==NumPad[1]) {
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
            else if(event.getSource()==NumPad[2]) {
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
                panelSelect.setPantalla(0, "Codigo: "+select+"_");
            else {
                panelSelect.setPantalla(0, "Codigo: "+select);
                try {
                    PanelLinker.getPanelExpendendor().comprarEnExpendedor(comprador.getNumPago(), comprador.getDepoPago(), compra);
                    setCompraDisplay(comprador.getNumPago()-compra.getPrecio());
                    comprador.setNumPago(0);
                } catch (Exception exception) {
                    panelSelect.setPantalla(2, exception.getMessage());
                }
                repaint();
                select = 0;
            }
        }
    }

    /** Método para mostrar la información de una compra exitosa en el PanelSelector
     * @param vuelto El valor total del vuelto obtenido al finalizar la compra */
    public void setCompraDisplay(int vuelto) {
        panelSelect.setPantalla(0, "Codigo: "+select+" | Producto Comprado");
        panelSelect.setPantalla(1, "Pago Ingresado: 0");
        panelSelect.setPantalla(2, "Vuelto: "+vuelto);
        bVuelto.changeImage("imgBotonVacio.png");
        if(vuelto != 0) {
            bVuelto.changeImage("imgBotonVuelto.png");
            panelSelect.setCaseVisible(0, true);
        }
        panelSelect.setCaseVisible(1, true);
        panelSelect.setImageProduct(PanelLinker.getPanelExpendendor().obtenerDepoProducto().checkContenido(0).getImage());
    }


    /** Un escuchador de acciones realizadas a los 3 botones bMonedas, el bóton bvuelto y el bóton bGetProducto
     * @author Chloe Yañez Lavin
     * @author Emily Osvaldo Gaete Bobadilla */
    private class InteraccionExpendedor implements ActionListener {

        /** Método para realizar una acción al  presionarse uno de los botones NumPad
         * @param event El evento realizado a uno de los botones */
        @Override
        public void actionPerformed(ActionEvent event) {
            PanelLinker.getPanelExpendendor().closeInfo();
            panelSelect.setPantalla(2, " ");
            if(event.getSource()==bMonedas[0]) {
                comprador.addMoneda(new Moneda100(201000+(serieMonedas[0]++)));
                bVuelto.changeImage("imgBotonDeolver.png");
            }
            else if(event.getSource()==bMonedas[1]) {
                comprador.addMoneda(new Moneda500(205000+(serieMonedas[1]++)));
                bVuelto.changeImage("imgBotonDeolver.png");
            }
            else if(event.getSource()==bMonedas[2]) {
                comprador.addMoneda(new Moneda1000(210000+(serieMonedas[2]++)));
                bVuelto.changeImage("imgBotonDeolver.png");
            }
            else if(event.getSource()==bVuelto) {
                if(bVuelto.getFilename().equals("imgBotonVuelto.png")) {
                    comprador.obtenerVuelto(PanelLinker.getPanelExpendendor().entregarVuelto());
                    panelSelect.setPantalla(2, "Vuelto Retirado");
                    bVuelto.changeImage("imgBotonVacio.png");
                    panelSelect.setCaseVisible(0, false);
                    panelInv.displayMonedas(comprador.getBilletera(), comprador.getVuelto());
                }
                else if(bVuelto.getFilename().equals("imgBotonDeolver.png")) {
                    PanelLinker.getPanelExpendendor().devolverPagoExp(comprador.getDepoPago());
                    panelSelect.setPantalla(0, "Codigo: __");
                    panelSelect.setPantalla(2, "Pago Devuelto");
                    bVuelto.changeImage("imgBotonVuelto.png");
                    select = 0;
                    comprador.setNumPago(0);
                    panelSelect.setCaseVisible(0, true);
                }
                panelInv.setTextoInv(comprador.getNumBilletera(), comprador.getVuelto());
                repaint();
            }
            else {
                if(PanelLinker.getPanelExpendendor().obtenerDepoProducto() != null) {
                    Producto producto = PanelLinker.getPanelExpendendor().obtenerDepoProducto().getContenido();
                    comprador.addProducto(producto);
                    panelInv.displayProducto(producto, comprador.getSizeBolsa());
                    panelSelect.setPantalla(0, "Codigo: __");
                    panelSelect.setPantalla(2, " ");
                    panelSelect.setCaseVisible(1, false);
                    select = 0;
                    repaint();
                }
            }
            panelSelect.setPantalla(1, "Pago Ingresado: "+comprador.getNumPago());
        }
    }

    /** Método para dibujar los componentes de Swing del panel
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}