package gui;

import model.Bagaglio;
import model.volo;
import model.stato_bagaglio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class visualizzaSmarrimenti extends JFrame {

    private JTable tabellaSmarrimenti;
    private DefaultTableModel tableModel;

    public visualizzaSmarrimenti(){
        setTitle("bagagli smarrito");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] colonne ={"volo", "codice", "descrizione", "stato"};
        tableModel = new DefaultTableModel(colonne, 0);
        tabellaSmarrimenti = new JTable(tableModel);
        add(new JScrollPane(tabellaSmarrimenti), BorderLayout.CENTER);

        caricaBagagliSmarriti();

        setVisible(true);
    }
    private void caricaBagagliSmarriti(){
        tableModel.setRowCount(0);

        for(volo v : volo.archivio){
            for(Bagaglio b: v.getBagagli()){
                if(b.getStato() == stato_bagaglio.smarrito){
                    Object[] row={
                            v.toString(),
                            b.getCodice(),
                            b.getDescrizione(),
                            b.getStato().toString()
                    };
                    tableModel.addRow(row);
                }
            }
        }
    }
}