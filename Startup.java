import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Startup extends JFrame{
    public Startup(String title) {
        super(title);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);        

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        JLabel headerLbl = new JLabel("Welcome");
        headerLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLbl.setFont(new Font("Arial", Font.PLAIN, 30));
        JButton regBtn = new JButton("Register user");
        regBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton loginBtn = new JButton("Login user");
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(15));
        panel.add(headerLbl);
        panel.add(Box.createVerticalStrut(30));
        panel.add(regBtn);
        panel.add(Box.createVerticalStrut(15));
        panel.add(loginBtn);


        setVisible(true);
    }
}
