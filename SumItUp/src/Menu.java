import javax.swing.*;
import java.awt.Component;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener{
    private JButton playButton, exitButton, tutorialButton;
    
    public Menu(){
        JFrame frame = new JFrame();
        frame.setTitle("Game Menu");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JButton playButton = new JButton("Play");
        playButton.setBounds(200, 100, 400,50);
        playButton.setLocation(100,200);
        playButton.setVisible(true);
        frame.add(playButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(200, 400, 400,50);
        exitButton.setLocation(100,280);
        exitButton.setVisible(true);
        
        frame.add(exitButton);

        JButton tutorialButton = new JButton("tutorial");
        tutorialButton.setBounds(600, 10, 80,50);
        tutorialButton.setLocation(500,10);
        tutorialButton.setVisible(true);
        frame.add(tutorialButton);

        playButton.addActionListener(this);
        exitButton.addActionListener(this);
        tutorialButton.addActionListener(this);

        setVisible(true);
        
}
    public void actionPerformed(ActionEvent  e){
            if (e.getSource() == playButton){
                getContentPane().removeAll();
                // Main main = new Main();
                JFrame frame = new JFrame();
                getContentPane().add(frame);
                pack();
                validate();
            }  
            //  exitButton.addActionListener(e ->{
            //      System.exit(0);
            //  });
            else if (e.getSource() == exitButton){
                System.exit(0);
            }
    }

    public static void main(String[] args) {
    Menu menu = new Menu();
    }
}

