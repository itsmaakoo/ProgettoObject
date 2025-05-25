package gui;

import javax.swing.*;
import java.awt.*;

public class UtenteGenericoPanel extends JPanel {

    public UtenteGenericoPanel() {
        setLayout(new BorderLayout());
    }

    JLabel titleLabel = new JLabel("Area Utente", SwingConstants.CENTER);

    private JPanel panel1;
    private JButton prenotaVoloButton;
    private JButton statoVoloButton;
    private JButton segnalaBagaglioSmarritoButton;
}
