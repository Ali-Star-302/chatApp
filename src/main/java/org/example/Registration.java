package org.example;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registration extends JFrame {

    private JTextField userFld;
    private JPasswordField passFld;
    private JLabel infoLbl;

    public Registration(String title) {
        super(title);
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

        //Password panel
        JPanel passPnl = new JPanel();
        passPnl.setLayout(new BoxLayout(passPnl, BoxLayout.X_AXIS));
        passPnl.setMaximumSize(new Dimension(300, 60));
        JLabel passLbl = new JLabel("Password:");
        headerLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLbl.setFont(new Font("Arial", Font.PLAIN, 30));
        passFld = new JPasswordField();
        passFld.setMaximumSize(new Dimension(200, 30));

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

        userPnl.add(userLbl);
        userPnl.add(Box.createHorizontalStrut(20));
        userPnl.add(userFld);
        panel.add(userPnl);

        panel.add(Box.createVerticalStrut(25));

        passPnl.add(passLbl);
        passPnl.add(Box.createHorizontalStrut(20));
        passPnl.add(passFld);
        panel.add(passPnl);

        panel.add(Box.createVerticalStrut(20));
        panel.add(infoLbl);

        panel.add(Box.createVerticalStrut(30));
        panel.add(submitBtn);
        panel.add(Box.createVerticalStrut(20));

        setVisible(true);
    }

    public void submitBtnPressed() {
        if (isValidUsername(userFld.getText()) && isValidPassword(new String(passFld.getPassword()))) {
            infoLbl.setText("Valid");
        }
        else {
            infoLbl.setText("Invalid");
        }
        //TODO: Check db for username
        //if not there add to db
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
