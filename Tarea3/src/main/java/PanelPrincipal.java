import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;


    public PanelPrincipal(BorderLayout borderLayout){
        super(borderLayout);
        exp = new PanelExpendedor();
        exp.setBackground(Color.GREEN);
        com = new PanelComprador();
        com.setBackground(Color.BLUE);
        this.setBackground(Color.red);
        this.add(exp,BorderLayout.NORTH);
        this.add(com,BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        com.paintComponent(g);
        exp.paintComponent(g);
    }
}
