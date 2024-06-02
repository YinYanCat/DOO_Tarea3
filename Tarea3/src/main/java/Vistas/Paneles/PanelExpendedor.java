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

public class PanelExpendedor extends JPanel {
    private Intermediario inter;
    private final int cantidadDepositos;
    private final Expendedor expendedor;
    private ArrayList<Deposito<Producto>> lDeposito;
    private PanelDeposito[] pDepos;
    private BufferedImage ImgBackground;
    private Boton bInfo;
    private PanelMonedas pMonedas;

    public PanelExpendedor(Expendedor expendedor) {
        super(null);
        this.expendedor = expendedor;
        lDeposito = expendedor.getListDepositos();
        cantidadDepositos = lDeposito.size();
        pDepos = new PanelDeposito[cantidadDepositos];

        pMonedas = new PanelMonedas();
        this.add(pMonedas);
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

        for(int i = 0; i < cantidadDepositos; i++){
            pDepos[i] = new PanelDeposito<>(lDeposito.get(i), i, expendedor);
            pDepos[i].setBounds(40+151*(i%4), 40+165*(i-i%4)/4,130,105);
            this.add(pDepos[i]);
        }
    }

    public void comprarEnExpendedor(int numPago, Deposito<Moneda>depoPago, Seleccion select) throws Exception  {
        expendedor.comprarProducto(numPago, depoPago, select);
        pDepos[select.getNumDepo()].ActualizarContenido();
        repaint();
    }

    public void closeInfo() {
        if(pMonedas.getVisible()) {
            pMonedas.togglePanel();
            pMonedas.setMonedas(expendedor.getAlmacen(), expendedor.getTotalAlmacen());
            repaint();
        }
    }

    public Deposito<Moneda> entregarVuelto() {
        return expendedor.getVuelto();
    }

    public void devolverPagoExp(Deposito<Moneda> depoMonedas) {
        expendedor.addVuelto(depoMonedas);
    }

    public Producto obtenerProducto() {
        return expendedor.getProducto();
    }

    public void setIntermediario(Intermediario intermediario) {
        inter = intermediario;
    }

    private class InfoExpendedor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            pMonedas.togglePanel();
            pMonedas.setMonedas(expendedor.getAlmacen(), expendedor.getTotalAlmacen());
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgBackground, 0, 0, this);
    }
}