package Vistas.Paneles;

/** Un Singleton que enlaza un PanelExpendedor y un PanelComprador y duelve los mismos
 * @author Chloe Yañez Lavin
 * @author Emily Osvaldo Gaete Bobadilla */

public class PanelLinker {

    /** Puntero a la instancia única de PanelLinker */
    private static PanelLinker panelLinker;

    /** El PanelExpendedor conectado al enlace */
    private static PanelExpendedor panelExpendedor;

    /** El PanelComprador conectado al enlace */
    private static PanelComprador panelComprador;

    /** Constructor privado donde se guardan los punteros de PanelExpendedor y un PanelComprador
     * @param panelExpendedor El PanelExpendedor a enlazar
     * @param panelComprador El PanelComprador a enlazar */
    private PanelLinker(PanelExpendedor panelExpendedor, PanelComprador panelComprador) {
        PanelLinker.panelExpendedor = panelExpendedor;
        PanelLinker.panelComprador = panelComprador;
    }

    /** Método para ingresar los punteros a enlazar una única vez
     * @param panelExpendedor El puntero al PanelExpendedor a enlazar
     * @param panelComprador El puntero al PanelComprador a enlazar */
    public static void setLinker(PanelExpendedor panelExpendedor, PanelComprador panelComprador) {
        if(panelLinker == null){
            panelLinker = new PanelLinker(panelExpendedor, panelComprador);
        }
    }

    /** Método que entrega la instancia guardada en el enlaze de PanelExpendedor
     * @return El puntero guardado de PanelExpendedor */
    public static PanelExpendedor getPanelExpendendor(){
            return panelExpendedor;
    }

    /** Método que entrega la instancia guardada en el enlaze de PanelComprador
     * @return El puntero guardado de PanelComprador */
    public static PanelComprador getPanelComprador(){
            return panelComprador;
    }
}
