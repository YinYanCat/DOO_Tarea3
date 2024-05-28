import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador2 com;
    private PanelExpendedor exp;


    public PanelPrincipal(BorderLayout borderLayout) {
        super(borderLayout);
        this.setBackground(Color.lightGray);
        this.setLayout(new BorderLayout());

        exp = new PanelExpendedor();
        exp.setBackground(Color.BLUE);
        this.add(exp, BorderLayout.CENTER);

        com = new PanelComprador2();
        com.setBackground(Color.WHITE);
        this.add(com, BorderLayout.EAST);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        exp.paintComponent(g);
        com.paintComponent(g);

    }
}
