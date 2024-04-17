package org.example;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import javax.swing.*;

public class Chat extends JFrame{
    public int windowWidth = 650;

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private Socket socket;
    private String username;

    private JTextArea sendField;
    private JTextArea chatBox;

    public Chat(String username) {
        super("Chat Client");

        initComponents();

        try {
            this.socket = new Socket("localhost", 1234);
            this.username = username;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

        listenForMessage();
        sendMessage();
    }


    public void sendMessage() {
        try {
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            while (socket.isConnected()) {
                String message = sendField.getText();
                bufferedWriter.write(username + ": " + message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;

                while (socket.isConnected()) {
                    try {
                        msgFromGroupChat = bufferedReader.readLine();
                        chatBox.setText(chatBox.getText() + msgFromGroupChat);
                        System.out.println(msgFromGroupChat);
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    public void initComponents() {
        setSize(windowWidth, 700);
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
        chatPanel.setMaximumSize(new Dimension(windowWidth-50, 400));
        chatBox = new JTextArea();
        chatBox.setSize(50,100);
        JScrollPane chatScrollPane = new JScrollPane();
        chatScrollPane.setViewportView(chatBox);
        chatPanel.add(chatScrollPane);

        //sendField
        JPanel sendPanel = new JPanel();
        sendPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendPanel.setLayout(new BoxLayout(sendPanel, BoxLayout.X_AXIS));
        sendPanel.setMaximumSize(new Dimension(windowWidth-50, 75));
        sendField = new JTextArea();
        sendField.setToolTipText("Type your message here...");
        sendField.setEditable(true);
        JScrollPane sendScrollPane = new JScrollPane();
        sendScrollPane.setViewportView(sendField);
        sendPanel.add(sendScrollPane);

        //Send button
        JPanel sendBtnPanel = new JPanel();
        sendBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendBtnPanel.setLayout(new BoxLayout(sendBtnPanel, BoxLayout.X_AXIS));
        sendBtnPanel.setMaximumSize(new Dimension(100, 25));
        JButton sendBtn = new JButton();
        sendBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendBtn.setText("Send");
        sendBtnPanel.add(sendBtn);
        sendBtn.addActionListener(e -> sendBtnPressed());

        //Adding to panel
        panel.add(Box.createVerticalStrut(15));
        panel.add(headerLbl);
        panel.add(Box.createVerticalStrut(15));
        panel.add(conLabel);
        panel.add(chatPanel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(sendPanel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(sendBtnPanel);

        setVisible(true);
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendBtnPressed() {

    }
}
