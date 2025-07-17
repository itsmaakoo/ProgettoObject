package gui;

import dao.passeggeroDAO;
import db.connessioneDb;
import model.Passeggero;
import model.volo;
import model.prenotazione;
import dao.voloDAO;
import dao.prenotazioniDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class PrenotaVolo extends JFrame {

    private JTextField nomeField, cognomeField, codiceFiscale;
    private JList<volo> listaVoli;
    private Connection conn;

    public PrenotaVolo() {
        setTitle("Prenota Volo");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());


        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        nomeField = new JTextField();
        cognomeField = new JTextField();
        codiceFiscale = new JTextField();

        formPanel.add(new JLabel("Nome:"));
        formPanel.add(nomeField);
        formPanel.add(new JLabel("Cognome:"));
        formPanel.add(cognomeField);
        formPanel.add(new JLabel("CodiceFiscale:"));
        formPanel.add(codiceFiscale);

        panel.add(formPanel, BorderLayout.NORTH);

        DefaultListModel<volo> model = new DefaultListModel<>();
        /*try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        Connection conn = connessioneDb.getConnection();
        if (conn != null) {
            // Usa la connessione, es. passala al tuo DAO
            voloDAO dao = new voloDAO(conn);
        } else {
            JOptionPane.showMessageDialog(null, "Errore di connessione al database.", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        voloDAO voloDAO = new voloDAO(conn);
        List<volo> voli = voloDAO.getTuttiVoli();
        for (volo v : voli) {
            model.addElement(v);
        }

        listaVoli = new JList<>(model);
        listaVoli.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaVoli);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton checkInButton = new JButton(" Effettua check in");
        checkInButton.addActionListener(e -> {
            try {
                prenota();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        panel.add(checkInButton, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
    }

    private void prenota() throws SQLException {
        volo selezionato = listaVoli.getSelectedValue();
        String nome = nomeField.getText().trim();
        String cognome = cognomeField.getText().trim();
        String cf = codiceFiscale.getText().trim();

        if (selezionato == null || nome.isEmpty() || cognome.isEmpty() || cf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "compila tutti i campi");
        }
        // crea salva passaggero
        Passeggero psg = new Passeggero(nome, cognome, cf);
        passeggeroDAO passeggeroDao = new passeggeroDAO(conn);
        int passeggeroId = passeggeroDao.salvaPasseggero(psg);

        if (passeggeroId == 0) {
            JOptionPane.showMessageDialog(this, "errore salvataggio passeggero");
            return;
        }

        Random rand = new Random();
        int num_biglietto = 1000 + rand.nextInt(999999);
        int prenotazioneId = 1 + rand.nextInt(10000);
        String documento = cf;
        String stato = "prenotazione confermata";

        prenotazione pr = new prenotazione(num_biglietto, passeggeroId, documento, selezionato.getId(), prenotazioneId, stato);
        prenotazioniDAO prenotazioniDao = new prenotazioniDAO(conn);
        prenotazioniDao.salvaPrenotazione(pr);
        JOptionPane.showMessageDialog(this, "prenotazione confermata");

        nomeField.setText("");
        cognomeField.setText("");
        codiceFiscale.setText("");
    }
}