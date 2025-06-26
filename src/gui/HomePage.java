package gui;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    private JPanel HomePanel;
    private JLabel Question;
    private JButton LoginUtente;
    private JButton LoginAdmin;

    public HomePage() {
        setTitle("Home Page");

        HomePanel = new JPanel(new GridBagLayout());
        HomePanel.setForeground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);
        Dimension buttonSize = new Dimension(200, 40);


        Question = new JLabel("Selezionare il profilo di accesso: ");
        Question.setFont(new Font("Arial", Font.BOLD, 20));
        c.gridx = 1;
        c.gridy = 2;
        HomePanel.add(Question, c);

        LoginUtente = new JButton("Login utente");
        LoginUtente.setFont(new Font("Arial", Font.BOLD, 16));
        c.gridx = 1;
        c.gridy = 3;
        LoginUtente.setPreferredSize(buttonSize);
        HomePanel.add(LoginUtente, c);

        LoginAdmin = new JButton("Login admin");
        LoginAdmin.setFont(new Font("Arial", Font.BOLD, 16));
        c.gridx = 1;
        c.gridy = 4;
        LoginAdmin.setPreferredSize(buttonSize);
        HomePanel.add(LoginAdmin, c);

        add(HomePanel);

        setSize(1150, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JButton getLoginUtenteButton() {
        return LoginUtente;
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
