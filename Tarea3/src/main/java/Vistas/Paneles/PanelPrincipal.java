package Vistas.Paneles;

import Modelos.*;

import javax.swing.*;
import java.awt.*;

/** Un panel principal de la ventana que contiene todos los sub paneles del programa
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelPrincipal extends JPanel {

    /** Un PanelExpendedor que contiene el expendedor del programa */
    private PanelExpendedor panelExp;

    /** Un PanelComprador que contiene el comprador del programa */
    private PanelComprador panelCom;

    /** Constructor se crea el Panel principal y los sub paneles PanelExpendedor y PanelComprador
     * @param borderLayout La distribución de los componentes en el panel */
    public PanelPrincipal(BorderLayout borderLayout) {
        super(borderLayout);
        int CantidadDeProductos = 5;
        this.setBackground(new Color(99,155, 255));
        this.setLayout(new BorderLayout());
        panelExp = new PanelExpendedor(new Expendedor(CantidadDeProductos));
        panelExp.setPreferredSize(new Dimension(663,720));
        this.add(panelExp, BorderLayout.WEST);
        panelCom = new PanelComprador(new Comprador());
        panelCom.setPreferredSize(new Dimension(603,720));
        this.add(panelCom, BorderLayout.EAST);
        PanelLinker.setLinker(panelExp, panelCom);
    }

    /** Método para dibujar los componentes de Swing del panel y los sub paneles
     * @param g El objeto grafico que dibuja los componentes */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        panelExp.paintComponent(g);
        panelCom.paintComponent(g);
    }
}
