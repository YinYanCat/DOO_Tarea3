package Vistas.Paneles;

public class PanelLinker {
    private static PanelLinker panelLinker;
    private static PanelExpendedor panelExpendedor;
    private static PanelComprador panelComprador;

    private PanelLinker(PanelExpendedor panelExpendedor, PanelComprador panelComprador) {
        PanelLinker.panelExpendedor = panelExpendedor;
        PanelLinker.panelComprador = panelComprador;
    }

    public static void setLinker(PanelExpendedor panelExpendedor, PanelComprador panelComprador) {
        if(panelLinker == null){
            panelLinker = new PanelLinker(panelExpendedor, panelComprador);
        }
    }

    public static PanelExpendedor getPanelExpendendor(){
            return panelExpendedor;
    }

    public static PanelComprador getPanelComprador(){
            return panelComprador;
    }
}
