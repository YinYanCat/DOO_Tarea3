package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel {

    private BufferedImage expImage;

    private Intermediario intermediario;

    private BufferedImage[] prodImages;
    private Rectangle[] posProdImg;
    int cantidadImg;
    private Expendedor expendedor;

    private ArrayList<Deposito<Producto>> lDeposito;

    public PanelExpendedor(Expendedor expendedor) {
        this.expendedor = expendedor;
        lDeposito = expendedor.getListDepositos();
        cantidadImg = lDeposito.size();
        prodImages = new BufferedImage[cantidadImg];
        posProdImg = new Rectangle[cantidadImg];

//        try {
//            expImage = ImageIO.read(getClass().getResource("/expendedor2.png"));
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }

//        for(int i=0;i<cantidadImg;i++){
//            try{
//                prodImages[i] = ImageIO.read(getClass().getResource("/producto"+i+".png"));
//                //cambiar posiciones iniciales
//                posProdImg[i] = new Rectangle(i%4*20,(i-i%4)*20/4,10,10);
//            }catch (IOException ex){
//                System.out.println(ex.getMessage());
//            }
//        }
    }

    public void comprarEnExpendedor(int numPago, Deposito<Moneda>depoPago, Seleccion select) throws Exception {
        expendedor.comprarProducto(numPago,depoPago,select);
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
        //g.drawImage(expImage, 0, 0, this);
    }

    public void setIntermediario(Intermediario inter) { intermediario = inter;}

    public void MoverProducto(int select) {
        int alturaExp = 700;
    //    while( y>alturaExp){}
    }

    public void ActualizarProductos(){
        lDeposito = expendedor.getListDepositos();
    }
}