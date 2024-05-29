package Vistas;

import Modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class PanelExpendedor extends JPanel {

    private Intermediario intermediario;

    private BufferedImage[] prodImages;
    private Rectangle[] posProdImg;
    int cantidadImg;
    private Expendedor expendedor;

    private ArrayList<Deposito<Producto>> lDeposito;

    public PanelExpendedor(Expendedor expendedor) {
        this.expendedor = expendedor;
        lDeposito = expendedor.getListDepositos();
        //cantidadImg = lDeposito.size();
        cantidadImg = 16;
        prodImages = new BufferedImage[cantidadImg];
        posProdImg = new Rectangle[cantidadImg];


        for(int i=0;i<cantidadImg;i++){
            try{
                prodImages[i] = ImageIO.read(getClass().getClassLoader().getResource("imgProducto"+i+".png"));
                //cambiar posiciones iniciales
                posProdImg[i] = new Rectangle(i*100,0,50,100);
                //posProdImg[i] = new Rectangle(i%4*20,(i-i%4)*20/4,50,100);
            } catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
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
        int index = 0;
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                g.drawImage(prodImages[index], 60+140*j+10*j, 45+165*i, this);
                index++;
            }
        }
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