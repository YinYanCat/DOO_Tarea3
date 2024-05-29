package Modelos;

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

    /** Producto que es comprado */
    private Producto ProductoComprado;

    /** Constructor para crear y llenar los depósitos del expendedor con productos
     * @param numProductos Número entero con la cantidad de productos que tiene cada depósito de 'listDepositos' */
    public Expendedor(int numProductos) {
        listDepositos = new ArrayList<>();
        depoVuelto = new Deposito<>();
        depoAlmacenMonedas = new Deposito<>();
        ProductoComprado = null;
        Trabajador trabajador = new Trabajador();
        // Llenar los depositos con productos
        for(int i=0; i<trabajador.getcantidadProductos(); i++) {
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
        if(ProductoComprado != null)
            throw new ProductoNoRetiradoException("Producto anterior no retirado");
        if(cantidadPago <= 0)
            throw new PagoIncorrectoException("Moneda no ingresada");

        Producto producto = null;
        int precio = select.getPrecio();
        int vuelto = cantidadPago - precio;

        if(vuelto >= 0) {
            producto = listDepositos.get(select.getNumDepo()).getContenido();
            if(producto == null) {
                //depoVuelto.extend(depoMonedas);
                throw new NoHayProductoException("Producto seleccionado agotado");
            }
            depoAlmacenMonedas.extend(depoMonedas);
            for (int i = 0; i < vuelto; i+=100) {
                depoVuelto.addContenido(new Moneda100());
            }
        }
        else {
            //depoVuelto.extend(depoMonedas);
            throw new PagoInsuficienteException("Pago insuficiente");
        }
        ProductoComprado = producto;
    }

    /** Método para devolver una primera moneda del depósito de vuelto del expendedor
     * @return Una moneda de 100 del vuelto, cuando se vacía el deposito retorna null*/
    public Deposito<Moneda> getVuelto() {
        return depoVuelto;
    }

    /** Método para obtener el producto comprado
     * @return Un producto comprado, cuando se vacía el deposito retorna null*/
    public Producto getProducto() {
        Producto aux = ProductoComprado;
        ProductoComprado = null;
        return aux;
    }
    public void addVuelto(Deposito<Moneda> depoMonedas) {
        depoVuelto.extend(depoMonedas);
    }
    /** Método para obtener la lista De depositos de productos
     * @return Un ArrayList de Deposito de Productos */
    public ArrayList<Deposito<Producto>> getListDepositos() {
        return listDepositos;
    }
}