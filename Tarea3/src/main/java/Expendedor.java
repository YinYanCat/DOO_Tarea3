import java.util.ArrayList;

/** Un expendedor que al ingresar una moneda y un número devuelve un producto y su vuelto
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Expendedor {

    /** Lista de todos los depósitos del expendedor, con un producto distinto en cada depósito */
    private ArrayList<Deposito<Producto>> listDepositos;

    /** Depósito de monedas donde se guarda el vuelto de la compra en monedas de 100 */
    private Deposito<Moneda> depoVuelto;

    /** Depósito de monedas donde se guarda el vuelto de la compra en monedas de 100 */
    private Deposito<Moneda> depoAlmacenMonedas;

    /** Constructor para crear y llenar los depósitos del expendedor con productos
     * @param numProductos Número entero con la cantidad de productos que tiene cada depósito de 'listDepositos' */
    public Expendedor(int numProductos) {
        listDepositos = new ArrayList<>();
        depoVuelto = new Deposito<>();
        depoAlmacenMonedas = new Deposito<>();
        Trabajador trabajador = new Trabajador();
        // Llenar los depositos con productos
        for(int i=0; i<trabajador.getcantidadProductos(); i++) {
            listDepositos.add(trabajador.llenarDeposito(numProductos, i));
        }
    }

    /** Método para comprar un producto del expendedor, sacándolo de uno de sus depósitos
     * @param cantidadPago El monto total de las monedas ingresadas
     * @param select Selección con el producto a comprar'
     * @return Instancia de 'Producto' con el producto comprado,
     * @throws PagoIncorrectoException Se lanza esta excepción si no existe una moneda para pagar (null)
     * @throws NoHayProductoException Se lanza esta excepción si no queda o no existe el producto seleccionado
     * @throws PagoInsuficienteException Se lanza esta excepción si el pago es menor al precio del producto */
    public Producto comprarProducto(int cantidadPago, Deposito<Moneda> depoMonedas, Seleccion select) throws Exception {
        //Moneda con puntero null (No existe moneda)
        if(cantidadPago <= 0)
            throw new PagoIncorrectoException("Moneda no ingresada");
        Producto producto = null;
        //Precio y vuelto del producto elegido
        int precio = select.getPrecio();
        int vuelto = cantidadPago - precio;
        if(vuelto >= 0) {
            producto = listDepositos.get(select.getNumDepo()).getContenido();
            //Depósito vacio (No queda producto elegido)
            if(producto == null) {
                depoVuelto = depoMonedas;
                throw new NoHayProductoException("Producto seleccionado agotado");
            }
            //Creación de las instancias 'Moneda100' en depoVuelto para el vuelto del producto
            Moneda m_vuelto = null;
            for (int i = 0; i < vuelto; i+=100) {
                m_vuelto = new Moneda100();
                depoVuelto.addContenido(m_vuelto);
            }
        }
        //Pago menor al precio del producto
        else {
            depoVuelto = depoMonedas;
            throw new PagoInsuficienteException("Pago insuficiente");
        }
        return producto;
    }

    /** Método para devolver una primera moneda del depósito de vuelto del expendedor
     * @return Una moneda de 100 del vuelto, cuando se vacía el deposito retorna null*/
    public Moneda getVuelto() {
        return depoVuelto.getContenido();
    }
}