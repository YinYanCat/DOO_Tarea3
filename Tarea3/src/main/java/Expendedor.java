import java.util.ArrayList;

/** Un expendedor que al ingresar una moneda y un número devuelve un producto y su vuelto
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Expendedor {

    /** Lista de todos los depósitos del expendedor, con un producto distinto en cada depósito */
    private ArrayList<Deposito<Producto>> listDepositos;

    /** Depósito de monedas donde se guarda el vuelto de la compra en monedas de 100 */
    private Deposito<Moneda> depoVuelto;

    /** Constructor para crear y llenar los depósitos del expendedor con productos
     * @param numProductos Número entero con la cantidad de productos que tiene cada depósito de 'listDepositos' */
    public Expendedor(int numProductos) {
        listDepositos = new ArrayList<>();
        depoVuelto = new Deposito<>();
        // Ciclo for para crear instancias de 'Deposito' para añadir a listDepositos
        for(int i=0; i<6; i++) {
            Deposito<Producto> newDepo = new Deposito<>();
            for(int j=0; j<numProductos; j++) {
                // Switch-case para llenar cada depósito con un producto distinto, siendo el total 'numProductos'
                switch(i) {
                    case 0:
                        newDepo.addContenido(new CocaCola(j + 100));
                        break;
                    case 1:
                        newDepo.addContenido(new Sprite(j + 200));
                        break;
                    case 2:
                        newDepo.addContenido(new Fanta(j + 300));
                        break;
                    case 3:
                        newDepo.addContenido(new Snickers(j + 400));
                        break;
                    case 4:
                        newDepo.addContenido(new Super8(j + 500));
                        break;
                    case 5:
                        newDepo.addContenido(new Flipy(j + 600));
                        break;
                }
            }
            listDepositos.add(newDepo);
        }
    }

    /** Método para comprar un producto del expendedor, sacándolo de uno de sus depósitos
     * @param moneda Una moneda que se utiliza para comprar el producto'
     * @param select Número entero con la selección del producto a comprar'
     * @return Instancia de 'Producto' con el producto comprado,
     * @throws PagoIncorrectoException Se lanza esta excepción si no existe una moneda para pagar (null)
     * @throws NoHayProductoException Se lanza esta excepción si no queda o no existe el producto seleccionado
     * @throws PagoInsuficienteException Se lanza esta excepción si el pago es menor al precio del producto */
    public Producto comprarProducto(Moneda moneda, Seleccion select) throws Exception {
        //Moneda con puntero null (No existe moneda)
        if(moneda == null)
            throw new PagoIncorrectoException("Método de pago invalido");
        Producto producto = null;
        //Precio y vuelto del producto elegido
        int precio = select.getPrecio();
        int vuelto = moneda.getValor() - precio;
        if(vuelto >= 0) {
            producto = listDepositos.get(select.getNumDepo()).getContenido();
            //Depósito vacio (No queda producto elegido)
            if(producto == null) {
                depoVuelto.addContenido(moneda);
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
            depoVuelto.addContenido(moneda);
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
