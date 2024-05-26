import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana(){
        super();
        this.setLayout((new BorderLayout()));
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1280,720);
        PanelPrincipal panel = new PanelPrincipal(new BorderLayout());
        this.add(panel,BorderLayout.CENTER);
        this.setVisible(true);
    }
}
