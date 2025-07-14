package gui;

import dao.BagaglioDAO;
import dao.voloDAO;
import dao.prenotazioniDAO;
import model.prenotazione;
import model.volo;
import model.Bagaglio;
import db.connessioneDb;
import java.sql.Connection;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class aggiornaBagaglio extends JFrame {

    private JTable bagagliTable;
    private JComboBox<volo> voloComboBox;
    private DefaultTableModel tableModel;

    public aggiornaBagaglio() {
        setTitle("Visualizza bagaglio");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Connection conn = connessioneDb.getConnection();
        voloDAO volodao = new voloDAO(conn);
        List<volo> voli = volodao.getTuttiVoli();

        voloComboBox = new JComboBox<>(volo.archivio.toArray(new volo[0]));
        add(voloComboBox, BorderLayout.NORTH);

        String[] colonne = {"volo", "codice bagaglio", "descrizione", "stato"};
        tableModel = new DefaultTableModel(colonne, 0);
        bagagliTable = new JTable(tableModel);
        add(new JScrollPane(bagagliTable), BorderLayout.CENTER);

        voloComboBox.addActionListener(e -> {
            caricaBagagli();
        });

        if (voloComboBox.getItemCount() > 0) {
            caricaBagagli();
        }
        setVisible(true);
    }

    private void caricaBagagli() {
        tableModel.setNumRows(0);
        volo selezionato = (volo) voloComboBox.getSelectedItem();
        if (selezionato != null) {
            try {
                Connection conn = connessioneDb.getConnection();
                prenotazioniDAO prenotazionidao = new prenotazioniDAO(conn);
                BagaglioDAO bagagliodao = new BagaglioDAO(conn);
                List<prenotazione> prenotazioni = prenotazionidao.trovaPrenotazioniPerVolo(selezionato.getId());
                List<Bagaglio> bagagli = null;

                for (prenotazione p : prenotazioni) {
                    bagagli = bagagliodao.trovaBagagliPerPrenotazione(p.getPrenotazioneId());
                }

                for (Bagaglio b : bagagli) {
                    Object[] row = {selezionato.toString(), b.getCodice(), b.getDescrizione(), b.getStato()};
                    tableModel.addRow(row);
                }

            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "Errore bagaglio");
                e.printStackTrace();
            }
        }
    }
}
