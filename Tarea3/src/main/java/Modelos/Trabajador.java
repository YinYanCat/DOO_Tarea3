package Modelos;

import Modelos.Bebidas.*;
import Modelos.Dulces.*;

/** Un trabajador que trabaja llenando los depositos de un expendedor
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Trabajador {

    /** Cantidad de productos que se venden en un expendedor */
    private int cantidadProductos;

    private int[] serieProducto;

    /** Constructor para crear un trabajdor, junto con la cantidad de productos */
    public Trabajador() {
        cantidadProductos = 16;
        serieProducto = new int[cantidadProductos];
        for(int i=0; i<cantidadProductos; i++){
            serieProducto[i] = 1;
        }
    }

    /** Método para comprar un producto del expendedor, sacándolo de uno de sus depósitos
     * @param numProductos La cantidad de productos que tiene cada deposito del expendedor
     * @param productCase El número del producto que se desea llenar en el depositp
     * @return Un deposito lleno del producto requerido */
    public Deposito<Producto> llenarDeposito(int numProductos, int productCase) {
        Deposito<Producto> newDepo = new Deposito<>();
        for(int j=0; j<numProductos; j++) {
            // Switch-case para llenar cada depósito con un producto distinto, siendo el total 'numProductos'
            switch(productCase) {
                case 0:
                    newDepo.addContenido(new Snickers(100+(serieProducto[0]+=j)));
                    break;
                case 1:
                    newDepo.addContenido(new Super8(200+(serieProducto[1]+=j)));
                    break;
                case 2:
                    newDepo.addContenido(new Rolls(300+(serieProducto[2]+=j)));
                    break;
                case 3:
                    newDepo.addContenido(new SahneNuss(400+(serieProducto[3]+=j)));
                    break;
                case 4:
                    newDepo.addContenido(new Trencito(500+(serieProducto[4]+=j)));
                    break;
                case 5:
                    newDepo.addContenido(new Doblon(600+(serieProducto[5]+=j)));
                    break;
                case 6:
                    newDepo.addContenido(new Flipy(700+(serieProducto[6]+=j)));
                    break;
                case 7:
                    newDepo.addContenido(new Ambrosito(800+(serieProducto[7]+=j)));
                    break;
                case 8:
                    newDepo.addContenido(new CocaCola(900+(serieProducto[8]+=j)));
                    break;
                case 9:
                    newDepo.addContenido(new Sprite(1000+(serieProducto[9]+=j)));
                    break;
                case 10:
                    newDepo.addContenido(new Fanta(1100+(serieProducto[10]+=j)));
                    break;
                case 11:
                    newDepo.addContenido(new Pepsi(1200+(serieProducto[11]+=j)));
                    break;
                case 12:
                    newDepo.addContenido(new Bilz(1300+(serieProducto[12]+=j)));
                    break;
                case 13:
                    newDepo.addContenido(new Pap(1400+(serieProducto[13]+=j)));
                    break;
                case 14:
                    newDepo.addContenido(new Kem(1500+(serieProducto[14]+=j)));
                    break;
                case 15:
                    newDepo.addContenido(new LimonSoda(1600+(serieProducto[15]+=j)));
                    break;
            }
        }
        return newDepo;
    }

    /** Método para obtener la cantidad de productos que crea el trabajador
     * @return El número con la cantidad total de productos que puede crear el trabajador */
    public int getCantidadProductos() {
        return cantidadProductos;
    }
}