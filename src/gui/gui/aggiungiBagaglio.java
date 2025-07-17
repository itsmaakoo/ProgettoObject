package gui;

import dao.prenotazioniDAO;
import dao.BagaglioDAO;
import dao.voloDAO;
import db.connessioneDb;
import model.Bagaglio;
import model.prenotazione;
import model.volo;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.util.List;

public class aggiungiBagaglio extends JFrame {

    private JComboBox<volo> voloJComboBox;
    private JTextField campoBagaglio;
    private JButton confermaButton;

    public aggiungiBagaglio() {
        setTitle("Aggiungi bagaglio");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(8, 8, 8, 8);
        c.fill = GridBagConstraints.HORIZONTAL;

        Connection conn = connessioneDb.getConnection();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Connessione fallita");
            dispose();
            return;
        }

        voloDAO volodao = new voloDAO(conn);
        List<volo> voli = volodao.getTuttiVoli();
        voloJComboBox = new JComboBox<>(voli.toArray(new volo[0]));

        campoBagaglio = new JTextField();
        confermaButton = new JButton("Aggiungi");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        panel.add(new JLabel("Seleziona Volo: "), c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        panel.add(voloJComboBox, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(new JLabel("Seleziona bagaglio: "), c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        panel.add(campoBagaglio, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        panel.add(confermaButton, c);

        add(panel);

        confermaButton.addActionListener(e -> {
            volo selezionato = (volo) voloJComboBox.getSelectedItem();
            String descrizione = campoBagaglio.getText().trim();

            if (selezionato != null && !descrizione.isEmpty()) {
                try {
                    int codiceBagaglio = Integer.parseInt(descrizione);
                    Connection connBagaglio = connessioneDb.getConnection();

                    prenotazioniDAO prenotazionidao = new prenotazioniDAO(connBagaglio);
                    List<prenotazione> prenotazioni = prenotazionidao.trovaPrenotazioniPerVolo(selezionato.getId());

                    if (!prenotazioni.isEmpty()) {
                        prenotazione primaprenotazione = prenotazioni.get(0); //usa la prima prenotazione come default
                        int prenotazioneId = primaprenotazione.getPrenotazioneId();
                        Bagaglio nuovoBagaglio = new Bagaglio(prenotazioneId, codiceBagaglio, "bagaglio aggiunto manualmente");
                        BagaglioDAO bagagliodao = new BagaglioDAO(connBagaglio);
                        bagagliodao.add(nuovoBagaglio, prenotazioneId);
                        JOptionPane.showMessageDialog(this, "Bagaglio aggiunto al volo");
                        campoBagaglio.setText("");

                    } else {
                        JOptionPane.showMessageDialog(this, "Nessuna prenotazione trovata per questo volo");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Inserisci un numero valido per il codice del bagaglio.");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Inserisci un numero valido per codice del bagaglio.");
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleziona un volo e inserisci il codice del bagaglio.");
            }
        });
        setVisible(true);
    }
}
