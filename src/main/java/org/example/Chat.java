package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chat extends JFrame{
    public Chat() {
        super("Chat Client");
        initComponents();
    }

    public void initComponents() {
        setSize(500, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        //Header label
        JLabel headerLbl = new JLabel("Chat client");
        headerLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLbl.setFont(new Font("Arial", Font.PLAIN, 30));

        //Connection label
        JLabel conLabel = new JLabel("Connected to: ");
        conLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        conLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        //chatBox
        JPanel chatPanel = new JPanel();
        chatPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        chatPanel.setMaximumSize(new Dimension(450, 400));
        JTextArea chatBox = new JTextArea();
        chatBox.setSize(50,100);
        JScrollPane chatScrollPane = new JScrollPane();
        chatScrollPane.setViewportView(chatBox);
        chatPanel.add(chatScrollPane);

        //sendField
        JPanel sendPanel = new JPanel();
        sendPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendPanel.setLayout(new BoxLayout(sendPanel, BoxLayout.X_AXIS));
        sendPanel.setMaximumSize(new Dimension(450, 75));
        JTextArea sendField = new JTextArea();
        sendField.setToolTipText("Type your message here...");
        sendField.setEditable(true);
        JScrollPane sendScrollPane = new JScrollPane();
        sendScrollPane.setViewportView(sendField);
        sendPanel.add(sendScrollPane);

        JPanel sendBtnPanel = new JPanel();
        sendBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendBtnPanel.setLayout(new BoxLayout(sendBtnPanel, BoxLayout.X_AXIS));
        sendBtnPanel.setMaximumSize(new Dimension(100, 25));
        JButton sendBtn = new JButton();
        sendBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendBtn.setText("Send");
        sendBtnPanel.add(sendBtn);

        panel.add(Box.createVerticalStrut(15));
        panel.add(headerLbl);
        panel.add(Box.createVerticalStrut(15));

        panel.add(conLabel);
        panel.add(chatPanel);
        panel.add(Box.createVerticalStrut(15));

        panel.add(sendPanel);
        panel.add(Box.createVerticalStrut(15));

        panel.add(sendBtnPanel);

        setVisible(true);
    }
}
