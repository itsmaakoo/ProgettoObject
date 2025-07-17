package gui;

import dao.passeggeroDAO;
import db.connessioneDb;
import model.Passeggero;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public class visualizzaPasseggeri extends JFrame {

    public visualizzaPasseggeri() {
        setTitle("Passeggeri Registrati");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] colonne = {"id","Nome", "Cognome", "Codice Fiscale"};
        DefaultTableModel model = new DefaultTableModel(colonne, 0);

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        try(Connection conn = connessioneDb.getConnection()){

            if(conn != null){
                passeggeroDAO dao = new passeggeroDAO(conn);
                List<Passeggero> passeggeri = dao.trovaListaPasseggero();

                for(Passeggero passeggero : passeggeri){
                    Object[] row = {passeggero.getId(), passeggero.getNome(), passeggero.getCognome(),passeggero.getCodiceFiscale()};
                    model.addRow(row);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Errore di connessione al database");
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Errore dei passeggeri");
            e.printStackTrace();
        }
        setVisible(true);
    }
}