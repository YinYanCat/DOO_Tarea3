package Vistas.Paneles;

import Vistas.Boton;
import Vistas.CuadroTexto;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/** Un panel que muestra las diferentes interacciones de un comprador en un expendedor
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelSelector extends JPanel {

    /** Arreglo de sub paneles donde se encuntran los componentes del panel */
    private JPanel[] Paneles;

    /** Arreglo de los cuadros de texto de la pantalla del panel selector */
    private CuadroTexto[] lPantalla;

    /** Arreglo de las imagenes utilizadas dentro del panel selector */
    private BufferedImage[] ImgUse;

    /** Arreglo de booleanos que indican la visibilidad de las imagenes dentro del panel selector  */
    private boolean[] ImgDisplay;

    /** Constructor donde se crea el panel, sus sub paneles, sus cuadros de texto y su imagen de fondo
     * @param x La coordenada X del panel
     * @param y La coordenada Y del panel
     * @param width El ancho del panel
     * @param height El alto del panel */
    public PanelSelector(int x, int y, int width, int height) {
        super(null);
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0,0,0,0));
        Paneles = new JPanel[3];
        lPantalla = new CuadroTexto[3];
        ImgUse = new BufferedImage[5];
        ImgDisplay = new boolean[2];

        try {
            ImgUse[0] = ImageIO.read(getClass().getClassLoader().getResource("imgVuelto.png"));
            ImgUse[1] = ImageIO.read(getClass().getClassLoader().getResource("imgPush.png"));
            ImgUse[3] = ImageIO.read(getClass().getClassLoader().getResource("imgPushMarco.png"));
            ImgUse[4] = ImageIO.read(getClass().getClassLoader().getResource("imgPanelComprador.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        lPantalla[0] = new CuadroTexto("Codigo: __", Color.BLACK, Color.WHITE, "OCR A Extended");
        lPantalla[1] = new CuadroTexto("Pago Ingresado: 0", Color.BLACK, Color.WHITE, "OCR A Extended");
        lPantalla[2] = new CuadroTexto(" ", Color.BLACK, Color.WHITE, "OCR A Extended");

        for(int i=0; i<3; i++) {
            Paneles[i] = new JPanel();
            Paneles[i].setBackground(new Color(0,0,0,0));
            Paneles[0].add(lPantalla[i]);
            this.add(Paneles[i]);
        }
        Paneles[0].setLayout(new GridLayout(3, 1));
        Paneles[0].setBounds(20,30,312,84);
        Paneles[1].setLayout(new GridLayout(2, 2, 10, 10));
        Paneles[1].setBounds(36,187,130,130);
        Paneles[2].setLayout(new GridLayout(1, 3, 10, 10));
        Paneles[2].setBounds(17,421,318,100);
    }

    /** Método para crear un NumPad con cuatro botones con números del 1 al 4
     * @param NumPad El arreglo de 4 botones que se van a utilizar para el NumPad */
    public void crearNumPad(Boton[] NumPad) {
        for(int i=0; i<4; i++) {
            NumPad[i] = new Boton(Color.BLACK,true,"imgBoton"+(i+1)+".png");
            Paneles[1].add(NumPad[i]);
        }
    }

    /** Método para crear un selector de monedas con tres botones con iconos de monedas
     * @param MonedasPad El arreglo de 3 botones que se van a utilizar para el selector de monedas */
    public void crearSelectMonedas(Boton[] MonedasPad) {
        for(int i=0; i<3; i++) {
            MonedasPad[i] = new Boton(new Color(133,170, 215),false,"imgMoneda"+i+".png");
            Paneles[2].add(MonedasPad[i]);
        }
    }

    /** Método para entregarle una nueva imagen a la imagen del producto
     * @param image La imagen a utilizar */
    public void setImageProduct(BufferedImage image) {
        ImgUse[2] = image;
    }

    /** Método para hacer visible o invisible imagenes especificas a un caso
     * @param setCase El número con el caso a utilizar
     * @param visible El booleano con la visiblidad de las imagenes del caso */
    public void setCaseVisible(int setCase, boolean visible) {
        ImgDisplay[setCase] = visible;
    }

    /** Método para entregarle un texto a un cuadro de texto dependiendo del cuadro
     * @param Pantalla El número con el cuadro de texto
     * @param texto El texto que se va a agregar al cuadro de texto */
    public void setPantalla(int Pantalla, String texto) {
        lPantalla[Pantalla].setText(texto);
    }

    /** Método para agregar un bóton al panel actual
     * @param boton El bóton que va a agregar al panel */
    public void addBoton(Boton boton) {
        this.add(boton);
    }

    /** Método para dibujar la imagen del fondo del panel, las imagenes visibles y sus componentes
     * @param g El objeto grafico que dibuja los componentes */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImgUse[4],0,0,this);
        if(ImgDisplay[0])
            g.drawImage(ImgUse[0],197,257,this);
        if(ImgDisplay[1]) {
            g.drawImage(ImgUse[1], 30, 596, this);
            g.drawImage(ImgUse[2], 70, 636, this);
            g.drawImage(ImgUse[3], 30, 596, this);
        }
    }
}
