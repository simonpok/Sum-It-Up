import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreBoard  {

        public static void main(String[] args){
        Y obj = new Y();
        obj.y_get();
    }
}

class Y extends JFrame{


    public void y_get(){

        //read the Name of the player
        String nameStr = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("name.txt"));
            nameStr = reader.readLine();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // read the contents of score.txt
        String scoreStr = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("score.txt"));
            scoreStr = reader.readLine();
            reader.close();
       } catch (IOException ex) {
            ex.printStackTrace();
        }

        JLabel label = new JLabel("Player name: "+nameStr);
        label.setBounds(200,5,200,200);

        JLabel label1 = new JLabel("Your Total "+scoreStr);
        label1.setBounds(200,50,200,200);


        setVisible(true);
        setSize(600,800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(label);
        add(label1);
        setLocationRelativeTo(null);
        setResizable(false);
        //toFront();

        JButton butt1 = new JButton("EXIT");
        JButton butt2 = new JButton("Try Again");
        add(butt1);
        add(butt2);
        butt1.setBounds(480,700,100,40);
        butt2.setBounds(10,700,100,40);
        butt1.setFocusable(false);
        butt2.setFocusable(false);
        butt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        butt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Opens NameClass Frame
                X obj = new X();
                obj.x_get();

                // Close the current frame
                dispose();

            }
        });


    }
}


