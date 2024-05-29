package Vistas;

public class Intermediario  {
    private PanelComprador panelCom;
    private PanelExpendedor panelExp;
    public Intermediario(PanelComprador panelCom, PanelExpendedor panelExp) {
        this.panelCom = panelCom;
        this.panelExp = panelExp;
    }
    public PanelComprador getPanelComp(){ return panelCom; }
    public PanelExpendedor getPanelExp(){ return panelExp; }
}
