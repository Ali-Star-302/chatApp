package org.example;

import javax.swing.*;
import java.awt.*;

public class Startup extends JFrame{
    public Startup(String title) {
        super(title);
        initComponents();
    }

    public void initComponents() {
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
        regBtn.addActionListener(e -> regBtnPressed());
        JButton loginBtn = new JButton("Login user");
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginBtn.addActionListener(e -> loginBtnPressed());

        panel.add(Box.createVerticalStrut(15));
        panel.add(headerLbl);
        panel.add(Box.createVerticalStrut(100));
        panel.add(regBtn);
        panel.add(Box.createVerticalStrut(30));
        panel.add(loginBtn);

        setVisible(true);
    }


    public void regBtnPressed() {
        Registration registration = new Registration();
        this.dispose();
    }

    public void loginBtnPressed() {
        Login registration = new Login();
        this.dispose();
    }
}
