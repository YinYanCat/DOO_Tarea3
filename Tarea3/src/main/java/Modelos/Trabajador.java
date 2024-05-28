package Modelos;

import Modelos.Ambrosito;

/** Un trabajador que trabaja llenando los depositos de un expendedor
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Trabajador {

    /** Cantidad de productos que se venden en un expendedor */
    private int cantidadProductos;

    /** Constructor para crear un trabajdor, junto con la cantidad de productos */
    public Trabajador() {
        cantidadProductos = 16;
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
                    newDepo.addContenido(new Snickers(j + 100));
                    break;
                case 1:
                    newDepo.addContenido(new Super8(j + 200));
                    break;
                case 2:
                    newDepo.addContenido(new Rolls(j + 300));
                    break;
                case 3:
                    newDepo.addContenido(new SahneNuss(j + 400));
                    break;
                case 4:
                    newDepo.addContenido(new Trencito(j + 500));
                    break;
                case 5:
                    newDepo.addContenido(new Doblon(j + 600));
                    break;
                case 6:
                    newDepo.addContenido(new Flipy(j + 700));
                    break;
                case 7:
                    newDepo.addContenido(new Ambrosito(j + 800));
                    break;
                case 8:
                    newDepo.addContenido(new CocaCola(j + 900));
                    break;
                case 9:
                    newDepo.addContenido(new Sprite(j + 1000));
                    break;
                case 10:
                    newDepo.addContenido(new Fanta(j + 1100));
                    break;
                case 11:
                    newDepo.addContenido(new Pepsi(j + 1200));
                    break;
                case 12:
                    newDepo.addContenido(new Bilz(j + 1300));
                    break;
                case 13:
                    newDepo.addContenido(new Pap(j + 1400));
                    break;
                case 14:
                    newDepo.addContenido(new Kem(j + 1500));
                    break;
                case 15:
                    newDepo.addContenido(new LimonSoda(j + 1600));
                    break;
            }
        }
        return newDepo;
    }

    public int getcantidadProductos() {
        return cantidadProductos;
    }
}