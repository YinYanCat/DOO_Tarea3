import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel {

    JRadioButton rbProduct1;
    JRadioButton rbProduct2;
    JRadioButton rbProduct3;
    JButton bComprar;

    public PanelComprador(){
        this.setLayout(new GridLayout(4,1));
        rbProduct1 = new JRadioButton("Producto1");
        rbProduct2 = new JRadioButton("Producto2");
        rbProduct3 = new JRadioButton("Producto3");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbProduct1);
        bg.add(rbProduct2);
        bg.add(rbProduct3);
        bComprar = new JButton("Comprar");
        bComprar.addActionListener(new EscucharCompra());
        this.add(rbProduct1);
        this.add(rbProduct2);
        this.add(rbProduct3);
        this.add(bComprar);



    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    private class EscucharCompra implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(rbProduct1.isSelected()){

            }
            if(rbProduct2.isSelected()){

            }
            if(rbProduct3.isSelected()){

            }

        }
    }
}
