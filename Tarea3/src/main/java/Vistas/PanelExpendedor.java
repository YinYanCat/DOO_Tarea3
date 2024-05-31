package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel {

    private Intermediario intermediario;
    private BufferedImage[] prodImages;
    private final int cantidadDepositos;
    private final Expendedor expendedor;
    private ArrayList<Deposito<Producto>> lDeposito;
    private PanelDeposito[] pDepos;
    private BufferedImage imgProducto;

    public PanelExpendedor(Expendedor expendedor) {
        super(null);
        this.expendedor = expendedor;
        lDeposito = expendedor.getListDepositos();
        cantidadDepositos = lDeposito.size();
        pDepos = new PanelDeposito[cantidadDepositos];
        prodImages = new BufferedImage[cantidadDepositos];

        for(int i = 0; i< cantidadDepositos; i++){
            try{
                prodImages[i] = ImageIO.read(getClass().getClassLoader().getResource("imgProducto"+i+".png"));
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }
            pDepos[i] = new PanelDeposito<>(lDeposito.get(i),prodImages[i]);
            pDepos[i].setBounds(40+151*(i%4), 40+165*(i-i%4)/4,130,105);
            this.add(pDepos[i]);
        }
    }

    public void comprarEnExpendedor(int numPago, Deposito<Moneda>depoPago, Seleccion select) throws Exception {
        expendedor.comprarProducto(numPago, depoPago, select);
        pDepos[select.getNumDepo()].ActualizarContenido();
        pDepos[select.getNumDepo()].repaintDepo();
        try{
            imgProducto = ImageIO.read(getClass().getClassLoader().getResource("imgProducto"+select.getNumDepo()+".png"));
            //imgProducto.
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        repaint();
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgProducto, 100, 0, this);
    }

    public void setIntermediario(Intermediario inter) {
        intermediario = inter;
    }

    public void MoverProducto(int select) {
    //    int alturaExp = 700;
    //    while( y>alturaExp){}
    }
}