import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador2 extends JPanel {

    private JButton bCodigo1;
    private JButton bCodigo2;
    private JButton bCodigo3;
    private JButton bCodigo4;
    private JButton bMoneda100;
    private JButton bMoneda500;
    private JButton bMoneda1000;
    private JButton bVuelto;
    private JLabel lProducto;

    private int select;

    public PanelComprador2() {

        select = 0;
        bCodigo1 = new JButton("1");
        bCodigo2 = new JButton("2");
        bCodigo3 = new JButton("3");
        bCodigo4 = new JButton("4");
        bMoneda100 = new JButton("100");
        bMoneda500 = new JButton("500");
        bMoneda1000 = new JButton("1000");
        bVuelto = new JButton("VUELTO");
        lProducto = new JLabel("String");
        lProducto.setForeground(Color.WHITE);

        ComprarProducto listenerCompra = new ComprarProducto();
        ManipularMoneda listenerMoneda = new ManipularMoneda();

        bCodigo1.addActionListener(listenerCompra);
        bCodigo2.addActionListener(listenerCompra);
        bCodigo3.addActionListener(listenerCompra);
        bCodigo4.addActionListener(listenerCompra);
        bMoneda100.addActionListener(listenerMoneda);
        bMoneda500.addActionListener(listenerMoneda);
        bMoneda1000.addActionListener(listenerMoneda);
        bVuelto.addActionListener(listenerMoneda);

        this.setLayout(new GridLayout(2, 1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBackground(Color.YELLOW);

        JPanel panelSelect = new JPanel();
        panelSelect.setLayout(new GridLayout(2, 2, 10, 10));
        panelSelect.setBackground(Color.BLACK);
        panelSelect.setBorder(BorderFactory.createMatteBorder(80, 40, 80, 40, Color.BLACK));
        panelSelect.add(bCodigo1);
        panelSelect.add(bCodigo2);
        panelSelect.add(bCodigo3);
        panelSelect.add(bCodigo4);
        panel1.add(panelSelect, BorderLayout.CENTER);

        JPanel panelVuelto = new JPanel();
        panelVuelto.setLayout(new BorderLayout());
        panelVuelto.setBackground(Color.BLUE);
        panelVuelto.setBorder(BorderFactory.createMatteBorder(80, 40, 80, 40, Color.BLUE));
        panelVuelto.add(bVuelto, BorderLayout.CENTER);
        panel1.add(panelVuelto, BorderLayout.EAST);

        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new BorderLayout());
        panelTexto.setBackground(Color.BLACK);
        panelTexto.setBorder(BorderFactory.createMatteBorder(40, 10, 20, 10, Color.YELLOW));
        panelTexto.add(lProducto, BorderLayout.CENTER);
        panel1.add(panelTexto, BorderLayout.NORTH);

        this.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3));
        panel2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 40));
        panel2.setBackground(Color.GREEN);
        panel2.add(bMoneda100);
        panel2.add(bMoneda500);
        panel2.add(bMoneda1000);
        this.add(panel2);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private class ComprarProducto implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Seleccion compra = null;

            if(e.getSource()==bCodigo1) {
                if(select == 0)
                    select = 1;
                else if(select == 1)
                    System.out.println("CocaCola");
                else if(select == 2)
                    System.out.println("Bilz");
                else if(select == 3)
                    System.out.println("Snickers");
                else
                    System.out.println("SahneNuss");
            }

            else if(e.getSource()==bCodigo2) {
                if(select == 0)
                    select = 2;
                else if(select == 1)
                    System.out.println("Fanta");
                else if(select == 2)
                    System.out.println("Pap");
                else if(select == 3)
                    System.out.println("Super8");
                else
                    System.out.println("Ambrosito");
            }

            else if(e.getSource()==bCodigo3) {
                if(select == 0)
                    select = 3;
                else if(select == 1)
                    System.out.println("Sprite");
                else if(select == 2)
                    System.out.println("Kem");
                else if(select == 3)
                    System.out.println("Flipy");
                else
                    System.out.println("Trencito");
            }

            else {
                if(select == 0)
                    select = 4;
                else if(select == 1)
                    System.out.println("Pepsi");
                else if(select == 2)
                    System.out.println("LimonSoda");
                else if(select == 3)
                    System.out.println("Rolls");
                else
                    System.out.println("Doblon");
            }


        }
    }
    private class ManipularMoneda implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()==bMoneda100) {
                System.out.println("100");
            }

            else if(e.getSource()==bMoneda500) {
                System.out.println("500");
            }

            else if(e.getSource()==bMoneda1000) {
                System.out.println("1000");
            }

            else {
                System.out.println("Vuelto");
            }
        }
    }
}