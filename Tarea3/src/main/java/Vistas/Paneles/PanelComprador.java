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

public class PanelComprador extends JPanel {
    private Boton[] NumPad;
    private Boton[] bMonedas;
    private Boton bVuelto;
    private Boton bGetProducto;
    private BufferedImage[] ImgUse;
    private boolean[] ImgDisplay;
    private CuadroTexto[] lPantalla;
    private Comprador comprador;
    private PanelInventario panelInv;
    private Intermediario inter;
    private int select;
    private int serieMonedas[];

    public PanelComprador(Comprador comprador) {
        super(null);
        this.comprador = comprador;
        NumPad = new Boton[4];
        bMonedas = new Boton[3];
        lPantalla = new CuadroTexto[3];
        ImgUse = new BufferedImage[5];
        ImgDisplay = new boolean[2];
        serieMonedas =  new int[3];
        select = 0;

        try {
            ImgUse[0] = ImageIO.read(getClass().getClassLoader().getResource("imgVuelto.png"));
            ImgUse[1] = ImageIO.read(getClass().getClassLoader().getResource("imgPush.png"));
            ImgUse[3] = ImageIO.read(getClass().getClassLoader().getResource("imgPushMarco.png"));
            ImgUse[4] = ImageIO.read(getClass().getClassLoader().getResource("imgPanelComprador.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        PanelSelector panelSelector =  new PanelSelector(0,0,354,720);
        panelInv = new PanelInventario(355, 0, 249, 720);
        InteraccionSelector listenerCompra = new InteraccionSelector();
        InteraccionExpendedor listenerOpcion = new InteraccionExpendedor();

        panelSelector.crearNumPad(NumPad);
        panelSelector.crearSelectMonedas(bMonedas);
        panelSelector.crearPantalla(lPantalla);

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
        panelSelector.addBoton(bVuelto);
        panelSelector.addBoton(bGetProducto);
        bGetProducto.addActionListener(listenerOpcion);
        bVuelto.addActionListener(listenerOpcion);

        this.add(panelSelector);
        this.add(panelInv);
    }

    private class InteraccionSelector implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            inter.getPanelExp().closeInfo();
            lPantalla[2].setText(" ");
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
                lPantalla[0].setText("Codigo: "+select+"_");
            else {
                lPantalla[0].setText("Codigo: "+select);
                try {
                    inter.getPanelExp().comprarEnExpendedor(comprador.getnumPago(), comprador.getdepoPago(), compra);
                    int vuelto = comprador.getnumPago()-compra.getPrecio();
                    comprador.setnumPago(0);
                    setCompraDisplay(vuelto, compra.getNumDepo());
                } catch (Exception exception) {
                    lPantalla[2].setText(exception.getMessage());
                }
                repaint();
                select = 0;
            }
        }
    }

    public void setCompraDisplay(int vuelto, int numCompra) {
        lPantalla[0].setText("Codigo: "+select+" | Producto Comprado");
        lPantalla[1].setText("Pago Ingresado: "+comprador.getnumPago());
        lPantalla[2].setText("Vuelto: "+vuelto);
        bVuelto.changeImage("imgBotonVacio.png");
        if(vuelto != 0) {
            bVuelto.changeImage("imgBotonVuelto.png");
            ImgDisplay[0] = true;
        }
        ImgDisplay[1] = true;
        try {
            ImgUse[2] = ImageIO.read(getClass().getClassLoader().getResource("imgProducto"+numCompra+".png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private class InteraccionExpendedor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            inter.getPanelExp().closeInfo();
            lPantalla[2].setText(" ");
            if(e.getSource()==bMonedas[0]) {
                comprador.addMoneda(new Moneda100(201000+(serieMonedas[0]++)));
                bVuelto.changeImage("imgBotonDeolver.png");
            }
            else if(e.getSource()==bMonedas[1]) {
                comprador.addMoneda(new Moneda500(205000+(serieMonedas[1]++)));
                bVuelto.changeImage("imgBotonDeolver.png");
            }
            else if(e.getSource()==bMonedas[2]) {
                comprador.addMoneda(new Moneda1000(210000+(serieMonedas[2]++)));
                bVuelto.changeImage("imgBotonDeolver.png");
            }
            else if(e.getSource()==bVuelto) {
                if(bVuelto.getFilename().equals("imgBotonVuelto.png")) {
                    comprador.obtenerVuelto(inter.getPanelExp().entregarVuelto());
                    lPantalla[2].setText("Vuelto Retirado");
                    bVuelto.changeImage("imgBotonVacio.png");
                    ImgDisplay[0] = false;
                    panelInv.displayMonedas(comprador.getBilletera(), comprador.getVuelto());
                }
                else if(bVuelto.getFilename().equals("imgBotonDeolver.png")) {
                    inter.getPanelExp().devolverPagoExp(comprador.getdepoPago());
                    lPantalla[2].setText("Pago Devuelto");
                    lPantalla[0].setText("Codigo: __");
                    bVuelto.changeImage("imgBotonVuelto.png");
                    select = 0;
                    comprador.setnumPago(0);
                    ImgDisplay[0] = true;
                }
                repaint();
                panelInv.setBilletera(comprador.getNumBilletera());
                panelInv.setVueltoText(comprador.getVuelto());
            }
            else {
                Producto producto = inter.getPanelExp().obtenerProducto();
                if(producto != null) {
                    comprador.addProducto(producto);
                    panelInv.displayProducto(producto, comprador.getSizeBolsa());
                    lPantalla[0].setText("Codigo: __");
                    lPantalla[2].setText(" ");
                    ImgDisplay[1] = false;
                    select = 0;
                    repaint();
                }
            }
            lPantalla[1].setText("Pago Ingresado: "+comprador.getnumPago());
        }
    }

    public void setIntermediario(Intermediario inter) { this.inter = inter;}

    @Override
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