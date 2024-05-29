package Vistas;

import Vistas.PanelPrincipal;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    public Ventana() {
        super();
        this.setLayout((new BorderLayout()));
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1280,757);
        this.setResizable(false);
        PanelPrincipal panel = new PanelPrincipal(new BorderLayout());
        this.add(panel,BorderLayout.CENTER);
        this.setVisible(true);
    }
}
