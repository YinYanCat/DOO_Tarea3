import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel {

    private JButton bCodigo1;
    private JButton bCodigo2;
    private JButton bCodigo3;
    private JButton bCodigo4;
    private JButton bMoneda100;
    private JButton bMoneda500;
    private JButton bMoneda1000;
    private JButton bVuelto;
    private JButton bGetProducto;
    private JLabel lProducto;
    private JLabel lMonto;
    private int select;
    private Comprador comprador;
    private Expendedor expendedor;

    public PanelComprador(Comprador comprador, Expendedor expendedor) {
        this.comprador = comprador;
        this.expendedor = expendedor;
        select = 0;
        Color darkRED = new Color(160,0, 0);

        bCodigo1 = new JButton("1");
        bCodigo2 = new JButton("2");
        bCodigo3 = new JButton("3");
        bCodigo4 = new JButton("4");
        bMoneda100 = new JButton("100");
        bMoneda500 = new JButton("500");
        bMoneda1000 = new JButton("1000");
        bVuelto = new JButton("VUELTO");
        bGetProducto = new JButton("PRODUCTO");
        lProducto = new JLabel("Codigo: __");
        lProducto.setForeground(Color.WHITE);
        lMonto = new JLabel("Pago Total: 0");
        lMonto.setForeground(Color.WHITE);

        InteraccionSelector listenerCompra = new InteraccionSelector();
        InteraccionExpendedor listenerMoneda = new InteraccionExpendedor();

        bCodigo1.addActionListener(listenerCompra);
        bCodigo2.addActionListener(listenerCompra);
        bCodigo3.addActionListener(listenerCompra);
        bCodigo4.addActionListener(listenerCompra);
        bMoneda100.addActionListener(listenerMoneda);
        bMoneda500.addActionListener(listenerMoneda);
        bMoneda1000.addActionListener(listenerMoneda);
        bGetProducto.addActionListener(listenerMoneda);
        bVuelto.addActionListener(listenerMoneda);

        this.setLayout(new GridLayout(2, 1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(Color.RED);

        JPanel panelSelect = new JPanel();
        panelSelect.setLayout(new GridLayout(2, 2, 10, 10));
        panelSelect.setBackground(darkRED);
        panelSelect.setBorder(BorderFactory.createMatteBorder(80, 40, 80, 40, darkRED));
        panelSelect.add(bCodigo1);
        panelSelect.add(bCodigo2);
        panelSelect.add(bCodigo3);
        panelSelect.add(bCodigo4);
        panel1.add(panelSelect, BorderLayout.CENTER);

        JPanel panelVuelto = new JPanel();
        panelVuelto.setLayout(new GridLayout(2, 1, 10, 10));
        panelVuelto.setBackground(darkRED);
        panelVuelto.setBorder(BorderFactory.createMatteBorder(80, 40, 80, 40, darkRED));
        panelVuelto.add(bVuelto);
        panelVuelto.add(bGetProducto);
        panel1.add(panelVuelto, BorderLayout.EAST);

        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new GridLayout(2, 1, 5, 5));
        panelTexto.setBackground(Color.BLACK);
        panelTexto.setBorder(BorderFactory.createMatteBorder(40, 10, 20, 10, Color.RED));
        panelTexto.add(lProducto);
        panelTexto.add(lMonto);
        panel1.add(panelTexto, BorderLayout.NORTH);

        this.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3));
        panel2.setBorder(BorderFactory.createLineBorder(Color.RED, 40));
        panel2.setBackground(Color.RED);
        panel2.add(bMoneda100);
        panel2.add(bMoneda500);
        panel2.add(bMoneda1000);
        this.add(panel2);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class InteraccionSelector implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Seleccion compra = null;

            if(e.getSource()==bCodigo1) {
                select = 1+select*10;
                if(select == 11)
                    compra = Seleccion.Snickers;
                else if(select == 21)
                    compra = Seleccion.Trencito;
                else if(select == 31)
                    compra = Seleccion.CocaCola;
                else if(select == 41)
                    compra = Seleccion.Bilz;
            }
            else if(e.getSource()==bCodigo2) {
                select = 2+select*10;
                if(select == 12)
                    compra = Seleccion.Super8;
                else if(select == 22)
                    compra = Seleccion.Doblon;
                else if(select == 32)
                    compra = Seleccion.Sprite;
                else if(select == 42)
                    compra = Seleccion.Pap;
            }
            else if(e.getSource()==bCodigo3) {
                select = 3+select*10;
                if(select == 13)
                    compra = Seleccion.Rolls;
                else if(select == 23)
                    compra = Seleccion.Flipy;
                else if(select == 33)
                    compra = Seleccion.Fanta;
                else if(select == 43)
                    compra = Seleccion.Kem;
            }
            else {
                select = 4+select*10;
                if(select == 14)
                    compra = Seleccion.SahneNuss;
                else if(select == 24)
                    compra = Seleccion.Ambrosito;
                else if(select == 34)
                    compra = Seleccion.Pepsi;
                else if(select == 44)
                    compra = Seleccion.LimonSoda;
            }

            if(compra == null)
                lProducto.setText("Codigo: "+select+"_");
            else {
                lProducto.setText("Codigo: "+select);
                try {
                    comprador.comprarEnExpendedor(expendedor, compra);
                    int vuelto = comprador.getnumPago()-compra.getPrecio();
                    comprador.setnumPago(0);
                    lMonto.setText("Pago Total: 0 | Vuelto: "+vuelto);
                } catch (Exception exception) {
                    lProducto.setText("Codigo: "+select+" [ ERROR: "+exception.getMessage()+ " ]");
                }
                select = 0;
            }
        }
    }
    private class InteraccionExpendedor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==bMoneda100) {
                comprador.addMoneda(new Moneda100());
            }
            else if(e.getSource()==bMoneda500) {
                comprador.addMoneda(new Moneda500());
            }
            else if(e.getSource()==bMoneda1000) {
                comprador.addMoneda(new Moneda1000());
            }
            else if(e.getSource()==bVuelto) {
                comprador.obtenerVuelto(expendedor);
                System.out.println("Vuelto: "+comprador.getVuelto());
                System.out.println("Billetera: "+comprador.getNumBilletera());
                expendedor.checkAlmacen();
            }
            else {
                Producto producto = expendedor.getProducto();
                if(producto == null)
                    System.out.println("No hay producto");
                else
                    System.out.println(producto.sabor());
            }
            lMonto.setText("Pago Total: "+comprador.getnumPago());
        }
    }
}