package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame{
    public Login() {
        super("Login");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        //Header label
        JLabel headerLbl = new JLabel("Enter your details");
        headerLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLbl.setFont(new Font("Arial", Font.PLAIN, 30));

        panel.add(Box.createVerticalStrut(15));
        panel.add(headerLbl);

        setVisible(true);
    }
}
