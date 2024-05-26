import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(){
        super();
        this.setLayout((new BorderLayout()));
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1000,1000);
        PanelPrincipal panel = new PanelPrincipal();
        this.add(panel,BorderLayout.CENTER);
        this.setVisible(true);
    }
}
