package gui;

import model.volo;
import model.Bagaglio;

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
        volo selezionato = (volo) voloComboBox.getSelectedItem();
        tableModel.setRowCount(0);
        if (selezionato != null) {
            for(Bagaglio b : selezionato.getBagagli()) {
                Object[] row = { b.getCodice(), b.getDescrizione(), b.getStato()};
                tableModel.addRow(row);
            }
        }
    }
}
