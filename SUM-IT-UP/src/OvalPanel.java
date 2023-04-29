import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OvalPanel extends JPanel implements ActionListener {
    private int y = 650;
    private int num = 0,num2=0;
    private JButton[] buttons;
    private int count=0;

    private Timer timer;

    public OvalPanel() {
        //setLayout(new GridLayout(2,2));
        setLayout(null);
        timer = new Timer(-100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y--;
                if (y < 0) {
                    y = 650;
                    num = generateRandomNumber();
                    num2=getDigitSum(num);
                    createButtons();
                }
                repaint();
            }
        });
        timer.start();
        num = generateRandomNumber();
        num2=getDigitSum(num);
        createButtons();
    }

    private void createButtons() {
        removeAll();
        buttons = new JButton[3];
        for (int i = 0; i < buttons.length; i++) {
            int randAnswer = (int)(Math.random() * 10) + 1;
            while (randAnswer == num2) {
                randAnswer = (int)(Math.random() * 10) + 1;
            }
            buttons[i] = new JButton("" + randAnswer);
            buttons[i].addActionListener(this);
            buttons[i].setBounds(490 , 100+(i * 50), 80, 40); // Set the bounds of the button
            add(buttons[i]);
        }

        JLabel label = new JLabel("Score: "+count);
        label.setBounds(0,0,100,100);
        label.setVisible(true);
        add(label);

        int correctIndex = (int)(Math.random() * 3);
        buttons[correctIndex].setText("" + num2);
        validate();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(250, y, 70, 70);
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 22);
        g.setFont(font);
        String numberString = String.format("%4d", num);
        g.drawString(numberString, 260, y + 45);
    }

    private int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(8999)+1000;
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
        JButton button = (JButton)e.getSource();
        String buttonText = button.getText();
        int selectedAnswer = Integer.parseInt(buttonText);
        if (selectedAnswer == num2) {
            //JOptionPane.showMessageDialog(null, "Correct!");
            count++;
            y=650;
            timer.start();
            num = generateRandomNumber();
            num2=getDigitSum(num);
            createButtons();

        } else {
            JOptionPane.showMessageDialog(null, "Incorrect.");
        }
    }
}