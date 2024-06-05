package Vistas.Paneles;

import Modelos.Deposito;
import Modelos.Monedas.Moneda;
import Vistas.CuadroTexto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/** Un panel que muestra las monedas guardadas en un deposito y sus series
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelAlmacen extends JPanel {

    /** Lista de paneles con un objeto, en este caso una moneda, en cada panel */
    private ArrayList<PanelObjeto> panelMoneda;

    /** Arreglo de enteros que contiene la coordenada (x,y) del último PanelObjeto agregado */
    private int[] startPos;

    /** Arreglo de cuadros de texto que muestran información sobre el panel */
    private CuadroTexto[] lExtraMonedas;

    /** Imagen que se dibuja al fondo del panel */
    private BufferedImage ImgBackground;

    /** Booleano que indica si el panel es visible o invisible */
    private boolean visible;

    /** Constructor se crea el panel, su fondo y sus cuadros de texto */
    public PanelAlmacen() {
        super(null);
        visible = false;
        startPos = new int [2];
        this.setBounds(30, 80,603,550);
        this.setBackground(new Color(0,0,0,0));
        lExtraMonedas = new CuadroTexto[2];
        for(int i=0; i<2; i++) {
            lExtraMonedas[i] = new CuadroTexto("", new Color(0,0,0,0), Color.WHITE, "Arial");
            lExtraMonedas[i].setBounds(30,510-(430*i),150,20);
            this.add(lExtraMonedas[i]);
        }

        try {
            ImgBackground = ImageIO.read(getClass().getClassLoader().getResource("imgPanelMonedas.png"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        panelMoneda = new ArrayList<>();
    }

    /** Método para volver visible o invisible al panel y sus componentes */
    public void togglePanel() {
        visible = !visible;
        for(int i=0; i<panelMoneda.size(); i++) {
            if(visible)
                this.add(panelMoneda.get(i));
            else
                this.remove(panelMoneda.get(i));
            panelMoneda.get(i).togglePanel();
        }
    }

    /** Método para obtener la visibilidad actual del panel
     * @return El booleano que indica la visibilidad del panel y sus componentes */
    public boolean getVisible() { return visible; }

    public void setText(String text, int i) {
        if (visible) {
            lExtraMonedas[i].setText(text);
            lExtraMonedas[i].setBackground(new Color(20, 20, 68));
        } else {
            lExtraMonedas[i].setText("");
            lExtraMonedas[i].setBackground(new Color(0, 0, 0, 0));
        }
    }

    /** Método para asignar una coordenada y añadir los PanelObjeto's con monedas al PanelAlmacen
     * @param depoExp El deposito con las monedas a añadir
     * @param total El valor total de las monedas dentro del deposito */
    public void setMonedas(Deposito<Moneda> depoExp, int total) {
        for(int j = startPos[0]; j<depoExp.getSizeCont(); j++) {
            if(j>=72)
                break;
            panelMoneda.add(new PanelObjeto(12+28*(j%18),110+100* startPos[1],100,100));
            panelMoneda.get(j).setObjeto(depoExp.checkContenido(j));
            this.add(panelMoneda.get(j));
            if(j%18==17)
                startPos[1]++;
        }
        if(depoExp.getSizeCont()-72>0)
            setText("+"+(depoExp.getSizeCont()-72)+" Monedas", 0);
        setText("Total: "+total, 1);
        startPos[0] = depoExp.getSizeCont();
    }

    /** Método para dibujar la imagen del fondo del panel y sus componentes
     * @param g El objeto grafico que dibuja los componentes */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(visible)
            g.drawImage(ImgBackground, 0, 0, this);
    }
}
