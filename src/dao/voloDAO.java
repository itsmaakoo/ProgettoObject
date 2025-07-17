package dao;

import model.volo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class voloDAO {
    private Connection connessione;

    public voloDAO(Connection conn) {
        this.connessione = conn;
    }

    public void salvaVolo(volo v) {
        String sql = "INSERT INTO volo (destinazione, data_partenza, data_arrivo, stato, gate) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = connessione.prepareStatement(sql)) {
            stmt.setString(1, v.getDestinazione());
            stmt.setDate(2, new java.sql.Date(v.getDataPartenza().getTime()));
            stmt.setDate(3, new java.sql.Date(v.getDataArrivo().getTime()));
            stmt.setString(4, v.getStato());
            stmt.setString(5, v.getGate());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<volo> getTuttiVoli() {
        List<volo> lista = new ArrayList<>();
        String sql = "SELECT * FROM volo";
        try (Statement stmt = connessione.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                String destinazione = rs.getString("destinazione");
                Date partenza = rs.getDate("data_partenza");
                Date arrivo = rs.getDate("data_arrivo");
                String stato = rs.getString("stato");
                String gate = rs.getString("gate");

                volo v= new volo(destinazione, partenza, arrivo, stato, gate);
                lista.add(v);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

    public void aggiornaStato(String destinazione, String nuovoStato){
        String sql = "UPDATE volo SET stato = ? WHERE destinazione = ?";
        try(PreparedStatement statement = connessione.prepareStatement(sql);){
            statement.setString(1, nuovoStato);
            statement.setString(2, destinazione);
            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
