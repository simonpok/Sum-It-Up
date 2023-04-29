import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("POP THE BALLON!");
        frame.setSize(600,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        GamePanel gamePanel = new GamePanel();
        gamePanel.setBounds(5, 5, 600, 1);
        gamePanel.setBackground(Color.BLACK);
        frame.add(gamePanel);


        OvalPanel ovalpanel = new OvalPanel();

        ovalpanel.setBounds(6,6,600,800);
        ovalpanel.setBackground(Color.cyan);
        frame.add(ovalpanel);


        frame.setVisible(true);

    }

}