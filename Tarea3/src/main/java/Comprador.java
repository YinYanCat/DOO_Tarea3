/** Un comprador que desea comprar un producto de una expendedora con una moneda, obteniendo un sabor y un vuelto
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Comprador {

    /** String que contiene el sabor del producto */
    private String sabor;

    /** Número entero que contiene el vuelto total de la compra del producto */
    private int vuelto;

    /** Constructor en donde se compra el producto y se obtiene su sabor y el vuelto
     * @param moneda Una moneda que se utiliza para comprar el producto
     * @param selectProducto Número entero que contiene la selección del producto
     * @param exp Un expendedor en donde se va a comprar el producto */
    public Comprador(Moneda moneda, Seleccion selectProducto, Expendedor exp) throws Exception {
        vuelto = 0;
        Producto p = exp.comprarProducto(moneda,selectProducto);
        if(p!= null) {
            sabor = p.sabor();
        } else {
            // Si producto es un puntero null, sabor es null
            sabor=null;
        }
        Moneda monVuelto=null;
        while (true) {
            monVuelto = exp.getVuelto();
            // Cuando el deposito depoVuelto de 'Expendedor' queda vacio, retorna null
            // Luego de esto el comprador retiró el vuelto de la compra
            if (monVuelto == null) {
                break;
            } else {
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
}