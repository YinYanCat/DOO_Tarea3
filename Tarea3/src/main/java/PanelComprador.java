import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {

    public PanelComprador(){
        this.setBackground(Color.blue);
        this.setLayout(new GridLayout(3,3));
        this.add(new JButton(("1")));
        this.add(new JButton(("2")));
        this.add(new JButton(("3")));
        this.add(new JButton(("4")));
        this.add(new JButton(("5")));
        this.add(new JButton(("6")));
        this.add(new JButton(("7")));
        this.add(new JButton(("8")));
        this.add(new JButton(("9")));

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
