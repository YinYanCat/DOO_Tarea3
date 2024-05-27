/** El main en donde se realiza el programa
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class Main {
    public static void main(String[] args) throws Exception {

        Expendedor exp = new Expendedor(8);
        Moneda m = new Moneda500();
        Comprador c = null;
        Seleccion select = Seleccion.CocaCola;

        try {
            c = new Comprador(m, select, exp);
            System.out.println("Sabor: "+c.queSabor());
            System.out.println("Vuelto: "+c.cuantoVuelto());
        } catch (PagoIncorrectoException e) {
            System.out.println(e.getMessage());
            System.out.println("Sin producto\nSin vuelto");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sin producto\n"+"Vuelto: "+exp.getVuelto().getValor());
        }
    }
}
