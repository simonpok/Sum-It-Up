import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JButton newGameBtn, loadGameBtn, exitBtn;
    private JLabel titleLabel;

    public Menu() {

        setTitle("Menu");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        titleLabel = new JLabel("Welcome", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        newGameBtn = new JButton("New Game");
        loadGameBtn = new JButton("Load Game");
        exitBtn = new JButton("Exit");

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(newGameBtn);
        buttonPanel.add(loadGameBtn);
        buttonPanel.add(exitBtn);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}
