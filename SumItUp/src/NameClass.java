import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class NameClass {
    public static void main(String[] args) {

        X obj = new X();
        obj.x_get();
//        ScoreBoard score =new ScoreBoard();
//        score.display(obj);
    }
}

class X extends JFrame{
    JTextField text = new JTextField();

    public void x_get()
    {
        JButton button = new JButton("JUMP IN");
        button.setBounds(250,450,100,30);

        JLabel label = new JLabel("Enter Your Name:");
        label.setBounds(120,400,100,30);



        text.setBounds(230,400,150,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //To print out the text of JTextField when button is Clicked
               String text1 = text.getText();
               try{
                   FileOutputStream outputStream = new FileOutputStream("name.txt");
                   outputStream.write(text1.getBytes());
                   outputStream.close();
                   System.out.println("Text Saved");
               }catch(IOException ex){
                   ex.printStackTrace();
               }
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
