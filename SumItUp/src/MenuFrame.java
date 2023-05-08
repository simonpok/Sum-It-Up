import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuFrame extends JFrame implements ActionListener{
    private JButton playButton, exitButton, tutorialButton;

    public MenuFrame(){

        playButton = new JButton("Play");
        playButton.setSize(200,300);
        playButton.addActionListener(this);
        playButton.setFocusable(false);

        exitButton = new JButton("Tutorial");
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);

        tutorialButton = new JButton("Exit");
        tutorialButton.addActionListener(this);
        tutorialButton.setFocusable(false);

        JPanel panel = new JPanel();
        panel.setSize(400, 800);
        panel.setLayout(new GridLayout(3,1));
        panel.add(playButton);
        panel.add(exitButton);
        panel.add(tutorialButton);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,800);
        this.setTitle("Menu");
        this.setLocationRelativeTo(null);
        setVisible(true);
        
}
    @Override
    public void actionPerformed(ActionEvent  e){

            if(e.getSource() == playButton){
                JFrame frame = new JFrame("SumItUp");
                ImageIcon icon = new ImageIcon("mygame.png");
                frame.setIconImage(icon.getImage());
                frame.setSize(600, 800);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);

                frame.setResizable(false);



                //Opens NameClass Frame
                X obj = new X();
                obj.x_get();

                // Close the current frame
                dispose();


            }
            else if(e.getSource() == tutorialButton){
                System.exit(0);
            }
            else if(e.getSource() ==  exitButton){
                //code for tutorial 
                System.out.println("Tutorial");

                Z object = new Z();
                object.z_get();
                dispose();
            }
    }
public static void main(String[] args){
    new MenuFrame();
}
    
}


