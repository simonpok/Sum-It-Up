import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class OvalPanel extends JPanel implements ActionListener {
    private int y = 650;
    private int num = 0, num2 = 0;
    private JButton[] buttons;
    private int count = 0;

    private Timer timer;

    private double speed =1.0;
    private Image backgroundImage;
    private JLabel scoreLabel;

    public OvalPanel() {

        backgroundImage= new ImageIcon("Background2.png").getImage();

        setLayout(null);


        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y-=speed;
                if (y < 0) {
                    y = 650;
                    num = generateRandomNumber();
                    num2 = getDigitSum(num);
                    createButtons();
                }
                repaint();
            }
        });
        timer.start();
        num = generateRandomNumber();
        num2 = getDigitSum(num);
        createButtons();

    }

    private void createButtons() {

        //Remove all existing buttons
        removeAll();

        //create an array of 3 buttons
        buttons = new JButton[3];

        //Generate random answers for each buttons
        for (int i = 0; i < buttons.length; i++) {

            //Generate a random number between 1 and 10
            int randAnswer = (int) (Math.random() * 10) + 1;

            //making sure the random number is not the same as num2
            while (randAnswer == num2) {
                randAnswer = (int) (Math.random() * 10) + 1;
            }

            //create a new button with the random answer
            buttons[i] = new JButton("" + randAnswer);

            //Add an action listener to the button (this refers to the current object)
            buttons[i].addActionListener(this);

            //set the bounds of the button (x,y,width, height)
            buttons[i].setBounds(490, 100 + (i * 50), 80, 40);

            //adding and managing buttons
            add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.GRAY);

        }
         //set the text of the random button to the correct answer
        int correctIndex = (int) (Math.random() * 3);
        buttons[correctIndex].setText("" + num2);

        validate();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw the background
        g.drawImage(backgroundImage,0,0,600,800,null);

        //Draw the Oval
        g.setColor(Color.CYAN);
        g.fillOval(250, y, 70, 70);
        g.setColor(Color.black);
        Font font = new Font("Arial", Font.BOLD, 22);
        g.setFont(font);
        String numberString = String.format("%4d", num);
        g.drawString(numberString, 260, y + 45);
        //System.out.println(y);



        //create a rectangle for collision
        g.setColor(Color.BLACK);
        g.fillRect(0,0,600,1);

        //Check if the Ball intersects with the rectangle
        Rectangle ovalBounds = new Rectangle(250, y, 70, 70);
        Rectangle rectangleBounds = new Rectangle(0,0,600,1);


        Font font1 = new Font("Arial", Font.PLAIN,25);
        //Score Label
        scoreLabel = new JLabel("Score: " + count);
        scoreLabel.setBounds(5, 0, 120, 40);
        scoreLabel.setVisible(true);
        add(scoreLabel);
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(font1);

        if(ovalBounds.intersects(rectangleBounds)){

            y=10;
            timer.stop();



            String text2 = Integer.toString(count);
            try{
                FileOutputStream outputStream = new FileOutputStream("score.txt");
                outputStream.write(text2.getBytes());
                outputStream.close();
                System.out.println("Score Saved");

            } catch (IOException ex) {
                ex.printStackTrace();
            }



// read the contents of name.txt
            String nameStr = "";
            try {
                BufferedReader reader = new BufferedReader(new FileReader("name.txt"));
                nameStr = reader.readLine();
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            Y obj = new Y();
            obj.y_get();

            //System.exit(0);
        }

        

    }

    private int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(8999) + 1000;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0 || sum > 9) {
            if (num == 0) {
                num = sum;
                sum = 0;
            }
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();
        int selectedAnswer = Integer.parseInt(buttonText);

        if (selectedAnswer == num2) {
            count++;
            y = 650;
            timer.start();
            num = generateRandomNumber();
            num2 = getDigitSum(num);
            createButtons();
        }

     else
    {
        timer.stop();


        String text2 = scoreLabel.getText();
        try{
            FileOutputStream outputStream = new FileOutputStream("score.txt");
            outputStream.write(text2.getBytes());
            outputStream.close();
            System.out.println("Score Saved");

        } catch (IOException ex) {
            ex.printStackTrace();
        }



// read the contents of name.txt
        String nameStr = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("name.txt"));
            nameStr = reader.readLine();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Y obj = new Y();
        obj.y_get();




        // display the name and score in the message dialog
       //JOptionPane.showMessageDialog(null, "GAME OVER!!!\nPlayer Name: "
         //       + nameStr + "\nFinal Score: " +count);


//         System.exit(0);





    }
     if (count %10==0)
     {
         speed+=1.0;
     }
        System.out.println(speed);

}

}