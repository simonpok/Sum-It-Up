import javax.swing.*;
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
    }
}


