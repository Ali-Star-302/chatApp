package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registration extends JFrame {

    private JTextField userFld;
    private JPasswordField passFld;
    private JLabel infoLbl;

    public Registration() {
        super("User Registration");
        initComponents();
    }

    public void initComponents() {
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

        //Username panel
        JPanel userPnl = new JPanel();
        userPnl.setLayout(new BoxLayout(userPnl, BoxLayout.X_AXIS));
        userPnl.setMaximumSize(new Dimension(300, 60));
        JLabel userLbl = new JLabel("Username:");
        headerLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLbl.setFont(new Font("Arial", Font.PLAIN, 30));
        userFld = new JTextField();
        userFld.setMaximumSize(new Dimension(200, 30));
        userPnl.add(userLbl);
        userPnl.add(Box.createHorizontalStrut(20));
        userPnl.add(userFld);

        //Password panel
        JPanel passPnl = new JPanel();
        passPnl.setLayout(new BoxLayout(passPnl, BoxLayout.X_AXIS));
        passPnl.setMaximumSize(new Dimension(300, 60));
        JLabel passLbl = new JLabel("Password:");
        headerLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLbl.setFont(new Font("Arial", Font.PLAIN, 30));
        passFld = new JPasswordField();
        passFld.setMaximumSize(new Dimension(200, 30));
        passPnl.add(passLbl);
        passPnl.add(Box.createHorizontalStrut(20));
        passPnl.add(passFld);

        //Info label
        infoLbl = new JLabel("Label");

        //Submit button
        JButton submitBtn = new JButton("Submit");
        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitBtn.addActionListener(e -> submitBtnPressed());

        //Adding to panels
        panel.add(Box.createVerticalStrut(15));
        panel.add(headerLbl);
        panel.add(Box.createVerticalStrut(50));
        panel.add(userPnl);
        panel.add(Box.createVerticalStrut(25));
        panel.add(passPnl);
        panel.add(Box.createVerticalStrut(20));
        panel.add(infoLbl);
        panel.add(Box.createVerticalStrut(30));
        panel.add(submitBtn);
        panel.add(Box.createVerticalStrut(20));

        setVisible(true);
    }

    public void submitBtnPressed() {
        String user = userFld.getText();
        String pass = new String(passFld.getPassword());
        if (isValidUsername(user) && isValidPassword(pass)) {
            infoLbl.setText("Valid");
            validRegistration();
        }
        else {
            infoLbl.setText("Invalid");
        }
        //TODO: Check db for username
        //if not there add to db
    }

    public void validRegistration() {
        Chat chat = new Chat();
        this.dispose();
    }

    public boolean isValidUsername(String username) {
        if (username.length() < 5 || username.matches(".*[&=_'+,<>].*")) {
            return false;
        }
        return true;
    }

    public boolean isValidPassword(String password) {
        if (password.length() < 5 || password.matches(".*[&=_'+,<>].*")) {
            return false;
        }
        return true;
    }
}
