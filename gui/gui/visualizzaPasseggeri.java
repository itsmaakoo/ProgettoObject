package gui;

import model.Passeggero;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class visualizzaPasseggeri extends JFrame {

    public visualizzaPasseggeri() {
        setTitle("Passeggeri Registrati");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] colonne = {"Nome", "Cognome", "Codice Fiscale"};
        DefaultTableModel model = new DefaultTableModel(colonne, 0);
        JTable table = new JTable(model);

        for(Passeggero p: Passeggero.archivioPasseggeri){
            Object[] row={p.getNome(), p.getCognome(), p.getCodiceFiscale()};
            model.addRow(row);
        }
        add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);
    }
}