package gui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField username;
    private JPasswordField password;
    private JButton login;

    public LoginFrame() {

        super("login");

        setLayout(new BorderLayout());

        username = new JTextField();
        password = new JPasswordField();
        login = new JButton("LOGIN");

        add(username, BorderLayout.PAGE_START);
        add(password, BorderLayout.CENTER);
        add(login, BorderLayout.PAGE_END);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LoginFrame();
    }
}

