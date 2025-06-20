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

        add(panel1);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Amministratore();
    }
}