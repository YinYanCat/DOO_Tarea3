import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelExpendedor extends JPanel {



    private BufferedImage image;

    public PanelExpendedor() {
        try {
            image = ImageIO.read(new File("./Images/Expendedor2.png"));
        } catch (IOException ex) {
            try {
                image = ImageIO.read(new File("./Tarea3/Images/Expendedor2.png"));
            } catch (IOException ex2) {
                System.out.println(ex2.getMessage());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

}
