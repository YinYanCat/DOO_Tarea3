package Modelos;

/** Un comprador que desea comprar un producto de una expendedora con una moneda, obteniendo un sabor y un vuelto
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Comprador {
    private Deposito<Moneda> billetera;
    private int numbilletera;
    private int vuelto;
    private Deposito<Moneda> depoPago;
    private int numPago;

    public Comprador() {
        billetera = new Deposito<>();
        numbilletera = 0;
        vuelto = 0;
        depoPago = new Deposito<>();
        numPago = 0;
    }
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
    public void setnumPago(int num) {
        numPago=num;
    }
    public int getVuelto() {
        return vuelto;
    }
    public int getnumPago() {
        return numPago;
    }
    public Deposito<Moneda> getdepoPago() {
        return depoPago;
    }
    public int getNumBilletera() {
        return numbilletera;
    }
    public void addMoneda(Moneda moneda) {
        depoPago.addContenido(moneda);
        numPago += moneda.getValor();
    }
}