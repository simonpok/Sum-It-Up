import javax.swing.*;
import java.awt.*;

class GamePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(5, 5, 600, 1);




    }
}