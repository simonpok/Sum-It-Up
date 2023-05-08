import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tutorial {
    public static void main(String[] args) {

       Z object = new Z();
       object.z_get();
    }

}
class Z extends JFrame {
    public void z_get() {
        setTitle("Tutorial");
        setLayout(null);
        setVisible(true);
        setSize(600, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(50, 150, 500, 400);
        add(textArea);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Tutorial.txt"));
            String line = reader.readLine();
            while (line != null) {
                textArea.append(line + "\n");
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JButton butt1 = new JButton("BACK");
        JButton butt2 = new JButton("PROCEED");
        butt1.setFocusable(false);
        butt2.setFocusable(false);
        butt1.setBounds(10,10,100,50);
        add(butt1);
        butt2.setBounds(450,600,100,50);
        add(butt2);

        butt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuFrame.main(new String[0]);  //call the main method on the Main class and run it.
                setVisible(true);
                dispose();
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


