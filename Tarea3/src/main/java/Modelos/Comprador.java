package Modelos;

/** Un comprador que desea comprar un producto de una expendedora con una moneda, obteniendo un sabor y un vuelto
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Comprador {

    /** Deposito donde se guardan las monedas entregadas como vuelto durante una compra */
    private Deposito<Moneda> billetera;

    /** Valor total de las monedas guardadas en la billetera */
    private int numbilletera;

    /** Valor total del vuelto de una compra */
    private int vuelto;

    /** Deposito donde se guardan las monedas que se utilizarán pagar comprar un producto */
    private Deposito<Moneda> depoPago;

    /** Valor total de las monedas que se utilizarán pagar comprar un producto */
    private int numPago;

    /** Constructor de Comprador donde se inicializan sus propiedades */
    public Comprador() {
        billetera = new Deposito<>();
        numbilletera = 0;
        vuelto = 0;
        depoPago = new Deposito<>();
        numPago = 0;
    }

    /** Método para obtener el vuelto de un deposito con monedas
     * @param depoVuelto El deposito con las monedas entregadas como vuelto */
    public void obtenerVuelto(Deposito<Moneda> depoVuelto) {
        vuelto = 0;
        Moneda monVuelto=null;
        while (true) {
            monVuelto = depoVuelto.getContenido();
            if (monVuelto == null) {
                break;
            } else {
                billetera.addContenido(monVuelto);
                vuelto += monVuelto.getValor();
                numbilletera += monVuelto.getValor();
            }
        }
    }

    /** Método para establecer el valor total de las monedas que se utilizarán pagar comprar un producto
     * @param num El número que se igualará al valor total de las monedas del deopisto */
    public void setnumPago(int num) {
        numPago=num;
    }

    /** Método para obtener el valor total del vuelto de una compra
     * @return Un número con el valor total de vuelto */
    public int getVuelto() {
        return vuelto;
    }

    /** Método para obtener el valor total de las monedas que se utilizarán pagar comprar un producto
     * @return Un número con el valor total de vuelto */
    public int getnumPago() {
        return numPago;
    }

    /** Método para obtener el deposito donde se guardan las monedas que se utilizarán pagar comprar un producto
     * @return El deposito con las monedas */
    public Deposito<Moneda> getdepoPago() {
        return depoPago;
    }

    /** Método para obtener el valor total de las monedas guardadas en la billetera
     * @return Un número con el valor total de las monedas */
    public int getNumBilletera() {
        return numbilletera;
    }

    /** Método para agregar una moneda al deposito que se utilizarán pagar comprar un producto
     * @param moneda Una moneda que se agregará al deposito de compra */
    public void addMoneda(Moneda moneda) {
        depoPago.addContenido(moneda);
        numPago += moneda.getValor();
    }
}