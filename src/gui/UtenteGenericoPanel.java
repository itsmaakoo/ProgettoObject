package gui;

import javax.swing.*;
import java.awt.*;

public class UtenteGenericoPanel extends JFrame {

    private JPanel panel1;
    private JButton prenotaVoloButton;
    private JButton statoVoloButton;
    private JButton segnalaBagaglioSmarritoButton;
    private JButton logoutButton;
    private JButton aggiungiBagaglio;

    public UtenteGenericoPanel() {
        super("Utente Generico");

        panel1 = new JPanel(new GridBagLayout());
        panel1.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);
        Dimension buttonSize = new Dimension(200, 40);

        prenotaVoloButton = new JButton("Prenota volo");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        prenotaVoloButton.setPreferredSize(buttonSize);
        c.anchor = GridBagConstraints.CENTER;
        panel1.add(prenotaVoloButton, c);

        prenotaVoloButton.addActionListener(e -> {
            new PrenotaVolo();
        });

        statoVoloButton = new JButton("Stato volo");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        statoVoloButton.setPreferredSize(buttonSize);
        c.anchor = GridBagConstraints.CENTER;
        panel1.add(statoVoloButton, c);

        statoVoloButton.addActionListener(e -> {
            new statoVolo();
        });

        aggiungiBagaglio = new JButton("Aggiungi Bagaglio");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        aggiungiBagaglio.setPreferredSize(buttonSize);
        c.anchor = GridBagConstraints.CENTER;
        panel1.add(aggiungiBagaglio, c);

        segnalaBagaglioSmarritoButton = new JButton("Segnala bagaglio smarrito");
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 3;
        segnalaBagaglioSmarritoButton.setPreferredSize(buttonSize);
        c.anchor = GridBagConstraints.CENTER;
        panel1.add(segnalaBagaglioSmarritoButton, c);


        logoutButton = new JButton("Logout");
        logoutButton.setForeground(Color.RED);
        c.gridx = 1;
        c.gridy = 6;
        panel1.add(logoutButton, c);

        logoutButton.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        add(panel1);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {

        new UtenteGenericoPanel();
    }
}