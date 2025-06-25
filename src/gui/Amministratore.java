package gui;

import javax.swing.*;
import java.awt.*;

public class Amministratore extends JFrame {

    private JPanel panel1;
    private JButton inserisciVolo;
    private JButton modificaVolo;
    private JButton assegnaGate;
    private JButton assegnaBagaglio;
    private JButton visualizzaSmarrimento;
    private JButton logoutButton;

    public Amministratore() {

        super("Amministratore");


        panel1 = new JPanel(new GridBagLayout());
        panel1.setBackground(Color.WHITE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);




        inserisciVolo = new JButton("Inserisci Volo");
        inserisciVolo.setForeground(Color.BLACK);

        c.gridx = 1;
        c.gridy = 0;
        panel1.add(inserisciVolo, c);

        inserisciVolo.addActionListener(e ->{
            new InserisciVolo();
        });



        modificaVolo = new JButton(" Modifica Volo ");
        c.gridx = 1;
        c.gridy = 2;
        panel1.add(modificaVolo, c);



        assegnaGate = new JButton("Assegna Gate");
        assegnaGate.setForeground(Color.BLACK);

        c.gridx = 1;
        c.gridy = 3;
        panel1.add(assegnaGate, c);



        assegnaBagaglio = new JButton("Assegna Bagaglio");
        c.gridx = 1;
        c.gridy = 4;
        panel1.add(assegnaBagaglio, c);


        visualizzaSmarrimento = new JButton("visualizza smarrimenti");
        visualizzaSmarrimento.setForeground(Color.BLACK);

        c.gridx = 1;
        c.gridy = 5;
        panel1.add(visualizzaSmarrimento, c);

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
        new Amministratore();
    }

    public JButton getInserisciVolo() {
        return inserisciVolo;
    }
    public JButton getModificaVolo() {
        return modificaVolo;
    }
    public JButton getAssegnaGate() {
        return assegnaGate;

    }
    public JButton getAssegnaBagaglio() {
        return assegnaBagaglio;
    }
    public JButton getVisualizzaSmarrimento() {
        return visualizzaSmarrimento;
    }

}