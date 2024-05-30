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
    int cantidadDepositos;
    private Expendedor expendedor;

    private ArrayList<Deposito<Producto>> lDeposito;

    public PanelExpendedor(Expendedor expendedor) {
        this.expendedor = expendedor;
        lDeposito = expendedor.getListDepositos();
        cantidadDepositos = lDeposito.size();
        //cantidadImg = 16;
        prodImages = new BufferedImage[cantidadDepositos];
        ActualizarProductos();



        for(int i = 0; i< cantidadDepositos; i++){
            try{
                prodImages[i] = ImageIO.read(getClass().getClassLoader().getResource("imgProducto"+i+".png"));

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

        ActualizarProductos();
        for(int i=0;i<cantidadDepositos;i++){
            for(int j=0;j<expendedor.getListDepositos().get(i).getCantidadContenido();j++){
                expendedor.getListDepositos().get(i).getList().get(j).paintComponent(g,this);
            }
        }
    }

    public void setIntermediario(Intermediario inter) {
        intermediario = inter;
    }

    public void MoverProducto(int select) {
        int alturaExp = 700;
    //    while( y>alturaExp){}
    }

    public void ActualizarProductos(){
        lDeposito = expendedor.getListDepositos();
        for(int i=0;i<cantidadDepositos;i++){
            for(int j=0;j<expendedor.getListDepositos().get(i).getCantidadContenido();j++){
                lDeposito.get(i).getList().get(j).Linker(prodImages[i],60+10*(j-i%4)+165*(i%4), 45+165*(i-i%4)/4);
            }
        }
    }
}