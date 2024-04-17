package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registration extends JFrame {

    private JTextField userFld;
    private JPasswordField passFld;
    private JLabel infoLbl;

    private String username;
    private String password;

    private enum UsernameErrors {
        InvalidLength,
        InvalidCharacters,
        ValidUser
    }

    private enum PasswordErrors {
        InvalidLength,
        InvalidCharacters,
        ValidPass
    }

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
        infoLbl = new JLabel("");
        infoLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoLbl.setForeground(Color.red);

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
        username = userFld.getText();
        password = new String(passFld.getPassword());
        String userResult = isValidUsername(username);
        String passResult = isValidPassword(password);

        if (!userResult.equals("Valid")){
            infoLbl.setText("Invalid username: " + userResult);
        }
        else if (!passResult.equals("Valid")){
            infoLbl.setText("Invalid password: " + passResult);
        }
        else {
            infoLbl.setText("Valid");
            validRegistration();
        }
        //TODO: Check db for username
        //if not there add to db
    }

    public void validRegistration() {
        Chat chat = new Chat(username);
        this.dispose();
    }

    private String isValidUsername(String username) {
        if (username.length() < 5 ) {
            return "length must be greater than 5";
        }
        else if (username.matches(".*[&=_'+,<>].*")) {
            return "invalid characters used";
        }

        return "Valid";
    }

    private String isValidPassword(String password) {
        if (password.length() < 8 ) {
            return "length must be greater than 8";
        }
        else if (password.matches(".*[&=_'+,<>].*")) {
            return "invalid characters used";
        }

        return "Valid";
    }
}
