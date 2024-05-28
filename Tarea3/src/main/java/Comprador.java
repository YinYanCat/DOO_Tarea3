/** Un comprador que desea comprar un producto de una expendedora con una moneda, obteniendo un sabor y un vuelto
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Comprador {

    /** String que contiene el sabor del producto */
    private String sabor;

    /** Número entero que contiene el vuelto total de la compra del producto */
    private int vuelto;

    /** Constructor en donde se compra el producto y se obtiene su sabor y el vuelto */

    private Deposito<Moneda> depoPago;
    private Deposito<Moneda> billetera;
    private int numPago;

    public Comprador() {
        vuelto = 0;
        numPago = 0;
        depoPago = new Deposito<>();
        billetera = new Deposito<>();
    }

    public void comprarEnExpendedor(Expendedor exp, Seleccion select) throws Exception {
        exp.comprarProducto(numPago,depoPago,select);
    }

    public void obtenerVuelto(Expendedor exp) {
        Moneda monVuelto=null;
        while (true) {
            monVuelto = exp.getVuelto();
            if (monVuelto == null) {
                break;
            } else {
                billetera.addContenido(monVuelto);
                vuelto += monVuelto.getValor();
            }
        }
    }

    /** Método para obtener la cantidad del vuelto recibido en la compra del producto
     * @return Número entero con el total del vuelto recibido del expendedor */
    public int cuantoVuelto() {
        return vuelto;
    }

    /** Método para obtener el sabor del producto (El nombre del producto)
     * @return String que contiene el sabor del producto comprado */
    public String queSabor() {
        return sabor;
    }

    public void setnumPago(int cantidad) {
        numPago = cantidad;
    }
    public int getnumPago() {
        return numPago;
    }
    public void addMoneda(Moneda moneda) {
        depoPago.addContenido(moneda);
    }
}