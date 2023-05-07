import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuFrame extends JFrame implements ActionListener{
    private JButton playButton, exitButton, tutorialButton;
    
    public MenuFrame(){

        playButton = new JButton("Play");
        playButton.setSize(200,300);
        playButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        tutorialButton = new JButton("Tutorial");
        tutorialButton.addActionListener(this);

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

        setVisible(true);
        
}
    @Override
    public void actionPerformed(ActionEvent  e){

            if(e.getSource() == playButton){
                JFrame frame = new JFrame("SumItUp");
                ImageIcon icon = new ImageIcon("favicon.png");
                frame.setIconImage(icon.getImage());
                frame.setSize(600, 800);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

//                OvalPanel ovalpanel = new OvalPanel();
//                ovalpanel.setBounds(0, 0, 600, 800);
//                ovalpanel.setBackground(Color.CYAN);
//                frame.add(ovalpanel);


                X obj = new X();
                obj.x_get();
                frame.add(obj);



                frame.setVisible(true);

            // Close the current frame
                //this.dispose();
                System.exit(0);
            }
            else if(e.getSource() == exitButton){
                System.exit(0);
            }
            else if(e.getSource() == tutorialButton){
                //code for tutorial 
                System.out.println("Tutorial");
            }
    }
public static void main(String[] args){
    new MenuFrame();
}
    
}


