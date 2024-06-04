package Vistas;

import Vistas.Paneles.PanelComprador;
import Vistas.Paneles.PanelExpendedor;
import Vistas.Paneles.PanelPrincipal;

public class Intermediario {

    private PanelPrincipal panelPrincipal;
    private PanelExpendedor panelExpendedor;
    private PanelComprador panelComprador;

    public Intermediario(PanelPrincipal panelPrincipal, PanelComprador panelComprador, PanelExpendedor panelExpendedor) {
        this.panelPrincipal = panelPrincipal;
        this.panelExpendedor = panelExpendedor;
        this.panelComprador = panelComprador;
    }
    public PanelPrincipal getPanelPrin(){ return panelPrincipal; }

    public PanelExpendedor getPanelExp(){ return panelExpendedor; }

    public PanelComprador getPanelComp(){ return panelComprador; }
}
