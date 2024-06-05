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
import java.util.ArrayList;

/** Un panel que contiene paneles y botones que muestran visualmente un expendedor
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelExpendedor extends JPanel {

    /** Panel donde se presentan las monedas ingresadas y guardadas en el expendedor */
    private PanelAlmacen panelAlmacen;

    /** Arreglo de paneles donde se presentan los diferentes depositos con productos del expendedor */
    private PanelDeposito[] pDepos;

    /** Expendedor que presenta visualmente en el panel */
    private final Expendedor expendedor;

    /** Bóton que abre o cierra el panelAlmacen */
    private Boton bInfo;

    /** Imagen que se dibuja al fondo del panel */
    private BufferedImage ImgBackground;

    /** Constructor se crea el panel, sus sub paneles conde depositos, su bóton y su imagen de fondo
     * @param expendedor El expendedor que se visualizará en el panel */
    public PanelExpendedor(Expendedor expendedor) {
        super(null);
        this.expendedor = expendedor;
        pDepos = new PanelDeposito[expendedor.getListDepositos().size()];

        panelAlmacen = new PanelAlmacen();
        this.add(panelAlmacen);
        InfoExpendedor listenerInfo = new PanelExpendedor.InfoExpendedor();
        bInfo = new Boton(Color.BLACK, true, "imgBotonInfo.png");
        bInfo.setBounds(10, 10, 50, 50);
        bInfo.addActionListener(listenerInfo);
        this.add(bInfo);

        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelExpendedor.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        for(int i = 0; i < expendedor.getListDepositos().size(); i++){
            pDepos[i] = new PanelDeposito<>(expendedor.getListDepositos().get(i), i, expendedor);
            pDepos[i].setBounds(40+151*(i%4), 40+165*(i-i%4)/4,130,105);
            this.add(pDepos[i]);
        }
    }

    /** Método para comprar un producto del expendedor y actualizar el deposito visualmente
     * @param numPago El monto total de las monedas ingresadas
     * @param depoPago El deposito con las monedas utilizadas en la compra
     * @param select El producto a comprar */
    public void comprarEnExpendedor(int numPago, Deposito<Moneda>depoPago, Seleccion select) throws Exception  {
        expendedor.comprarProducto(numPago, depoPago, select);
        pDepos[select.getNumDepo()].ActualizarContenido();
        repaint();
    }

    /** Método para cerrar el PanelAlmacen si se encuentra abierto */
    public void closeInfo() {
        if(panelAlmacen.getVisible()) {
            panelAlmacen.togglePanel();
            panelAlmacen.setMonedas(expendedor.getAlmacen(), expendedor.getTotalAlmacen());
            repaint();
        }
    }

    /** Método para obtener un deposito de monedas con el vuelto del expendedor
     * @return El deposito de monedas con el vuelto de la compra */
    public Deposito<Moneda> entregarVuelto() {
        return expendedor.getVuelto();
    }

    /** Método para devolver las monedas ingresadas al expendedor
     * @param depoMonedas El deposito de monedas con las monedas ingresadas al expendedor */
    public void devolverPagoExp(Deposito<Moneda> depoMonedas) {
        expendedor.addVuelto(depoMonedas);
    }

    /** Método para devolver un deposito con el producto de la compra en su interior
     * @return El deposito único con un producto en su interior si se encuentra lleno */
    public Deposito<Producto> obtenerDepoProducto() {
        return expendedor.getDepoProducto();
    }


    /** Un escuchador de acciones realizadas al bóton bInfo que activa o desactiva el PanelAlmacen
     * @author Chloe Yañez Lavin
     * @author Emily Osvaldo Gaete Bobadilla */
    private class InfoExpendedor implements ActionListener {

        /** Método para realizar una acción al presionarse uno de los botones NumPad
         * @param event El evento realizado al bóton bInfo */
        @Override
        public void actionPerformed(ActionEvent event) {
            panelAlmacen.togglePanel();
            panelAlmacen.setMonedas(expendedor.getAlmacen(), expendedor.getTotalAlmacen());
            repaint();
        }
    }

    /** Método para dibujar los componentes de Swing del panel
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }
}