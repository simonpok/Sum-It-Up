import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameClass {
    public static void main(String[] args) {

        X obj = new X();

    }
}

class X extends JFrame{
    public X()
    {
        JButton button = new JButton("JUMP IN");
        button.setBounds(250,450,100,30);

        JLabel label = new JLabel("Enter Your Name:");
        label.setBounds(120,400,100,30);


        JTextField text = new JTextField();
        text.setBounds(230,400,150,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");

                Main.main(new String[0]);  //call the main method on the Main class and run it.
                setVisible(true);
                dispose();
            }
        });

        setLayout(null);
        setVisible(true);
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(button);
        add(text);
        add(label);
    }
}
