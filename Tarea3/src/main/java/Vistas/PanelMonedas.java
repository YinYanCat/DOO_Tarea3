package Vistas;

import javax.swing.*;
import java.awt.*;

public class PanelMonedas extends JPanel {

    private boolean visible;

    public PanelMonedas() {
        visible = false;
        this.setBounds(30, 140,600,500);
        this.setBackground(new Color(0,0,0,0));
    }

    public void togglePanel() {
        if(visible) {
            this.setBackground(new Color(0,0,0,0));
            visible = false;
        }
        else {
            this.setBackground(Color.BLUE);
            visible = true;
        }
    }
}
