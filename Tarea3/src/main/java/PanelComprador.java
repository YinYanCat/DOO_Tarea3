import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel {

    Comprador comprador;

    JRadioButton rbCoca;
    JRadioButton rbFanta;
    JRadioButton rbSprite;
    JRadioButton rbBilz;
    JRadioButton rbPap;
    JRadioButton rbKem;
    JRadioButton rbSnicker;
    JRadioButton rbSuper8;
    JRadioButton rbFlipy;
    JRadioButton rbRolls;
    JRadioButton rbSahnenuss;
    JRadioButton rbAmbrosito;

//     BOTONES TEMPORALES
//     EXPENDEDOR ACTUAL PUEDE SOLO RECIBIR UNA MONEDA
//     TO-DO PERMITIR MAS DE 1 MONEDA (AGREAR MONEDA100, AGREGAR MONEDA100, ... = $1000 INSERTADOS)

    JRadioButton rbMoneda500;
    JRadioButton rbMoneda1000;
    JRadioButton rbMoneda1500;
    JButton bComprar;

    public PanelComprador() {
        this.setLayout(new GridLayout(4, 4));

        rbCoca = new JRadioButton("CocaCola");
        rbFanta = new JRadioButton("Fanta");
        rbSprite = new JRadioButton("Sprite");
        rbBilz = new JRadioButton("Bilz");
        rbPap = new JRadioButton("Pap");
        rbKem = new JRadioButton("Kem");
        rbSnicker = new JRadioButton("Snickers");
        rbSuper8 = new JRadioButton("Super8");
        rbFlipy = new JRadioButton("Flipy");
        rbRolls = new JRadioButton("Rolls");
        rbSahnenuss = new JRadioButton("Sahne-Nuss");
        rbAmbrosito = new JRadioButton("Ambrosito");

        //Botones Monedas
        rbMoneda500 = new JRadioButton("Moneda 500");
        rbMoneda1000 = new JRadioButton("Moneda 1000");
        rbMoneda1500 = new JRadioButton("Moneda 1500");

        ButtonGroup bgMonedas = new ButtonGroup();
        bgMonedas.add(rbMoneda500);
        bgMonedas.add(rbMoneda1000);
        bgMonedas.add(rbMoneda1500);

        ButtonGroup bgProd = new ButtonGroup();
        bgProd.add(rbCoca);
        bgProd.add(rbFanta);
        bgProd.add(rbSprite);
        bgProd.add(rbBilz);
        bgProd.add(rbPap);
        bgProd.add(rbKem);
        bgProd.add(rbSnicker);
        bgProd.add(rbSuper8);
        bgProd.add(rbFlipy);
        bgProd.add(rbRolls);
        bgProd.add(rbSahnenuss);
        bgProd.add(rbAmbrosito);

        this.add(rbCoca);
        this.add(rbFanta);
        this.add(rbSprite);
        this.add(rbBilz);
        this.add(rbPap);
        this.add(rbKem);
        this.add(rbSnicker);
        this.add(rbSuper8);
        this.add(rbFlipy);
        this.add(rbRolls);
        this.add(rbSahnenuss);
        this.add(rbAmbrosito);

        this.add(rbMoneda500);
        this.add(rbMoneda1000);
        this.add(rbMoneda1500);

        bComprar = new JButton("Comprar");
        bComprar.addActionListener(new ComprarProducto());
        this.add(bComprar);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }



    private class ComprarProducto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Seleccion selProducto = null;
            Moneda m;

            if (rbMoneda500.isSelected()){
                m = new Moneda500();
            } else if (rbMoneda1000.isSelected()) {
                m = new Moneda1000();
            } else if (rbMoneda1500.isSelected()) {
                m = new Moneda1500();
            }

            if (rbCoca.isSelected()) {
                selProducto = Seleccion.CocaCola;
            }
            else if (rbFanta.isSelected()) {
                selProducto = Seleccion.Fanta;
            }
            else if (rbSprite.isSelected()) {
                selProducto = Seleccion.Sprite;
            }
            else if (rbBilz.isSelected()) {
                selProducto = Seleccion.Bilz;
            }
            else if (rbPap.isSelected()) {
                selProducto = Seleccion.Pap;
            }
            else if (rbKem.isSelected()) {
                selProducto = Seleccion.Kem;
            }
            else if (rbSnicker.isSelected()) {
                selProducto = Seleccion.Snickers;
            }
            else if (rbSuper8.isSelected()) {
                selProducto = Seleccion.Super8;
            }
            else if (rbFlipy.isSelected()) {
                selProducto = Seleccion.Flipy;
            }
            else if (rbRolls.isSelected()) {
                System.out.println("Rolls");
            }
            else if (rbSahnenuss.isSelected()) {
                System.out.println("Sahne-Nuss");
            }
            else {
                System.out.println("Ambrosito");
            }

            
        }
    }
}
