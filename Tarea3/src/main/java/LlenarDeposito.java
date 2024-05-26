public class LlenarDeposito {

    private int cantidadProductos;

    public LlenarDeposito() {
        cantidadProductos = 6;
    }
    public Deposito<Producto> llenarDepoConProducto(int numProductos, int productCase) {
        Deposito<Producto> newDepo = new Deposito<>();
        for(int j=0; j<numProductos; j++) {
            // Switch-case para llenar cada depósito con un producto distinto, siendo el total 'numProductos'
            switch(productCase) {
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
        return newDepo;
    }

    public int getcantidadProductos() {
        return cantidadProductos;
    }
}
