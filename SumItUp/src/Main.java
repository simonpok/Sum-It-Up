import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("SumItUp");
        ImageIcon icon = new ImageIcon("favicon.png");
        frame.setIconImage(icon.getImage());
        frame.setSize(600,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        //Create a Panel
        OvalPanel ovalpanel = new OvalPanel();
        ovalpanel.setBounds(0,0,600,800);
        ovalpanel.setBackground(Color.CYAN);
        frame.add(ovalpanel);


        frame.setVisible(true);

    }

}