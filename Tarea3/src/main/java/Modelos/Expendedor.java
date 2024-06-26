package Modelos;

import Modelos.Excepciones.*;
import Modelos.Monedas.*;
import java.util.ArrayList;

/** Un expendedor que al ingresar una moneda y un número devuelve un producto y su vuelto
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Expendedor {

    /** Lista de todos los depósitos del expendedor, con un producto distinto en cada depósito */
    private ArrayList<Deposito<Producto>> listDepositos;

    /** Depósito de monedas donde se guarda el vuelto de la compra en monedas de 100 */
    private Deposito<Moneda> depoVuelto;

    /** Depósito de monedas donde se guarda las monedas entregadas al expendedor durante una compra */
    private Deposito<Moneda> depoAlmacenMonedas;

    /** El valor total de las monedas almacenadas en el deposito depoAlmacenMonedas */
    private int totalAlmacenMonedas;

    /** Producto que es comprado */
    private Deposito<Producto> DepoUnicoProducto;

    /** Un arreglo de enteros que contienen los números finales de las series de las monedas creadas */
    private int[] serieMonedas;

    /** Un trabajor que rellena el expendedor de productos */
    private Trabajador trabajador;

    /** Cantidad de productos que vende el expendedor */
    private int numProductos;

    /** Constructor para crear y llenar los depósitos del expendedor con productos
     * @param cantidadProductos Número entero con la cantidad de productos que tiene cada depósito de 'listDepositos' */
    public Expendedor(int cantidadProductos) {
        numProductos = cantidadProductos;
        listDepositos = new ArrayList<>();
        depoVuelto = new Deposito<>();
        depoAlmacenMonedas = new Deposito<>();
        DepoUnicoProducto = new Deposito<>();;
        serieMonedas = new int[3];
        for(int i=0; i<3; i++){
            serieMonedas[i] = 1;
        }
        trabajador = new Trabajador();
        for(int i=0; i<trabajador.getCantidadProductos(); i++) {
            listDepositos.add(trabajador.llenarDeposito(numProductos, i));
        }
    }

    /** Método para comprar un producto del expendedor, sacándolo de uno de sus depósitos
     * @param cantidadPago El monto total de las monedas ingresadas
     * @param depoMonedas El deposito con las monedas utilizadas en la compra
     * @param select El producto a comprar
     * @throws PagoIncorrectoException Se lanza esta excepción si no existe una moneda para pagar (null)
     * @throws NoHayProductoException Se lanza esta excepción si no queda o no existe el producto seleccionado
     * @throws PagoInsuficienteException Se lanza esta excepción si el pago es menor al precio del producto
     * @throws ProductoNoRetiradoException Se lanza esta excepción si hay un producto sin retirar en el expendedor */
    public void comprarProducto(int cantidadPago, Deposito<Moneda> depoMonedas, Seleccion select) throws Exception {
        if(DepoUnicoProducto.getSizeCont()!=0)
            throw new ProductoNoRetiradoException("Producto anterior no retirado");
        if(cantidadPago <= 0)
            throw new PagoIncorrectoException("Moneda no ingresada");

        Producto producto;
        int precio = select.getPrecio();
        int vuelto = cantidadPago - precio;

        if(vuelto >= 0) {
            producto = listDepositos.get(select.getNumDepo()).getContenido();
            if (producto == null) {
                throw new NoHayProductoException("Producto seleccionado agotado");
            }
            depoAlmacenMonedas.extend(depoMonedas);
            Moneda newMoneda;
            while(vuelto > 0) {
                if(1000%(vuelto+1) == 1000)
                    depoVuelto.addContenido(newMoneda = new Moneda1000(110000+(serieMonedas[2]++)));
                else if(500%(vuelto+1) == 500)
                    depoVuelto.addContenido(newMoneda = new Moneda500(105000+(serieMonedas[1]++)));
                else
                    depoVuelto.addContenido(newMoneda = new Moneda100(101000+(serieMonedas[0]++)));
                vuelto -= newMoneda.getValor();
            }
        }
        else {
            throw new PagoInsuficienteException("Pago insuficiente");
        }
        totalAlmacenMonedas+=cantidadPago;
        DepoUnicoProducto.addContenido(producto);
    }

    /** Método para rellenar un deposito del expendedor con productos
     * @return El número del caso del producto que se quiere rellenar */
    public Deposito<Producto> rellenarDeposito(int productCase) {
        listDepositos.set(productCase, trabajador.llenarDeposito(numProductos, productCase));
        return listDepositos.get(productCase);
    }

    /** Método para devolver una primera moneda del depósito de vuelto del expendedor
     * @return Una moneda de 100 del vuelto, cuando se vacía el deposito retorna null */
    public Deposito<Moneda> getVuelto() {
        return depoVuelto;
    }

    /** Método para obtener el producto comprado
     * @return Un producto comprado, cuando se vacía el deposito retorna null*/
    public Deposito<Producto>  getDepoProducto() {
        if(DepoUnicoProducto.getSizeCont()!=0)
            return  DepoUnicoProducto;
        return null;
    }

    /** Método para agregar un deposito de monedas al deposito de vuelto del expendedor
     * @param depoMonedas El deposito de monedas que se quiere extender a depoVuelto */
    public void addVuelto(Deposito<Moneda> depoMonedas) {
        depoVuelto.extend(depoMonedas);
    }

    /** Método para obtener la lista De depositos de productos
     * @return Un ArrayList de Deposito de Productos */
    public ArrayList<Deposito<Producto>> getListDepositos() {
        return listDepositos;
    }

    /** Método para obtener el almacén de monedas ingresadas al expendedor
     * @return El deposito de monedas entregadas y guardadas en el expendedor */
    public Deposito<Moneda> getAlmacen() {
        return depoAlmacenMonedas;
    }

    /** Método para obtener el valor total de las monedas almacenadas en el almacen del expendedor
     * @return El número con el valor total de las monedas en el deposito almacén */
    public int getTotalAlmacen() {
        return totalAlmacenMonedas;
    }
}